public class SwapReverse {
    public static void reverse(String s){
        int i=0;
        int j=s.length()-1;
        StringBuffer sbr=new StringBuffer(s);
        while(i<j){
            char temp=sbr.charAt(i);
            sbr.setCharAt(i,sbr.charAt(j));
            sbr.setCharAt(j,temp);
            i++;
            j--;
          

        }
        System.out.println(sbr.toString());

    }
   public static void main(String[] args) {
        String s = "abdcfe";
        reverse(s);
        System.out.println(s);
    
    }
}

