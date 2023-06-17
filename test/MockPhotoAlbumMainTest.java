import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * A JUnit test class for the Photo Album application.
 */
public class MockPhotoAlbumMainTest {
  StringBuilder output;
  File outputFile;

  /**
   * Sets up the necessary tools for testing the web view.
   */
  @Before
  public void setUp() {
    outputFile = new File("test/test_output.html");
    output = new StringBuilder();
  }

  /**
   * Deletes the test file.
   */
  @After
  public void deleteFile() {
    outputFile.deleteOnExit();
  }

  /**
   * Tests the initialization of the graphical view.
   */
  @Test
  public void testGraphicalView() {
    String[] args1 = "-v graphical -in demo_input.txt".split(" ");
    assertEquals("Running graphical view with default window size",
            MockPhotoAlbumMain.main(args1));
    String[] args2 = "-view graphical -in demo_input.txt".split(" ");
    assertEquals("Running graphical view with default window size",
            MockPhotoAlbumMain.main(args2));
    String[] args3 = "-v graphical -in demo_input.txt 1100".split(" ");
    assertEquals("Running graphical view with default window size",
            MockPhotoAlbumMain.main(args3));
    String[] args4 = "-view graphical -in demo_input.txt 1100 900".split(" ");
    assertEquals("Running graphical view with custom window size",
            MockPhotoAlbumMain.main(args4));
  }

  /**
   * Tests the web view initialized with a default window size.
   */
  @Test
  public void testWebViewWithDefaultWindow() {
    String[] args = "-v web -in test/demo_input.txt -out test/test_output.html".split(" ");
    MockPhotoAlbumMain.main(args);
    try {
      Scanner reader = new Scanner(outputFile);
      while (reader.hasNextLine()) {
        output.append(reader.nextLine()).append("\n");
      }
    } catch (IOException e) {
      System.err.println("File not found");
      System.exit(1);
    }
    String expectedResult = """
            <!DOCTYPE html>
            <html>
            <body>
            <h1>CS 5004 Shapes Photo Album</h1>
            <div style="background-color: powderblue; margin: 1%; border-style: solid; border-color: red; border-width: thick;">
            \t<h2>test</h2>
            \t<p>Description: After first selfie</p>
            \t<svg width="1000" height="1000">
            \t\t<rect id="myrect" x="200" y="200" width="50" height="100" fill="rgb(255,0,0)">
            \t\t</rect>
            \t\t<ellipse id="myoval" cx="500" cy="100" rx="60" ry="30" fill="rgb(0,255,1)">
            \t\t</ellipse>
            \t</svg>
            </div>
            <div style="background-color: powderblue; margin: 1%; border-style: solid; border-color: red; border-width: thick;">
            \t<h2>test</h2>
            \t<p>Description: 2nd selfie</p>
            \t<svg width="1000" height="1000">
            \t\t<rect id="myrect" x="100" y="300" width="25" height="100" fill="rgb(255,0,0)">
            \t\t</rect>
            \t\t<ellipse id="myoval" cx="500" cy="100" rx="60" ry="30" fill="rgb(0,255,1)">
            \t\t</ellipse>
            \t</svg>
            </div>
            <div style="background-color: powderblue; margin: 1%; border-style: solid; border-color: red; border-width: thick;">
            \t<h2>test</h2>
            \t<svg width="1000" height="1000">
            \t\t<rect id="myrect" x="100" y="300" width="25" height="100" fill="rgb(0,0,255)">
            \t\t</rect>
            \t\t<ellipse id="myoval" cx="500" cy="400" rx="60" ry="30" fill="rgb(0,255,1)">
            \t\t</ellipse>
            \t</svg>
            </div>
            <div style="background-color: powderblue; margin: 1%; border-style: solid; border-color: red; border-width: thick;">
            \t<h2>test</h2>
            \t<p>Description: Selfie after removing the rectangle from the picture</p>
            \t<svg width="1000" height="1000">
            \t\t<ellipse id="myoval" cx="500" cy="400" rx="60" ry="30" fill="rgb(0,255,1)">
            \t\t</ellipse>
            \t</svg>
            </div>
            </body>
            </html>
            """;
    assertEquals(expectedResult, output.toString());
  }

