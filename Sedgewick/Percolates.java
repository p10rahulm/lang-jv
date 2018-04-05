//java Percolates 10 0.6
public class Percolates {
    public static void main(String[] args){
        // main methods are flow which gives percolated areas given an initial open sites boolean matrix
        // and percolates which tells whether a given matrix percolates or not
        int n = 10;
        double p = 0.6;
        {
            boolean[][] opensites = MatrixOps.generate_random_matrix(n,n,p);
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            MatrixOps.visualize_square_boolean_matrix(opensites,false);

            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            boolean[][] full = flow(opensites);
            MatrixOps.visualize_square_boolean_matrix(full,true);
            StdDraw.pause(1000);
        }
        Percolates.visualize(20,0.95,1);
        {
            //rectangular
            boolean[][] opensites = MatrixOps.generate_random_matrix(n,2*n,p);
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            MatrixOps.visualize_boolean_matrix(opensites,false);
            StdDraw.pause(1000);
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            boolean[][] full = flow(opensites);
            MatrixOps.visualize_square_boolean_matrix(full,true);
            StdDraw.pause(1000);
        }

    }
    public static boolean percolates(boolean[][] open, boolean onlyvertical_percolation){
        boolean[][] full_sites;
        if(onlyvertical_percolation){
            full_sites = flow_vp(open);
        }   else {
            full_sites = flow(open);
        }
        for(int j =0;j<full_sites[0].length;j++){
            if(full_sites[full_sites.length-1][j]){
                return true;
            }
        }
        return false;
    }



    public static boolean[][] flow(boolean[][] open_sites){
        int n = open_sites.length;
        boolean[][] filled = new boolean[open_sites.length][open_sites[0].length];
        for (int column = 0; column < open_sites[0].length; column++) {
            //assume 0 is top row
            flow_from(0,column,open_sites,filled, false);
        }
        return filled;
    }
    public static boolean flow_from(int row,int column,boolean[][] open_sites,boolean[][] filled_sofar, boolean done){
        int n = filled_sofar.length;
        if(row>=n||row<0||column<0||column>=filled_sofar[0].length)return false;
        if(filled_sofar[row][column])return false;
        if(!open_sites[row][column])return false;
        filled_sofar[row][column]=true;
        if(row==(n-1)) return true;
        if(!done){done = flow_from(row+1,column,open_sites,filled_sofar,done);}
        if(!done){done = flow_from(row,column-1,open_sites,filled_sofar,done);}
        if(!done){done = flow_from(row,column+1,open_sites,filled_sofar,done);}
        if(!done){done = flow_from(row-1,column,open_sites,filled_sofar,done);}
        return done;

    }

    public static boolean[][] flow_vp(boolean[][] open_sites){ //considering simple case of vertical percolation
        int n = open_sites.length;
        boolean[][] filled = new boolean[open_sites.length][open_sites[0].length];
        for(int j =0;j<n;j++){
            filled[0][j] = open_sites[0][j];
        }
        for (int i =1;i<n;i++) {
            for(int j =0;j<open_sites[0].length;j++){
                filled[i][j] = open_sites[i][j]&&filled[i-1][j];
            }
        }
        return filled;
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
            StdDraw.pause(1000);
        }
    }


}
