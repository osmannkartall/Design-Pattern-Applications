package osman_kartal_ooad_hw1_p3;

/**
 * ExoskeletonArmoredSuit is the abstract class that provides basic
 * methods and data to all suit types.
 * It has cost and weight method so that subclasses can define
 * different cost and weight values for their special suits.
 * Additionally, it provides description field so that
 * subclasses(different suits) can have different descriptions.
 *
 * @author Osman Kartal
 */
abstract class ExoskeletonArmoredSuit {
    /**
     * Description of suit.
     */
    String description;

    /**
     * Calculates cost of the suit.
     *
     * @return cost of the suit.
     */
    abstract int cost();

    /**
     * Calculates weight of the suit.
     *
     * @return weight of the suit.
     */
    abstract double weight();

    /**
     * Getter for suit description
     *
     * @return suit description
     */
    String getDescription() {
        return description;
    }
}
