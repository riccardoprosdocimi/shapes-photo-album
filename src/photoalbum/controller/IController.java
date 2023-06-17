package photoalbum.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface contains methods that all types of photo album controller should support.
 */
public interface IController {
  /**
   * Reads the commands from a txt file and tokenizes them.
   *
   * @param fileName the txt file containing the commands
   * @return the tokenized commands
   */
  List<ArrayList<String>> readCommands(String fileName);

  /**
   * Runs the system.
   *
   * @param fileName the txt file containing the commands
   */
  void go(String fileName);
}