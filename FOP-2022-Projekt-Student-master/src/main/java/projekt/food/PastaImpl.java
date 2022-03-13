package projekt.food;

import projekt.FoodBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class PastaImpl implements Pasta{

    private final BigDecimal price;
    private final Food.Variant<?, ?> foodVariant;
    private final List<? extends Extra<?>> extras;
    private final double thickness;
    private final String sauce;
    public static final FoodBuilder<Pasta, Config, Variant> BUILDER = null;// FIXME: 2/20/2022

    //List<? extends Extra<?>>
    /**
     * create an instance of PastaImpl with the following attributes
     * @param price price of the pasta
     * @param foodVariant the foodvariant
     * @param extras the extras of the pasta
     * @param thickness the thickness of the pasta
     * @param sauce the sauce for the pasta
     */
    public PastaImpl(BigDecimal price, Food.Variant<?, ?> foodVariant, List<? extends Extra<?>> extras, double thickness, String sauce){
        this.price = price;
        this.foodVariant = foodVariant;
        this.extras = extras;
        this.thickness = thickness;
        this.sauce = sauce;
        //BUILDER.build(new Config(bigDecimal -> price, operand -> thickness,s -> sauce), foodVariant, extras); // FIXME: 2/20/2022
    }
    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public double getWeight() {
        return 0;
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
    public double getThickness() {
        return thickness;
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
        public Config (UnaryOperator<BigDecimal> priceMutator, DoubleUnaryOperator weightMutator, UnaryOperator<String> sauceOperator){
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

    private static class Variant implements Pasta.Variant{
        private final Pasta.Variant SPAGHETTI;
        private final Pasta.Variant RIGATONI;
        private final Pasta.Variant RAVIOLI;
        private final Pasta.Variant FUSILLI;

        private Variant(Pasta.Variant spaghetti, Pasta.Variant rigatoni, Pasta.Variant ravioli, Pasta.Variant fusilli) {
            SPAGHETTI = spaghetti;
            RIGATONI = rigatoni;
            RAVIOLI = ravioli;
            FUSILLI = fusilli;
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
            if (Pasta.Variant == SPAGHETTI)
                return "Spaghetti";
            if (Pasta.Variant == RIGATONI)
                return "Rigatoni";
            if (Pasta.Variant == RAVIOLI)
                return "Ravioli";
            if (Pasta.Variant == FUSILLI)
                return "Fusilli";
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
            return FoodTypes.PASTA;
        }

        /**
         * The base price of this variant.
         *
         * @return The base price of this variant
         */
        @Override
        public BigDecimal getBasePrice() {
            if (Pasta.Variant == SPAGHETTI)
                return BigDecimal.valueOf(12.5);
            if (Pasta.Variant == RIGATONI)
                return BigDecimal.valueOf(11.5);
            if (Pasta.Variant == RAVIOLI)
                return BigDecimal.valueOf(11.5);
            if (Pasta.Variant == FUSILLI)
                return BigDecimal.valueOf(11.5);
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
            if (Pasta.Variant == SPAGHETTI)
                return 0.2;
            if (Pasta.Variant == RIGATONI)
                return 0.2;
            if (Pasta.Variant == RAVIOLI)
                return 0.2;
            if (Pasta.Variant == FUSILLI)
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
            return new PastaImpl.Config(null,null,null);
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
         * @return BaseThickness
         */
        @Override
        public double getBaseThickness() {
            if (Pasta.Variant == SPAGHETTI)
                return 2;
            if (Pasta.Variant == RIGATONI)
                return 10;
            if (Pasta.Variant == RAVIOLI)
                return 40;
            if (Pasta.Variant == FUSILLI)
                return 15;
            else
                return 0;
        }

        @Override
        public String getBaseSauce() {
            return null;
        }
    }
}
