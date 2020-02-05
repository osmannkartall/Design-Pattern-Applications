package osman_kartal_ooad_hw1_p4b;

/**
 * Plane is the abstract class that contains all common operations
 * for plane production.
 * It also provides data fields to define plane properties.
 *
 * @author Osman Kartal
 */
abstract class Plane {
    String model;
    String purpose;
    String skeleton;
    String engine;
    String seating;
    String name;
    EngineInjection engineInjection;
    SeatingCover seatingCover;

    /**
     * Simulates preparation of the plane parts.
     */
    abstract void prepare();

    void constructSkeleton() {
        System.out.println("Construct skeleton.");
    }

    void placeEngines() {
        System.out.println("Place engines.");
    }

    void placeSeats() {
        System.out.println("Place seats.");
    }

    EngineInjection getEngineInjection() {
        return engineInjection;
    }

    SeatingCover getSeatingCover() {
        return seatingCover;
    }

    /**
     *
     * @return string representation of the created plane.
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("---- " + name + " ----\n");
        if (engineInjection != null) {
            result.append(engineInjection);
            result.append("\n");
        }
        if (seatingCover != null) {
            result.append(seatingCover);
            result.append("\n");
        }
        return result.toString();
    }
}
