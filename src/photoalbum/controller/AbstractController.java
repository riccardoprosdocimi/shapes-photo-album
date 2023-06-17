package photoalbum.controller;

import java.util.ArrayList;
import java.util.List;

import photoalbum.util.FileReader;

/**
 * This class contains a method for all types of controller.
 */
public abstract class AbstractController implements IController {
  @Override
  public List<ArrayList<String>> readCommands(String fileName) {
    return FileReader.parse(fileName);
  }
}