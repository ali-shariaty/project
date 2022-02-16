package projekt.base;

public class Location {
    private final int x;
    private final int y;

    /**
     * The public construcor initializes the private attributes using the following parameters
     * @param x the x coordinate of the location
     * @param y the y coordinate of the location
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method
     * @return the x coordinate of this location object
     */
    public int getX() {
        return x;
    }

    /**
     * Getter method
     * @return the y coordinate of this location objecg
     */
    public int getY() {
        return y;
    }

    /**
     * This method takes a parameter
     * @param l , instance of Location class
     * @return a new object of Location class whose coordinate vectors are the added coordinates of the calling object and the parameter object
     */
    public Location add(Location l)
    {
        return new Location(this.x + l.getX(), this.y + l.getY());
    }

    /**
    * This method takes a parameter
    * @param l , instance of Location class
    * @return a new object of Location class whose coordinate vectors are the difference of coordinates of the parameter object from the calling object
    */
    public Location subtract(Location l)
    {
        return new Location(this.x - l.getX(), this.y - l.getY());
    }
}
