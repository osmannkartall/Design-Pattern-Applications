package osman_kartal_ooad_hw1_p4a;

/**
 * TPX300Plane is the class that represents one of the plane types.
 * It has constructor to define plane properties that inherited for
 * it's own needs.
 *
 * @author Osman Kartal
 */
class TPX300Plane extends Plane {
    TPX300Plane() {
        model = "TPX 300";
        purpose = "Transatlantic flights";
        skeleton = "Titanium alloy";
        engine = "Quadro jet engines";
        seating = "250 seats";
    }

    /**
     * Overrides inherited placeSeats method to give specific information
     * for it's own model.
     */
    @Override
    void placeSeats() {
        System.out.println("Place seats. CAUTION: There should be at least 6 seats in a row.");
    }
}
