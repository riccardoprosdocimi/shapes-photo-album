package photoalbum.model;

/**
 * This class represents a command to change the color of an IShape object.
 */
public class ChangeColor extends AbstractCommand {
  private final Color color;

  /**
   * Instantiates a new ChangeColor object using its super class constructor to the given shape
   * and color.
   *
   * @param shape the IShape object to be recolored
   * @param color the new color
   */
  protected ChangeColor(IShape shape, Color color) {
    super(shape);
    this.color = color;
  }

  /**
   * Returns the primary color red's level in additive color synthesis of the new color.
   *
   * @return the red's level of the new color
   */
  public double getR() {
    return this.color.getR();
  }

  /**
   * Returns the primary color green's level in additive color synthesis of the new color.
   *
   * @return the green's level of the new color
   */
  public double getG() {
    return this.color.getG();
  }

  /**
   * Returns the primary color blue's level in additive color synthesis of the new color.
   *
   * @return the blue's level of the new color
   */
  public double getB() {
    return this.color.getB();
  }

  @Override
  public void changeShape() {
    this.getShape().setColor(this.color);
  }

  /**
   * Returns a string representation of an IShape object's new color.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    return "The new color of this " + this.getShape().getType() + " called "
            + this.getShape().getName() + " is (" + this.getR() + "," + this.getG()
            + "," + this.getB() + ")";
  }
}