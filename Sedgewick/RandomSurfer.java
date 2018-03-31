//Run with :
// java RandomSurfer 1000 < data/tiny.txt (at 100000 instead of 100, the results would start matching the matrix)

public class RandomSurfer {
    public static void main(String[] args){
        int num_jumps = Integer.parseInt(args[0]);
        Object[] linkages  = count_links();
        double random_jump_prob = 0.1; // 90% of time follow links else, randomly jump
        double[][] transition_matrix = get_transition_matrix(linkages,random_jump_prob);
        double[][] cumulative_tm = MatrixOps.cumulative_rows(transition_matrix);
        int vertices = (int)linkages[0];
        double[] freq_landing_in_page = get_freq_landing_in_page(cumulative_tm,vertices,num_jumps);
        VectorOps.printvector(freq_landing_in_page);
        /*  The probability of getting to any point from point[0] in one step = [1,0,0,0,0]*TM
            The probability for getting to each point from each point in one step is given by I*TM (Identity * transition matrix)
            The probability for getting to each point from each point in n steps is given by I*TM (Identity * transition matrix^n)
            we shall take n to be a power of 2, and multiply ((TM^2)^2)^2...
            Lets say n = 2^10;         */
        double[][] transition_through2n_steps = MatrixOps.copy_square_matrix(transition_matrix);
        // We do a transition through 2^10 steps
        for(int i =0;i<10;i++){transition_through2n_steps = MatrixOps.square_matrix(transition_through2n_steps);}
        MatrixOps.print_matrix(transition_through2n_steps);
        // Note firstly how the rows are same as each other. Means at the limit, doesn't matter where you start.
        // Secondly note how it's very similar to the manual simulation


    }

    public static double[] get_freq_landing_in_page(double[][] cumulative_transition_matrix,int vertices,int num_jumps){
        double[] freq_landing_in_page = new double[vertices];
        int page = (int)(Math.random()*vertices);
        freq_landing_in_page[page]++;
        int sum=1;
        for(int i=0;i<num_jumps;i++){
            double p = Math.random();
            int j;
            for(j =0;j<vertices&&p>=cumulative_transition_matrix[page][j];j++) {}
            page = j;
            freq_landing_in_page[page]++;
            sum++;
        }
        for(int i =0;i<vertices;i++){freq_landing_in_page[i]/=sum;}
        return freq_landing_in_page;
    }

    public static Object[] count_links(){
        int vertices = StdIn.readInt();
        int[][] link_counter = new int[vertices][vertices];
        int[] total_outgoing_links = new int[vertices];
        while(!StdIn.isEmpty()){
            int a = StdIn.readInt();
            int b = StdIn.readInt();
            link_counter[a][b]+=1;
            total_outgoing_links[a]++;
        }
        return new Object[]{vertices,link_counter, total_outgoing_links};
    }
    private static double[][] get_transition_matrix(Object[] linkages,double random_jump_prob){
        int vertices = (int)linkages[0];
        int[][] link_counter = (int[][]) linkages[1];
        int[] total_outgoing_links = (int[]) linkages[2];
        double[][] transition_matrix = new double[vertices][vertices];
        for(int i = 0;i<vertices;i++){
            for(int j = 0;j<vertices;j++){
                transition_matrix[i][j] = random_jump_prob/vertices+(1-random_jump_prob)*link_counter[i][j]/total_outgoing_links[i];
            }
        }
        return transition_matrix;
    }



}
