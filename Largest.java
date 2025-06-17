import java.util.Scanner;
import java.util.Arrays;
public class Largest {
    public static void large(int []arr,int n){
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[i]<arr[j]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            else{
                arr[i]=arr[i];
            }
        }

      }
      System.out.println(Arrays.toString(arr));
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int []arr={12,1,12,12,12};
        int n=arr.length;
        large(arr, n);
        int last =arr[n-1];
        System.out.println(last);
        for(int i=n-2;i>=0;i--){
           if(arr[i]!=last){
            System.out.println(arr[i]);

        }
        
    }
    
}
}
    

