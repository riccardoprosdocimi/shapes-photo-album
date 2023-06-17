package photoalbum.model;

import java.util.Set;

/**
 * This interface contains methods that all types of canvas should support.
 */
public interface ICanvas {
  /**
   * Instantiates a new IShape object to the given name, position, horizontal size, vertical
   * size, and color.
   *
   * @param name the name of this shape
   * @param type the type of this shape
   * @param position the position of this shape
   * @param xDimension the horizontal size of this shape
   * @param yDimension the vertical size of this shape
   * @param color the color of this shape
   * @return a new IShape object
   * @throws IllegalArgumentException if the type or name are either empty or null, if the
     position is null, if either dimensions are non-positive, or if the color is null
   */
  IShape createShape(String name, String type, Point2D position, int xDimension,
                    int yDimension, Color color) throws IllegalArgumentException;

  /**
   * Moves an IShape object to a new location on the canvas.
   *
   * @param shape the IShape object to be moved
   * @param position the new position on the canvas
   * @throws IllegalArgumentException if either shape or position or both are null
   */
  void move(IShape shape, Point2D position) throws IllegalArgumentException;

  /**
   * Changes the color of an IShape object.
   *
   * @param shape the IShape object to be recolored
   * @param color the new color
   * @throws IllegalArgumentException if either shape or color or both are null
   */
  void changeColor(IShape shape, Color color) throws IllegalArgumentException;

  /**
   * Changes the dimensions of an IShape object.
   *
   * @param shape the IShape object to be resized
   * @param xDimension the new horizontal size
   * @param yDimension the new vertical size
   * @throws IllegalArgumentException if either dimensions are non-positive or shape is null
   */
  void resize(IShape shape, int xDimension, int yDimension) throws IllegalArgumentException;

  /**
   * Removes an IShape object from the canvas.
   *
   * @param shape the IShape object to be removed from the canvas
   * @throws IllegalArgumentException if shape is null
   */
  void remove(IShape shape) throws IllegalArgumentException;

  /**
   * Returns the IShape object currently located on the canvas.
   *
   * @return the IShape object currently located on the canvas
   */
  Set<IShape> getShapeSet();

  /**
   * Returns a copy of the current state of the canvas.
   *
   * @return the copy of the current state of the canvas.
   */
  ICanvas copy();

  /**
   * Removes all shapes from the canvas.
   */
  void reset();
}