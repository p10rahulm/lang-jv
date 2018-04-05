public class PercolatesExperiments {
    public static void main(String[] args){
        /*int trials = Integer.parseInt(args[0]);
        int p_spacing = Integer.parseInt(args[1]);
        int size = Integer.parseInt(args[2]);*/

        double[][] percolation_probabilities = run_experiments(100, 2, 50,5,
                0.05,1,0.05);
        MatrixOps.print_matrix(percolation_probabilities);
        plot_curve(percolation_probabilities,0.05,1,0.05,2,50,5);
    }

    public static double[][] run_experiments(int num_trials, int size_lo, int size_hi,int size_spacing,double probability_open_lo,double probability_open_hi,double p_spacing){
        // Let's create a matrix that stores the probability of full percolation with
        // probability of random filling and with size of n*n ground.
        double[][] prob_percolation = new double[(size_hi-size_lo)/size_spacing+1][(int)((probability_open_hi-probability_open_lo)/p_spacing+1)];
        StdOut.printf("size of percolation matrix is %d by %d\n",prob_percolation.length,prob_percolation[0].length);
        int i=0,j;
        for (int size = size_lo; size <=size_hi ; size+=size_spacing) {
            j=0;
            for (double probability_of_open = probability_open_lo; probability_of_open <=probability_open_hi ; probability_of_open+=p_spacing) {
                for (int trial = 0; trial < num_trials; trial++) {
                    boolean[][] open = MatrixOps.generate_random_matrix(size,size,probability_of_open);
                    if(Percolates.percolates(open,false))prob_percolation[i][j]+=1.0;
                    //StdOut.printf("size = %d, probability = %f, number of trials = %d\n",size,probability_of_open,trial);
                }
                j+=1;
            }
            i+=1;
        }
        for(i=0;i<prob_percolation.length;i++){
            for(j=0;j<prob_percolation[0].length;j++){
                prob_percolation[i][j]/=num_trials;
            }
        }
        return prob_percolation;
    }
    public static void plot_curve(double[][] percolation_probs,double prob_lo,double prob_hi,double p_spacing,
                                  int size_lo,int size_hi, int size_spacing){
        StdDraw.setXscale(prob_lo-0.05,prob_hi+0.05);
        double legend_center_x =prob_lo+0.1,legend_center_y = 0.9;
        StdDraw.text(legend_center_x,legend_center_y,"Legend");
        legend_center_y -=0.04;
        for (int i = 0; i < percolation_probs.length; i++) {
            StdDraw.setPenColor(Random.randbetween(0,255),Random.randbetween(0,255),Random.randbetween(0,255));
            StdDraw.filledRectangle(legend_center_x-0.025,legend_center_y,0.025,0.0125);
            StdDraw.text(legend_center_x+0.025,legend_center_y,Integer.toString(size_lo+size_spacing*i));
            legend_center_y -=0.04;
            int j =1;
            for (double prob = prob_lo+p_spacing; prob <=prob_hi ; prob+=p_spacing,j++) {
                StdDraw.line(prob,percolation_probs[i][j],prob-p_spacing,percolation_probs[i][j-1]);
            }
        }
    }
}
