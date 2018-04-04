public class NthRoot {
    public static void main(String[] args){
        double input = Integer.parseInt(args[0]);
        double nthroot = Integer.parseInt(args[1]);
        double guess = input;
        double epsilon = 1e-15;
        while(Math.abs(guess - input/Math.pow(guess,nthroot-1)) >= epsilon*guess){
            //The below result is an extraordinary result. So how do i get this? By comparing with sqrt method.
            // How did newton get it? Calculus. We have estimate of t = t - f(t)/f'(t) (Sedgewick, Pg 78)
            guess = guess - (guess - input/Math.pow(guess,(nthroot-1)))/(nthroot);
        }
        System.out.println(guess);
    }
}
