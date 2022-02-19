package projekt.food;

import java.util.List;

public class FoodTypeImpl <F extends Food, C extends Food.Config> implements FoodType{


    private final String name;
    private final List<? extends  Extra> compatibleExtras;
    private final List<Food.Variant<F, C>> foodVariants;

    /**
     * Der public Konstruktor von FoodTypeImpl, initialisiert die privaten Objektkonstanten.
     * Initialisiert foodvariants gleich null. Wird später mit addFoodVariont befüllt.
     * @param name vom formalen Typ String, der Name des Foods
     * @param compatibleExtras vom formalen Typ List<? extends Extra>, die Liste mit kompatiblen Extras für diese Kategorie von Food
     */
    public FoodTypeImpl(String name, List<? extends Extra> compatibleExtras){
        this.name = name;
        this.compatibleExtras = compatibleExtras;
        foodVariants = null;
    }


    /**
     * Getter-Methode für die private Objektkonstante name
     * @return name, der Name des Foods
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter-Methode für die private Objektkonstante compatibleExtras
     * @return compatibleExtras, Die Liste mit kompatiblen Extras für diese Kategorie von Food
     */
    @Override
    public List<? extends Extra> getCompatibleExtras() {
        return compatibleExtras;
    }

    /**
     * die Methode addFoodVariant füllt die Liste foodVariants
     * @param variant The {@link Food.Variant} to add to this food type
     */
    @Override
    public void addFoodVariant(Food.Variant variant) {
        foodVariants.add(variant);
    }

    /**
     * Getter-Methode für die private Objektkonstante foodVariants
     * @return foodVariants, Die Liste von Varianten in dieser Kategorie.
     */
    @Override
    public List<? extends Food.Variant> getFoodVariants() {
        return foodVariants;
    }
}
