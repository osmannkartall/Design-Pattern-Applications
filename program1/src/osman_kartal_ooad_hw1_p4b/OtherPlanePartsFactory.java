package osman_kartal_ooad_hw1_p4b;

/**
 * EurasiaPlanePartsFactory is the class that contains methods to give
 * geared turbofan injection type and leather seating cover.
 *
 * @author Osman Kartal
 */
public class OtherPlanePartsFactory implements PlanePartsFactory {
    public EngineInjection createEngineInjection() {
        return new GearedTurbofan();
    }

    public SeatingCover createSeatingCover() {
        return new Leather();
    }
}
