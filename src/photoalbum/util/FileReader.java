package photoalbum.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This class represents a utility class for reading and parsing txt files.
 */
public class FileReader {
  /**
   * Reads a txt file line by line.
   *
   * @param fileName the txt file
   * @return a list containing each line as separate elements
   */
  private static List<String> read(String fileName) {
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(Paths.get(fileName));
    } catch (IOException ex) {
      System.err.println("The file is not valid or doesn't exist");
    }
  return lines;
  }

  /**
   * Parses lines of text ignoring those that start with a pound sign or are empty.
   *
   * @param fileName the txt file
   * @return a nested list containing each tokenized line
   */
  public static List<ArrayList<String>> parse(String fileName) {
    List<ArrayList<String>> parsedLines = new ArrayList<>();
    for (String line : read(fileName)) {
      ArrayList<String> parsedLine = new ArrayList<>();
      if (!line.contains("#")) { // ignore all lines that start with a pound sign
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
          parsedLine.add(tokenizer.nextToken());
        }
      }
      if (!parsedLine.isEmpty()) { // ignore all empty lines
        parsedLines.add(parsedLine);
      }
    }
    return parsedLines;
  }
}