// java HammingDistance 4 2 0
// numbers represented by binary 4 digits, which are at hamming distance 2 from 0.

public class HammingDistance {
    public static void main(String[] args){
        int numdigits = Integer.parseInt(args[0]);
        int numchanged = Integer.parseInt(args[1]);
        int input_num = Integer.parseInt(args[2]);
        // num changed should be less than num digits
        if(numchanged>=numdigits){throw new ArithmeticException("yoyoma, don't ch more than you can chu");}
        for (int i = 0; i < MMath.twopower(numdigits); i++) {
            if(MMath.hamming_distance(input_num,i)==numchanged){
                StdOut.println("Hamming distance to " + input_num+" for "+ i +" is " + numchanged);
            }
        }
    }


}
