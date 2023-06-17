package photoalbum.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a snapshot. The snapshot has a canvas, an ID, a timestamp, and a
 * description.
 */
public class Snapshot implements ISnapshot {
  private final ICanvas canvas;
  private final String id;
  private final String timeStamp;
  private final String description;

  /**
   * Instantiates a new Snapshot object to the given description and canvas. It also sets the ID to
   * this point in time accurate to the microsecond and sets the timestamp to this point in time
   * accurate to the second.
   *
   * @param description the description of this snapshot
   * @param canvas the canvas of this snapshot
   */
  protected Snapshot(String description, ICanvas canvas) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    this.id = now.toString();
    this.timeStamp = now.format(formatter);
    this.description = description;
    this.canvas = canvas.copy();
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public String getTimestamp() {
    return this.timeStamp;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public ICanvas getCanvas() {
    return this.canvas;
  }

  /**
   * Returns a string representation of this snapshot with the ID, timestamp, description, and
   * canvas.
   *
   * @return the string representation of this snapshot
   */
  @Override
  public String toString() {
    return "Snapshot ID: " + this.getId() + "\nTimestamp: " + this.getTimestamp()
            + "\nDescription: " + this.getDescription() + "\n" + "Shape Information:\n"
            + this.canvas.toString();
  }
}