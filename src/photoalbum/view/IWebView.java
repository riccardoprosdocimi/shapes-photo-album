package photoalbum.view;

/**
 * This interface contains an attribute and methods that all types of photo album static web view
 * should support.
 */
public interface IWebView {
  int DEFAULT_WINDOW_SIZE = 1000;

  /**
   * Returns the width of this web view.
   *
   * @return the width of this web view.
   */
  int getWidth();

  /**
   * Returns the height of this web view.
   *
   * @return the height of this web view
   */
  int getHeight();

  /**
   * Writes the text representation of this web view to a file.
   *
   * @param html the text representation of this web view
   */
  void writeToHtmlFile(String html);
}