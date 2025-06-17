public class Recursiverevese {
    public static void reverse(char []s,int l,int r)
    {
       if(l>=r){
        System.err.println();
       }
       else{
        char temp=s[l];
        s[l]=s[r];
        s[r]=temp;

       }
       reverse(s, l+1, r-1);
    }
    public static void conversionString(String s){

        char []arr=s.toCharArray();
        reverse(arr, 0, arr.length-1);
        System.out.println(new String(arr));
    }
    public static void main(String[]args){
        String s="abdeh";
        conversionString(s);
    }
    
}
