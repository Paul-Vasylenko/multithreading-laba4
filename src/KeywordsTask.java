import java.util.Map;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class KeywordsTask {
    private final ForkJoinPool forkJoinPool = new ForkJoinPool();
    public  Map<String, Map<String, Integer>> analyze(Folder folder, Set<String> keywords) {
        return forkJoinPool.invoke(new FolderTask(folder, keywords));
    }
}
