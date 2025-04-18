package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SearchEngineTest {

    @Test
    void testSearchOnEmptyDocuments() {
        assertThat(SearchEngine.search(List.of(), "kawabanga")).isEmpty();
    }

    @Test
    void testSearchOnSomeDocuments() {
        var doc1 = "I can't shoot straight unless I've had a pint!";
        var doc2 = "Don't shoot shoot    shoot that thing at me.";
        var doc3 = "I'm your shooter.";
        var doc4 = "";
        var doc5 = "    ";

        List<Map<String, String>> docs = List.of(
                Map.of("id", "doc1", "text", doc1),
                Map.of("id", "doc2", "text", doc2),
                Map.of("id", "doc3", "text", doc3),
                Map.of("id", "doc4", "text", doc4),
                Map.of("id", "doc5", "text", doc5)
        );
        assertThat(SearchEngine.search(docs, "shoot"))
                .containsExactlyInAnyOrder("doc1", "doc2");
    }

    @Test
    void testSearchOnDocumentsWithSpecialSymbols() {
        var doc1 = "I can't shoot straight unless I've had a shoot!";
        var doc2 = "Don't shoot shoot shoot that thing at me.";
        var doc3 = "I'm your shoot.";
        var doc4 = "I'm your shoot_shoot.";

        List<Map<String, String>> docs = List.of(
                Map.of("id", "doc1", "text", doc1),
                Map.of("id", "doc2", "text", doc2),
                Map.of("id", "doc3", "text", doc3),
                Map.of("id", "doc4", "text", doc4)
        );
        assertThat(SearchEngine.search(docs, "shoot"))
                .containsExactlyInAnyOrder("doc1", "doc2", "doc3");
    }
}