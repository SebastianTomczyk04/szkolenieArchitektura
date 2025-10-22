package pl.training.articles.adapters.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "article")
@Getter
@Setter
class ArticleEntity {

    @Id
    private Long id;
    private String title;
    private long authorId;
    // todo: add comments relation
    private String content;
    private String category;
    private LocalDateTime lastUpdatedAt;
}
