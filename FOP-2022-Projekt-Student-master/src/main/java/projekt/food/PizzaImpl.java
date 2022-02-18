package projekt.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class PizzaImpl implements Pizza{

    private final BigDecimal price;
    private final double weight;
    private final Food.Variant<?, ?> foodVariant;
    private final List<? extends Extra<?>> extras;
    private final double diameter;
    private final String sauce;

    /**
     * creates an instance of PizzaImpl with the following attributes
     * @param price price of the pizza
     * @param weight weight of the pizza
     * @param foodVariant the foodvariant
     * @param extras the extras for the pizza
     * @param diameter diameter of the pizza
     * @param sauce the sauce for the pizza
     */
    public PizzaImpl(BigDecimal price, double weight, Food.Variant<?, ?> foodVariant, List<? extends Extra<?>> extras, double diameter, String sauce){
        this.price = price;
        this.weight = weight;
        this.foodVariant = foodVariant;
        this.extras = extras;
        this.diameter = diameter;
        this.sauce = sauce;
    }


    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public Food.Variant<?, ?> getFoodVariant() {
        return foodVariant;
    }

    @Override
    public List<? extends Extra<?>> getExtras() {
        return extras;
    }

    @Override
    public double getDiameter() {
        return diameter;
    }

    @Override
    public String getSauce() {
        return sauce;
    }

    private static class Config implements Saucable.Config{

        private final UnaryOperator<BigDecimal> priceMutator;
        private final DoubleUnaryOperator weightMutator;
        private final UnaryOperator<String> sauceOperator;

        /**
         * creates an instance of Config with the following attributes
         * @param priceMutator UnaryOperator which changes the price
         * @param weightMutator DoubleUnaryOperator which changes the weight
         * @param sauceOperator UnaryOperator which changes the sauce
         */
        public Config(UnaryOperator<BigDecimal> priceMutator, DoubleUnaryOperator weightMutator, UnaryOperator<String> sauceOperator){
            this.priceMutator = priceMutator;
            this.weightMutator = weightMutator;
            this.sauceOperator = sauceOperator;
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

        @Override
        public void sauce(UnaryOperator<String> op) {
            getSauceOperator().andThen(op);
        }

        @Override
        public UnaryOperator<String> getSauceOperator() {
            return sauceOperator;
        }
    }
}
