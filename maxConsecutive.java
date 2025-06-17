// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.lang.*;
class maxConsecutive{
    public static void m1(int arr[],int n){
        int max=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==(1)){
                count++;
                max=Math.max(max,count);
                
            }
            else{
                count=0;
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int []arr={1,1,1,1,1,0,1};
        int n=arr.length;
        m1(arr,n);
    }
}
