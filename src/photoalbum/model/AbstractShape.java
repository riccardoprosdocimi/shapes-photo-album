package photoalbum.model;

import java.util.Objects;

/**
 * This class contains attributes and methods for all types of shape.
 */
public abstract class AbstractShape implements IShape {
  private final String name;
  private String type;
  private Point2D position;
  private int xDimension;
  private int yDimension;
  private Color color;

  /**
   * Package-private constructor available for use by all types of shape.
   *
   * @param name the name of this shape
   * @param position the position of this shape
   * @param xDimension the horizontal size of this shape
   * @param yDimension the vertical size of this shape
   * @param color the color of this shape
   */
  AbstractShape(String name, Point2D position, int xDimension, int yDimension,
                Color color) {
    this.name = name;
    this.position = position;
    this.xDimension = xDimension;
    this.yDimension = yDimension;
    this.color = color;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getType() {
    return this.type;
  }

  /**
   * Sets the type of this shape.
   *
   * @param type the type of this shape
   */
  protected void setType(String type) {
    this.type = type;
  }

  @Override
  public Point2D getPosition() {
    return this.position;
  }

  @Override
  public void setPosition(Point2D position) {
    this.position = position;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public int getXDimension() {
    return this.xDimension;
  }

  @Override
  public int getYDimension() {
    return this.yDimension;
  }

  @Override
  public void setSize(int xDimension, int yDimension) {
    this.xDimension = xDimension;
    this.yDimension = yDimension;
  }

  /**
   * Package-private helper method for the copy method.
   *
   * @return a new shape type object
   */
  abstract AbstractShape copyHelper();

  @Override
  public IShape copy() {
    return copyHelper();
  }

  /**
   * Returns a string representation of a shape type object with its name and type.
   *
   * @return the string representation of a shape type object
   */
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n" + "Type: " + this.getType() + "\n";
  }

  /**
   * Asserts if two shape type objects are equal based on their name and type.
   *
   * @param o the other shape type object
   * @return true if the shape type objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractShape that = (AbstractShape) o;
    return Objects.equals(getName(), that.getName()) && Objects.equals(getType(), that.getType());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getType());
  }
}