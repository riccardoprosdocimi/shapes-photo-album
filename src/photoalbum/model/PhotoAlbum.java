package photoalbum.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents a photo album. The photo album has a list of snapshots and can only be
 * instantiated once.
 */
public class PhotoAlbum implements IPhotoAlbum {
  private static final PhotoAlbum INSTANCE = new PhotoAlbum();
  private static final List<ISnapshot> SNAPSHOT_LIST = new LinkedList<>();

  /**
   * Instantiates a new PhotoAlbum object.
   */
  private PhotoAlbum() {
  }

  /**
   * Returns a single instance of a PhotoAlbum object.
   *
   * @return the instance of a PhotoAlbum object
   */
  public static PhotoAlbum getInstance() {
    return INSTANCE;
  }

  @Override
  public ICanvas createCanvas(String kind) throws IllegalArgumentException {
    if (kind == null || kind.isEmpty()) {
      throw new IllegalArgumentException("Kind cannot be null or empty");
    } else {
      return switch (kind.toUpperCase()) {
        case "SIMPLE CANVAS" -> SimpleCanvas.create();
        default -> null;
      };
    }
  }

  public static void takeSnapshot(ICanvas canvas, String description)
          throws IllegalArgumentException {
    if (canvas == null) {
      throw new IllegalArgumentException("Canvas cannot be null");
    } else {
      SNAPSHOT_LIST.add(new Snapshot(description, canvas));
    }
  }

  @Override
  public List<ISnapshot> getSnapshotList() {
    return SNAPSHOT_LIST;
  }

  @Override
  public List<String> listSnapshots() {
    return SNAPSHOT_LIST
            .stream()
            .map(ISnapshot::getId)
            .collect(Collectors.toList());
  }

  @Override
  public String printSnapshots() {
    StringBuilder str;
    str = new StringBuilder("Printing Snapshots\n");
    str.append(SNAPSHOT_LIST.stream()
            .map(ISnapshot::toString)
            .collect(Collectors.joining("\n\n\n")));
    return str.toString();
  }

  @Override
  public void reset() {
    SNAPSHOT_LIST.clear();
  }
}