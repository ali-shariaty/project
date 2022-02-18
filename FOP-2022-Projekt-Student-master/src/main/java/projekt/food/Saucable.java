package projekt.food;

import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public interface Saucable extends Food{
    /**
     * The definition of this method describes the sauce of the saucable type
     * @return the sauce kind of the actual Saucable type
     */
    String getSauce();
    interface Config extends Food.Config
    {
        /**
         * @see IceCream.Config #flavor to understand how this method should be implemented
         * This method takes parameter:
         * @param op the operator interface whose functional method describes the change of the sauce of this Saucable type
         */
        void sauce(UnaryOperator<String> op);
        /**
         * You may have inserted many unaryOperators, each describing a certain change. This method
         * @return the composition of all these operations.
         */
        UnaryOperator<String> getSauceOperator();
    }

    interface Variant extends Food.Variant{
        String getBaseSauce();
    }
}
