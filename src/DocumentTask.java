import java.util.*;
import java.util.concurrent.RecursiveTask;

public class DocumentTask extends RecursiveTask<Map<String, Map<String, Integer>>> {
    private final Document document;
    private final Set<String> keywords;

    DocumentTask(Document document, Set<String> keywords) {
        super();
        this.document = document;
        this.keywords = keywords;
    }
    @Override
    protected Map<String, Map<String, Integer>> compute() {
        var map = new HashMap<String, Integer>();
        List<String> lines = document.getLines();


        for(var line : lines) {
            String[] words = line.trim().split("(\\s|\\p{Punct})+");

            for(var word : words) {
                if (!keywords.contains(word)) {
                    continue;
                }

                if(map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        var result = new HashMap<String, Map<String, Integer>>();
        result.put(document.path, map);

        return result;
    }
}
