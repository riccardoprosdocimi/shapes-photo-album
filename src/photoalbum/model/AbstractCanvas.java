package photoalbum.model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class contains attributes and methods for all types of canvas.
 */
public abstract class AbstractCanvas implements ICanvas {
  private final Set<IShape> shapeSet;

  /**
   * Package-private constructor available for use by all types of canvas.
   */
  AbstractCanvas() {
    this.shapeSet = new LinkedHashSet<>();
  }

  @Override
  public IShape createShape(String name, String type, Point2D position, int xDimension,
                       int yDimension, Color color) throws IllegalArgumentException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Type cannot be null or empty");
    } else if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    } else if (position == null) {
      throw new IllegalArgumentException("Position cannot be null");
    } else if (xDimension <= 0 || yDimension <= 0) {
      throw new IllegalArgumentException("Horizontal and vertical sizes cannot be non-positive");
    } else if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    } else {
      switch (type.toUpperCase()) {
        case "RECTANGLE":
          IShape rectangle = Rectangle.create(name, position, xDimension, yDimension, color);
          this.shapeSet.add(rectangle);
          return rectangle;
        case "OVAL":
          IShape oval = Oval.create(name, position, xDimension, yDimension, color);
          this.shapeSet.add(oval);
          return oval;
        default:
          return null;
      }
    }
  }

  @Override
  public void move(IShape shape, Point2D position) {
    if (shape == null || position == null) {
      throw new IllegalArgumentException("Shape and position cannot be null");
    }
    ChangePosition newPosition = new ChangePosition(shape, position);
    newPosition.changeShape();
  }

  @Override
  public void changeColor(IShape shape, Color color) {
    if (shape == null || color == null) {
      throw new IllegalArgumentException("Shape and color cannot be null");
    }
    ChangeColor newColor = new ChangeColor(shape, color);
    newColor.changeShape();
  }

  @Override
  public void resize(IShape shape, int xDimension, int yDimension)
          throws IllegalArgumentException {
    if (shape == null) {
      throw new IllegalArgumentException("Shape cannot be null");
    } else if (xDimension <= 0 || yDimension <= 0) {
      throw new IllegalArgumentException("Horizontal and vertical sizes cannot be non-positive");
    } else {
      ChangeSize newSize = new ChangeSize(shape, xDimension, yDimension);
      newSize.changeShape();
    }
  }

  @Override
  public void remove(IShape shape) throws IllegalArgumentException {
    if (shape == null) {
      throw new IllegalArgumentException("Shape cannot be null");
    } else {
      this.shapeSet.remove(shape);
    }
  }

  @Override
  public Set<IShape> getShapeSet() {
    return this.shapeSet;
  }

  /**
   * Package-private helper method for the copy method.
   *
   * @return a new canvas type object
   */
  abstract AbstractCanvas copyHelper();

  @Override
  public ICanvas copy() {
    AbstractCanvas canvas = copyHelper();
    for (IShape shape : this.shapeSet) {
      canvas.shapeSet.add(shape.copy());
    }
    return canvas;
  }

  /**
   * Returns a string representation of a canvas type object with all its shapes and their
   * corresponding data delimited by an empty space.
   *
   * @return the string representation of a canvas type object
   */
  @Override
  public String toString() {
    return this.shapeSet.stream()
            .map(IShape::toString)
            .collect(Collectors.joining("\n\n"));
  }

  @Override
  public void reset() {
    this.shapeSet.clear();
  }
}