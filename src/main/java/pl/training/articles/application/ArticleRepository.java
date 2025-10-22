package pl.training.articles.application;

import pl.training.articles.domain.article.Article;

public interface ArticleRepository {

    void save(Article article);
}
