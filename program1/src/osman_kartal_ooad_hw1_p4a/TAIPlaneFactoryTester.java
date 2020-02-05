package osman_kartal_ooad_hw1_p4a;

/**
 * TAIPlaneFactoryTester is the driver class for testing
 * operations on classes in p3 package.
 *
 * @author Osman Kartal
 */
public class TAIPlaneFactoryTester {
    public static void main(String[] args) {
        PlaneFactory tpxPlaneFactory = new TPXPlaneFactory();

        Plane plane = tpxPlaneFactory.orderPlane("TPX200");
        System.out.println("Ordered plane: " + plane.model + ", " + plane.purpose
                + ", " + plane.skeleton + ", " + plane.engine + ", " + plane.seating);

        System.out.println("----------------------------------------------------------");
        plane = tpxPlaneFactory.orderPlane("TPX100");
        System.out.println("Ordered plane: " + plane.model + ", " + plane.purpose
                + ", " + plane.skeleton + ", " + plane.engine + ", " + plane.seating);

        System.out.println("----------------------------------------------------------");
        plane = tpxPlaneFactory.orderPlane("TPX300");
        System.out.println("Ordered plane: " + plane.model + ", " + plane.purpose
                + ", " + plane.skeleton + ", " + plane.engine + ", " + plane.seating);

    }
}
