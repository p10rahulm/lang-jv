public class Hadamard_Matrix {
    public static void main(String[] args){
        int size = Integer.parseInt(args[0]);
        if(size == 1){System.out.println("Enter a power greater than 1");return;}
        //check power of 2
        boolean size_is_two_power = size>0&&(size&(size-1))==0;
        if(!size_is_two_power){
            System.out.println("You haven't entered a power of two for the Hadamard Matrix");
            return;
        }

        int twobase =0;
        while(Math.pow(2,twobase)<size){
            twobase++;
        }
        boolean[][] current = new boolean[][] {{true}};
        boolean[][] old;
        int current_size =1;
        for(int i = 0;i<twobase;i++){
            old = MatrixOps.copy_square_matrix(current);
            current_size*=2;
            current = new boolean[current_size][current_size];
            //make 4 copies of old into new
            for(int p=0; p<3;p++ ){
                for(int a = 0;a<old.length;a++){
                    for(int b = 0;b<old.length;b++){
                        current[a+(p/2)*old.length][b+(p%2)*old.length] = old[a][b];
                    }
                }
            }
            for(int a = 0;a<old.length;a++){
                for(int b = 0;b<old.length;b++){
                    current[a+old.length][b+old.length] = !old[a][b];
                }
            }
        }
        MatrixOps.print_matrix(current);
    }
}
