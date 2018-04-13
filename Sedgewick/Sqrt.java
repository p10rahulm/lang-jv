//java Sqrt 10
public class Sqrt {
    public static void main(String[] args){
        double input = Double.parseDouble(args[0]);
        double sq_rt = sqrt(input);
        //System.out.println(guess);
        StdOut.printf("The square root of " + input + " is "+sq_rt+".\n");
        StdOut.printf("The square root of %.1f is %.6f.\n", input,sq_rt);
        // Ok now some reality check
        int n = 10000000;
        StdOut.println(n);
        // sum of square roots of integers from 1 to n using Math.sqrt(x).
        Stopwatch timer1 = new Stopwatch();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (Calced sum of sqrt in %.2f seconds)\n", sum1, time1);

        // sum of square roots of integers from 1 to n using Math.pow(x, 0.5).
        Stopwatch timer2 = new Stopwatch();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (Calced sum of sqrt in %.2f seconds)\n", sum2, time2);

        // sum of square roots of integers from 1 to n using newton method :/.
        Stopwatch timer3 = new Stopwatch();
        double sum3 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum3 += Sqrt.sqrt(i);
        }
        double time3 = timer3.elapsedTime();
        StdOut.printf("%e (Calced sum of sqrt in %.2f seconds)\n", sum3, time3);

    }
    public static double sqrt(double input){
        double error = 1e-15;
        double guess = input;
        while(Math.abs(guess - input/guess)>error*guess){
            guess = (input/guess + guess)/2;
        }
        return guess;
    }
    public static double sqrt(int input){
        double error = 1e-15;
        double guess = (double) input;
        while(Math.abs(guess - input/guess)>error*guess){
            guess = (input/guess + guess)/2;
        }
        return guess;
    }
}
