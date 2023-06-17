package photoalbum.view;

import photoalbum.controller.GraphicsController;
import photoalbum.model.ISnapshot;

/**
 * This interface contains an attribute and methods that all types of photo album interactive
 * graphical view should support.
 */
public interface IGraphicalView {
  int DEFAULT_WINDOW_SIZE = 1000;

  /**
   * Adds the interactive buttons to this view.
   *
   * @param controller the graphics controller
   */
  void addFeatures(GraphicsController controller);

  /**
   * Displays the snapshot.
   *
   * @param snapshot the snapshot
   */
  void displaySnapshot(ISnapshot snapshot);

  /**
   * Displays the snapshot menu.
   *
   * @param options the snapshot options
   * @param counter the counter that keeps track of the current index
   * @return the selected snapshot
   */
  Object displaySnapshotMenu(Object[] options, int counter);

  /**
   * Displays the pop-up message.
   */
  void displayPopUp();
}