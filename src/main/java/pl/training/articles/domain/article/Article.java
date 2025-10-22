package pl.training.articles.domain.article;

import pl.training.articles.domain.author.Author;
import pl.training.articles.domain.comment.Comment;

import java.time.LocalDateTime;
import java.util.List;

public class Article {

    private ArticleId articleId;
    private ArticleTitle title;
    private Author author;
    private List<Comment> comments;
    private ArticleContent articleContent;
    private ArticleCategory articleCategory;
    private LocalDateTime lastUpdatedAt;
}
