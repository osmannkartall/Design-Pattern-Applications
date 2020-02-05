package osman_kartal_ooad_hw1_p4a;

/**
 * TPX200Plane is the class that represents one of the plane types.
 * It has constructor to define plane properties that inherited for
 * it's own needs.
 *
 * @author Osman Kartal
 */
class TPX200Plane extends Plane {
    TPX200Plane() {
        model = "TPX 200";
        purpose = "Domestic and short international flights";
        skeleton = "Nickel alloy";
        engine = "Twin jet engines";
        seating = "100 seats";
    }
}
