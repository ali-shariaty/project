package projekt.base;

public class ManhattanDistanceCalculator implements DistanceCalculator{

    /**
     * This functional method takes parameters
     * @param l1 the starting point
     * @param l2 the destination
     * @return the distance between the objects based on the Manhattan Distance(First Norm)
     */
    @Override
    public double calculateDistance(Location l1, Location l2) {
        return Math.abs(l1.getX() - l2.getX()) + Math.abs(l1.getY() - l2.getY());
    }
}
