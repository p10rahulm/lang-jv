// we have to find the leading digit in a sequence of integers read from standard input
public class BenfordsLaw {
    public static void main(String[] args){
        int[] leading_digits = leading_digit_histogram();
        double[]prob_digits = VectorOps.normalize(leading_digits);
        double[] cumulative_prob = VectorOps.cumulative_sum(prob_digits);
        //Generate Random Number with leading digit distribution as above, from $1.00 to $1000.00.
        // We can get this by generating ints between 0 and 9999, adding one leading digit and then dividing by 100.
        int[] numdigits = {3,4,5};
        double myrand = (double)GenerateRandom(cumulative_prob,numdigits)/100;
        StdOut.println(myrand);
    }
    public static int GenerateRandom(double[] leaddigit_cumul_distr,int[] digits){
        double[] prob_digits = new double[digits.length];
        for(int i =0;i<digits.length;i++){
            prob_digits[i] =Math.pow(10,digits[i])-Math.pow(10,digits[i]-1);
        }
        prob_digits = VectorOps.normalize(prob_digits);
        prob_digits = VectorOps.cumulative_sum(prob_digits);

        // We shall (a) choose a number of digits. (b) choose a leading digit
        // (c) choose a random number with appropriate high and lo.
        // Concatenate these to give the required number
        //choose a number of digits
        double rand_numdigits = Math.random();
        int digitcounter;
        for(digitcounter=0;digitcounter < digits.length&&prob_digits[digitcounter]<rand_numdigits;digitcounter++){}
        int numdigits = digits[digitcounter];

        //choose leading digit
        double rand_leaddigit = Math.random();
        int lead_counter;
        for(lead_counter=0;lead_counter< 10&&leaddigit_cumul_distr[lead_counter]<rand_numdigits;lead_counter++){}
        int leaddigit = lead_counter;
        int number = leaddigit*(int)Math.pow(10,numdigits-1) + Random.randbetween(0,(int)Math.pow(10,numdigits-1));
        StdOut.printf("numdigits %d, lead_digit_chosen %d, final number is %d\n",numdigits,leaddigit,number);
        return number;
    }

    public static int[] leading_digit_histogram(){
        int[] leading_digits = new int[10];
        int i=0;
        while(!StdIn.isEmpty()){
            //StdOut.print(i);
            int a = StdIn.readInt();
            int leading_digit=a;
            while(leading_digit/10!=0){
                leading_digit = leading_digit/10;
                //StdOut.println(leading_digit);
            }
            leading_digits[leading_digit]+=1;
            i++;
        }
        //VectorOps.printvector(leading_digits);
        return leading_digits;
    }
}
