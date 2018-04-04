public class PercolatesTester1 {
    public static void main(String[] args){
        visualize(20,0.95,1);
        visualize(20,0.85,1);
    }
    public static void visualize(int size,double probability_of_open,int trials){
        for (int i = 0; i < trials; i++) {
            boolean[][] open = MatrixOps.generate_random_matrix(size,size,probability_of_open);
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            MatrixOps.visualize_square_boolean_matrix(open,false);
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            boolean[][] full = Percolates.flow_vp(open);
            MatrixOps.visualize_square_boolean_matrix(full,true);
            StdDraw.show(1000);
        }
    }
}
