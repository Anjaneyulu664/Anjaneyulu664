
import java.io.*;
import java.util.*;
class Railway{
    private int tickets=10;
    private int count=0;
    public synchronized void booked(int n){
        if(tickets>=n){
            tickets-=n;
            System.out.println("n:"+n+",tickets:"+tickets);
            count++;
        }
        else {
            System.out.println("no avaliable tickets");
        }
    }
    public int available(){
        return tickets;
    }
    public int numTickets(){
        return count;
    }
    
}
class Main{
    public static void main(String[]args){
        Railway railway=new Railway();
        Thread t1=new Thread(()->{
            for(int i=0;i<2;i++){
                railway.booked(1);
            System.out.println("ticket booked");
                
            
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
           
            }
        });
        Thread t2=new Thread(()->{
            for(int i=0;i<2;i++){
                railway.booked(1);
            
            try{
                Thread.sleep(1000);
                System.out.println("booked");
                
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
           
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("total tickets:"+railway.available());
        System.out.println("total bokked:"+railway.numTickets());
        
    }
}