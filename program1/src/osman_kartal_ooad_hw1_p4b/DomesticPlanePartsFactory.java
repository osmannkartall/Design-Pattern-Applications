package osman_kartal_ooad_hw1_p4b;

/**
 * DomesticPlanePartsFactory is the class that contains methods to give
 * turbojet injection type and velvet seating cover.
 *
 * @author Osman Kartal
 */
public class DomesticPlanePartsFactory implements PlanePartsFactory {
    public EngineInjection createEngineInjection() {
        return new Turbojet();
    }

    public SeatingCover createSeatingCover() {
        return new Velvet();
    }
}
