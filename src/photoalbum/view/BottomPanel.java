package photoalbum.view;

import java.awt.*;

import javax.swing.*;

/**
 * This class represents the bottom panel for the photo album graphical view. The bottom panel
 * has four buttons to go to the previous or next snapshot, select a snapshot, or quit the program.
 */
public class BottomPanel extends JPanel {
  private final JButton previous;
  private final JButton select;
  private final JButton next;
  private final JButton quit;

  /**
   * Instantiates a new BottomPanel object.
   */
  public BottomPanel() {
    this.previous = new JButton("<< Prev <<");
    this.previous.setActionCommand("Previous Button");
    this.add(this.previous);
    this.select = new JButton("^^ Select ^^");
    this.select.setActionCommand("Select Button");
    this.add(this.select);
    this.next = new JButton(">> Next >>");
    this.next.setActionCommand("Next Button");
    this.add(this.next);
    this.quit = new JButton("xx Quit xx");
    this.quit.setActionCommand("Quit Button");
    this.add(this.quit);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Color.ORANGE);
  }

  /**
   * Returns the previous button.
   *
   * @return the previous button
   */
  public JButton getPrevious() {
    return this.previous;
  }

  /**
   * Returns the select button.
   *
   * @return the select button
   */
  public JButton getSelect() {
    return this.select;
  }

  /**
   * Returns the next button.
   *
   * @return the next button
   */
  public JButton getNext() {
    return this.next;
  }

  /**
   * Returns the quit button.
   *
   * @return the quit button
   */
  public JButton getQuit() {
    return this.quit;
  }
}