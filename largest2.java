
import java.util.Arrays;
public class largest2 {
    public static int large2(int []arr){
        int n=arr.length;
        Arrays.sort(arr);
        System.out.println(arr[n-1]);
        for(int i=n-2;i>0;i++){
            if(arr[i]!=arr[n-1]){
                System.out.println(arr[i]);
            }
        
    }
    return -1;                
        }
    
       
    public static void main(String[]args){
        int [] arr={12,1,2,1,2,3};
        large2(arr);
        
    
    }
    
}
