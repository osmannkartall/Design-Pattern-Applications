package osman_kartal_ooad_hw1_p4b;

/**
 * EurasiaPlanePartsFactory is the class that contains methods to give
 * turbofan injection type and linen seating cover.
 *
 * @author Osman Kartal
 */
public class EurasiaPlanePartsFactory implements PlanePartsFactory {
    public EngineInjection createEngineInjection() {
        return new Turbofan();
    }

    public SeatingCover createSeatingCover() {
        return new Linen();
    }
}
