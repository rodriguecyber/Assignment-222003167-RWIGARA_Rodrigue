public class breakstatement {
    public static void main(String[] args)  {
        //declare variable
        int x;
        //start for loop
        for(x=2; x<11; x++)
        {
            System.out.println(x);
            //start if statement
       if(x==6)
       {
        System.out.println("program stopped here!"); 
        //break stop code execution when condition fulfilled
        break;
       }
        
    }}
}