  /**
   * Tests the web view initialized with a custom window size.
   */
  @Test
  public void testWebViewWithCustomWindow() {
    String[] args = "1100 -view web -in test/demo_input.txt -out test/test_output.html 900"
            .split(" ");
    MockPhotoAlbumMain.main(args);
    try {
      Scanner reader = new Scanner(outputFile);
      while (reader.hasNextLine()) {
        output.append(reader.nextLine()).append("\n");
      }
    } catch (IOException e) {
      System.err.println("File not found");
      System.exit(1);
    }
    String expectedResult = """
            <!DOCTYPE html>
            <html>
            <body>
            <h1>CS 5004 Shapes Photo Album</h1>
            <div style="background-color: powderblue; margin: 1%; border-style: solid; border-color: red; border-width: thick;">
            \t<h2>test</h2>
            \t<p>Description: After first selfie</p>
            \t<svg width="1100" height="900">
            \t\t<rect id="myrect" x="200" y="200" width="50" height="100" fill="rgb(255,0,0)">
            \t\t</rect>
            \t\t<ellipse id="myoval" cx="500" cy="100" rx="60" ry="30" fill="rgb(0,255,1)">
            \t\t</ellipse>
            \t</svg>
            </div>
            <div style="background-color: powderblue; margin: 1%; border-style: solid; border-color: red; border-width: thick;">
            \t<h2>test</h2>
            \t<p>Description: 2nd selfie</p>
            \t<svg width="1100" height="900">
            \t\t<rect id="myrect" x="100" y="300" width="25" height="100" fill="rgb(255,0,0)">
            \t\t</rect>
            \t\t<ellipse id="myoval" cx="500" cy="100" rx="60" ry="30" fill="rgb(0,255,1)">
            \t\t</ellipse>
            \t</svg>
            </div>
            <div style="background-color: powderblue; margin: 1%; border-style: solid; border-color: red; border-width: thick;">
            \t<h2>test</h2>
            \t<svg width="1100" height="900">
            \t\t<rect id="myrect" x="100" y="300" width="25" height="100" fill="rgb(0,0,255)">
            \t\t</rect>
            \t\t<ellipse id="myoval" cx="500" cy="400" rx="60" ry="30" fill="rgb(0,255,1)">
            \t\t</ellipse>
            \t</svg>
            </div>
            <div style="background-color: powderblue; margin: 1%; border-style: solid; border-color: red; border-width: thick;">
            \t<h2>test</h2>
            \t<p>Description: Selfie after removing the rectangle from the picture</p>
            \t<svg width="1100" height="900">
            \t\t<ellipse id="myoval" cx="500" cy="400" rx="60" ry="30" fill="rgb(0,255,1)">
            \t\t</ellipse>
            \t</svg>
            </div>
            </body>
            </html>
            """;
    assertEquals(expectedResult, output.toString());
  }

  /**
   * Tests the application under several bad scenarios.
   */
  @Test
  public void testBadMain() {
    String[] badArgs1 = "test".split(" ");
    assertEquals("Please provide a view using the flags -v or -view and an input file "
            + "using the flag -in", MockPhotoAlbumMain.main(badArgs1));
    String[] badArgs2 = "-v graphical".split(" ");
    assertEquals("Please provide a view using the flags -v or -view and an input file "
            + "using the flag -in", MockPhotoAlbumMain.main(badArgs2));
    String[] badArgs3 = "-in demo_input.txt".split(" ");
    assertEquals("Please provide a view using the flags -v or -view and an input file "
            + "using the flag -in", MockPhotoAlbumMain.main(badArgs3));
    String[] badArgs4 = "-view web -in demo_input.txt -out".split(" ");
    assertEquals("The arguments provided are not valid",
            MockPhotoAlbumMain.main(badArgs4));
    String[] badArgs5 = "900 -v graphical 500 -in demo_input.txt 1100".split(" ");
    assertEquals("Please provide width and height only",
            MockPhotoAlbumMain.main(badArgs5));
    String[] badArgs6 = "900 -view web -in demo_input.txt 1100 -out test.txt".split(" ");
    assertEquals("Please provide a valid html file", MockPhotoAlbumMain.main(badArgs6));
    String[] badArgs7 = "-v interactive -in demo_input.txt 1100 -out test.html".split(" ");
    assertEquals("Please provide a valid view", MockPhotoAlbumMain.main(badArgs7));
    String[] badArgs8 = "-view -in demo_input.txt 1100 -out test.html".split(" ");
    assertEquals("Please provide a valid view", MockPhotoAlbumMain.main(badArgs8));
    String[] badArgs9 = "-v web -in demo_input.html 1100 900 -out test.html".split(" ");
    assertEquals("Please provide a valid input file", MockPhotoAlbumMain.main(badArgs9));
    String[] badArgs10 = "-view web -in 1100 900 -out test.html".split(" ");
    assertEquals("Please provide a valid input file", MockPhotoAlbumMain.main(badArgs10));
    // if output file is omitted completely, hence -out is not even present, the program exits
    // and prints to standard error.
  }
}