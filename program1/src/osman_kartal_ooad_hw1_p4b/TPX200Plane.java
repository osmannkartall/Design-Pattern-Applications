package osman_kartal_ooad_hw1_p4b;

/**
 * TPX200Plane is the class that represents one of the plane types.
 * It has constructor to define plane properties that inherited for
 * it's own needs.
 *
 * @author Osman Kartal
 */
class TPX200Plane extends Plane {
    /**
     * This holds reference to a super class to get different
     * injection types and seating covers.
     */
    private PlanePartsFactory planePartsFactory;

    TPX200Plane(PlanePartsFactory planePartsFactory) {
        this.planePartsFactory = planePartsFactory;
        model = "TPX 200";
        purpose = "Domestic and short international flights";
        skeleton = "Nickel alloy";
        engine = "Twin jet engines";
        seating = "100 seats";
    }

    protected void prepare() {
        System.out.println("Purpose: " + purpose);
        System.out.println("Adding " + skeleton);
        System.out.println("Adding " + engine);
        System.out.println("Adding " + seating);
        engineInjection = planePartsFactory.createEngineInjection();
        seatingCover = planePartsFactory.createSeatingCover();
    }
}

