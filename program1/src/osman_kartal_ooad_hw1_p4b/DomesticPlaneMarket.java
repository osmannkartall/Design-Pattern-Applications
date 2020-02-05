package osman_kartal_ooad_hw1_p4b;

/**
 * DomesticPlaneMarket is one of the subclasses of PlaneMarket that contains
 * implementation of the protected abstract method that it inherits.
 * It gives a plane model with turbojet injection type and velvet seating cover.
 *
 * @author Osman Kartal
 */
public class DomesticPlaneMarket extends PlaneMarket {
    /**
     * Returns a plane for the given model with turbojet engine injection
     * and velvet seating cover.
     *
     * @param model model of the created plane
     * @return created plane or null
     */
    protected Plane createPlane(String model) {
        Plane plane = null;

        // Get seating cover and injection type for Domestic Market.
        PlanePartsFactory planePartsFactory = new DomesticPlanePartsFactory();

        if (model.equals("TPX100")) {
            plane = new TPX100Plane(planePartsFactory);
            plane.name = "TPX 100 - Domestic Market";
        }
        else if (model.equals("TPX200")) {
            plane = new TPX200Plane(planePartsFactory);
            plane.name = "TPX 200 - Domestic Market";
        }
        else if (model.equals("TPX300")) {
            plane = new TPX300Plane(planePartsFactory);
            plane.name = "TPX 300 - Domestic Market";
        }
        return plane;
    }
}
