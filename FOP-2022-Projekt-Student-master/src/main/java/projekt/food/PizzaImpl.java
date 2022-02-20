package projekt.food;

import projekt.FoodBuilder;

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
    public static final FoodBuilder<Pizza, Config, Variant> BUILDER = null; // FIXME: 2/20/2022

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
        //BUILDER.build(new Config(bigDecimal -> price, operand -> weight, s -> sauce), foodVariant, extras); // FIXME: 2/20/2022
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

    private static class Config implements Saucable.Config{ // FIXME: 2/20/2022

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

    private static class Variant implements Pizza.Variant{

        private final Pizza.Variant MARGHERITA;
        private final Pizza.Variant HAWAII;
        private final Pizza.Variant RUCOLA;
        private final Pizza.Variant BBQ;

        private Variant(Pizza.Variant margherita, Pizza.Variant hawaii, Pizza.Variant rucola, Pizza.Variant bbq) {
            MARGHERITA = margherita;
            HAWAII = hawaii;
            RUCOLA = rucola;
            BBQ = bbq;
        }

        /**
         * The name of this variant.
         *
         * <p>
         * This may be something similar to {@code "Pizza Margherita"}.
         * </p>
         *
         * @return The name of this variant
         */
        @Override
        public String getName() {
            if (Pizza.Variant == MARGHERITA)
                return "Margherita";
            if (Pizza.Variant == HAWAII)
                return "Margherita";
            if (Pizza.Variant == RUCOLA)
                return "Margherita";
            if (Pizza.Variant == BBQ)
                return "Margherita";
            else
                return null;
        }

        /**
         * The food type in which this variant is grouped.
         *
         * <p>
         * For example, if this variant was named {@code "Pizza Margherita"}, the matching food type would be {@code "Pizza"}.
         * </p>
         *
         * @return The food type of this variant
         */
        @Override
        public FoodType getFoodType() {
            return FoodTypes.PIZZA;
        }

        /**
         * The base price of this variant.
         *
         * @return The base price of this variant
         */
        @Override
        public BigDecimal getBasePrice() {
            if (Pizza.Variant == MARGHERITA)
                return BigDecimal.valueOf(9.75);
            if (Pizza.Variant == HAWAII)
                return BigDecimal.valueOf(13.75);
            if (Pizza.Variant == RUCOLA)
                return BigDecimal.valueOf(14.50);
            if (Pizza.Variant == BBQ)
                return BigDecimal.valueOf(14.50);
            else
                return null;
        }

        /**
         * The base weight of this variant.
         *
         * @return The weight price of this variant
         */
        @Override
        public double getBaseWeight() {
            if (Pizza.Variant == MARGHERITA)
                return 0.8;
            if (Pizza.Variant == HAWAII)
                return 1.0;
            if (Pizza.Variant == RUCOLA)
                return 0.9;
            if (Pizza.Variant == BBQ)
                return 1.1;
            else
                return 0;
        }

        /**
         * Creates an empty {@link Config} for this variant.
         *
         * @return An empty {@link Config} for this variant
         */
        @Override
        public Food.Config createEmptyConfig() {
            return null; // FIXME: 2/20/2022
        }

        /**
         * Creates a new instance of {@link Food} described by this variant, its base values and modifications defined by the
         * provided list of {@link Extra Extras}.
         *
         * <p>
         * The provided extras are to an instance of {@link Config}. After this config has
         * been fully "configured" by the extras, the base values from this variant are supplied to the config's mutators to
         * calculate the food's concrete values. Providing an empty list will create a food with the base values for this
         * variant.
         * </p>
         *
         * @param list The list of {@link Extra Extras} to configure the resultant {@link Food}
         * @return An instance of {@link Food} based on the values from this variant and configured by the provided extras
         */
        @Override
        public Food create(List list) {
            return null;
        }

        /**
         * @return BaseDiameter
         */
        @Override
        public double getBaseDiameter() {
            if (Pizza.Variant == MARGHERITA)
                return 30.0;
            if (Pizza.Variant == HAWAII)
                return 30.0;
            if (Pizza.Variant == RUCOLA)
                return 30.0;
            if (Pizza.Variant == BBQ)
                return 30.0;
            else
                return 0;
        }

        @Override
        public String getBaseSauce() {
            if (Pizza.Variant == MARGHERITA)
                return "Tomato";
            if (Pizza.Variant == HAWAII)
                return "Tomato";
            if (Pizza.Variant == RUCOLA)
                return "Tomato";
            if (Pizza.Variant == BBQ)
                return "BBQ";
            else
                return null;
        }
    }
}
