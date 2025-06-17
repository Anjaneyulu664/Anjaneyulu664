import java.util.Arrays;
public class Onerotate{
    public static void elemntRotate(int []arr,int n,int d){
        int[] temp=new int[d];
        for (int i=0;i<d;i++){
            temp[i]=arr[i];
        }
        for(int i=d;i<n;i++)
        {
            arr[i-d]=arr[i];
        }
        int j=0;
        for(int i=d+1;i<n;i++){
            arr[i]=temp[j];
            j++;
        }
        System.out.println("left rotate:"+Arrays.toString(arr));

    }
    public static void main(String[]args){
        int arr[]={1,2,3,4,5};
        int n=arr.length;
        elemntRotate(arr, n, 2);
        
    }
}