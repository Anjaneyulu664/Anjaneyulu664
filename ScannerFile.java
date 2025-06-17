import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.stream.FileImageInputStream;


public class ScannerFile {
    public static void main(String[] args)throws IOException {
    File file=new File("./writte.text");
    if(!file.exists()){
   file.createNewFile();

    }
    Scanner sc=new Scanner(new FileReader(file));
    String s="";
    while (sc.hasNextLine()) {
        s+=sc.nextLine();
       //System.out.println(sc.nextLine());
        
    }  
    System.out.println(s); 
    FileWriter fwr=new FileWriter(file);
    fwr.write(s+"hello");
   
    sc.close(); 
    }
    

    
}
