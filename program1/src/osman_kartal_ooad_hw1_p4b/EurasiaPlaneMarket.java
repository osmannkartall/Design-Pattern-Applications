package osman_kartal_ooad_hw1_p4b;

/**
 * EurasiaPlaneMarket is one of the subclasses of PlaneMarket that contains
 * implementation of the protected abstract method that it inherits.
 * It gives a plane model with turbofan injection type and linen seating cover.
 *
 * @author Osman Kartal
 */
public class EurasiaPlaneMarket extends PlaneMarket {
    /**
     * Returns a plane for the given model with turbofan engine injection
     * and linen seating cover.
     *
     * @param model model of the created plane
     * @return created plane or null
     */
    protected Plane createPlane(String model) {
        Plane plane = null;
        PlanePartsFactory planePartsFactory = new EurasiaPlanePartsFactory();
        if (model.equals("TPX100")) {
            plane = new TPX100Plane(planePartsFactory);
            plane.name = "TPX 100 - Eurasia Market";
        }
        else if (model.equals("TPX200")) {
            plane = new TPX200Plane(planePartsFactory);
            plane.name = "TPX 200 - Eurasia Market";
        }
        else if (model.equals("TPX300")) {
            plane = new TPX300Plane(planePartsFactory);
            plane.name = "TPX 300 - Eurasia Market";
        }
        return plane;
    }
}
