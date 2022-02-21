package projekt.food;

import projekt.FoodBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class IceCreamImpl implements IceCream{

    private final String flavor;
    public static final FoodBuilder<IceCream, Config, Variant> BUILDER = null;

    //price, weight, foodvariant, extras?
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

    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public Food.Variant<?, ?> getFoodVariant() {
        return null;
    }

    @Override
    public List<? extends Extra<?>> getExtras() {
        return null;
    }
    //public Constructor in einer privaten Klasse??
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

    private static class Variant implements IceCream.Variant{
        private final IceCream.Variant VANILLA;
        private final IceCream.Variant STRAWBERRY;
        private final IceCream.Variant CHOCOLATE;
        private final IceCream.Variant STRACCIATELLA;

        private Variant(IceCream.Variant vanilla, IceCream.Variant strawberry, IceCream.Variant chocolate, IceCream.Variant stracciatella) {
            VANILLA = vanilla;
            STRAWBERRY = strawberry;
            CHOCOLATE = chocolate;
            STRACCIATELLA = stracciatella;
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
            if (IceCream.Variant == VANILLA)
                return "Vanilla";
            if (IceCream.Variant == STRAWBERRY)
                return "Strawberry";
            if (IceCream.Variant == CHOCOLATE)
                return "Chocolate";
            if (IceCream.Variant == STRACCIATELLA)
                return "Stracciatella";
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
            return FoodTypes.ICE_CREAM;
        }

        /**
         * The base price of this variant.
         *
         * @return The base price of this variant
         */
        @Override
        public BigDecimal getBasePrice() {
            if (IceCream.Variant == VANILLA)
                return BigDecimal.valueOf(1.5);
            if (IceCream.Variant == STRAWBERRY)
                return BigDecimal.valueOf(1.5);
            if (IceCream.Variant == CHOCOLATE)
                return BigDecimal.valueOf(1.5);
            if (IceCream.Variant == STRACCIATELLA)
                return BigDecimal.valueOf(1.5);
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
            if (IceCream.Variant == VANILLA)
                return 0.2;
            if (IceCream.Variant == STRAWBERRY)
                return 0.2;
            if (IceCream.Variant == CHOCOLATE)
                return 0.2;
            if (IceCream.Variant == STRACCIATELLA)
                return 0.2;
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
            return null;
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
         * @return BaseFlavor
         */
        @Override
        public String getBaseFlavor() {
            if (IceCream.Variant == VANILLA)
                return "Vanilla";
            if (IceCream.Variant == STRAWBERRY)
                return "Strawberry";
            if (IceCream.Variant == CHOCOLATE)
                return "Chocolate";
            if (IceCream.Variant == STRACCIATELLA)
                return "Stracciatella";
            else
                return null;
        }
    }
}
