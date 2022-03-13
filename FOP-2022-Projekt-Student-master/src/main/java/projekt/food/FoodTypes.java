package projekt.food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FoodTypes {


    private static List<Extra> pizzaList =new ArrayList<>();
    private static List<Extra> pastaList =new ArrayList<>();
    private static List<Extra> ice_creamList =new ArrayList<>();


    /**
     * Selbstgeschriebene Methode fügt die kompatiblen Extras der entsprechenden Liste hinzu.
     * @param i vom formalen Typ int, beschreibt welche Liste returned werden soll
     * @return geaddete List
     */
    private static List<Extra> addThingsToList(int i){
        if(i==0) {
            pizzaList.add(Extras.EXTRA_HAM);
            pizzaList.add(Extras.EXTRA_OLIVES);
            pizzaList.add(Extras.SPICY_SAUCE);
            pizzaList.add(Extras.EXTRA_SAUCE);
            pizzaList.add(Extras.NO_SAUCE);
            return pizzaList;
        }

        else if (i == 1) {
            pastaList.add(Extras.EXTRA_THICK);
            pastaList.add(Extras.SPICY_SAUCE);
            pastaList.add(Extras.EXTRA_SAUCE);
            pastaList.add(Extras.NO_SAUCE);
            return pastaList;
        }

        else if (i==2) {
            ice_creamList.add(Extras.RAINBOW_SPRINKLES);
            ice_creamList.add(Extras.EXTRA_SCOOP);
            return ice_creamList;
        }
        else
            return null;
    }


    public static final FoodType<Pizza,Pizza.Config> PIZZA = new FoodTypeImpl<>("Pizza",addThingsToList(0));
    public static final FoodType<Pasta,Pasta.Config> PASTA = new FoodTypeImpl<>("Pasta",addThingsToList(1));
    public static final FoodType<IceCream, IceCream.Config> ICE_CREAM = new FoodTypeImpl<>("Ice Cream", addThingsToList(2));
    //IceCream müsste Food extenden, dann sollte der Aufruf hier funktionieren


    private static Map<String, FoodType<?,?>> map = new HashMap<>();

    /**
     * Selbstgeschriebene Methode fügt die Attribute zur Map hinzu, für ALL.
     * @return map die befüllt worden ist
     */
    private static Map<String,FoodType<?,?>> putIntoMap(){
        map.put(PIZZA.getName(),PIZZA);
        map.put(PASTA.getName(),PASTA);
        map.put(ICE_CREAM.getName(),ICE_CREAM);
        return map;
    }

    public static final Map<String,FoodType<?,?>> ALL = putIntoMap();


    /**
     * privater Konstruktor für FoodTypes. Es sollen keine Objekte erstellt werden können dieser Klasse.
     */
    private FoodTypes(){}


//Das ist ein static initializer, frag nicht habs auch noch nie gesehen
//wird automatisch immer als erstes ausgeführt, sogar vor dem Konstruktor.
    static {
        IceCream.Variant.create(ice_creamList);
        Pizza.Variant.create(pizzaList);
        Pasta.Variant.create(pastaList);
}

}
