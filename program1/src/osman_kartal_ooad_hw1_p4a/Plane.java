package osman_kartal_ooad_hw1_p4a;

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

    /**
     * Simulates preparation of the plane parts.
     */
    void prepare() {
        System.out.println("Preparing " + model);
        System.out.println("It's purpose: " + purpose);
        System.out.println("Adding " + skeleton);
        System.out.println("Adding " + engine);
        System.out.println("Adding " + seating);
    }

    void constructSkeleton() {
        System.out.println("Construct skeleton.");
    }

    void placeEngines() {
        System.out.println("Place engines.");
    }

    void placeSeats() {
        System.out.println("Place seats.");
    }

    // Getter Methods

    /**
     *
     * @return model of the plane
     */
    String getModel() {
        return model;
    }

    /**
     *
     * @return usage purpose of the plane
     */
    String getPurpose() {
        return purpose;
    }

    /**
     *
     * @return skeleton of the plane
     */
    String getSkeleton() {
        return skeleton;
    }

    /**
     *
     * @return engine of the plane
     */
    String getEngine() {
        return engine;
    }

    /**
     *
     * @return seating of the plane
     */
    String getSeating() {
        return seating;
    }
}
