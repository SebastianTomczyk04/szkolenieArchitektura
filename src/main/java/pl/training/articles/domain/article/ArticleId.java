package pl.training.articles.domain.article;

public record ArticleId(long value) {

    public ArticleId {
        if(value < 0) {
            throw new IllegalArgumentException("ArticleId must be positive");
        }
    }
}
