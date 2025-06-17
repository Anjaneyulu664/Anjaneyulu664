import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.Arrays;  // Import the IOException class to handle errors
import java.util.Date;

public class FileHandling {
  public static void main(String[] args)throws Exception {
    
      File myObj = new File("D:\\visualstudio programs\\javaprograms");
      System.out.println(myObj.getName());
      System.out.println(myObj.getAbsolutePath()); 
      System.out.println(myObj.getParent());
      System.out.println(myObj.isDirectory());
      System.out.println(myObj.isFile());
      System.out.println(new Date(myObj.lastModified()));
      File f=new File("./resume.docx");
      f.createNewFile();
      System.out.println(f.getName());
      //f.delete();
      System.out.println(new Date(f.lastModified()));
      System.out.println(f.isDirectory());
      System.out.println(f.isFile());

    //
    //  if (myObj.createNewFile()) {
      //  System.out.println("File created: " + myObj.getName());
      //} else {
      //  System.out.println("File already exists.");
      //}
    ////} catch (IOException e) {
      //System.out.println("An error occurred.");
      //e.printStackTrace();
    //}
  }
}