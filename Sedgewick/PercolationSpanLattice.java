// Here the attempt is to identify whether there is complete left to right or up to down percolation

public class PercolationSpanLattice {
    public static void main(String[] args){
        int num_buckets = 100;
        double[] spanning_prob = get_probability_of_span(10, 10000,num_buckets);
        VectorOps.printvector(spanning_prob);
        double[] percolation_prob = new double[num_buckets];
        for (int i = 0; i < num_buckets; i++) {
            percolation_prob[i] = (double)i/num_buckets;
        }
        PlotFunction.plot_function(percolation_prob,spanning_prob);

    }
    public static double[] get_probability_of_span(int lattice_size, int trials, int num_buckets){
        double[] probs = new double[num_buckets];
        for (int i = 0; i < num_buckets; i++) {
            double percolation_probability = (double) i/num_buckets;
            for (int t = 0; t < trials; t++) {
                if(percolate(lattice_size,percolation_probability)){
                    probs[i]+=1;
                }
            }
            probs[i]/=trials;
        }
        return probs;
    }

    public static boolean percolate(int latticesize, double percolation_prob){
        boolean[][] percolate = new boolean[latticesize][latticesize];
        for (int i = 0; i < latticesize; i++) {
            for (int j = 0; j < latticesize; j++) {
                if(Math.random()<percolation_prob){
                    percolate[i][j] = true;
                }
            }
        }
        // Check Percolation
        boolean percolated;
        //check left-right percolation
        percolated = check_rowcolumn_percolation(latticesize,percolate,true);
        if(percolated) return true;
        //check top-down percolation
        percolated = check_rowcolumn_percolation(latticesize,percolate,false);
        return percolated;

    }
    public static boolean check_rowcolumn_percolation(int lattice_size, boolean[][] percolated_matrix, boolean leftright){
        boolean percolated = false;
        for (int i = 0; i < lattice_size; i++) {
            percolated = true;
            for (int j = 0; j < lattice_size; j++) {
                boolean rowcolumn_boolean;
                if(leftright){
                    rowcolumn_boolean=percolated_matrix[i][j];
                } else {
                    rowcolumn_boolean=percolated_matrix[j][i];
                }

                if(!rowcolumn_boolean){
                    percolated = false;
                    break;
                }
            }
            if(percolated){
                return true;
            }
        }
        return percolated;
    }
}
