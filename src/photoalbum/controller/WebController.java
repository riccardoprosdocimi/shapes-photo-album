package photoalbum.controller;

import java.util.ArrayList;
import java.util.List;

import photoalbum.model.IModel;
import photoalbum.model.IShape;
import photoalbum.model.ISnapshot;
import photoalbum.util.SvgShapeAdapter;
import photoalbum.view.IWebView;

/**
 * This class represents the controller for the photo album static html markup with embedded SVG
 * view.
 */
public class WebController extends AbstractController {
  private final IModel model;
  private final IWebView webView;

  /**
   * Instantiates a new WeController object to the given model and web view.
   *
   * @param model the model
   * @param webView the web view
   */
  public WebController(IModel model, IWebView webView) {
    this.model = model;
    this.webView = webView;
  }

  /**
   * Produces HTML + SVG markup from a list of snapshots.
   *
   * @param snapshots the list of snapshots
   * @return the text representation
   */
  private String buildWebView(List<ISnapshot> snapshots) {
    StringBuilder html = new StringBuilder();
    html.append("<!DOCTYPE html>\n<html>\n<body>\n<h1>CS 5004 Shapes Photo Album</h1>\n");
    for (ISnapshot snapshot : snapshots) {
      html.append("<div style=\"background-color: powderblue; margin: 1%; "
                      + "border-style: solid; border-color: red; border-width: thick;\">\n\t<h2>")
              .append(snapshot.getId()).append("</h2>\n");
      if (!snapshot.getDescription().isEmpty()) {
        html.append("\t<p>Description: ").append(snapshot.getDescription()).append("</p>\n");
      }
      html.append("\t<svg width=\"").append(this.webView.getWidth()).append("\" height=\"")
              .append(this.webView.getHeight()).append("\">\n");
      for (IShape shape : snapshot.getCanvas().getShapeSet()) {
        html.append(SvgShapeAdapter.toSvgFromModel(shape));
      }
      html.append("\t</svg>\n</div>\n");
    }
    html.append("</body>\n</html>");
    return html.toString();
  }

  @Override
  public void go(String fileName) {
    List<ArrayList<String>> commands = this.readCommands(fileName); // gets commands from txt file
    List<ISnapshot> snapshots = this.model.processCommands(commands); // passes commands to model to
                                                                      // be processed
    this.webView.writeToHtmlFile(this.buildWebView(snapshots)); // passes the string to the view
    this.model.getPhotoAlbum().reset(); // clears the snapshots
  }
}