public class LargestNumFactored_in_nmilliseconds {
    /*
    A run at 5 milliseconds takes me to the 38th power of 2; ie i can factor 2^38-1;
    31milliseconds are taken for the first iteration which is ignored
    > java LargestNumFactored_in_nmilliseconds 15
    */
    private static String factors(Long input){
        long n = input;
        int i = 2;
        StringBuilder s = new StringBuilder();
        while(i<=n/i){
            if(n%i==0) {
                n=n/i;
                s.append(i).append(", ");
            }
            //else {i+=1;System.out.println("i = "+i + ", n = "+n);}
            else i+=1;
        }
        s.append(n);
        return s.toString();
    }

    public static void main(String[] args) {
        double allowed_seconds = Double.parseDouble(args[0]);
        String fact;
        int twopow = 1;
        long currentnum = 1;
        long lasttime = 0, start;
        while ((currentnum == 1 || lasttime < allowed_seconds) && currentnum <Long.MAX_VALUE) {
            start = System.currentTimeMillis();
            currentnum = (long) (Math.pow(2,twopow) - 1);
            fact = factors(currentnum);
            lasttime = System.currentTimeMillis() - start;
            System.out.println("currentnum = " + currentnum + ", lasttime = " + lasttime + ", twopow = " + twopow + ", fact = " + fact);
            twopow +=1;

        }
    }
}
