package photoalbum.model;

/**
 * This class represents a point on a 2D cartesian coordinate system. The point has an
 * x-coordinate and a y-coordinate.
 */
public class Point2D {
  private final int x;
  private final int y;

  /**
   * Instantiates a new Point2D object to the given x-coordinate and y-coordinate.
   *
   * @param x the x-coordinate
   * @param y the y-coordinate
   */
  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns the x-coordinate of this point.
   *
   * @return the x-coordinate of this point
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the y-coordinate of this point.
   *
   * @return the y-coordinate of this point
   */
  public int getY() {
    return y;
  }

  /**
   * Returns a string representation of this point with the x-coordinate and the y-coordinate.
   *
   * @return the string representation of this point
   */
  @Override
  public String toString() {
    return "(" + this.getX() + "," + this.getY() + ")";
  }
}