package osman_kartal_ooad_hw1_p3;

/**
 * SuitAccessory is the abstract class that extends ExoskeletonArmoredSuit.
 * It provides the interface for different suit accessory types that
 * decorates suit objects. It defines inherited getDescription method as
 * abstract so that it's subclasses can add to accessory description to
 * suit description.
 * It also delegates implementation of the cost and
 * weight methods to it's subclasses so that cost and weight of accessory
 * can be added to total cost and weight.
 *
 * @author Osman Kartal
 */
abstract class SuitAccessory extends ExoskeletonArmoredSuit {
    /**
     * Getter for description of suit with accessories
     *
     * @return suit description
     */
    abstract String getDescription();
}