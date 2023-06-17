package photoalbum.view;

import java.awt.*;
import javax.swing.*;

import photoalbum.controller.GraphicsController;
import photoalbum.model.ISnapshot;

/**
 * This class represents the interactive graphical view for the photo album. The interactive
 * graphical view has a top panel, a middle panel, a bottom panel, and default values for widths
 * and heights.
 */
public class GraphicalView extends JFrame implements IGraphicalView {
  private static final int TOP_PANEL_HEIGHT = 20;
  private static final int TOP_PANEL_HEIGHT_WITH_DESCRIPTION = 35;
  private static final int MIDDLE_PANEL_HEIGHT = 940;
  private static final int MIDDLE_PANEL_HEIGHT_WITH_DESCRIPTION = 925;
  private static final int BOTTOM_PANEL_HEIGHT = 40;
  private int width = 0;
  private int height = 0;
  TopPanel topPanel;
  MiddlePanel middlePanel;
  BottomPanel bottomPanel;

  /**
   * Instantiates a new GraphicalView object.
   */
  public GraphicalView() {
    this.setTitle("CS 5004 Shapes Photo Album Viewer");
    this.setSize(DEFAULT_WINDOW_SIZE, DEFAULT_WINDOW_SIZE);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    this.topPanel = new TopPanel();
    this.add(topPanel, BorderLayout.NORTH);
    this.middlePanel = new MiddlePanel();
    this.add(middlePanel, BorderLayout.CENTER);
    this.bottomPanel = new BottomPanel();
    this.bottomPanel.setPreferredSize(new Dimension(DEFAULT_WINDOW_SIZE, BOTTOM_PANEL_HEIGHT));
    this.add(bottomPanel, BorderLayout.SOUTH);
  }

  /**
   * Instantiates a new GraphicalView object to the given width and height.
   *
   * @param width  the width
   * @param height the height
   */
  public GraphicalView(int width, int height) {
    this.width = width;
    this.height = height;
    this.setTitle("CS 5004 Shapes Photo Album Viewer");
    this.setSize(width, height);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    this.topPanel = new TopPanel();
    this.add(topPanel, BorderLayout.NORTH);
    this.middlePanel = new MiddlePanel();
    this.add(middlePanel, BorderLayout.CENTER);
    this.bottomPanel = new BottomPanel();
    this.bottomPanel.setPreferredSize(new Dimension(width, BOTTOM_PANEL_HEIGHT));
    this.add(bottomPanel, BorderLayout.SOUTH);
  }

  @Override
  public void addFeatures(GraphicsController controller) {
    this.bottomPanel.getPrevious().addActionListener(evt -> controller.previous());
    this.bottomPanel.getSelect().addActionListener(evt -> controller.select());
    this.bottomPanel.getNext().addActionListener(evt -> controller.next());
    this.bottomPanel.getQuit().addActionListener(evt -> controller.exit());
  }

  @Override
  public void displaySnapshot(ISnapshot snapshot) {
    if (this.width == 0 || this.height == 0) {
      if (!snapshot.getDescription().isEmpty()) {
        this.topPanel.setPreferredSize(new Dimension(DEFAULT_WINDOW_SIZE,
                TOP_PANEL_HEIGHT_WITH_DESCRIPTION));
        this.middlePanel.setPreferredSize(new Dimension(DEFAULT_WINDOW_SIZE,
                MIDDLE_PANEL_HEIGHT_WITH_DESCRIPTION));
      } else {
        this.topPanel.setPreferredSize(new Dimension(DEFAULT_WINDOW_SIZE, TOP_PANEL_HEIGHT));
        this.middlePanel.setPreferredSize(new Dimension(DEFAULT_WINDOW_SIZE, MIDDLE_PANEL_HEIGHT));
      }
    } else {
      if (!snapshot.getDescription().isEmpty()) {
        this.topPanel.setPreferredSize(new Dimension(this.width,
                TOP_PANEL_HEIGHT_WITH_DESCRIPTION));
        this.middlePanel.setPreferredSize(new Dimension(this.width,
                this.height - TOP_PANEL_HEIGHT_WITH_DESCRIPTION - BOTTOM_PANEL_HEIGHT));
      } else {
        this.topPanel.setPreferredSize(new Dimension(this.width, TOP_PANEL_HEIGHT));
        this.middlePanel.setPreferredSize(new Dimension(this.width,
                this.height - TOP_PANEL_HEIGHT - BOTTOM_PANEL_HEIGHT));
      }
    }
    this.middlePanel.setSnapshot(snapshot);
    this.displaySnapshotInfo(snapshot);
    this.setVisible(true);
    this.repaint();
  }

  private void displaySnapshotInfo(ISnapshot snapshot) {
    this.topPanel.setSnapshot(snapshot);
    this.topPanel.displaySnapshotInfo();
  }

  @Override
  public Object displaySnapshotMenu(Object[] options, int counter) {
    JDialog.setDefaultLookAndFeelDecorated(true);
    return JOptionPane.showInputDialog(null,
            "Choose", "Menu",
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[counter]);
  }

  @Override
  public void displayPopUp() {
    JOptionPane.showMessageDialog(this, "End of the photo album. "
            + "No snapshots to show beyond this one.");
  }
}