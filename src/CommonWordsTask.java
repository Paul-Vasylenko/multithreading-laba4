import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class CommonWordsTask {
    private final ForkJoinPool forkJoinPool = new ForkJoinPool();
    public Set<String> analyze(Folder folder) {
        return forkJoinPool.invoke(new FolderTask(folder));
    }
}
