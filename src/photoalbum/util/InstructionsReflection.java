package photoalbum.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.NoSuchElementException;

import photoalbum.model.Color;
import photoalbum.model.ICanvas;
import photoalbum.model.IShape;
import photoalbum.model.PhotoAlbum;
import photoalbum.model.Point2D;

/**
 * This class represents a utility class for matching the commands with the corresponding methods.
 */
public class InstructionsReflection {
  /**
   * Executes the instructions corresponding to the input commands.
   *
   * @param model the model executing the instructions
   * @param instruction the instruction
   */
  public static void executeInstruction(ICanvas model, List<String> instruction) {
    String command = instruction.get(0).toLowerCase(); // gets the command
    try {
      Method method = InstructionsReflection.class.getDeclaredMethod(command,
              ICanvas.class, List.class); // matches the command with the corresponding method
      method.invoke(null, model, instruction); // invokes the method passing in the required
                                                    // arguments
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      System.err.println("Invalid command");
    }
  }

  /**
   * Finds the shape corresponding to the input command.
   *
   * @param model the model containing the shapes
   * @param shape the shape included in the command
   * @return the shape in the model corresponding to the input command
   */
  private static IShape getShapeFromCommand(ICanvas model, String shape) {
    return model.getShapeSet().stream()
            .filter(element -> element.getName().equals(shape))
            .findFirst()
            .orElseThrow(NoSuchElementException::new);
  }

  /**
   * Executes the command to create a new shape.
   *
   * @param model the model executing the instructions
   * @param command the command containing the instruction
   */
  private static void shape(ICanvas model, List<String> command) {
    model.createShape(command.get(1), // gets the shape's name
            command.get(2), // gets the shape's type
            new Point2D(Integer.parseInt(command.get(3)), // gets the x-coordinate
                    Integer.parseInt(command.get(4))), // gets the y-coordinate
            Integer.parseInt(command.get(5)), // gets the x-dimension
            Integer.parseInt(command.get(6)), // gets the y-dimension
            new Color(Integer.parseInt(command.get(7)), // gets the R
                    Integer.parseInt(command.get(8)), // gets the G
                    Integer.parseInt(command.get(9)))); // gets the B
  }

  /**
   * Executes the command to take a snapshot.
   *
   * @param model the model executing the instructions
   * @param command the command containing the instruction
   */
  private static void snapshot(ICanvas model, List<String> command) {
    if (command.size() == 1) { // if there's no snapshot description
      PhotoAlbum.takeSnapshot(model, ""); // assign an empty string to it
    } else {
      PhotoAlbum.takeSnapshot(model, String.join(" ", command.subList(1, command.size())));
    }
  }

  /**
   * Executes the command to move a shape.
   *
   * @param model the model executing the instructions
   * @param command the command containing the instruction
   */
  private static void move(ICanvas model, List<String> command) {
    IShape shape = getShapeFromCommand(model, command.get(1)); // gets the shape to be moved
    model.move(shape, new Point2D(Integer.parseInt(command.get(2)), // gets the new x-coordinate
            Integer.parseInt(command.get(3)))); // gets the new y-coordinate
  }

  /**
   * Executes the command to change a shape's color.
   *
   * @param model the model executing the instructions
   * @param command the command containing the instruction
   */
  private static void color(ICanvas model, List<String> command) {
    IShape shape = getShapeFromCommand(model, command.get(1)); // gets the shape to be recolored
    model.changeColor(shape, new Color(Integer.parseInt(command.get(2)), // gets the new R
            Integer.parseInt(command.get(3)), // gets the new G
            Integer.parseInt(command.get(4)))); // gets the new B
  }

  /**
   * Executes the command to change a shape's dimensions.
   *
   * @param model the model executing the instructions
   * @param command the command containing the instruction
   */
  private static void resize(ICanvas model, List<String> command) {
    IShape shape = getShapeFromCommand(model, command.get(1)); // gets the shape to be resized
    model.resize(shape, Integer.parseInt(command.get(2)), // gets the new x-dimension
            Integer.parseInt(command.get(3))); // gets the new y-dimension
  }

  /**
   * Executes the command to delete a shape.
   *
   * @param model the model executing the instructions
   * @param command the command containing the instruction
   */
  private static void remove(ICanvas model, List<String> command) {
    model.remove(getShapeFromCommand(model, command.get(1))); // gets and removes the shape
  }
}