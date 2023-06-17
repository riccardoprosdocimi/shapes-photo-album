package photoalbum.model;

/**
 * This class represents a simple canvas. The simple canvas has a set of shapes.
 */
public class SimpleCanvas extends AbstractCanvas {
  /**
   * Instantiates a new SimpleCanvas object using its super class constructor.
   */
  private SimpleCanvas() {
    super();
  }

  /**
   * Returns a new SimpleCanvas object.
   *
   * @return a new SimpleCanvas object
   */
  protected static SimpleCanvas create() {
    return new SimpleCanvas();
  }

  @Override
  AbstractCanvas copyHelper() {
    return new SimpleCanvas();
  }
}