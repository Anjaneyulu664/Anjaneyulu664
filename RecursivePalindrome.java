public class RecursivePalindrome{
    static int recursivePalin(String s,int left,int right){
        if(left>=right){
            return 1;
        }
        if(s.charAt(left)!=s.charAt(right)){
            return 0;
        }
        return recursivePalin( s,left+1,right -1);
    }
    public static void main(String []args){
        String s="abbbba";
        int left=0;
        int right=s.length()-1;
        System.out.println(recursivePalin(s,left,right));
        
    }
}