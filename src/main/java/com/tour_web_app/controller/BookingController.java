package com.tour_web_app.controller;

import com.tour_web_app.Dto.BookingRequestDto;
import com.tour_web_app.Dto.BookingResponseDto;
import com.tour_web_app.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookings")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping()
    public BookingResponseDto book(@RequestBody BookingRequestDto request, Authentication authentication) {
        String username = authentication.getName();
        return bookingService.booking(request, username);
    }

    @GetMapping()
    public List<BookingResponseDto> getAllBookingsOfUser(Authentication authentication){
        String username = authentication.getName();
        return bookingService.getAllBookingsOfUser(username);
    }

    @DeleteMapping("/{id}")
    public BookingResponseDto cancel(@PathVariable("id") Long BookingId, Authentication authentication) {
        String username = authentication.getName();
        return bookingService.cancel(BookingId, username);
    }
}
