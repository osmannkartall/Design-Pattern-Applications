package osman_kartal_ooad_hw1_p3;

/**
 * Dec is one of the concrete class that extends ExoskeletonArmoredSuit.
 * It is one of the suit type.
 * It inherits description field and abstract methods from it's super class.
 * Then, it defines all of them according to it's features.
 *
 * @author Osman Kartal
 */
class Dec extends ExoskeletonArmoredSuit {
    /**
     * No parameter constructor.
     */
    Dec() {
        description = "Dec";
    }

    /**
     * Calculates cost of the suit.
     *
     * @return cost in TL
     */
    int cost() {
        return 500000;
    }

    /**
     * Calculates weight of the suit.
     *
     * @return weight in kilograms
     */
    double weight() {
        return 25.0;
    }

}
