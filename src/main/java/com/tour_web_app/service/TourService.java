package com.tour_web_app.service;

import com.tour_web_app.entity.Tour;

import java.util.List;
import java.util.UUID;

public interface TourService {

    Tour saveTour(Tour tour);

    List<Tour> fetchTourList();

    Tour updateTour(Tour tour, UUID tourId);

    void deleteTourById(UUID tourId);
}
