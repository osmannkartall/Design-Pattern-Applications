/**
 * This is the adapter class to make BestDSEver class which comes as black-box thread-safe.
 */
public class BestDSEverAdapter implements NormalDS{
    private BestDSEver bestDSEver;

    public BestDSEverAdapter(BestDSEver bestDSEver) {
        this.bestDSEver = bestDSEver;
    }

    public synchronized void add(Object o) {
        bestDSEver.insert(o);
    }

    public synchronized void delete(Object o) {
        bestDSEver.remove(o);
    }

    public synchronized Object take(int index) {
        return bestDSEver.get(index);
    }
}
