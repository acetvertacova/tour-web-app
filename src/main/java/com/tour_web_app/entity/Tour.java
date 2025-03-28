package com.tour_web_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "t_tours")

public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="CITY")
    private String city;

    @Column(name="CHECK_IN_DATE")
    private String checkInDate;

    @Column(name="CHECK_OUT_DATE")
    private String checkOutDate;

    @Column(name="FOOD_TYPE")
    private String foodType;

    @Column(name="PRICE")
    private double price;

    @Column(name="HOTEL")
    private String hotel;

    @Column(name="STARS")
    private byte stars;

    @Column(name="DEPARTURE_THERE_DATE")
    private String departureThereDate;

    @Column(name="DEPARTURE_BACK_DATE")
    private String departureBackDate;


}
