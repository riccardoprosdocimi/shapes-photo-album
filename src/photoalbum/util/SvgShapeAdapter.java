package photoalbum.util;

import photoalbum.model.IShape;

/**
 * This class represents a utility class for converting shape's data to SVG format.
 */
public class SvgShapeAdapter {
  /**
   * Converts a shape's data to SVG format.
   *
   * @param shape the shape
   * @return the SVG formatted string
   */
  public static String toSvgFromModel(IShape shape) {
    StringBuilder svg = new StringBuilder();
    switch (shape.getType().toLowerCase()) {
      case "rectangle" -> svg.append("\t\t<rect id=\"").append(shape.getName()).append("\" x=\"")
              .append(shape.getPosition().getX()).append("\" y=\"")
              .append(shape.getPosition().getY()).append("\" width=\"")
              .append(shape.getXDimension()).append("\" height=\"")
              .append(shape.getYDimension()).append("\" fill=\"")
              .append(shape.getColor().toString()).append("\">\n\t\t</rect>\n");
      case "oval" -> svg.append("\t\t<ellipse id=\"").append(shape.getName()).append("\" cx=\"")
              .append(shape.getPosition().getX()).append("\" cy=\"")
              .append(shape.getPosition().getY()).append("\" rx=\"")
              .append(shape.getXDimension()).append("\" ry=\"")
              .append(shape.getYDimension()).append("\" fill=\"")
              .append(shape.getColor().toString()).append("\">\n\t\t</ellipse>\n");
    }
    return svg.toString();
  }
}