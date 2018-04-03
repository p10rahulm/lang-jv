public class Minesweeper {
    public static void main(String[] args){
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        boolean[][] large_mine = new boolean[m+2][n+2];
        for(int i =1;i<m+1;i++){
            for(int j = 1;j<n+1;j++){
                if(Math.random()<=p)large_mine[i][j]=true;
            }
        }
        MatrixOps.print_matrix(large_mine);
        print_mineweeper(large_mine);

    }

    public static void print_mineweeper(boolean[][] a){
        System.out.print("   ");
        for(int i =0;i<a[1].length;i++){
            if(i/100==0)System.out.print(" ");
            System.out.print(i+1);
            if(i/10==0)System.out.print(" ");
        }
        System.out.println();
        for(int i =0;i<a.length;i++){
            if(i/100==0)System.out.print(" ");
            System.out.print(i+1);
            if(i/10==0)System.out.print(" ");
            for(int j=0;j<a[i].length;j++){
                if(a[i][j])System.out.print(" * ");
                else if(i==0||j==0||i==(a.length-1)||j==(a[0].length-1)) System.out.print("   ");
                else {
                    int num_adj =0;
                    if(a[i-1][j])num_adj++;
                    if(a[i+1][j])num_adj++;
                    if(a[i][j-1])num_adj++;
                    if(a[i][j+1])num_adj++;
                    if(a[i-1][j-1])num_adj++;
                    if(a[i-1][j+1])num_adj++;
                    if(a[i+1][j-1])num_adj++;
                    if(a[i+1][j+1])num_adj++;
                    System.out.print(" " + num_adj+"  ");
                }
            }
            System.out.println();
        }
    }

}
