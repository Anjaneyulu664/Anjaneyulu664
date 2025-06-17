

public class Missing { 
    public static void main(String[] args) {
        
        int []arr ={1,2,4,5};
        int []hash=new int[arr.length+1];
        for(int i=0;i<arr.length-1  ;i++){
    
        hash[arr[i]]=1;
        }
        for(int i=1;i<arr.length;i++){
                if(hash[i]==0){
                    System.out.println(i);
                    break;
                }
            }
            }
        }
    
    
      

