package photoalbum.util;

import photoalbum.model.Color;

/**
 * This class represents a utility class for converting a custom color to the Java native one.
 */
public class ColorAdapter {
  /**
   * Converts a custom color to the Java native one found inside the Abstract Window Toolkit
   * package.
   *
   * @param color the custom color
   * @return the Java native color
   */
  public static java.awt.Color toSwingFromModel(Color color) {
    return new java.awt.Color(color.getR(), color.getG(), color.getB());
  }
}