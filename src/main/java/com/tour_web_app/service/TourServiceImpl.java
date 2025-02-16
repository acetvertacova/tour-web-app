package com.tour_web_app.service;

import com.tour_web_app.entity.Tour;
import com.tour_web_app.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public Tour saveTour(Tour tour) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public List<Tour> fetchTourList() {
        List<Tour> listTour = StreamSupport.stream(tourRepository.findAll().spliterator(), false)
                .toList();
        return listTour;
    }

    @Override
    public Tour updateTour(Tour tour, UUID tourId) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void deleteTourById(UUID tourId) {
        throw new RuntimeException("Not yet implemented");
    }
}
