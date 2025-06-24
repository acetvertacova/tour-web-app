package com.tour_web_app.repository;

import com.tour_web_app.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByTourId(Long tourId);
}
