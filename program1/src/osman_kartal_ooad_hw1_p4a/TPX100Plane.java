package osman_kartal_ooad_hw1_p4a;

/**
 * TPX100Plane is the class that represents one of the plane types.
 * It has constructor to define plane properties that inherited for
 * it's own needs.
 *
 * @author Osman Kartal
 */
class TPX100Plane extends Plane {
    TPX100Plane() {
        model = "TPX 100";
        purpose = "Domestic flights";
        skeleton = "Aluminum alloy";
        engine = "Single jet engine";
        seating = "50 seats";
    }
}
