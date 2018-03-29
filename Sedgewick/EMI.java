
public class EMI {
    public static void main(String[] args){
        double principal = Double.parseDouble(args[0]);
        double number_of_years = Double.parseDouble(args[1]);
        double interest_rate = Double.parseDouble(args[2]);
        double prin_rem = principal, tot_int=0;
        double EMI = find_EMI(principal,number_of_years,interest_rate);

        // Print the first line
        StdOut.printf("%7s %10s %15s %15s %15s %15s %15s\n","SlNo","month_no","mnthly_pymnt","interest","principal","prncpl_remn","total_intrst");
        for(int i = 1;i<=12*number_of_years;i++){
            StdOut.printf("%7d %10d %15.2f %15.2f %15.2f %15.2f %15.2f\n",i,i-1,EMI,prin_rem*interest_rate/12,EMI-prin_rem*interest_rate/12,prin_rem - (EMI-prin_rem*interest_rate/12),tot_int + prin_rem*interest_rate/12);
            tot_int+=prin_rem*interest_rate/12;
            prin_rem-=(EMI-prin_rem*interest_rate/12);
        }
    }
    public static double find_EMI(double principal,double number_of_years,double interest_rate){
        System.out.println("inside");
        double amount_remaining=principal;
        double guess=0, guess_hi  = principal/(number_of_years*12) + principal*(Math.pow(1+interest_rate,number_of_years)-1)/(12*number_of_years),guess_lo = principal/(number_of_years*12);
        System.out.println("guess_hi = " + guess_hi + ", guess_lo = "+ guess_lo);
        while(Math.abs(amount_remaining)>0.005){
            guess = (guess_hi + guess_lo)/2;
            amount_remaining=principal;
            for(int i = 1;i<=(int)(12*number_of_years);i++){
                amount_remaining-=(guess-amount_remaining*interest_rate/12);
            }
            System.out.println("guess_hi = " + guess_hi + ", guess_lo = "+ guess_lo+ ", amount_rem = "+ amount_remaining);
            if(amount_remaining<0){guess_hi=guess;} else {guess_lo=guess;}

        }
        return(guess);
    }
}
