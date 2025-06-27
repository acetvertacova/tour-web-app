package com.tour_web_app.dto;

import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private String content;
    private String username;
    private Long tourId;
    private Date createdAt;
}
