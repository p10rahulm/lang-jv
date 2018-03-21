import java.util.Arrays;

public class MatrixOps {

    public static void main(String[] args){
        boolean[][] a = new boolean[10][15];
        for(int i =0;i<10*15;i++){
            if(i%2==0){a[i/15][i%15]=true;}
        }
        print_boolean_matrix(a);
        //check ragged copy
        int[][] b = new int[][]{{1,2,3},{4,5,6,7},{11,12}};
        print_matrix(b);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.deepToString(b));
    }
    public static int[][] cross_product(int[][] a,int[][] b){
        int x1 = a.length;
        int x2 = a[0].length;
        int y1 = b.length;
        int y2 = b[0].length;
        if(x2!=y1){
            System.out.println("Wrong Matrix dimensions to multiple");
            return(new int[][]{{}});
        }
        int[][] out = new int[x1][y2];
        for(int i = 0;i<x1;i++){
            for(int j = 0;j<y2;j++){
                int sum = 0;
                for(int k=0;k<x2;k++){
                    sum+=a[i][k]*b[k][j];
                }
                out[i][j] = sum;
            }
        }
        return out;
    }
    public static double[][] cross_product(double[][] a,double[][] b){
        int x1 = a.length;
        int x2 = a[0].length;
        int y1 = b.length;
        int y2 = b[0].length;
        if(x2!=y1){
            System.out.println("Wrong Matrix dimensions to multiple");
            return(new double[][]{{}});
        }
        double[][] out = new double[x1][y2];
        for(int i = 0;i<x1;i++){
            for(int j = 0;j<y2;j++){
                double sum = 0;
                for(int k=0;k<x2;k++){
                    sum+=a[i][k]*b[k][j];
                }
                out[i][j] = sum;
            }
        }
        return out;
    }
    public static boolean[][] cross_product(boolean[][] a,boolean[][] b){
        int x1 = a.length;
        int x2 = a[0].length;
        int y1 = b.length;
        int y2 = b[0].length;
        if(x2!=y1){
            System.out.println("Wrong Matrix dimensions to multiple");
            return(new boolean[][] {{}});
        }
        boolean[][] out = new boolean[x1][y2];
        for(int i = 0;i<x1;i++){
            for(int j = 0;j<y2;j++){
                boolean sum = false;
                boolean now;
                for(int k=0;k<x2;k++){
                    now =a[i][k]&&b[k][j];
                    sum = sum || now;
                }
                out[i][j] = sum;
            }
        }
        return out;
    }


    public static void print_boolean_matrix(boolean[][] a){
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
                else System.out.print("   ");
            }
            System.out.println();
        }
    }
    public static void print_matrix(int[][] a){
        for(int i =0;i<a.length;i++){
            if(i/100==0)System.out.print(" ");
            System.out.print(i+":");
            if(i/10==0)System.out.print(" ");
            for(int j=0;j<a[i].length;j++){System.out.print("\t"+a[i][j]);}
            System.out.println();
        }
    }
    public static void print_matrix(String[][] a){
        for(int i =0;i<a.length;i++){
            if(i/100==0)System.out.print(" ");
            System.out.print(i+":");
            if(i/10==0)System.out.print(" ");
            for(int j=0;j<a[i].length;j++){System.out.print("\t"+a[i][j]);}
            System.out.println();
        }
    }
    public static void print_string_matrix(String[][] a){
        for(int i =0;i<a.length;i++){
            if(i/100==0)System.out.print(" ");
            System.out.print(i+":");
            if(i/10==0)System.out.print(" ");
            for(int j=0;j<a[i].length;j++){System.out.print("\t"+a[i][j]);}
            System.out.println();
        }
    }
    public static int[][] copy_square_matrix(int[][] a){
        int n = a.length;
        int[][] out = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                out[i][j]=a[i][j];
            }
        }
        return out;
    }
    public static int[][] copy_rectangular_matrix(int[][] a){
        int x = a.length;
        int y = a[1].length;
        int[][] out = new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                out[i][j]=a[i][j];
            }
        }
        return out;
    }
    public static int[][] copy_ragged_matrix(int[][] a){
        int x = a.length;
        int[][] out = new int[x][];
        for(int i=0;i<x;i++){
            int y = a[i].length;
            out[i] = new int[y];
            for(int j=0;j<y;j++){
                out[i][j]=a[i][j];
            }
        }
        return out;
    }
    public static int[][] transpose_inplace(int[][] a){
        int x = a.length;
        int y = a[0].length;
        int temp;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                temp = a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
        return a;
    }
    public static double[][] transpose(double[][] a){
        int x = a.length;
        int y = a[0].length;
        double[][] out = new double[y][x];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                out[i][j]=a[j][i];
            }
        }
        return out;
    }
    public static int[][] transpose(int[][] a){
        int x = a.length;
        int y = a[0].length;
        int[][] out = new int[y][x];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                out[i][j]=a[j][i];
            }
        }
        return out;
    }
}
