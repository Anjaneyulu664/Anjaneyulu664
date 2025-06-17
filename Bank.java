class Bank{
    private int total=1000;
    public synchronized void withDraw(int amount){
        if(total>=amount){
        total=total-amount;
        System.out.println("withDrawn:"+amount+",balance:"+total);
        }
        else{
            System.out.println("insufficient balance");
        }
        
    }
    public synchronized void Deposit(int amount){
        total+=amount;
        System.out.println("deposit"+amount+",balance"+total);
    }
    public int getBalance(){
        return total;
    }
}
class Main{
    public static void main(String[]args){
        Bank account=new Bank();
        Thread t1=new Thread(()->{
        for(int i=0;i<3;i++){
            account.Deposit(100);
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        }
        });
        Thread t2=new Thread(()->{
            for(int i=0;i<3;i++){
                account.withDraw(50);
                try{
                    t1.sleep(100);
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
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("final balance"+account.getBalance());
    }
}
    