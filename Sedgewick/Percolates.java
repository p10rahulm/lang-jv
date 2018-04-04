//java Percolates 10 0.6
public class Percolates {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        boolean[][] opensites = MatrixOps.generate_random_matrix(n,n,p);
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        MatrixOps.visualize_square_boolean_matrix(opensites,false);

        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        boolean[][] full = Percolates.flow(opensites);
        MatrixOps.visualize_square_boolean_matrix(full,true);
        StdDraw.show(1000);

    }
    public static boolean percolates(boolean[][] open){
        boolean[][] full = flow(open);
        for(int j =0;j<full[0].length;j++){
            if(full[full.length-1][j]){
                return true;
            }
        }
        return false;
    }
    public static boolean percolates_vp(boolean[][] open){
        boolean[][] full = flow_vp(open);
        for(int j =0;j<full[0].length;j++){
            if(full[full.length-1][j]){
                return true;
            }
        }
        return false;
    }
    public static boolean[][] flow_vp(boolean[][] open_sites){ //considering simple case of vertical percolation
        int n = open_sites.length;
        boolean[][] filled = new boolean[n][n];
        for(int j =0;j<n;j++){
            filled[0][j] = open_sites[0][j];
        }
        for (int i =1;i<n;i++) {
            for(int j =0;j<n;j++){
                filled[i][j] = open_sites[i][j]&&filled[i-1][j];
            }
        }
        return filled;
    }

    public static boolean[][] flow(boolean[][] open_sites){
        int n = open_sites.length;
        boolean[][] filled = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            //assume 0 is top row
            flow_from(0,i,open_sites,filled);
        }

        return filled;
    }
    public static void flow_from(int row,int column,boolean[][] open_sites,boolean[][] filled_sofar){
        int n = filled_sofar.length;
        if(row>=n||row<0||column<0||column>=n)return;
        if(filled_sofar[row][column])return;
        if(!open_sites[row][column])return;
        filled_sofar[row][column]=true;
        flow_from(row-1,column,open_sites,filled_sofar);
        flow_from(row+1,column,open_sites,filled_sofar);
        flow_from(row,column-1,open_sites,filled_sofar);
        flow_from(row,column+1,open_sites,filled_sofar);

    }


}
