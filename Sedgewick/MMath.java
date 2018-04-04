public class MMath {
    public static double hypotenuse(double a,double b){
        return sqrt(a*a+b*b);
    }
    public static double sqrt(double a){
        return Sqrt.sqrt(a);
    }
    public static boolean isPrime(int n){
        int a =2;
        int check_upto = (int) Math.pow(n,0.5);
        while(a<=check_upto){
            if(n%a==0)return false;
            a++;
        }
        return true;
    }
    public static boolean isPrime(long n){
        long a =2;
        long check_upto = (long) Math.pow(n,0.5);
        while(a<=check_upto){
            if(n%a==0)return false;
            a++;
        }
        return true;
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
    public static double eval_polynomial(double x, double[]p){
        //polynomial evaluation
        // Horners Method
        int num_coeffs = p.length;
        double term=0;
        for(int i = 0;i<num_coeffs;i++){
            term = (term*x+p[num_coeffs-i-1]);
        }
        return(term);
    }
    public static long toBase_long(int num, int base){
        int v = 1;
        long output=0;
        while(v<=num/base){v = v*base;}
        int n = num;
        while(v>0){
            if(n<v){
                output*=10;
            } else{
                output*=10;
                output+=n/v;
                n -= (n/v) * v;
            }
            v = v/base;
        }
        return output;
    }
    public static String toBase_String(int num, int base){
        int v = 1;
        String output="";
        while(v<=num/base){v = v*base;}
        int n = num;
        while(v>0){
            if(n<v){
                output=output+"0";
            } else{
                if((n/v)>9){
                    output +=Character.toString((char)(65+(n/v)-10));
                    //Ascii value of A = 65 thats why adding that, and A = 10 thats why subtracting 10.
                } else{
                    output=output + (n/v);
                }
                n -= (n/v) * v;
            }
            v = v/base;
        }
        return output;
    }
    public static int twopower(int n){
        if(n<0){throw new ArithmeticException("less than zero");}
        return(1<<n);
    }
    public static double logfactorial(int n){ //computes log(n!)
        if(n<0){throw new ArithmeticException("less than zero");}
        if(n==1){return 0;}
        return Math.log(n) + logfactorial(n-1);
    }
    public static int bitcounter(int n){
        //This counts all bits, including the 1 for denoting negative numbers
        int bits = 0;
        while(n!=0){
            if ((n & 1) == 1) {
                bits++;
            }
            n = n>>>1;
        }
        return bits;
    }
    public static boolean nth_bit_is_1(int number,int n){
        return ((number>>>n&1)==1);
    }



    public static void main(String[] args){
        int n =101;
        StdOut.println(harmonic(n) +" "+Harmonic.H_small(n));
        double[] p = {1,2,3};
        System.out.println(eval_polynomial(2.0,p));
        System.out.println(toBase_String(15,16));
        System.out.println(toBase_String(255,16));
        System.out.println(toBase_long(255,16));
        System.out.println(toBase_long(255,2));
        System.out.println(twopower(0));
        System.out.println(twopower(1));
        System.out.println(twopower(2));
        System.out.println(twopower(10));
        //System.out.println(twopower(-1));
        for (int i = -32; i < 32; i++) {StdOut.println("The number of bits in n = "+i+" = " + MMath.bitcounter(i));}
    }

}
