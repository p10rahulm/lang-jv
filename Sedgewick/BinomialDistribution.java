public class BinomialDistribution {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        double binomial = binomial(n,k,p);
        double binomial_approx = binomial_approx(n,k,p);
        System.out.println("binomial = " + binomial+"\nbinomial_approximation = " + binomial_approx);
    }
    public static double binomial(int n,int k,double p){
        double logn = k*Math.log(p) + (n-k)*Math.log(1-p);
        for(int i =(k+1);i<=n;i++){logn+=Math.log(i);}
        for(int i =1;i<=(n-k);i++){logn-=Math.log(i);}
        double out = Math.exp(logn);
        return(out);
    }
    public static double binomial_approx(int n, int k, double p){

        return (Random.phi(k,n*p,Math.sqrt(n*p*(1-p))));

    }

}
