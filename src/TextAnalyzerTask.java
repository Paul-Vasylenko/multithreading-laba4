import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class TextAnalyzerTask {
    private final ForkJoinPool forkJoinPool = new ForkJoinPool();
    public ArrayList<Integer> analyze(Folder folder) {
        return forkJoinPool.invoke(new FolderAnalizerTask(folder));
    }
}
