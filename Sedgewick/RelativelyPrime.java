public class RelativelyPrime {
    public static void main(String[] args){
        int input1 = Integer.parseInt(args[0]);
        int input2 = Integer.parseInt(args[1]);
        String relatively_prime ="";
        if(GCD_Euclid.gcd_iter(input1,input2) != 1)relatively_prime="not ";
        System.out.println(input1 + " and "+ input2+" are relatively " + relatively_prime + "prime");
    }
}
