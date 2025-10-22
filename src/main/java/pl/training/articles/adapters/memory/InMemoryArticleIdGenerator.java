package pl.training.articles.adapters.memory;

import org.springframework.stereotype.Component;
import pl.training.articles.application.ArticleIdGenerator;

import java.util.concurrent.atomic.AtomicInteger;

@Component
class InMemoryArticleIdGenerator implements ArticleIdGenerator {

    private final AtomicInteger sequence = new AtomicInteger(0);

    @Override
    public long generate() {
        return sequence.getAndIncrement();
    }
}
