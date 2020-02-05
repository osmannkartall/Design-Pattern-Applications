package osman_kartal_ooad_hw1_p3;

/**
 * Flamethrower is one of the concrete classes that extends SuitAccessory class.
 * It decorates ExoskeletonArmoredSuit object by using a
 * ExoskeletonArmoredSuit reference so that suits can have accessories.
 * It adds Flamethrower cost to the total cost of suit.
 * It adds Flamethrower weight to the total weight of suit.
 *
 * @author Osman Kartal
 */
class Flamethrower extends SuitAccessory {
    /**
     * Object that holds reference of decorated suit object.
     */
    private ExoskeletonArmoredSuit suit;

    /**
     * One parameter constructor
     *
     * @param suit decorated suit object
     */
    Flamethrower(ExoskeletonArmoredSuit suit) {
        this.suit = suit;
    }

    /**
     * Getter for description of suit with accessories
     *
     * @return suit description
     */
    String getDescription() {
        return suit.getDescription() + ", Flamethrower";
    }

    /**
     * Calculates cost of the suit with a Flamethrower.
     *
     * @return cost in TL
     */
    int cost() {
        return 50000 + suit.cost();
    }

    /**
     * Calculates weight of the suit with a Flamethrower.
     *
     * @return weight in kilograms
     */
    double weight() {
        return 2.0 + suit.weight();
    }
}
