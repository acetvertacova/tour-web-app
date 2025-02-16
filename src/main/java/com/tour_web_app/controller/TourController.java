package com.tour_web_app.controller;

import com.tour_web_app.entity.Tour;
import com.tour_web_app.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tourApi")
public class TourController {

    @Autowired
    private TourService tourService;

        @GetMapping("/tours")
        public List<Tour> tours() {
            return tourService.fetchTourList();
        }
}


