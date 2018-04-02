public class MMath {
    public static double hypotenuse(double a,double b){
        return sqrt(a*a+b*b);
    }
    public static double sqrt(double a){
        return Sqrt.sqrt(a);
    }
    public static boolean isPrime(int n){
        return PrimeCounter.isPrime(n);
    }
    public static int abs(int n){
        if(n<0){return(-n);}
        return n;
    }
    public static double abs(double n){
        if(n<0){return(-n);}
        return n;
    }
    public static double sigmoid(double x){
        return 1/(1+Math.exp(-x));
    }
    public static double harmonic(int n){
        if(n>=100){return(H_large(n));}
        return(Harmonic.H_small(n));
    }
    public static double H_large(int n){
        // Lehman book has nice explanation on below;
        double term = 1.0/2/n;
        double sum = term;
        term/=(6*n);
        sum -= term;
        term/=(10*n*n);
        sum += term;
        return(Math.log(n) + 0.577215664901532 + sum);
    }
    public static void main(String[] args){
        int n =101;
        StdOut.println(harmonic(n) +" "+Harmonic.H_small(n));
        double[] p = {1,2,3};
        System.out.println(eval_polynomial(2.0,p));
    }
    //polynomial evaluation
    // Horners Method
    public static double eval_polynomial(double x, double[]p){
        int num_coeffs = p.length;
        double term=0;
        for(int i = 0;i<num_coeffs;i++){
            term = (term*x+p[num_coeffs-i-1]);
        }
        return(term);
    }



}
