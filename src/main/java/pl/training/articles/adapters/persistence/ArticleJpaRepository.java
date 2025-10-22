package pl.training.articles.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface ArticleJpaRepository extends JpaRepository<ArticleEntity, Long> {
}
