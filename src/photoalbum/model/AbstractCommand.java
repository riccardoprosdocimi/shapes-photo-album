package photoalbum.model;

/**
 * This class contains attributes and methods for all types of command.
 */
public abstract class AbstractCommand implements Command {
  private final IShape shape;

  /**
   * Package-private constructor available for use by all types of command.
   *
   * @param shape the IShape object to be modified
   */
  AbstractCommand(IShape shape) {
    this.shape = shape;
  }

  @Override
  public IShape getShape() {
    return this.shape;
  }
}