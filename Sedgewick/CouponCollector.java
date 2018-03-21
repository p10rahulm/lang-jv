public class CouponCollector {
    public static void main(String[] args){
        int numvals =Integer.parseInt(args[0]);
        boolean[] foundarray = new boolean[numvals];
        int foundcount = 0,attempts =0;
        while(foundcount!=numvals){
            int newval = (int) (Math.random()*numvals);
            if(!foundarray[newval]){
                foundarray[newval] = true;
                foundcount++;
            }
            attempts++;
        }
        System.out.println(attempts);
    }
}
