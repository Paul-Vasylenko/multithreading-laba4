import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderAnalizerTask extends RecursiveTask<ArrayList<Integer>> {
    private final Folder folder;
    public FolderAnalizerTask(Folder folder) {
        super();
        this.folder = folder;
    }

    @Override
    protected ArrayList<Integer> compute() {
        List<RecursiveTask<ArrayList<Integer>>> forks = new LinkedList<>();

        for (var subFolder : folder.getSubFolders()) {
            FolderAnalizerTask task = new FolderAnalizerTask(subFolder);
            forks.add(task);
            task.fork();
        }

        for (var document : folder.getDocuments()) {
            DocumentAnalizerTask task = new DocumentAnalizerTask(document);
            forks.add(task);
            task.fork();
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < forks.size(); i++) {
            var taskResult = forks.get(i).join();

            result.addAll(taskResult);
        }

        return result;
    }
}
