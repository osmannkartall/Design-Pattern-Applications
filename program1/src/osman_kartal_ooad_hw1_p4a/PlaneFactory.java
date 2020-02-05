package osman_kartal_ooad_hw1_p4a;

/**
 * PlaneFactory is the abstract class that contains a common method and
 * an abstract method for it's subclasses that creates plane.
 *
 * @author Osman Kartal
 */
abstract class PlaneFactory {
    /**
     * Executes common methods to all planes after a subclass
     * create a plane for the given model.
     *
     * @param model model of the created plane
     * @return created plane
     */
    Plane orderPlane(String model) {
        Plane plane;
        plane = createPlane(model);
        plane.prepare();
        plane.constructSkeleton();
        plane.placeEngines();
        plane.placeSeats();
        return plane;
    }

    /**
     * Returns a plane for the given model
     *
     * @param model model of the created plane
     * @return created plane or null
     */
    protected abstract Plane createPlane(String model);
}
