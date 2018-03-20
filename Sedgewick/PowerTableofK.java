public class PowerTableofK {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        long currentpower = k;
        int power = 1;
        while(currentpower < Long.MAX_VALUE){
            currentpower = (long) Math.pow(k,power);
            System.out.println("p = " +power+", k^p = "+currentpower);
            power +=1;
        }
    }
}
