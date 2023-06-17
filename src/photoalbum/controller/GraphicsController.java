package photoalbum.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import photoalbum.model.IModel;
import photoalbum.model.ISnapshot;
import photoalbum.util.SnapshotCollection;
import photoalbum.view.IGraphicalView;

/**
 * This class represents the controller for the photo album interactive graphical view.
 */
public class GraphicsController extends AbstractController {
  private final IModel model;
  private final IGraphicalView view;
  private List<ISnapshot> snapshots;
  private SnapshotCollection snapshotCollection;
  private Iterator<ISnapshot> snapshotIterator;
  private Iterator<ISnapshot> snapshotReverseIterator;

  /**
   * Instantiates a new GraphicsController object to the given model and graphical view.
   *
   * @param model the model
   * @param graphicalView the graphical view
   */
  public GraphicsController(IModel model, IGraphicalView graphicalView) {
    this.model = model;
    this.view = graphicalView;
    this.view.addFeatures(this); // adds the interactive buttons to the view
  }

  @Override
  public void go(String fileName) {
    List<ArrayList<String>> commands = this.readCommands(fileName); // gets commands from txt file
    this.snapshots = this.model.processCommands(commands); // passes commands to model to be
                                                           // processed
    this.snapshotCollection = new SnapshotCollection(this.snapshots); // makes the snapshots
                                                                      // iterable
    this.snapshotIterator = this.snapshotCollection.iterator(); // creates the forward iterator
    this.snapshotReverseIterator = this.snapshotCollection.reverseIterator(); // creates the
                                                                              // backward iterator
    this.view.displaySnapshot(this.snapshots.get(0)); // passes the first snapshot to the view to
                                                      // be displayed
  }

  /**
   * Iterates a snapshot collection forward.
   */
  public void next() {
    if (this.snapshotIterator.hasNext()) {
      this.view.displaySnapshot(this.snapshotIterator.next());
    } else {
      this.view.displayPopUp(); // displays a message if no further snapshots exist
    }
  }

  /**
   * Selects a snapshot from a menu.
   */
  public void select() {
    Object[] options = this.model.getPhotoAlbum().listSnapshots().toArray();
    Object selection = this.view.displaySnapshotMenu(options, this.snapshotCollection.getCounter());
    if (selection != null) { // does nothing if user clicks cancel
      ISnapshot selected = this.snapshots.stream()
              // finds the snapshot corresponding to the ID selected
              .filter(ISnapshot -> ISnapshot.getId().equals(selection.toString()))
              .findFirst()
              .orElse(this.snapshots.get(0));
      this.view.displaySnapshot(selected);
      this.snapshotCollection.setCounter(this.snapshots.indexOf(selected)); // sets the iterators
                                                                            // at the selected
                                                                            // snapshot's position
    }
  }

  /**
   * Iterates a snapshot collection backward.
   */
  public void previous() {
    if (this.snapshotReverseIterator.hasNext()) {
      this.view.displaySnapshot(this.snapshotReverseIterator.next());
    } else {
      this.view.displayPopUp(); // displays a message if no further snapshots exist
    }
  }

  /**
   * Quits the program.
   */
  public void exit() {
    System.exit(0);
  }
}