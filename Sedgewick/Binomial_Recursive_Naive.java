// https://stackoverflow.com/questions/28326501/understanding-a-recursive-method-for-finding-binomial-coefficient
// See the triangle bit
// $> java Binomial_Recursive_Naive 5 3
public class Binomial_Recursive_Naive {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(binomial(n,k));
        StdOut.println(binomial2(n,k));
        StdOut.println(binomial3(n,k));
    }
    public static double binomial(int n, int k){
        if((n==k) || (k==0)) {
            return 1;
        }
        double r = (binomial(n-1,k) + binomial(n-1,k-1));
        return(r);
    }
    public static double binomial2(int n, int k){
        if((n==0) || (k<0)) {// This is given in text, and is wrong.
            return 1;
        }
        double r = (binomial2(n-1,k) + binomial2(n-1,k-1));
        return(r);
    }
    public static double binomial3(int n, int k){
        if(n==0 || k==0|| k==n) {
            return 1;
        }
        double r = (binomial3(n-1,k) + binomial3(n-1,k-1));
        return(r);
    }
}
