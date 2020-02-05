package osman_kartal_ooad_hw1_p3;

/**
 * RocketLauncher is one of the concrete classes that extends SuitAccessory class.
 * It decorates ExoskeletonArmoredSuit object by using a
 * ExoskeletonArmoredSuit reference so that suits can have accessories.
 * It adds RocketLauncher cost to the total cost of suit.
 * It adds RocketLauncher weight to the total weight of suit.
 *
 * @author Osman Kartal
 */
class RocketLauncher extends SuitAccessory {
    /**
     * Object that holds reference of decorated suit object.
     */
    private ExoskeletonArmoredSuit suit;

    /**
     * One parameter constructor
     *
     * @param suit decorated suit object
     */
    RocketLauncher(ExoskeletonArmoredSuit suit) {
        this.suit = suit;
    }

    /**
     * Getter for description of suit with accessories
     *
     * @return suit description
     */
    String getDescription() {
        return suit.getDescription() + ", RocketLauncher";
    }

    /**
     * Calculates cost of the suit with a RocketLauncher.
     *
     * @return cost in TL
     */
    int cost() {
        return 150000 + suit.cost();
    }

    /**
     * Calculates weight of the suit with a RocketLauncher.
     *
     * @return weight in kilograms
     */
    double weight() {
        return 7.5 + suit.weight();
    }
}
