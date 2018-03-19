public class LoanInterest_pert {
    public static void main(String[]  args){
        double Principle = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        double time_in_years = Double.parseDouble(args[2]);
        System.out.println(Principle*(Math.exp(rate*time_in_years)-1));
    }

}
