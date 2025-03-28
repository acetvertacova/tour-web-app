package com.tour_web_app.service;

import com.tour_web_app.entity.Tour;
import com.tour_web_app.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public List<Tour> fetchTourList() {
        List<Tour> listTour = StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .toList();
        return listTour;
    }

    @Override
    public Tour updateTour(@RequestBody Tour tourUpdated, @PathVariable UUID tourId) {
        Tour tourNeededUpdate = tourRepository.findById(tourId).get();

        tourNeededUpdate.setCountry(tourUpdated.getCountry());
        tourNeededUpdate.setCity(tourUpdated.getCity());
        tourNeededUpdate.setCheckInDate(tourUpdated.getCheckInDate());
        tourNeededUpdate.setCheckOutDate(tourUpdated.getCheckOutDate());
        tourNeededUpdate.setFoodType(tourUpdated.getFoodType());
        tourNeededUpdate.setPrice(tourUpdated.getPrice());
        tourNeededUpdate.setHotel(tourUpdated.getHotel());
        tourNeededUpdate.setStars(tourUpdated.getStars());
        tourNeededUpdate.setDepartureThereDate(tourUpdated.getDepartureThereDate());
        tourNeededUpdate.setDepartureBackDate(tourUpdated.getDepartureBackDate());

        //todo
        // Tour newTour= Tour.builder().checkInDate().build()

        return tourRepository.save(tourNeededUpdate);

    }

    @Override
    public Tour deleteTourById(UUID tourId) {
        Tour tour = tourRepository.findById(tourId).get();
        tourRepository.deleteById(tourId);

        return tour;
    }
}
