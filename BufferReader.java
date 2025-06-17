import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReader {
    public static void main(String[]args) throws IOException{
        File f=new File("./table.docx");
        if(!f.exists()){
        f.createNewFile();
        }
        FileInputStream fr=new FileInputStream(f);
        InputStreamReader fir =new  InputStreamReader(fr);
        FileReader frr=new FileReader(f);
        BufferedReader bfr=new BufferedReader(frr);
      String line=new String();
      while ((line=bfr.readLine())!=null) {
        System.out.println(line);
        
      }

    }
}
