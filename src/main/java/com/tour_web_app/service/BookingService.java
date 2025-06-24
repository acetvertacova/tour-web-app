package com.tour_web_app.service;

import com.tour_web_app.Dto.BookingMapper;
import com.tour_web_app.Dto.BookingRequestDto;
import com.tour_web_app.Dto.BookingResponseDto;
import com.tour_web_app.entity.Booking;
import com.tour_web_app.entity.Tour;
import com.tour_web_app.entity.UserEntity;
import com.tour_web_app.repository.BookingRepository;
import com.tour_web_app.repository.TourRepository;
import com.tour_web_app.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final TourRepository tourRepository;
    private final UserRepository userRepository;

    @Transactional
    public BookingResponseDto booking(BookingRequestDto request, String username){
        Tour tour = tourRepository.findById(request.tourId()).orElseThrow(()-> new RuntimeException("Tour not found"));

        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        if (bookingRepository.existsByUserAndTour(user, tour)) {
            throw new RuntimeException("You have already booked this tour");
        }

        if (tour.getAvailableSpots() < request.seatsBooked()){
            throw new RuntimeException("Not enough available spots");
        }

        tour.setAvailableSpots(tour.getAvailableSpots() - request.seatsBooked());
        tourRepository.save(tour);

        Booking booking = bookingRepository.save(BookingMapper.toEntity(request, tour, user));
        return BookingMapper.toDto(booking);
    }

    public List<BookingResponseDto> getAllBookingsOfUser(String username){
       UserEntity user = userRepository.findByUsername(username).orElseThrow();
       List<Booking> bookings = bookingRepository.findAllByUser(user);

       return bookings.stream()
               .map(BookingMapper::toDto)
               .toList();
    }

    @Transactional
    public BookingResponseDto cancel(Long bookingId, String username){
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (!booking.getUser().getUsername().equals(username)) {
            throw new RuntimeException("You can cancel only your bookings");
        }

        Tour tour = booking.getTour();
        tour.setAvailableSpots(tour.getAvailableSpots() + booking.getSeatsBooked());
        tourRepository.save(tour);

        bookingRepository.delete(booking);
        return BookingMapper.toDto(booking);
    }
}
