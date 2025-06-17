public class Priority extends Thread{
    public static void main(String[]args){
        Thread t=Thread.currentThread();
        System.out.println("current thread:"+t.getName());
        t.setName("geeks");
        System.out.println("current thread aftr changed:"+t.getName());
        System.out.println("priority of thread:"+t.getPriority());
        t.setPriority(MAX_PRIORITY);
        System.out.println(t.getPriority());
        Thread c=new Thread(){
            public void run(){
                for (int i=0;i<5;i++){
                    System.out.println("child");
                }
                
            }
        };
        System.out.println("c thread priotrity"+c.getPriority());
        c.setPriority(MIN_PRIORITY);
        System.out.println(c.getPriority());
        c.start();
        
    }
}