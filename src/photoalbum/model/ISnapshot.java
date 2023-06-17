package photoalbum.model;

/**
 * This interface contains methods that all types of snapshot should support.
 */
public interface ISnapshot {
  /**
   * Returns the timestamp of this snapshot.
   *
   * @return the timestamp of this snapshot
   */
  String getTimestamp();

  /**
   * Returns the ID of this snapshot
   *
   * @return the ID of this snapshot
   */
  String getId();

  /**
   * Returns the description of this snapshot.
   *
   * @return the description of this snapshot
   */
  String getDescription();

  /**
   * Returns the canvas of this snapshot.
   *
   * @return the canvas of this snapshot
   */
  ICanvas getCanvas();
}