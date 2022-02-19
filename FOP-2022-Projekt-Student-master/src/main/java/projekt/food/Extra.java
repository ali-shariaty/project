package projekt.food;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A modification that targets configurable values in a {@link Food.Config}.
 *
 * @param <C> The target {@link Food.Config} type
 */
public interface Extra<C extends Food.Config> {

    /**
     * The name of this extra.
     *
     * @return The name of this extra
     */
    String getName();

    /**
     * The priority of the extra, lower is calculated first
     */
    int getPriority();

    /**
     * Applies the modifications of this extra to the provided {@link C config}.
     */
    void apply(C config);


    /**
     * In der Methode writeToConfig wird die Methode apply, mit dem Parameter config, auf jedes Element der Liste angewendet.
     * Dabei wird das in folgender Reihenfolge ausgeführt:
     * 1. Als erstes sollte aufsteigend nach dem getPriority-Wert sortiert werden.
     * 2. Falls zwei oder mehr Elemente aus extras den selben getPriority-Wert haben, sollten diese als Zweites alphabe-
     *    tisch sortiert werden.
     * @param config vom formalen generischen Typ C, die Konfigurationseinstellungen die in apply angewendet werden
     * @param extras vom formalen Typ List<? extends Extra>, die Liste die die Extras enthält
     * @param <C> generischer Typ, extended Food.Config
     */
    static <C extends Food.Config> void writeToConfig(C config, List<? extends Extra> extras) {

        List<? extends Extra> extrasSorted = extras;

        //sortiert aufsteigend nach dem getPriority-Wert
        Collections.sort(extrasSorted, (Comparator<Extra>) (o1, o2) -> {
            if (o1.getPriority() < o2.getPriority()) {
                return -1;
            }
            else if(o1.getPriority() > o2.getPriority()){
                return 1;
            }
            else
                return 0;
        });

        //Falls zwei oder mehr Elemente den den selben getPriority-Wert haben, werden sie alphabetisch sortiert
        Collections.sort(extrasSorted, (Comparator<Extra>) (a, b) -> {
            if (a.getPriority() == b.getPriority()) {
                if (a.getName().compareTo(b.getName()) > 0)
                    return 1;

                else if (a.getName().compareTo(b.getName()) < 0)
                    return -1;
                else return 0;
            }
            else return 0;
        });

        //Jedem Element der Listewird apply angewendet mit dem Parameter config
        for (int i = 0; i < extrasSorted.size(); i++) {
            extrasSorted.get(i).apply(config);
        }

    }


}
