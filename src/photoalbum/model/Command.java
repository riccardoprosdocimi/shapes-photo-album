package photoalbum.model;

/**
 * This interface contains methods that all types of command should support.
 */
public interface Command {
  /**
   * Returns an IShape object to be modified.
   *
   * @return the IShape object to be modified
   */
  IShape getShape();

  /**
   * Modifies an IShape object.
   */
  void changeShape();
}