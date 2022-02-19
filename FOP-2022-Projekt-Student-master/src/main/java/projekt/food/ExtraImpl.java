package projekt.food;

import java.util.function.Consumer;


public class ExtraImpl<C extends Food.Config> implements Extra{

    private final String name;
    private final int priority;
    private final Consumer<? super C> configMutator;

    /**
     * Der public Konstruktor für ExtraImpl. Initialisiert die privaten Objektkonstanten.
     * @param name vom formalen Typ String, der Name des Extras
     * @param priority vom formalen Typ int, der Zahlenwert für die Priorität
     * @param configMutator vom formalen Typ Consumer <? super C>, ein Consumer der in Methode apply eine Konfiguration annimmt.
     */
    public ExtraImpl(String name, int priority, Consumer<? super C> configMutator) {
        this.name = name;
        this.priority = priority;
        this.configMutator = configMutator;
    }


    /**
     * Getter-Methode für die private Objektkonstante name.
     * @return name, der Name des Extras
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter-Methode für die private Objektkonstante priority.
     * @return priority, der Zahlenwert für die Priorität
     */
    @Override
    public int getPriority() {
        return priority;
    }

    /**
     * Wendet die Modifikationen des Extras an
     * @param config vom formalen Typ Food.Config, die Konfigurationen die angewendet werden sollen
     */
    @Override
    public void apply(Food.Config config) {
        //price und weight müssen hier configurated werden
       // configMutator.accept(config); oder so etwas in der Art
    }

}
