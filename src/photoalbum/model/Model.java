package photoalbum.model;

import java.util.ArrayList;
import java.util.List;

import photoalbum.util.InstructionsReflection;

/**
 * This class represents a photo album model.
 */
public class Model implements IModel {
  private final IPhotoAlbum photoAlbum;
  private final ICanvas canvas;

  /**
   * Instantiates a new Model object.
   */
  public Model() {
    this.photoAlbum = PhotoAlbum.getInstance();
    this.canvas = this.photoAlbum.createCanvas("simple canvas");
  }

  @Override
  public IPhotoAlbum getPhotoAlbum() {
    return this.photoAlbum;
  }

  /**
   * Executes the instructions contained in the commands.
   *
   * @param commands the commands
   */
  private void executeInstructions(List<ArrayList<String>> commands) {
    for (ArrayList<String> command : commands) {
      InstructionsReflection.executeInstruction(this.canvas, command);
    }
  }

  @Override
  public List<ISnapshot> processCommands(List<ArrayList<String>> commands) {
    this.executeInstructions(commands);
    return this.photoAlbum.getSnapshotList();
  }
}