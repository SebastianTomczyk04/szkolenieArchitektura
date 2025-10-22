package pl.training.articles.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ArticleJpaRepository extends JpaRepository<ArticleEntity, Long> {
    Optional<ArticleEntity> findById(Long articleId);
}
