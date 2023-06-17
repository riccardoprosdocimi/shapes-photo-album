package photoalbum.model;

/**
 * This class represents a command to change the location of an IShape object.
 */
public class ChangePosition extends AbstractCommand {
  private final Point2D position;

  /**
   * Instantiates a new ChangePosition object using its super class constructor to the given shape
   * and position.
   *
   * @param shape the IShape object to be moved
   * @param position the new position
   */
  public ChangePosition(IShape shape, Point2D position) {
    super(shape);
    this.position = position;
  }

  /**
   * Returns the new x-coordinate.
   *
   * @return the new x-coordinate
   */
  public double getX() {
    return this.position.getX();
  }

  /**
   * Returns the new y-coordinate.
   *
   * @return the new y-coordinate
   */
  public double getY() {
    return this.position.getY();
  }

  @Override
  public void changeShape() {
    this.getShape().setPosition(this.position);
  }

  /**
   * Returns a string representation of an IShape object's new position.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    return "The new position of this " + this.getShape().getType() + " called "
            + this.getShape().getName() + " is at (" + this.getX() + "," + this.getY() + ")";
  }
}