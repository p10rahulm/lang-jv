public class EulersTotientFunction {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        int totient_counter = totient_function(num);
        System.out.println(totient_counter);
    }

    public static int totient_function(int num){
        int totient_counter=0;
        for(int i =1;i<num;i++){
            if(RelativelyPrime.relatively_prime(num,i)){totient_counter+=1;};
        }
        return(totient_counter);
    }
    public static long totient_function(long num){
        long totient_counter=0;
        for(long i =1;i<num;i++){
            if(RelativelyPrime.relatively_prime(num,i)){totient_counter+=1;};
        }
        return(totient_counter);
    }
}
