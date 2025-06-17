

public class Halfpalindrome{
    public static int halfPalin(String s){
        int n=s.length();
     int    k=n/2;
        for(int i=0;i<k;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[]args){
        String s="abba";
       System.out.println( halfPalin(s));
    }
}