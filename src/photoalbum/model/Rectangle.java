package photoalbum.model;

/**
 * This class represents a rectangle. The rectangle has a name, a type, a position, a horizontal
 * size, a vertical size, and a color.
 */
public class Rectangle extends AbstractShape {
  /**
   * Instantiates a new Rectangle object using its super class constructor to the given name,
   * position, horizontal size, vertical size, and color. It also sets the type to "rectangle".
   */
  private Rectangle(String name, Point2D position, int xDimension, int yDimension, Color color) {
    super(name, position, xDimension, yDimension, color);
    this.setType("rectangle");
  }

  /**
   * Returns a new Rectangle object instantiated with the given name, position, horizontal size,
   * vertical size, and color.
   *
   * @param name the name of this rectangle
   * @param position the position of this rectangle
   * @param xDimension the horizontal dimension of this rectangle
   * @param yDimension the vertical dimension of this rectangle
   * @param color the color of this rectangle
   * @return a new Rectangle object
   */
  protected static Rectangle create(String name, Point2D position, int xDimension,
                        int yDimension, Color color) {
    return new Rectangle(name, position, xDimension, yDimension, color);
  }

  @Override
  AbstractShape copyHelper() {
    return new Rectangle(this.getName(), new Point2D(this.getPosition().getX(),
            this.getPosition().getY()), this.getXDimension(), this.getYDimension(),
            new Color(this.getColor().getR(), this.getColor().getG(), this.getColor().getB()));
  }

  /**
   * Returns a string representation of this rectangle with the name, the type, the position, the
   * size, and the color.
   *
   * @return the string representation of this rectangle
   */
  @Override
  public String toString() {
    return super.toString() + "Min corner: " + this.getPosition() + ", Width: "
            + this.getXDimension() + ", Height: " + this.getYDimension()
            + ", " + this.getColor().toString();
  }
}