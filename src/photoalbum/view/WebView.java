package photoalbum.view;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the static web view for the photo album. The static web view has a html
 * file, a width, and a height.
 */
public class WebView implements IWebView {
  private final String htmlFile;
  private final int width;
  private final int height;

  /**
   * Instantiates a new WebView object to the given html file.
   *
   * @param htmlFile the html file
   */
  public WebView(String htmlFile) {
    this.htmlFile = htmlFile;
    this.width = DEFAULT_WINDOW_SIZE;
    this.height = DEFAULT_WINDOW_SIZE;
  }

  /**
   * Instantiates a new WebView object to the given html file, width, and height.
   *
   * @param htmlFile the html file
   * @param width the width
   * @param height the height
   */
  public WebView(String htmlFile, int width, int height) {
    this.htmlFile = htmlFile;
    this.width = width;
    this.height = height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public void writeToHtmlFile(String html) {
    try {
      FileWriter fileWriter = new FileWriter(this.htmlFile);
      fileWriter.write(html);
      fileWriter.close();
    } catch (IOException e) {
      System.err.println("The program quit because the output file was not provided. Please use "
              + "the flag -out to provide one");
      System.exit(1);
    }
  }
}