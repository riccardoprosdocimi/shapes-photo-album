package photoalbum.model;

/**
 * This interface contains methods that all types of shape should support.
 */
public interface IShape {
  /**
   * Returns the name of this shape.
   *
   * @return the name of this shape
   */
  String getName();

  /**
   * Returns the type of this shape.
   *
   * @return the type of this shape
   */
  String getType();

  /**
   * Returns the position of this shape on the canvas.
   *
   * @return the position of this shape on the canvas
   */
  Point2D getPosition();

  /**
   * Changes the position of this shape on the canvas.
   *
   * @param position the new position of this shape on the canvas
   */
  void setPosition(Point2D position);

  /**
   * Returns the horizontal size of this shape.
   *
   * @return the horizontal size of this shape
   */
  int getXDimension();

  /**
   * Returns the vertical size of this shape.
   *
   * @return the vertical size of this shape
   */
  int getYDimension();

  /**
   * Changes the size of this shape.
   *
   * @param xDimension the new horizontal size of this shape
   * @param yDimension the new vertical size of this shape
   */
  void setSize(int xDimension, int yDimension);

  /**
   * Returns the color of this shape.
   *
   * @return the color of this shape
   */
  Color getColor();

  /**
   * Changes the color of this shape.
   *
   * @param color the new color of this shape
   */
  void setColor(Color color);

  /**
   * Makes a copy of this shape.
   *
   * @return the copy of this shape
   */
  IShape copy();
}