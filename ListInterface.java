import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
public class ListInterface{
    public static void main(String[]args){
        String []arr={"hi","hello","how are you"};
        List<String> list = new ArrayList<>();
        for(String i:arr){
            list.add(i);
        
        }
        System.out.println(list);
        System.out.println(list.lastIndexOf("hello"));
        List<String> vector=new Vector<>();
        for(String i:arr){
            vector.add(i);
        }
        System.out.println(vector);
        
        vector.set(1,"ker");
        System.out.println(vector.indexOf("hi"));
        vector.remove(2);
        System.out.println("element removed");
        System.out.println(vector);
        System.out.println(vector.get(0));
    }
}
    
