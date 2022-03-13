package projekt.food;

import java.util.function.UnaryOperator;

public interface IceCream extends Food
{
    IceCream.Variant Variant = null;

    /**
     * The definition of this method describes the flavor of the ice cream
     * @return the flavor of the actual IceCream type
     */
    String getFlavor();
    interface Config extends Food.Config
    {
        /**
         * This method is just defined in this nested interface.
         * Its intended implementation goes like this:
         * Every time you want to change the current flavor of the ice cream you
         * insert the operator describing this change.
         * For example if the current flavor of the ice cream is Chocolate, to make it (Color) Chocolate you add
         * this lambda expression as the parameter: (color) -> color + " Chocolate";
         * @param op the operator interface whose functional method describes the change
         */
        void flavor(UnaryOperator<String> op);

        /**
         * You may have inserted many unaryOperators, each describing a certain change. This method
         * @return the composition of all these operations.
         */
        UnaryOperator<String> getFlavorMutator();
    }
    //interface Variant <F extends Food, C extends Config> extends Food.Variant<F, C>
    interface Variant extends Food.Variant{
        /**
         * Getter-method for BaseFlavor
         * @return BaseFlavor
         */
        String getBaseFlavor();
    }
}
