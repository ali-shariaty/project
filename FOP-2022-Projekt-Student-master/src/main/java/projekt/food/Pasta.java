package projekt.food;

import java.util.function.DoubleUnaryOperator;

public interface Pasta extends Saucable{
    Pasta.Variant Variant = null;

    /**
     * The definition of this method describes the thickness of the pasta
     * @return the thickness in cm of the actual Pasta type
     */
    double getThickness();
    interface Config extends Food.Config
    {
        /**
         * @see IceCream.Config #flavor to understand how this method should be implemented
         * This method takes parameter:
         * @param op the operator interface whose functional method describes the change of the thickness of the pasta
         */
        void thickness(DoubleUnaryOperator op);
        /**
         * You may have inserted many unaryOperators, each describing a certain change. This method
         * @return the composition of all these operations.
         */
        DoubleUnaryOperator getThicknessMutator();
    }
    interface Variant <F extends Food, C extends Config> extends Saucable.Variant<F, C>
    //interface Variant extends Saucable.Variant
    {
        /**
         * gettter-method for BaseThickness
         * @return BaseThickness
         */
        double getBaseThickness();
    }
}
