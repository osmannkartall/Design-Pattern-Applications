package osman_kartal_ooad_hw1_p4b;

/**
 * OtherPlaneMarket is one of the subclasses of PlaneMarket that contains
 * implementation of the protected abstract method that it inherits.
 * It gives a plane model with geared turbofan injection type and leather seating cover.
 *
 * @author Osman Kartal
 */
public class OtherPlaneMarket extends PlaneMarket {
    /**
     * Returns a plane for the given model with geared turbofan engine injection
     * and leather seating cover.
     *
     * @param model model of the created plane
     * @return created plane or null
     */
    protected Plane createPlane(String model) {
        Plane plane = null;
        PlanePartsFactory planePartsFactory = new OtherPlanePartsFactory();
        if (model.equals("TPX100")) {
            plane = new TPX100Plane(planePartsFactory);
            plane.name = "TPX 100 - Other Market";
        }
        else if (model.equals("TPX200")) {
            plane = new TPX200Plane(planePartsFactory);
            plane.name = "TPX 200 - Other Market";
        }
        else if (model.equals("TPX300")) {
            plane = new TPX300Plane(planePartsFactory);
            plane.name = "TPX 300 - Other Market";
        }
        return plane;
    }
}
