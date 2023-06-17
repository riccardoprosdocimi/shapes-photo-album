package photoalbum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import photoalbum.controller.GraphicsController;
import photoalbum.controller.IController;
import photoalbum.controller.WebController;
import photoalbum.model.IModel;
import photoalbum.model.Model;
import photoalbum.view.GraphicalView;
import photoalbum.view.IGraphicalView;
import photoalbum.view.IWebView;
import photoalbum.view.WebView;

/**
 * This class represents the entry point for the photo album MVC design.
 */
public class PhotoAlbumMain {
  private static final int MINIMUM_GRAPHICAL_HEIGHT = 76;

  /**
   * The entry point of the photo album application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    List<String> flags1 = new ArrayList<>();
    List<String> flags2 = new ArrayList<>();
    flags1.add("-in");
    flags1.add("-v");
    flags2.add("-in");
    flags2.add("-view");
    String inputFile = "";
    String viewType = "";
    String outputFile = "";
    int width = 0;
    int height = 0;
    int j = 0;
    try { // if the array of args goes out of bounds looking for inputs, i.e. [i + 1]
      if (args.length > 0) { // if arguments are actually entered
        if (Arrays.stream(args).toList().containsAll(flags1)
                || Arrays.stream(args).toList().containsAll(flags2)) { // if arguments contain
          // necessary flags
          for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase(flags1.get(0))) { // input file switch
              if (args[i + 1].contains(".txt")) { // if the file is in txt format
                inputFile = args[i + 1];
              } else {
                System.err.println("Please provide a valid input file");
                System.exit(1);
              }
            } else if (args[i].equalsIgnoreCase(flags1.get(1)) // view type switch
                    || args[i].equalsIgnoreCase(flags2.get(1))) { // another view type switch
              if (args[i + 1].equalsIgnoreCase("web") // web view
                      || args[i + 1].equalsIgnoreCase("graphical")) { // graphical view
                viewType = args[i + 1];
              } else {
                System.err.println("Please provide a valid view");
                System.exit(1);
              }
            } else if (args[i].equalsIgnoreCase("-out")) { // output file switch
              if (args[i + 1].contains(".html")) {
                outputFile = args[i + 1];
              } else {
                System.err.println("Please provide a valid html file");
                System.exit(1);
              }
            } else if (args[i].matches("-?\\d+")) { // argument is an int
              if (j == 0) { // first int
                width = Integer.parseInt(args[i]);
                j++;
              } else if (j == 1) { // second int
                height = Integer.parseInt(args[i]);
                j++;
              } else {
                j++; // more integers
                if (j > 2) { // invalid parameters
                  System.err.println("Please provide width and height only");
                  System.exit(1);
                }
              }
            }
          }
        } else {
          System.err.println("Please provide a view using the flags -v or -view and an input file "
                  + "using the flag -in");
        }
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println("The arguments provided are not valid");
      System.exit(1);
    }
    IModel model = new Model();
    switch (viewType.toLowerCase()) {
      case "web" -> {
        if (width <= 0 || height <= 0) {
          IWebView webView = new WebView(outputFile);
          IController webController = new WebController(model, webView);
          webController.go(inputFile);
        } else {
          IWebView webView = new WebView(outputFile, width, height);
          IController webController = new WebController(model, webView);
          webController.go(inputFile);
        }
      }
      case "graphical" -> {
        if (width <= 0 || height < MINIMUM_GRAPHICAL_HEIGHT) {
          IGraphicalView graphicalView = new GraphicalView();
          IController graphicsController = new GraphicsController(model, graphicalView);
          graphicsController.go(inputFile);
        } else {
          IGraphicalView graphicalView = new GraphicalView(width, height);
          IController graphicsController = new GraphicsController(model, graphicalView);
          graphicsController.go(inputFile);
        }
      }
    }
  }
}