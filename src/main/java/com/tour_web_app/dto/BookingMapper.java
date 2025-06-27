package com.tour_web_app.dto;

import com.tour_web_app.entity.*;

public class BookingMapper {

    public static Booking toEntity(BookingRequestDto requestDto, Tour tour, UserEntity user) {
        return Booking.builder()
                .seatsBooked(requestDto.seatsBooked())
                .user(user)
                .tour(tour)
                .build();
    }

    public static BookingResponseDto toDto(Booking booking) {
        return new BookingResponseDto(
                booking.getId(),
                booking.getTour(),
                booking.getSeatsBooked()
        );
    }
}
