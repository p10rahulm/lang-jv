public class GeneratenRandom {
    public static void main(String[] args){
        int number_of_random = Integer.parseInt(args[0]);
        for(int i=0;i<number_of_random;i++){
            StdOut.println(Math.random());
        }
    }
}
