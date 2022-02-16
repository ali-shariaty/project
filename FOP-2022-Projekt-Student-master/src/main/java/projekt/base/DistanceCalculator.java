package projekt.base;
@FunctionalInterface
public interface DistanceCalculator {
    /**
     * This functional method takes parameters
     * @param l1 the starting point
     * @param l2 the destination
     * @return the distance between the objects based on a certain algorithm
     */
    double calculateDistance(Location l1, Location l2);
}
