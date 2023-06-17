package photoalbum.model;

import java.util.List;

/**
 * This interface contains methods that all types of snapshot should support.
 */
public interface IPhotoAlbum {
  /**
   * Returns a new Canvas type object.
   *
   * @param kind the kind of canvas
   * @return the new Canvas type object
   * @throws IllegalArgumentException if the kind is either null or empty
   */
  ICanvas createCanvas(String kind) throws IllegalArgumentException;

  /**
   * Returns the list of snapshots of this photo album.
   *
   * @return the list of snapshots of this photo album
   */
  List<ISnapshot> getSnapshotList();

  /**
   * Returns a list of the taken snapshot's IDs.
   *
   * @return the list of the taken snapshot's ID's
   */
  List<String> listSnapshots();

  /**
   * Prints all the taken snapshot's full details.
   *
   * @return all the taken snapshot's full details
   */
  String printSnapshots();

  /**
   * Deletes all taken snapshots.
   */
  void reset();
}