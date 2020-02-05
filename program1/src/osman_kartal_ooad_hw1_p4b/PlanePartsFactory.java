package osman_kartal_ooad_hw1_p4b;

/**
 * PlanePartsFactory is the interface that contains
 * methods for variable "parts" of the plane.
 *
 * @author Osman Kartal
 */
public interface PlanePartsFactory {
    EngineInjection createEngineInjection();
    SeatingCover createSeatingCover();
}
