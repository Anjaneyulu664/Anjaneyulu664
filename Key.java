import java.util.Arrays;
public class Key{
    static void sort(int []arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[]args){
        int[] arr={5,1,6,2,4,3};
        sort(arr);
    }
}