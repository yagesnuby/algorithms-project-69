package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchEngine {

    public static List<String> search(List<Map<String, String>> documents, String stringToSearch) {
        var pattern = Pattern.compile("\\w+");
        var result = new ArrayList<String>();
        for (Map<String, String> document : documents) {
            var text = document.get("text");
            for (String token : text.split(" ")) {
                String term = pattern.matcher(token)
                        .results()
                        .map(MatchResult::group)
                        .collect(Collectors.joining());
                if (term.equals(stringToSearch)) {
                    result.add(document.get("id"));
                    break;
                }
            }
        }
        return result;
    }

}
