public class PercolatesEstimator {
    public static void main(String[] args){
        int size_of_matrix = Integer.parseInt(args[0]);
        double probability_of_opensite = Double.parseDouble(args[1]);
        int trials = Integer.parseInt(args[2]);
        double prob_percolation = estimate_probability_of_percolation(size_of_matrix,probability_of_opensite,trials,false);
        System.out.println("probability of percolation = "+prob_percolation);
        prob_percolation = estimate_probability_of_percolation(size_of_matrix,probability_of_opensite,trials,true);
        System.out.print("probability of percolation = "+prob_percolation);
    }
    public static double estimate_probability_of_percolation(int size, double prob, int numtrials,boolean onlyvertical_percolation){
        int count=0;
        for (int i = 0; i < numtrials; i++) {
            boolean[][] open = MatrixOps.generate_random_matrix(size,size,prob);
            if(Percolates.percolates(open,onlyvertical_percolation)){
                count+=1;
            }
        }
        return (double)count/numtrials;
    }
}
