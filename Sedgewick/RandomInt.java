public class RandomInt {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        double randm = Math.random();
        int out = (int) (randm*n);
        System.out.println(out);
    }
}
