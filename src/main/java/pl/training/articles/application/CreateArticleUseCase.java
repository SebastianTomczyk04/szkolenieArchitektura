package pl.training.articles.application;

import lombok.RequiredArgsConstructor;
import pl.training.annotations.Atomic;
import pl.training.annotations.UseCase;
import pl.training.articles.domain.article.*;

@UseCase
@RequiredArgsConstructor
public class CreateArticleUseCase {

    private final ArticleIdGenerator articleIdGenerator;
    private final ArticleRepository articleRepository;

    @Atomic
    public void create(Command command) {
        Article article = new Article(
                new ArticleId(articleIdGenerator.generate()),
                new ArticleTitle(command.title),
                new AuthorId(command.authorId),
                new ArticleContent(command.content),
                ArticleCategory.valueOf(command.category)
        );

        articleRepository.save(article);
    }

    public record Command(
            String title,
            long authorId,
            String content,
            String category
    ) {
    }
}
