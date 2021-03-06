import java.sql.Array;
import java.util.Arrays;

public class MatrixOps {

    public static void main(String[] args){
        boolean[][] a = new boolean[10][15];
        for(int i =0;i<10*15;i++){
            if(i%2==0){a[i/15][i%15]=true;}
        }
        print_matrix(a);
        //check ragged copy
        int[][] b = new int[][]{{1,2,3},{4,5,6,7},{11,12}};
        print_matrix(b);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.deepToString(b));
    }
    public static double[][] scale_to_x(double[][] input,double x){
        double[][] output = new double[input.length][input[0].length];
        double max=Double.NEGATIVE_INFINITY,min=Double.POSITIVE_INFINITY;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                double v = input[i][j];
                if(v>max&&v!=Double.POSITIVE_INFINITY)max=v;
                if(v<min&&v!=Double.NEGATIVE_INFINITY)min=v;
            }
        }
        //StdOut.printf("max =%f, min = %f\n",max,min);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                output[i][j] = (input[i][j]-min)*x/(max-min);
            }
        }
        return output;
    }
    public static double[][] scale_to_x(int[][] input,double x){
        double[][] output = new double[input.length][input[0].length];
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                int v = input[i][j];
                if(v>max)max=v;
                if(v<min)min=v;
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                output[i][j] = (double)(input[i][j]-min)*x/(max-min);
            }
        }
        return output;
    }

    public static double[][] normalize(double[][] input){
        double[][] output = new double[input.length][input[0].length];
        double max=Double.NEGATIVE_INFINITY,min=Double.POSITIVE_INFINITY;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                double v = input[i][j];
                if(v>max)max=v;
                if(v<min)min=v;
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                output[i][j] = (double)(input[i][j]-min)/(max-min);
            }
        }
        return output;
    }

    public static double[][] normalize(int[][] input){
        double[][] output = new double[input.length][input[0].length];
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                int v = input[i][j];
                if(v>max)max=v;
                if(v<min)min=v;
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                output[i][j] = (double)(input[i][j]-min)/(max-min);
            }
        }
        return output;
    }

    public static boolean[][] generate_random_matrix(int numrows, int numcols, double prob_of_true){
        boolean[][] output = new boolean[numrows][numcols];
        for (int i = 0; i < numrows; i++) {
            for (int j = 0; j < numcols; j++) {
                output[i][j] = Random.bernoulli(prob_of_true);
            }
        }
        return output;
    }
    public static void visualize_square_boolean_matrix(boolean[][] input, boolean true_or_false){
        StdDraw.setYscale(-1,input.length);
        StdDraw.setXscale(-1,input[0].length);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if(input[i][j]==true_or_false){
                    StdDraw.filledSquare(j,input.length-1-i,0.5);
                } else {
                    StdDraw.square(j,input.length-1-i,0.5);
                }
            }
        }
    }
    public static void visualize_boolean_matrix(boolean[][] input, boolean true_or_false){
        StdDraw.setYscale(-1,input.length);
        StdDraw.setXscale(-1,input[0].length);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if(input[i][j]==true_or_false){
                    StdDraw.filledSquare(j,input.length-1-i,0.5);
                } else {
                    StdDraw.square(j,input.length-1-i,0.5);
                }
            }
        }
    }
    public static void visualize_boolean_matrix(boolean[][] input, boolean true_or_false,boolean no_square){
        StdDraw.setYscale(-1,input.length);
        StdDraw.setXscale(-1,input[0].length);
        if(no_square){
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    if (input[i][j] == true_or_false) {
                        StdDraw.filledSquare(j, input.length - 1 - i, 0.5);
                    }
                }
            }
        } else {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    if (input[i][j] == true_or_false) {
                        StdDraw.filledSquare(j, input.length - 1 - i, 0.5);
                    } else {
                        StdDraw.square(j, input.length - 1 - i, 0.5);
                    }
                }
            }
        }
    }

    public static int[][] multiply(int[][] a, int[][] b){
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
    public static double[][] multiply(double[][] a, double[][] b){
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
    public static boolean[][] multiply(boolean[][] a, boolean[][] b){
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
    public static int[] multiply(int[][] a, int[] b){
        if(a[0].length!=b.length){
            System.out.println("Wrong Matrix dimensions to multiple");
            return new int[]{};
        }
        int[] out = new int[a.length];
        for(int i = 0;i<a.length;i++){
            int sum = 0;
            for(int j = 0;j<a[0].length;j++){
                sum+=a[i][j]*b[j];
            }
            out[i] = sum;
        }
        return out;
    }
    public static double[] multiply(double[][] a, double[] b){
        if(a[0].length!=b.length){
            System.out.println("Wrong Matrix dimensions to multiple");
            return new double[]{};
        }
        double[] out = new double[a.length];
        for(int i = 0;i<a.length;i++){
            double sum = 0;
            for(int j = 0;j<a[0].length;j++){
                sum+=a[i][j]*b[j];
            }
            out[i] = sum;
        }
        return out;
    }
    public static int[] multiply(int[] a, int[][] b){
        if(a.length!=b.length){
            System.out.println("Wrong Matrix dimensions to multiple");
            return new int[]{};
        }
        int[] out = new int[b[0].length];
        for(int i = 0;i<b[0].length;i++){
            int sum = 0;
            for(int j = 0;j<a.length;j++){
                sum+=a[j]*b[j][i];
            }
            out[i] = sum;
        }
        return out;
    }
    public static double[] multiply(double[] a, double[][] b){
        if(a.length!=b.length){
            System.out.println("Wrong Matrix dimensions to multiple");
            return new double[]{};
        }
        double[] out = new double[b[0].length];
        for(int i = 0;i<b[0].length;i++){
            double sum = 0;
            for(int j = 0;j<a.length;j++){
                sum+=a[j]*b[j][i];
            }
            out[i] = sum;
        }
        return out;
    }


    public static void print_matrix(boolean[][] a){
        StdOut.printf("%3s","");
        for(int i =0;i<a[1].length;i++){
            StdOut.printf("%5d",i+1);
        }
        System.out.println();
        for(int i =0;i<a.length;i++){
            StdOut.printf("%3d",i+1);
            for(int j=0;j<a[i].length;j++){
                if(a[i][j])StdOut.printf("%5s","*");
                else StdOut.printf("%5s"," ");;
            }
            System.out.println();
        }
    }
    public static void print_matrix(int[][] a){
        for(int i =0;i<a.length;i++){
            StdOut.printf("%4d:",i);
            for(int j=0;j<a[i].length;j++){System.out.print("\t"+a[i][j]);}
            System.out.println();
        }
    }
    public static void print_matrix(double[][] a){
        for(int i =0;i<a.length;i++){
            StdOut.printf("%4d:",i);
            for(int j=0;j<a[i].length;j++){System.out.print("\t"+a[i][j]);}
            System.out.println();
        }
    }
    public static void print_matrix(String[][] a){
        for(int i =0;i<a.length;i++){
            StdOut.printf("%4d:",i);
            for(int j=0;j<a[i].length;j++){System.out.print("\t"+a[i][j]);}
            System.out.println();
        }
    }
    public static void print_string_matrix(String[][] a){
        for(int i =0;i<a.length;i++){
            StdOut.printf("%4d:",i);
            for(int j=0;j<a[i].length;j++){System.out.print("\t"+a[i][j]);}
            System.out.println();
        }
    }
    public static boolean[][] copy_square_matrix(boolean[][] a){
        int n = a.length;
        boolean[][] out = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                out[i][j]=a[i][j];
            }
        }
        return out;
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
    public static double[][] copy_square_matrix(double[][] a){
        int n = a.length;
        double[][] out = new double[n][n];
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
    public static double[][] cumulative_rows(double[][] input){
        double[][] output = copy_square_matrix(input);
        for(int i = 0;i<output.length;i++){
            for(int j = 1;j<output.length;j++){
                output[i][j] = output[i][j]+output[i][j-1];
            }
        }
        return output;
    }
    public static double[][] square_matrix(double[][] input){
        int size= input.length;
        double[][] output=new double[size][size];
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                double sum = 0;
                for(int k=0;k<size;k++){
                    sum += input[i][k]*input[k][j];
                }
                output[i][j] += sum;
            }
        }
        return output;
    }
    public static double[][] readDouble2D(){
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        double[][] out = new double[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                out[i][j] = StdIn.readDouble();
            }
        }
        return(out);
    }
    public static int[][] readInt2D(){
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        int[][] out = new int[m][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                out[m][n] = StdIn.readInt();
            }
        }
        return(out);
    }
    public static boolean[][] readBoolean2D(){
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        boolean[][] out = new boolean[m][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                out[m][n] = StdIn.readBoolean();
            }
        }
        return(out);
    }



}
