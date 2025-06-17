public class StringbuliderPalin {
     
    static int recursivePalin(String s){
        StringBuilder sb=new StringBuilder(s);
        String str=sb.reverse().toString();
        if(str.equals(s)){
            return 1;
        }
        return 0;
    }
        
         public static void main(String []args){
        String s="abbba";
        ;
        System.out.println(recursivePalin(s));
        if(recursivePalin(s)==0){
            System.out.println("not a palindrome");
        }
        else{
        System.out.println("palindromme");
        }
    }
}
    

