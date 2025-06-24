package com.tour_web_app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "seats_booked")
    private int seatsBooked;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private Tour tour;
}
