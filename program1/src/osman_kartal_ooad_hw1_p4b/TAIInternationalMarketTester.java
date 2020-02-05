package osman_kartal_ooad_hw1_p4b;

/**
 * TAIInternationalMarketTester is the driver class for testing
 * operations on classes in p3 package.
 *
 * @author Osman Kartal
 */
public class TAIInternationalMarketTester {
    public static void main(String[] args) {
        PlaneMarket domesticMarket = new DomesticPlaneMarket();
        Plane plane = domesticMarket.orderPlane("TPX100");
        System.out.println("...");
        System.out.print("Ordered plane is " + plane.toString());
        System.out.println("---------------------------------------------------");

        PlaneMarket eurasiaMarket = new EurasiaPlaneMarket();
        plane = eurasiaMarket.orderPlane("TPX300");
        System.out.println("...");
        System.out.print("Ordered plane is " + plane.toString());
        System.out.println("---------------------------------------------------");

        PlaneMarket otherMarket = new OtherPlaneMarket();
        plane = otherMarket.orderPlane("TPX200");
        System.out.println("...");
        System.out.print("Ordered plane is " + plane.toString());
        System.out.println("---------------------------------------------------");
    }
}