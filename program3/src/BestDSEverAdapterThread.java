/**
 * This class used for BestDSEverAdapter class with multi-threading.
 */
public class BestDSEverAdapterThread implements Runnable {
    private BestDSEverAdapter bestDSEverAdapter;
    BestDSEverAdapterThread(BestDSEverAdapter bestDSEverAdapter) {
        this.bestDSEverAdapter = bestDSEverAdapter;
    }
    public void run()
    {
        try {
            System.out.println(Thread.currentThread().getName() + " is inserting items.");
            bestDSEverAdapter.add(Thread.currentThread().getId());
            bestDSEverAdapter.add(Thread.currentThread().getName());
        }
        catch (Exception e) {
            System.out.println ("Exception");
        }
    }
}
