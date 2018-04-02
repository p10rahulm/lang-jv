import jdk.jshell.StatementSnippet;

public class Bernoulli {
    public static int binomial(int n){
        // simulate flipping a coin n times
        int heads = 0;
        for (int i = 0; i < n; i++) {if(Random.bernoulli(0.5))heads++;}
        return heads;
    }
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]); // num flips per trial
        int t = Integer.parseInt(args[1]); //num trials
        int[] freq = new int[n+1];
        for (int i = 0; i < t; i++) {
            freq[binomial(n)]++;
        }
        double[] norm = VectorOps.normalize(freq);
        ArrayStats.plotBars(norm);
        double stdev = Math.sqrt(n)/2.0;
        double[] phi = new double[n+1];
        for (int i = 0; i < n; i++) {
            phi[i] = Random.phi(i,n/2,stdev);
        }
        ArrayStats.plotLines(phi,0.5);
    }
}
