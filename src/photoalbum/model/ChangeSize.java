package photoalbum.model;

/**
 * This class represents a command to change the size of an IShape object.
 */
public class ChangeSize extends AbstractCommand {
  private final int xDimension;
  private final int yDimension;

  /**
   * Instantiates a new ChangeSize object using its super class constructor to the given shape,
   * horizontal size, and vertical size.
   *
   * @param shape the IShape object to be resized
   * @param xDimension the new horizontal size
   * @param yDimension the new vertical size
   */
  public ChangeSize(IShape shape, int xDimension, int yDimension) {
    super(shape);
    this.xDimension = xDimension;
    this.yDimension = yDimension;
  }

  /**
   * Returns the new horizontal size.
   *
   * @return the new horizontal size
   */
  public int getXDimension() {
    return this.xDimension;
  }

  /**
   * Returns the new vertical size.
   *
   * @return the new vertical size
   */
  public int getYDimension() {
    return this.yDimension;
  }

  @Override
  public void changeShape() {
    this.getShape().setSize(this.xDimension, this.yDimension);
  }

  /**
   * Returns a string representation of an IShape object's new size.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    return "The new size of this " + this.getShape().getType() + " called "
            + this.getShape().getName() + " is " + this.getXDimension() + " by "
            + this.getYDimension();
  }
}