package com.tour_web_app.specification;

import com.tour_web_app.entity.Tour;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TourSpecification {
    public static Specification<Tour> hasCountry(String country) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("country")),
                        country.toLowerCase()
                );
    }

    public static Specification<Tour> minPrice(String minPrice) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Tour> maxPrice(String maxPrice) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Tour> hasRating(Integer rating) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("rating"), rating);
    }

    public static Specification<Tour> hasAvailableSpots(Integer availavleSpots) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("availableSpots"), availavleSpots);
    }

    public static Specification<Tour> datesBetween(LocalDate dateFrom, LocalDate dateTo) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.greaterThanOrEqualTo(root.get("checkInDate"), dateFrom),
                criteriaBuilder.equal(root.get("checkOutDate"), dateTo)
        );
    }
}
