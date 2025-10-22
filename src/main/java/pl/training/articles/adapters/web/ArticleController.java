package pl.training.articles.adapters.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.training.articles.application.CreateArticleUseCase;

@RestController
@RequiredArgsConstructor
class ArticleController {

    private final CreateArticleUseCase createArticleUseCase;

    @PostMapping("/articles")
    ResponseEntity<Void> createArticle(@RequestBody CreateArticleRequest createArticleRequest) {
        createArticleUseCase.create(new CreateArticleUseCase.Command(
                createArticleRequest.title(),
                createArticleRequest.authorId(),
                createArticleRequest.content(),
                createArticleRequest.category()
        ));

        return ResponseEntity.noContent().build();
    }

    public record CreateArticleRequest(
            String title,
            long authorId,
            String content,
            String category
    ) {
    }
}
