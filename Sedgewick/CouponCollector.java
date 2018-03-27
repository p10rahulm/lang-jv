public class CouponCollector {
    public static void main(String[] args){
        int numvals =Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int total_attemps =0,max_attempts=0;
        for(int i =0;i<trials;i++){
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
            total_attemps+=attempts;
            if(attempts>max_attempts){max_attempts=attempts;}
        }

        System.out.println("Average Number of Coupons collected = " + ((double)total_attemps/trials));
        System.out.println("Maximum Number of Coupons collected = " + ((double)max_attempts));
    }
}
