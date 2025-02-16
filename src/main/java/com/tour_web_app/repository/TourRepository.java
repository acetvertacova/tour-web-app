package com.tour_web_app.repository;

import com.tour_web_app.entity.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TourRepository extends CrudRepository<Tour, UUID> {

}
