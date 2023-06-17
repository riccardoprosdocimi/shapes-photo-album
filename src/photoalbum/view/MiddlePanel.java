package photoalbum.view;

import java.awt.*;
import javax.swing.*;

import photoalbum.model.IShape;
import photoalbum.model.ISnapshot;
import photoalbum.util.ColorAdapter;

/**
 * This class represents the middle panel for the photo album graphical view. The middle panel
 * has a snapshot and a shape.
 */
public class MiddlePanel extends JPanel {
  private ISnapshot snapshot;
  private IShape shape;

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
    this.setBackground(new Color(64, 156, 247));
    for (IShape shape : this.snapshot.getCanvas().getShapeSet()) {
      switch (shape.getType().toLowerCase()) {
        case "rectangle":
          this.shape = shape;
          drawRectangle(g);
        case "oval":
          this.shape = shape;
          this.drawOval(g);
      }
    }
  }

  /**
   * Draws a rectangle type of shape.
   *
   * @param g the paintbrush
   */
  private void drawRectangle(Graphics g) {
    g.setColor(ColorAdapter.toSwingFromModel(shape.getColor()));
    g.fillRect(shape.getPosition().getX(), shape.getPosition().getY(),
            shape.getXDimension(), shape.getYDimension());
    g.drawRect(shape.getPosition().getX(), shape.getPosition().getY(),
            shape.getXDimension(), shape.getYDimension());
  }

  /**
   * Draws an oval type of shape.
   *
   * @param g the paintbrush
   */
  private void drawOval(Graphics g) {
    g.setColor(ColorAdapter.toSwingFromModel(shape.getColor()));
    g.fillOval(shape.getPosition().getX(), shape.getPosition().getY(),
            shape.getXDimension(), shape.getYDimension());
    g.drawOval(shape.getPosition().getX(), shape.getPosition().getY(),
            shape.getXDimension(), shape.getYDimension());
  }
}