public class Sqrt {
    public static void main(String[] args){
        double input = Double.parseDouble(args[0]);
        double sq_rt = sqrt(input);
        //System.out.println(guess);
        StdOut.printf("The square root of " + input + " is "+sq_rt+".\n");
        StdOut.printf("The square root of %.1f is %.6f.", input,sq_rt);
    }
    public static double sqrt(double input){
        double error = 1e-15;
        double guess = input;
        while(Math.abs(guess - input/guess)>error*guess){
            guess = (input/guess + guess)/2;
        }
        return guess;
    }
}
