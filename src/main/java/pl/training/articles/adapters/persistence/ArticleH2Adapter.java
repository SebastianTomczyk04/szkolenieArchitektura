package pl.training.articles.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.training.articles.application.ArticleRepository;
import pl.training.articles.domain.article.Article;

@Component
@RequiredArgsConstructor
class ArticleH2Adapter implements ArticleRepository {

    private final ArticleJpaRepository articleJpaRepository;

    @Override
    public void save(Article article) {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(article.getArticleId().value());
        entity.setTitle(article.getTitle().value());
        entity.setAuthorId(article.getAuthorId().value());
        entity.setContent(article.getArticleContent().value());
        entity.setCategory(article.getArticleCategory().name());
        entity.setLastUpdatedAt(article.getLastUpdatedAt());

        articleJpaRepository.save(entity);
    }
}
