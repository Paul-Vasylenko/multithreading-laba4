import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

public class Main {
    public static final int ACCOUNTS = 10;
    public static final int INITIAL_BALANCE = 10000;
    public static void main(String[] args) {
        Bank b = new Bank(ACCOUNTS, INITIAL_BALANCE);
        List<TransferTask> transferTasks = new ArrayList<>();
        for (int i = 0; i < ACCOUNTS; i++){
            TransferTask t = new TransferTask(b, i,
                    INITIAL_BALANCE);
            transferTasks.add(t);
        }

        ForkJoinTask.invokeAll(transferTasks);
    }
}