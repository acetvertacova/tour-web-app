package com.tour_web_app.security;

import com.tour_web_app.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("commentSecurity")
public class CommentSecurity {
    private final CommentRepository commentRepository;

    //called by preauthorize annotation
    public boolean isCommentOwner(Long commentId, String username) {
        return commentRepository.findById(commentId)
                .map(comment -> comment.getUser().getUsername().equals(username))
                .orElse(false);
    }

}
