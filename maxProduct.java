public class maxProduct {
    public static int  product(int []arr,int n){
        int max_product=0;
     for(int i=0;i<n-2;i++){
        for(int j=i+1;j<n-1;j++){
            for(int k=j+1;j<n;j++){
                max_product=Math.max(max_product,arr[i]*arr[j]*arr[k]);
            }
        }
     }
      return max_product;
    }
   
    public static void main(String[]args){
        int [] arr={10,20,3,5,6};
        int n=arr.length;
        int res=product(arr, n);
        System.out.println(res);
    }
    
    
}
