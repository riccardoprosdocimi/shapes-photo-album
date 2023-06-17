package photoalbum.util;

import java.util.Iterator;
import java.util.List;
import photoalbum.model.ISnapshot;

/**
 * This class represents a utility class for iterating through a list of snapshots back and forth.
 */
public class SnapshotCollection implements Iterable<ISnapshot> {
  private final int start;
  private final int end;
  List<ISnapshot> snapshots;
  private int counter;

  /**
   * Instantiates a new SnapshotCollection object to the given list of snapshots. It also sets
   * the indexes for the start and end of the collection as well as initializing the counter that
   * keeps track of the current index to 0.
   *
   * @param snapshotList the list of snapshots
   */
  public SnapshotCollection(List<ISnapshot> snapshotList) {
    this.start = 0;
    this.end = snapshotList.size() - 1;
    this.snapshots = snapshotList;
    this.counter = 0;
  }

  @Override
  public Iterator<ISnapshot> iterator() {
    return new SnapshotIterator();
  }

  /**
   * Sets the counter to the current index when jumping to a selected element within the collection.
   *
   * @param counter the counter that keeps track of the current index
   * @throws IllegalArgumentException if the new index is out of bounds
   */
  public void setCounter(int counter) throws IllegalArgumentException {
    if (counter < this.start || counter > this.end) {
      throw new IllegalArgumentException("Index out of bounds");
    } else {
      this.counter = counter;
    }
  }

  /**
   * Returns the counter that keeps track of the current index.
   *
   * @return the counter that keeps track of the current index
   */
  public int getCounter() {
    return this.counter;
  }

  private class SnapshotIterator implements Iterator<ISnapshot> {
    /**
     * Instantiates a new SnapshotIterator object.
     */
    public SnapshotIterator() {
    }

    @Override
    public boolean hasNext() {
      return counter < end;
    }

    @Override
    public ISnapshot next() {
      counter++;
      return snapshots.get(counter);
    }
  }

  private class ReverseSnapshotIterator implements Iterator<ISnapshot> {
    private ReverseSnapshotIterator() {
    }

    @Override
    public boolean hasNext() {
      return counter > start;
    }

    @Override
    public ISnapshot next() {
      counter--;
      return snapshots.get(counter);
    }
  }

  /**
   * Instantiates a new ReverseSnapshotIterator object.
   *
   * @return the ReverseSnapshotIterator object
   */
  public Iterator<ISnapshot> reverseIterator() {
    return new ReverseSnapshotIterator();
  }
}