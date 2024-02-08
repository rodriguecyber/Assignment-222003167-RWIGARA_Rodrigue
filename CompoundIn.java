public class CompoundIn{
    //create class for compound interest 
   static class Compound{
    double principal;
    double rate;
    int time;
   int compoundFrequency;
   // constructor for compound interest class
    public Compound(double principal, double rate, int time,int compoundFrequency)
    {
        this.principal=principal;
        this.rate=rate;
        this.time=time;
        this.compoundFrequency=compoundFrequency;
    }
    //create method for calculating compound interest
    double CompoundInterest(){
    double totalAmount = principal * Math.pow(1 + (rate / 100) / compoundFrequency, compoundFrequency * time);
    return totalAmount - principal;
   }

}
// start main method
public static void main(String[] args){
    double principalForLoan = 500000;
        double rateForLoan = 18;
        int timeForLoan = 3;
        int compoundFrequency = 12;
        //creating object for compound constructor
Compound compoundobj=new Compound(principalForLoan, rateForLoan, timeForLoan, compoundFrequency);
//displaying output
System.out.println(compoundobj.CompoundInterest());
}
}