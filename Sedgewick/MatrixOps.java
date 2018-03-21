public class MatrixOps {

    public static void main(String[] args){
        boolean[][] a = new boolean[10][15];
        for(int i =0;i<10*15;i++){
            if(i%2==0){a[i/15][i%15]=true;}
        }
        print_boolean_matrix(a);
    }
    public static void print_boolean_matrix(boolean[][] a){
        System.out.print("   ");
        for(int i =0;i<a[1].length;i++){
            if(i/100==0)System.out.print(" ");
            System.out.print(i);
            if(i/10==0)System.out.print(" ");
        }
        System.out.println();
        for(int i =0;i<a.length;i++){
            if(i/100==0)System.out.print(" ");
            System.out.print(i);
            if(i/10==0)System.out.print(" ");
            for(int j=0;j<a[i].length;j++){
                if(a[i][j])System.out.print(" * ");
                else System.out.print("   ");
            }
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
}
