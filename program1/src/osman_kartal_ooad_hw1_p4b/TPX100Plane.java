package osman_kartal_ooad_hw1_p4b;

/**
 * TPX100Plane is the class that represents one of the plane types.
 * It has constructor to define plane properties that inherited for
 * it's own needs.
 *
 * @author Osman Kartal
 */
class TPX100Plane extends Plane {
    /**
     * This holds reference to a super class to get different
     * injection types and seating covers.
     */
    private PlanePartsFactory planePartsFactory;

    TPX100Plane(PlanePartsFactory planePartsFactory) {
        this.planePartsFactory = planePartsFactory;
        model = "TPX 100";
        purpose = "Domestic flights";
        skeleton = "Aluminum alloy";
        engine = "Single jet engine";
        seating = "50 seats";
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
