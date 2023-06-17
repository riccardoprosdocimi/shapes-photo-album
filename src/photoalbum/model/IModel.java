package photoalbum.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface contains methods that all types of photo album model should support.
 */
public interface IModel {
  /**
   * Returns the photo album.
   *
   * @return the photo album
   */
  IPhotoAlbum getPhotoAlbum();

  /**
   * Processes the commands coming from the controller and generates a list of snapshots.
   *
   * @param commands the commands
   * @return the list of snapshots
   */
  List<ISnapshot> processCommands(List<ArrayList<String>> commands);
}