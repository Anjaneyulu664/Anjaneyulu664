import java.io.File; 
import java.io.FileInputStream; // Import the File class
import java.io.IOException;
import java.util.Arrays;  // Import the IOException class to handle errors
import java.util.Date;

import javax.imageio.stream.FileImageInputStream;
public class HalndlingText {
    public static void main(String[]args)throws IOException{
   
        File file=new File("./sample.text");
   if(!file.exists()){
    file.createNewFile();
   }
  FileInputStream fis=new FileInputStream(file);
   int ascciicode;
   String text=" ";
   while ((ascciicode=fis.read())!=-1) {
  text+=String.valueOf((char)ascciicode);
   // System.out.print((char)ascciicode); 
   }
   System.out.println(text);
   fis.close();
   
    }
    

    
}
