package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchEngine {

    public static List<String> search(List<Map<String, String>> documents, String stringToSearch) {
        var result = new ArrayList<String>();
        for (Map<String, String> document : documents) {
            var text = document.get("text");
            for (String word : text.split(" ")) {
                if (word.equals(stringToSearch)) {
                    result.add(document.get("id"));
                    break;
                }
            }
        }
        return result;
    }

}
