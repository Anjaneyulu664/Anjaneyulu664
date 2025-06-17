public class reverse {
    public static void reverseString(String s){
        int n=s.length();
        StringBuilder sbd=new StringBuilder();
        for(int  i=n-1;i>=0;i--){
            sbd.append(s.charAt(i));
        }
        System.out.println(sbd.toString());
    }
    public static void main(String[] args) {
        String s="21345";
        reverseString(s);

    }
    
}
