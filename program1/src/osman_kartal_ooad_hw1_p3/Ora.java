package osman_kartal_ooad_hw1_p3;

/**
 * Ora is one of the concrete class that extends ExoskeletonArmoredSuit.
 * It is one of the suit type.
 * It inherits description field and abstract methods from it's super class.
 * Then, it defines all of them according to it's features.
 *
 */
class Ora extends ExoskeletonArmoredSuit {
    /**
     * No parameter constructor.
     */
    Ora() {
        description = "Ora";
    }

    /**
     * Calculates cost of the suit.
     *
     * @return cost in TL
     */
    int cost() {
        return 1500000;
    }

    /**
     * Calculates weight of the suit.
     *
     * @return weight in kilograms
     */
    double weight() {
        return 30.0;
    }

}
