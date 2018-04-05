public class ConvaysGameofLife {
    public static void main(String[] args){
        boolean[][] gamescene = new boolean[50+2][50+2];// we add
        set_initial_state(gamescene);
        //MatrixOps.print_matrix(gamescene);
        play_game(gamescene);
    }
    public static void play_game(boolean[][] gamescene){
        boolean updated = true;
        displayMatrix(gamescene);
        //while(true){
        while(updated){
            updated = update_matrix(gamescene);
            StdDraw.pause(100);
            displayMatrix(gamescene);
        }
        StdOut.println("Stopped Updating");
    }
    public static boolean update_matrix(boolean[][]gamescene){
        //StdOut.printf("called\n");
        boolean[][]gamescenecopy = MatrixOps.copy_square_matrix(gamescene);
        boolean updated = false;
        for (int i = 1; i < gamescene.length-1; i++) {
            for (int j = 1; j < gamescene[0].length-1; j++) {
                int liveneighbours = get_live_neighbours(gamescenecopy, i, j);
                if(!gamescene[i][j] &&(liveneighbours==3)){
                    //StdOut.printf("inside\n");
                    //StdOut.printf("i = %d, j = %d and current state is %b with  number of live neighbours %d\n",i,j,gamescene[i][j],liveneighbours);
                    gamescene[i][j]=true;
                    updated=true;
                } else if(gamescene[i][j] &&((liveneighbours==1)||(liveneighbours>3))){
                    gamescene[i][j]=false;
                    updated=true;
                }
            }
        }
        return updated;
    }
    private static int get_live_neighbours(boolean[][] gamescene, int i, int j){
        //if(i ==3 && j ==3) MatrixOps.print_matrix(gamescene);
        int liveneighbours = (gamescene[i-1][j-1]?1:0)+(gamescene[i-1][j]?1:0)+(gamescene[i-1][j+1]?1:0)+
                (gamescene[i][j-1]?1:0)+(gamescene[i][j+1]?1:0)+
                (gamescene[i+1][j-1]?1:0)+(gamescene[i+1][j]?1:0)+(gamescene[i+1][j+1]?1:0);
        return liveneighbours;
    }
    private static void displayMatrix(boolean[][] gamescene){
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        MatrixOps.visualize_boolean_matrix(gamescene,true,true);
        return;
    }
    private static void set_initial_state1(boolean[][] gamescene){
        // we add one as the edges are in the first,last column and first,last row.
        // But it doesn't really matter
        gamescene[1+1][2+1]=true;
        gamescene[2+1][3+1]=true;
        gamescene[3+1][1+1]=true;
        gamescene[3+1][2+1]=true;
        gamescene[3+1][3+1]=true;
        return;
    }
    // add some more states

}
