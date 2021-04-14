import java.util.concurrent.atomic.LongAdder;

public class Shop implements Runnable{

    private static LongAdder sum;
    protected Long[] receipts;
    private final long BILL_TIMER = 2000L;

    public Shop(Long[] receipts) {
        sum = new LongAdder();
        this.receipts = receipts;
    }

    public long getSum() {
        return sum.sum();
    }

    protected void workingDay() {

        for (int i = 0; i < receipts.length; i++) {

            try {
                Thread.sleep(BILL_TIMER);
                sum.add(receipts[i]);
                System.out.println(Thread.currentThread().getName() + " пробил чек на сумму " + receipts[i] + " рублей");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void run() {
        workingDay();
    }
}
