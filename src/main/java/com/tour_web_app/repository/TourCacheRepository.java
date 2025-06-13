package com.tour_web_app.repository;

import com.tour_web_app.entity.Tour;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@AllArgsConstructor
@Repository
public class TourCacheRepository {
    private final RedisTemplate<String, Tour> redisTemplate;

    public void save(Tour tour) {
        redisTemplate.opsForValue().set("tour:" + tour.getId(), tour);
        redisTemplate.expire("tour:" + tour.getId(), Duration.ofMinutes(1));
    }

    public Tour findById(Long id) {
        return redisTemplate.opsForValue().get("tour:" + id);
    }

    public void deleteById(Long id) {
        redisTemplate.delete("tour:" + id);
    }
}
