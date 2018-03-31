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



}
