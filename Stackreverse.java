import java.util.Stack;
import java.util.Arrays;
public class Stackreverse {
    public static void reverse(String s){
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }
        System.out.println(stack);
        char []arr=new char[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=stack.pop();
        }
        System.out.println(Arrays.toString(arr));

    }
     public static void main(String[] args) {
        String s = "abdcfe";
        reverse(s);
    
}
}
