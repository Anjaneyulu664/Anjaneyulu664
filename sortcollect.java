// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Integer []arr={4,3,6,5,1,2,5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        List <Integer> al=new ArrayList<>(Arrays.asList(arr));
        Collections.sort(al);
        System.out.println(al);
    }
}