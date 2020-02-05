import java.util.ArrayList;
import java.util.List;

class BestDSEver {
    private List<Object> objects;

    /**
     * Default constructor. It must private so that only one object from the class can be sampled.
     */
    BestDSEver() {
        objects = new ArrayList<Object>();
    }

    List<Object> getObjects() {
        return objects;
    }

    /**
     * Insert that object to the top. Shift the rest of the list to the right once.
     * @param o object to be inserted
     */
    void insert(Object o) {
        objects.add(0, o);
    }

    /**
     * Delete that object first encountered in the list.
     * @param o object to be removed
     */
    void remove(Object o) {
        objects.remove(o);
    }

    /**
     * Go to the desired index and return the object there.
     * @param index index of the object
     * @return object at given index
     */
    Object get(int index) {
        return objects.get(index);
    }

}