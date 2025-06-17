// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class palindrome{
    public static int ispalindrome(String s){
    int sl=s.length();
        int i=0;
        int j=sl-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return 0;
            else{
                   i++;
                j--;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        String s = "abba";
        System.out.println(ispalindrome(s));
    }
    }
