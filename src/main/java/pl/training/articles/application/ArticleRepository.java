package pl.training.articles.application;

import pl.training.articles.domain.article.Article;
import pl.training.articles.domain.article.ArticleId;

import java.util.Optional;

public interface ArticleRepository {
    Article update(Article article);
    Optional<Article> findById(Long articleId);
    void save(Article article);
}
