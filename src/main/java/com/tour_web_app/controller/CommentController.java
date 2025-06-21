package com.tour_web_app.controller;

import com.tour_web_app.Dto.CommentDto;
import com.tour_web_app.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comments/{tourId}")
    public List<CommentDto> comments(@PathVariable long tourId){
        return commentService.getAllByTourId(tourId);
    }

    @PostMapping("/comments")
    public CommentDto create(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @PutMapping("/comments/{id}")
    @PreAuthorize("commentSecurity.isCommentOwner(#id, authentication.name)")
    public CommentDto update(@RequestBody CommentDto commentDto, @PathVariable long id) {
        return commentService.update(commentDto, id);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteById(@PathVariable long id){
        commentService.deleteById(id);
    }
}
