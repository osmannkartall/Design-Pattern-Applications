package osman_kartal_ooad_hw1_p3;

/**
 * AutoRifle is one of the concrete classes that extends SuitAccessory class.
 * It decorates ExoskeletonArmoredSuit object by using a
 * ExoskeletonArmoredSuit reference so that suits can have accessories.
 * It adds AutoRifle cost to the total cost of suit.
 * It adds AutoRifle weight to the total weight of suit.
 *
 * @author Osman Kartal
 */
class AutoRifle extends SuitAccessory {
    /**
     * Object that holds reference of decorated suit object.
     */
    private ExoskeletonArmoredSuit suit;

    /**
     * One parameter constructor
     *
     * @param suit decorated suit object
     */
    AutoRifle(ExoskeletonArmoredSuit suit) {
        this.suit = suit;
    }

    /**
     * Getter for description of suit with accessories
     *
     * @return suit description
     */
    String getDescription() {
        return suit.getDescription() + ", AutoRifle";
    }

    /**
     * Calculates cost of the suit with an AutoRifle.
     *
     * @return cost in TL
     */
    int cost() {
        return 30000 + suit.cost();
    }

    /**
     * Calculates weight of the suit with an AutoRifle.
     *
     * @return weight in kilograms
     */
    double weight() {
        return 1.5 + suit.weight();
    }
}
