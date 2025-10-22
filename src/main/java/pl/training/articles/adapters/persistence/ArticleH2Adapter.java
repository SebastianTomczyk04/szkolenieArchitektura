package pl.training.articles.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.training.articles.application.ArticleRepository;
import pl.training.articles.domain.article.*;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class ArticleH2Adapter implements ArticleRepository {

    private final ArticleJpaRepository articleJpaRepository;

    @Override
    public Optional<Article> findById(Long articleId) {
        Optional<ArticleEntity> articleEntity = articleJpaRepository.findById(articleId);
        return articleEntity.map(art -> Article.builder()
                .articleCategory(ArticleCategory.valueOf(articleEntity.get().getCategory()))
                .articleContent(new ArticleContent(articleEntity.get().getContent()))
                .lastUpdatedAt(articleEntity.get().getLastUpdatedAt())
                .authorId(new AuthorId(articleEntity.get().getAuthorId()))
                .title(new ArticleTitle(articleEntity.get().getTitle()))
                .build());
    }

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
