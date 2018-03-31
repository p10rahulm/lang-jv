public class RandomSurfer {
    public static void main(String[] args){
        Object[] linkages  = count_links();
        double random_jump_prob = 0.1; // 90% of time follow links else, randomly jump
        double[][] transition_matrix = get_transition_matrix(linkages,random_jump_prob);
        MatrixOps.print_matrix(transition_matrix);
        double[][] cumulative_tm = MatrixOps.cumulative_rows(transition_matrix);

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
