import java.util.concurrent.RecursiveAction;

class TransferTask extends RecursiveAction {
    private Bank bank;
    private int fromAccount;
    private int maxAmount;
    private static final int REPS = 500000;
    public TransferTask(Bank b, int from, int max){
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }
    @Override
    public void compute(){
            for (int i = 0; i < REPS; i++) {
                int toAccount = (int) (bank.size() * Math.random());
                int amount = (int) (maxAmount * Math.random()/REPS);
                bank.transferSync(fromAccount, toAccount, amount);
            }
    }
}