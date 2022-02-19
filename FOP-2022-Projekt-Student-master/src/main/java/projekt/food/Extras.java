package projekt.food;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public final class Extras {
    /**
     * Privater Konstruktor für Extras. Es sollen keine Objekte von außerhalb konstruiert werden
     */
    private Extras(){}

    //hier werden die einzelnen Extra-Wünsche berechnet

    private static final UnaryOperator<BigDecimal> priceHam = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(1.0);
        return bigDecimal.add(addThis);
    };
    private static final DoubleUnaryOperator weightHam = operand -> operand + 0.1;
    private static final Consumer<Pizza.Config> hamConfig = config -> {config.price(priceHam);
        config.weight(weightHam);
    };

    private static final UnaryOperator<BigDecimal> priceOlives = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(0.8);
        return bigDecimal.add(addThis);
    };
    private static final DoubleUnaryOperator weightOlives = operand -> operand + 0.05;
    private static final Consumer<Pizza.Config> oliveConfig = config -> {config.price(priceOlives);
        config.weight(weightOlives);
    };

    private static final UnaryOperator<BigDecimal> priceThick = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(4.0);
        return bigDecimal.add(addThis);
    };
    private static final DoubleUnaryOperator weightThick = operand -> operand * 2;
    private static final DoubleUnaryOperator thicknessThick = operand -> operand * 2;
    private static final Consumer<Pasta.Config> thickConfig = config -> {config.price(priceThick);
        config.weight(weightThick);
        config.thickness(thicknessThick);
    };

    private static final UnaryOperator<BigDecimal> priceSpicy = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(0.5);
        return bigDecimal.add(addThis);
    };
    private static final UnaryOperator<String> sauceSpicy = s -> "Spicy " + s;
    private static final Consumer<Saucable.Config> spicyConfig = config -> {config.price(priceSpicy);
        config.sauce(sauceSpicy);
    };

    private static final UnaryOperator<BigDecimal> priceExtraSauce = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(1.25);
        return bigDecimal.add(addThis);
    };
    private static final UnaryOperator<String> sauceExtraSauce = s -> "Extra " + s;
    private static final DoubleUnaryOperator weightExtraSauce = operand -> operand + 0.12;
    private static final Consumer<Saucable.Config> extraSauceConfig = config -> {config.price(priceExtraSauce);
        config.weight(weightExtraSauce);
        config.sauce(sauceExtraSauce);
    };

    private static final UnaryOperator<BigDecimal> priceNoSauce = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(-1.0);
        return bigDecimal.add(addThis);
    };
    private static final DoubleUnaryOperator weightNoSauce = operand -> operand - 0.1;
    private static final UnaryOperator<String> sauceNoSauce = s -> null;
    private static final Consumer<Saucable.Config> noSauceConfig = config -> {config.price(priceNoSauce);
        config.weight(weightNoSauce);
        config.sauce(sauceNoSauce);
    };

    private static final UnaryOperator<BigDecimal> priceRainbowSprinkles = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(0.5);
        return bigDecimal.add(addThis);
    };
    private static final DoubleUnaryOperator weightRainbowSprinkles = operand -> operand + 0.03;
    private static final Consumer<IceCream.Config> rainbowSprinklesConfig = config -> {config.price(priceRainbowSprinkles);
        config.weight(weightRainbowSprinkles);
    };

    private static final UnaryOperator<BigDecimal> priceExtraScoop = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(3.0);
        return bigDecimal.add(addThis);
    };
    private static final DoubleUnaryOperator weightExtraScoop = operand -> operand + 0.1;
    private static final Consumer<IceCream.Config> extraScoopConfig = config -> {config.price(priceExtraScoop);
        config.weight(weightExtraScoop);
    };


    //Eigene Extras
    private static final UnaryOperator<BigDecimal> priceMicky = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(5.0);
        return bigDecimal.add(addThis);
    };
    private static final DoubleUnaryOperator weightMicky = operand -> operand + 0.5;
    private static final Consumer<IceCream.Config> mickyConfig = config -> {config.price(priceMicky);
    config.weight(weightMicky);
    };

    private static final UnaryOperator<BigDecimal> priceUnicornPoopy = bigDecimal -> {
        BigDecimal addThis = new BigDecimal(10);
        return bigDecimal.add(addThis);
    };
    private static final DoubleUnaryOperator weightUnicornPoopy = operand -> operand + 1;
    private static final Consumer<IceCream.Config> unicornPoopyConfig = config -> {config.price(priceUnicornPoopy);
        config.weight(weightUnicornPoopy);
    };



    public static final Extra<Pizza.Config> EXTRA_HAM = new ExtraImpl<Pizza.Config>("Extra Ham",5,hamConfig);
    public static final Extra<Pizza.Config> EXTRA_OLIVES = new ExtraImpl<>("Extra Olives", 5,oliveConfig);
    public static final Extra<Pasta.Config> EXTRA_THICK = new ExtraImpl<>("Extra Thick",4,thickConfig);
    public static final Extra<Saucable.Config> SPICY_SAUCE = new ExtraImpl<>("Spicy Sauce",3,spicyConfig);
    public static final Extra<Saucable.Config> EXTRA_SAUCE = new ExtraImpl<>("Extra Sauce",4,extraSauceConfig);
    public static final Extra<Saucable.Config> NO_SAUCE = new ExtraImpl<>("No Sauce",5,noSauceConfig);
    public static final Extra<IceCream.Config> RAINBOW_SPRINKLES = new ExtraImpl<>("Rainbow Sprinkles",5,rainbowSprinklesConfig);
    public static final Extra<IceCream.Config> EXTRA_SCOOP = new ExtraImpl<>("Extra Scoop", 2 ,extraScoopConfig);
    //Eigenes Eis Extra:
    public static final Extra<IceCream.Config> MICKY_MAUS_WUNDERHAUS = new ExtraImpl<>("Micky Maus Wunderhaus", 3,mickyConfig);
    public static final Extra<IceCream.Config> UNICORN_POOPY = new ExtraImpl<>("Unicorn Poopy", 4,unicornPoopyConfig);


    private static Map<String, Extra<?>> map = new HashMap<>();

    /**
     * Eigene erstellte Methode, die alle Extras in die Map reintut.
     * @return map die alle Extras beinhaltet
     */
    private static Map<String,Extra<?>> putIntoMap(){
        map.put(EXTRA_HAM.getName(),EXTRA_HAM);
        map.put(EXTRA_OLIVES.getName(),EXTRA_OLIVES);
        map.put(EXTRA_THICK.getName(),EXTRA_THICK);
        map.put(SPICY_SAUCE.getName(),SPICY_SAUCE);
        map.put(EXTRA_SAUCE.getName(),EXTRA_SAUCE);
        map.put(NO_SAUCE.getName(),NO_SAUCE);
        map.put(RAINBOW_SPRINKLES.getName(),RAINBOW_SPRINKLES);
        map.put(EXTRA_SCOOP.getName(),EXTRA_SCOOP);
        map.put(MICKY_MAUS_WUNDERHAUS.getName(),MICKY_MAUS_WUNDERHAUS);
        map.put(UNICORN_POOPY.getName(),UNICORN_POOPY);
        return map;
    }

    public static final Map<String,Extra<?>> ALL = putIntoMap();



}
