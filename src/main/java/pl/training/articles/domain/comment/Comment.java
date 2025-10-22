package pl.training.articles.domain.comment;

import pl.training.articles.domain.author.AuthorName;

import java.time.LocalDateTime;

public class Comment {

    private CommentId id;
    private CommentContent content;
    private AuthorName authorName;
    private LocalDateTime createdAt;
}
