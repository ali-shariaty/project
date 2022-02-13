package projekt;

import projekt.food.Extra;
import projekt.food.Food;

import java.util.List;

@FunctionalInterface
public interface FoodBuilder<F extends Food, C extends Food.Config, V extends Food.Variant> {


    F build(C c, V v, List<Extra<Food.Config>> list);

}
