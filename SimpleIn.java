public class SimpleIn{
    // create class for simple interest and declaration of variable used
        static class SimpleInterest {
            double principal;
            double rate;
            int time;
    
            // Constructor for SimpleInterest class
            public SimpleInterest(double principal, double rate, int time) {
                this.principal = principal;
                this.rate = rate;
                this.time = time;
            }
    
            // Method to calculate simple interest
            public double calculateSimpleInterest() {
                return (principal * rate * time) / 100;
            }
        }
    
       
        public static void main(String[] args) {
            // Simple Interest Calculation for Bank Deposit
            double principalForDeposit = 100000;
            double rateForDeposit = 5;
            int timeForDeposit = 5;
    
            // Creating object for SimpleInterest and calculating simple interest
            SimpleInterest simpleInterest = new SimpleInterest(principalForDeposit, rateForDeposit, timeForDeposit);
            double bankSimpleInterest = simpleInterest.calculateSimpleInterest();
            System.out.println("Simple Interest on Bank Deposit: " + bankSimpleInterest + " RWF");
    
            
        }
    }
    