public class RelativelyPrime {
    public static void main(String[] args){
        checkrelatively_prime(5,9);checkrelatively_prime(7,700);
        int check_till = Integer.parseInt(args[0]);
        boolean[][] rpm = relativelyprime_matrix(check_till);
        MatrixOps.print_boolean_matrix(rpm);
    }
    public static void checkrelatively_prime(int input1,int input2){
        String relatively_prime ="";
        if(GCD_Euclid.gcd_iter(input1,input2) != 1)relatively_prime="not ";
        System.out.println(input1 + " and "+ input2+" are relatively " + relatively_prime + "prime");
    }
    public static boolean relatively_prime(int input1,int input2){
        boolean relatively_prime =true;
        if(GCD_Euclid.gcd_iter(input1,input2) != 1)relatively_prime=false;
        return relatively_prime;
    }
    public static boolean relatively_prime(long input1,long input2){
        boolean relatively_prime =true;
        if(GCD_Euclid.gcd_iter(input1,input2) != 1)relatively_prime=false;
        return relatively_prime;
    }
    public static boolean[][] relativelyprime_matrix(int highest_num){
        boolean[][] out = new boolean[highest_num][highest_num];
        for(int i =1;i<highest_num;i++){
            for(int j = i; j< highest_num; j ++){
                if(GCD_Euclid.gcd_iter(i+1,j+1) == 1){
                    out[i][j] = true;
                    out[j][i] = true;
                }
            }
        }
        return out;

    }

}
