package photoalbum.model;

/**
 * This class represents a color. The color has a red, green, and blue levels in additive color
 * synthesis as well as a minimum and a maximum values for each of them.
 */
public class Color {
  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 255;
  private final int r;
  private final int g;
  private final int b;

  /**
   * Instantiates a new Color object to the given RGB values.
   *
   * @param r the red value
   * @param g the green value
   * @param b the blue value
   * @throws IllegalArgumentException if the RGB values are invalid (less than 0 or greater than
     255)
   */
  public Color(int r, int g, int b) throws IllegalArgumentException {
    if (r < MIN_VALUE || r > MAX_VALUE || g < MIN_VALUE || g > MAX_VALUE || b < MIN_VALUE
            || b > MAX_VALUE) {
      throw new IllegalArgumentException("RGB values must be between 0 and 255");
    } else {
      this.r = r;
      this.g = g;
      this.b = b;
    }
  }

  /**
   * Returns the primary color red's level in additive color synthesis of this color.
   *
   * @return the red's level of this color
   */
  public int getR() {
    return this.r;
  }

  /**
   * Returns the primary color green's level in additive color synthesis of this color.
   *
   * @return the green's level of this color
   */
  public int getG() {
    return this.g;
  }

  /**
   * Returns the primary color blue's level in additive color synthesis of this color.
   *
   * @return the blue's level of this color
   */
  public int getB() {
    return this.b;
  }

  /**
   * Returns a string representation of this color with the RGB values.
   *
   * @return the string representation of this color
   */
  @Override
  public String toString() {
    return "rgb(" + this.getR() + "," + this.getG() + "," + this.getB() + ")";
  }
}