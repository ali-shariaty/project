package projekt.base;

public class ChessboardDistanceCalculator implements DistanceCalculator{
    /**
     * This functional method takes parameters
     * @param l1 the starting point
     * @param l2 the destination
     * @return the distance between the objects based on the Chessboard Distance(Infinite Norm)
     */
    @Override
    public double calculateDistance(Location l1, Location l2) {
        return Math.max(Math.abs(l1.getX() - l2.getX()), Math.abs(l1.getY() - l2.getY()));
    }
}
