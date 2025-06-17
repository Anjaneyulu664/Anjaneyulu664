public class MaxThread implements Runnable{
    int count=0;
    public synchronized void run(){
        int max=1_000_00_000;
        for(int i=0;i<max;i++){
            count++;
        }
    }
    
}
class Main{
    public static void main(String[]args)throws InterruptedException{
        MaxThread c=new MaxThread();
        Thread first=new Thread(c);
        Thread second=new Thread(c);
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println(c.count);
    }   
    }

 
    

