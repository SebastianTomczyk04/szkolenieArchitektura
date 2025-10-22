package pl.training.articles.adapters.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerModuleTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateArticle() throws Exception {
        // when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/articles")
                .contentType("application/json")
                .content("""
                        {
                            "title": "New Article",
                            "authorId": 1,
                            "content": "This is the content of the new article.",
                            "category": "TECHNOLOGY"
                        }
                        """));

        // then
        resultActions.andExpect(status().isNoContent());
    }
}