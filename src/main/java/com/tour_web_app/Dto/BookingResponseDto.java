package com.tour_web_app.Dto;

import com.tour_web_app.entity.Tour;

public record BookingResponseDto(Long id, Tour tour, int seatsBooked) {
}
