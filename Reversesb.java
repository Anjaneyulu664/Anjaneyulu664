public class Reversesb {
    public static void main(String[]args){
        String s="sdfbsdjhfs";
        StringBuilder sbr=new StringBuilder(s);
        sbr.reverse();
        sbr.setCharAt(1,'k');
        
        System.out.println(sbr.toString());
    }
    
}
