import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteFile {
  public static void main(String[] args) {
    try {
         File myObj = new File("D:/visualstudio programs\\filename1.txt");
        
      FileWriter myWriter = new FileWriter("filename1");
myObj.canRead();
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } 
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}