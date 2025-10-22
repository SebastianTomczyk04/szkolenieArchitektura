package pl.training.articles.domain.article;

public record ArticleTitle(String value) {

    public ArticleTitle {
         if(value == null || value.isBlank()) {
             throw new IllegalArgumentException("ArticleTitle cannot be null or blank");
         }
    }
}
