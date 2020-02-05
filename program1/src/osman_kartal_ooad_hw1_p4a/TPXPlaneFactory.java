package osman_kartal_ooad_hw1_p4a;

/**
 * TPXPlaneFactory is the concrete class that contains
 * implementation of the protected abstract method that it inherits.
 *
 * @author Osman Kartal
 */
class TPXPlaneFactory extends PlaneFactory{
    /**
     * Returns a plane for the given model
     *
     * @param model model of the created plane
     * @return created plane or null
     */
    protected Plane createPlane(String model) {
        if (model.equals("TPX100")) {
            return new TPX100Plane();
        }
        else if (model.equals("TPX200")) {
            return new TPX200Plane();
        }
        else if (model.equals("TPX300")) {
            return new TPX300Plane();
        }
        else {
            return null;
        }
    }
}
