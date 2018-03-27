public class BinomCoinTosses { // we want to estimate probability of k heads in 100 trials of 1,2,3...n-1,n-2, n tosses
    public static void main (String[] args){
        int binom_tree_size = Integer.parseInt(args[0]);
        double[][] binom_tree = new double[binom_tree_size][];
        int numtrials = 100; // some random
        binom_tree[0] = new double[]{1.0};
        for(int i =1;i<binom_tree_size;i++){
            binom_tree[i] = new double[i+1];
            for(int j=0;j<numtrials;j++){
                int numheads = 0;
                for(int k=0;k<i;k++){
                    if(Math.random()<0.5)numheads++;
                }
                //System.out.println("numheads = "+numheads+", i = "+i);
                binom_tree[i][numheads]++;
            }
            for(int j=0;j<i+1;j++){
                binom_tree[i][j]/=100;
            }
        }
        MatrixOps.print_matrix(binom_tree);

    }
}
