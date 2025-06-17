public class frlp {
    public static void frloop(int []arr,int n){
        int largest=-1;
        int secondLargestt=-1;
        int third=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        System.out.println(largest);
        for(int i=0;i<n;i++){
            if(arr[i]!=largest && arr[i]>secondLargestt){
                secondLargestt=arr[i];
            }
        }
        System.out.println(secondLargestt);
        for(int i=0;i<n;i++){
            if(arr[i]!=largest && arr[i]!=secondLargestt && arr[i]>third){
                third=arr[i];
            }
        }
        System.out.println(third);
    }
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        int n=arr.length;
        frloop(arr, n);
    }
    
}
