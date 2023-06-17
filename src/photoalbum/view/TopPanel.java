package photoalbum.view;

import java.awt.*;
import javax.swing.*;

import photoalbum.model.ISnapshot;

/**
 * This class represents the top panel for the photo album graphical view. The top panel has a
 * snapshot and two labels for the snapshot ID and description as well as a few default values.
 */
public class TopPanel extends JPanel {
  private static final int X = 5;
  private static final int ID_Y = 0;
  private static final int ID_HEIGHT = 20;
  private static final int DESCRIPTION_Y = 20;
  private static final int DESCRIPTION_HEIGHT = 15;
  private static final int WIDTH = 1000;
  private ISnapshot snapshot;
  private JLabel id;
  private JLabel description;

  /**
   * Sets the snapshot to the current snapshot.
   *
   * @param snapshot the current snapshot
   */
  public void setSnapshot(ISnapshot snapshot) {
    this.snapshot = snapshot;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Color.PINK);
  }

  /**
   * Displays the current snapshot's information.
   */
  public void displaySnapshotInfo() {
    if (this.getLayout() != null) {
      this.setLayout(null);
    }
    if (this.id == null) {
      this.id = new JLabel();
      this.id.setBounds(X, ID_Y, WIDTH, ID_HEIGHT);
      this.add(this.id);
    }
    if (this.description == null) {
      this.description = new JLabel();
      this.description.setBounds(X, DESCRIPTION_Y, WIDTH, DESCRIPTION_HEIGHT);
      this.add(this.description);
    }
    this.id.setText(this.snapshot.getId());
    this.description.setText(this.snapshot.getDescription());
  }
}