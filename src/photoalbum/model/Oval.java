package photoalbum.model;

/**
 * This class represents an oval. The oval has a name, a type, a position, a horizontal size, a
 * vertical size, and a color.
 */
public class Oval extends AbstractShape {
  /**
   * Instantiates a new Oval object using its super class constructor to the given name,
   * position, horizontal size, vertical size, and color. It also sets the type to "oval".
   */
  private Oval(String name, Point2D position, int xDimension, int yDimension, Color color) {
    super(name, position, xDimension, yDimension, color);
    this.setType("oval");
  }

  /**
   * Returns a new Oval object instantiated with the given name, position, horizontal size,
   * vertical size, and color.
   *
   * @param name the name of this oval
   * @param position the position of this oval
   * @param xDimension the horizontal size of this oval
   * @param yDimension the vertical size of this oval
   * @param color the color of this oval
   * @return a new Oval object
   */
  protected static Oval create(String name, Point2D position, int xDimension,
                        int yDimension, Color color) {
    return new Oval(name, position, xDimension, yDimension, color);
  }

  @Override
  AbstractShape copyHelper() {
    return new Oval(this.getName(), new Point2D(this.getPosition().getX(),
            this.getPosition().getY()), this.getXDimension(), this.getYDimension(),
            new Color(this.getColor().getR(), this.getColor().getG(), this.getColor().getB()));
  }

  /**
   * Returns a string representation of this oval with the name, the type, the position, the
   * size, and the color.
   *
   * @return the string representation of this oval
   */
  @Override
  public String toString() {
    return super.toString() + "Center: " + this.getPosition() + ", X radius: "
            + this.getXDimension() + ", Y radius: " + this.getYDimension()
            + ", " + this.getColor().toString();
  }
}