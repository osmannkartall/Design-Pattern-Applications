package osman_kartal_ooad_hw1_p3;

/**
 * ExoskeletonArmoredSuitTester is the driver class for testing
 * operations on classes in p3 package.
 *
 * @author Osman Kartal
 */
public class ExoskeletonArmoredSuitTester {
    public static void main(String[] args) {
        ExoskeletonArmoredSuit suit = new Dec();
        System.out.println(suit.getDescription()
                + ": " + suit.cost() + "TL, " + suit.weight() + "kg.");

        ExoskeletonArmoredSuit suit2 = new Ora();
        suit2 = new Flamethrower(suit2);
        suit2 = new Flamethrower(suit2);
        suit2 = new Laser(suit2);
        suit2 = new RocketLauncher(suit2);
        suit2 = new AutoRifle(suit2);
        System.out.println(suit2.getDescription()
                + ": " + suit2.cost() + "TL, " + suit2.weight() + "kg.");

        ExoskeletonArmoredSuit suit3 = new Tor();
        suit3 = new Flamethrower(suit3);
        suit3 = new AutoRifle(suit3);
        suit3 = new Laser(suit3);
        System.out.println(suit3.getDescription()
                + ": " + suit3.cost() + "TL, " + suit3.weight() + "kg.");

    }
}
