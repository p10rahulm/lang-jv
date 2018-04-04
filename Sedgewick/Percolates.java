public class Percolates {
    public static void main(String[] args){
        boolean[][] open = MatrixOps.readBoolean2D();
        VectorOps.printvector(flow(open));
        System.out.println(percolates(open));

    }
    public static boolean percolates(boolean[][] open){
        boolean[][] full = flow(open);
        for(int j =0;j<full[0])

    }
    public static boolean[][] flow(boolean[][] open_sites){
        int n = open_sites.length;
        boolean[][] filled = new boolean[n][n];
        /*
        implement something here

         */

        return filled;
    }
}
