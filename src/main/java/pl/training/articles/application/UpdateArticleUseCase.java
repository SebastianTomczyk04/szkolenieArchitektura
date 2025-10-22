package pl.training.articles.application;

import lombok.Getter;
import pl.training.articles.application.exceptions.ArticleNotFoundException;
import pl.training.articles.domain.article.Article;
import pl.training.articles.domain.article.ArticleCategory;
import pl.training.articles.domain.article.ArticleContent;
import pl.training.articles.domain.article.ArticleTitle;
import pl.training.articles.domain.comment.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UpdateArticleUseCase {

    private final ArticleRepository articleRepository;

    public UpdateArticleUseCase(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article handle(Command updateArticle) {
        Article articleToUpdate = findArticleToUpdate(updateArticle.getArticleId())
                .orElseThrow(() ->
                        new ArticleNotFoundException("Article with id: " + updateArticle.getArticleId() + "not found."));
        articleToUpdate = updateArticle(articleToUpdate, updateArticle);
        return articleRepository.update(articleToUpdate);
    }

    private Optional<Article> findArticleToUpdate(Long articleId) {
        return articleRepository.findById(articleId);
    }

    private Article updateArticle(Article articleToUpdate, Command updateArticle) {
        articleToUpdate.updateArticle(new ArticleTitle(updateArticle.getTitle()),
                new ArticleContent(updateArticle.getArticleContent()),
                updateArticle.getArticleCategory(), updateArticle.getLastUpdatedAt());
        return articleToUpdate;
    }

    @Getter
    public static class Command {
        private Long articleId;
        private String title;
        private Long authorId;
        private List<Comment> comments;
        private String articleContent;
        private ArticleCategory articleCategory;
        private LocalDateTime lastUpdatedAt;
    }
}
