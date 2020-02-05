package osman_kartal_ooad_hw1_p3;

/**
 * Laser is one of the concrete classes that extends SuitAccessory class.
 * It decorates ExoskeletonArmoredSuit object by using a
 * ExoskeletonArmoredSuit reference so that suits can have accessories.
 * It adds Laser cost to the total cost of suit.
 * It adds Laser weight to the total weight of suit.
 *
 * @author Osman Kartal
 */
class Laser extends SuitAccessory {
    /**
     * Object that holds reference of decorated suit object.
     */
    private ExoskeletonArmoredSuit suit;

    /**
     * One parameter constructor
     *
     * @param suit decorated suit object
     */
    Laser(ExoskeletonArmoredSuit suit) {
        this.suit = suit;
    }

    /**
     * Getter for description of suit with accessories
     *
     * @return suit description
     */
    String getDescription() {
        return suit.getDescription() + ", Laser";
    }

    /**
     * Calculates cost of the suit with a Laser.
     *
     * @return cost in TL
     */
    int cost() {
        return 200000 + suit.cost();
    }

    /**
     * Calculates weight of the suit with a Laser.
     *
     * @return weight in kilograms
     */
    double weight() {
        return 5.5 + suit.weight();
    }
}
