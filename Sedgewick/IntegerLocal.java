import java.util.*;


public class IntegerLocal {
    public static int eulers_totient_function(int n){
        return EulersTotientFunction.totient_function(n);
    }
    public static long eulers_totient_function(long n){
        return EulersTotientFunction.totient_function(n);
    }
    public static boolean isPrime(int n){
        return MMath.isPrime(n);
    }
    public static boolean isPrime(long n){
        return MMath.isPrime(n);
    }
    public static boolean relativelyPrime(int a, int b){
        return RelativelyPrime.relatively_prime(a,b);
    }
    public static int[] factors(int n){
        List<Integer> a = new ArrayList();
        int i = 2;boolean has_factors = false;
        while(i<=Math.sqrt(n)){
            if(n%i==0) {
                a.add(i);
                n=n/i;
            }
            else i+=1;
        }
        a.add(n);
        int[] b = new int[a.size()];
        for (int j = 0; j < b.length; j++) {
            b[j] = a.get(j);
        }
        return b;
    }

    public static List<Integer> factor_list(int n){
        List<Integer> a = new ArrayList();
        int i = 2;
        boolean has_factors = false;
        while(i<=Math.sqrt(n)){
            if(n%i==0) {
                a.add(i);
                n=n/i;
            }
            else i+=1;
        }
        a.add(n);
        return a;
    }
    public static void main(String args[]){
        int a  = 21;
        int b = 3;
        System.out.print(lcm(a,b));
    }

    public static int gcd(int a,int b){
        return GCD_Euclid.gcd_iter(a,b);
    }
    public static int lcm2(int a,int b){
        List<Integer> x = factor_list(a);
        List<Integer> y = factor_list(b);

        Set<Integer> aset = new HashSet<Integer>(x);
        Set<Integer> bset = new HashSet<Integer>(y);
        Set<Integer> out = new HashSet<Integer>(aset);
        out.addAll(bset);
        System.out.println(out);
        int output=1;
        for (int i : out) {
            output*=i;
        }
        return output;
    }
    public static int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }
}
