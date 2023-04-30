import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DocumentAnalizerTask extends RecursiveTask<ArrayList<Integer>> {
    private final Document document;
    public DocumentAnalizerTask(Document document) {
        super();
        this.document = document;
    }

    @Override
    protected ArrayList<Integer> compute() {
        List<String> lines = document.getLines();
        ArrayList<Integer> lengths = new ArrayList<>();
        for(var line : lines) {
            String[] words = line.trim().split("(\\s|\\p{Punct})+");

            for(var word : words) {
                lengths.add(word.length());
            }
        }
        return lengths;
    }
}
