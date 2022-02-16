package projekt.base;

public class EuclideanDistanceCalculator implements DistanceCalculator{
    /**
     * This functional method takes parameters
     * @param l1 the starting point
     * @param l2 the destination
     * @return the distance between the objects based on the Euclidean Distance(Second Norm)
     */
    @Override
    public double calculateDistance(Location l1, Location l2) {
        return Math.sqrt(Math.pow(l2.getX() - l1.getX(), 2) + Math.pow(l2.getY() - l1.getY(), 2));
    }
}
