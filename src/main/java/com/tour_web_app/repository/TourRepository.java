package com.tour_web_app.repository;

import com.tour_web_app.entity.Tour;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface TourRepository extends CrudRepository<Tour, Long>, JpaSpecificationExecutor<Tour> {
    Optional<Tour> findByCheckInDateAndCheckOutDateAndCountry(LocalDate checkIndate, LocalDate checkOutDate, String country);
    //List<Tour> findByCountryContainingIgnoreCase(String country);
}
