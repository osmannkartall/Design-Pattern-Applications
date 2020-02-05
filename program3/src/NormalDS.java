/**
 * This is the interface similar to BestDSEver class. Adapter class implements it
 * to match with BestDsEver class with its small differences(method names, thread-safety).
 */
public interface NormalDS {
    /**
     * Insert that object to the top. Shift the rest of the list to the right once.
     * @param o object to be inserted
     */
    void add(Object o);

    /**
     * Delete that object first encountered in the list.
     * @param o object to be removed
     */
    void delete(Object o);

    /**
     * Go to the desired index and return the object there.
     * @param index index of the object
     * @return object at given index
     */
    Object take(int index);
}
