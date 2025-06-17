// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Datatype {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a number");
                int n=sc.nextInt();
        for(int i=0;i<n;i++){
            try{
                Long num=sc.nextLong();
                if(num>=Byte.MIN_VALUE && num<=Byte.MAX_VALUE)
                    System.out.println(num+"number is fitted intof the byte");
                if(num>=Short.MIN_VALUE && num<=Short.MAX_VALUE)
                    System.out.println(num+"fitted into the short");
                if(num>=Integer.MIN_VALUE && num>=Integer.MAX_VALUE)System.out.println(num+"fitted into the integer");
                
                
                
            }
            catch(Exception e){
                System.out.println("not fitted into the any data type above mentioned");
            }
        }
        sc.close();
        
    }
}