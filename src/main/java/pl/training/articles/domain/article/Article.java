package pl.training.articles.domain.article;

import lombok.Getter;
import pl.training.articles.domain.comment.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Article {

    private ArticleId articleId;
    private ArticleTitle title;
    private AuthorId authorId;
    private List<Comment> comments;
    private ArticleContent articleContent;
    private ArticleCategory articleCategory;
    private LocalDateTime lastUpdatedAt;

    public Article(ArticleId articleId, ArticleTitle title, AuthorId authorId, ArticleContent articleContent, ArticleCategory articleCategory) {
        this.articleId = articleId;
        this.title = title;
        this.authorId = authorId;
        this.articleContent = articleContent;
        this.articleCategory = articleCategory;
    }

    public void updateArticle(ArticleTitle title, ArticleContent articleContent
            ,ArticleCategory articleCategory, LocalDateTime lastUpdatedAt) {
        this.title = title;
        this.articleContent = articleContent;
        this.articleCategory = articleCategory;
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
