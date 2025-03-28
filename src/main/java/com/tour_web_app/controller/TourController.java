package com.tour_web_app.controller;

import com.tour_web_app.entity.Tour;
import com.tour_web_app.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tourApi")
public class TourController {


    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }


    @PostMapping("/tours")
    public Tour saveTour(@RequestBody Tour tour){
        return tourService.saveTour(tour);
    }

    @GetMapping("/tours")
    public List<Tour> tours() {
        return tourService.fetchTourList();
    }

    @PutMapping("/tours/{id}")
    public Tour updateTour(@RequestBody Tour tour, @PathVariable("id") UUID tourId){
        return tourService.updateTour(tour, tourId);
    }

    @DeleteMapping("/tours/{id}")
    public Tour deleteTour(@PathVariable("id") UUID tourId){
        return tourService.deleteTourById(tourId);
    }
}



