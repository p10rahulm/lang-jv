public class Sqrt {
    public static void main(String[] args){
        double input = Double.parseDouble(args[0]);
        double error = 1e-15;
        double guess = input;
        while(Math.abs(guess - input/guess)>error*guess){
            guess = (input/guess + guess)/2;
        }
        System.out.println(guess);
    }
}
