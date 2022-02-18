package projekt.food;

import java.math.BigDecimal;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class IceCreamImpl implements IceCream{

    private final String flavor;

    /**
     * creates an instance of IceCreamImpl with the following attribute
     * @param flavor flavor of icecream
     */
    public IceCreamImpl(String flavor){
        this.flavor = flavor;
    }
    @Override
    public String getFlavor() {
        return flavor;
    }

    private static class Config implements Food.Config{

        private final UnaryOperator<BigDecimal> priceMutator;
        private final DoubleUnaryOperator weightMutator;

        /**
         * creates an instance of Config with the following attributes
         * @param priceMutator UnaryOperator which changes the price
         * @param weightMutator DoubleUnaryOperator which changes the weight
         */
        public Config(UnaryOperator<BigDecimal> priceMutator, DoubleUnaryOperator weightMutator){
            this.priceMutator = priceMutator;
            this.weightMutator = weightMutator;
        }

        @Override
        public void price(UnaryOperator<BigDecimal> priceMutator) {
            getPriceMutator().andThen(priceMutator);
        }

        @Override
        public UnaryOperator<BigDecimal> getPriceMutator() {
            return priceMutator;
        }

        @Override
        public void weight(DoubleUnaryOperator weightMutator) {
            getWeightMutator().andThen(weightMutator);
        }

        @Override
        public DoubleUnaryOperator getWeightMutator() {
            return weightMutator;
        }
    }
}
