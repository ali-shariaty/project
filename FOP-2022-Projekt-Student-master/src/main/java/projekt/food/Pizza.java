package projekt.food;

import java.util.function.DoubleUnaryOperator;

public interface Pizza extends Saucable{
    /**
     * The definition of this method describes the diameter of the pizza
     * @return the diameter in cm of the actual Pizza type
     */
    double getDiameter();
    interface Config extends Food.Config
    {
        /**
         * @see IceCream.Config flavor to understand how the implementation of this method should work
         * This method takes parameter:
         * @param op the operator interface whose functional method describes the change of the diameter of the pizza
         */
        void diameter(DoubleUnaryOperator op);
        /**
         * You may have inserted many unaryOperators, each describing a certain change. This method
         * @return the composition of all these operations.
         */
        DoubleUnaryOperator getDiameterMutator();
    }
    interface Variant extends Saucable.Variant{
        double getBaseDiameter();
    }
}
