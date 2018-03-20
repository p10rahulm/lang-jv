import java.util.Arrays;

public class PrimeCounter {
    public static boolean isPrime(int num){
        int a =2;
        int check_upto = (int) Math.pow(num,0.5);
        while(a<=check_upto){
            if(num%a==0)return false;
            a++;
        }
        return true;
    }
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        int max_num = Integer.parseInt(args[0]);
        int check_upto = (int) Math.pow(max_num,0.5);
        boolean[] primes = new boolean[max_num];
        Arrays.fill(primes, Boolean.TRUE);
        primes[0] = false;
        boolean isprime;
        for(int i=2;i<=check_upto;i++){
            //System.out.println("i = "+i+", primes[i-1] = "+primes[i-1]);
            if(primes[i-1]) {
                isprime = isPrime(i);
                //System.out.print("i = " + i + ", isprime = " + isprime);
                if (isprime) {
                    for (int j = 2; j * i <= max_num; j++) {
                        //System.out.println("i = " + i + ", i*j= " + (i * j));
                        primes[(j * i) - 1] = false;
                    }
                } else {
                    primes[i - 1] = false;
                }
                //for (i = 0; i < primes.length; i++) {                    System.out.println(primes[i]);                }
            }
        }

        //for (int i = 0; i < primes.length; i++) {System.out.print(primes[i]);}
        int counter =0;
        for(int i =0;i<max_num;i++){
            if(primes[i]){counter++;}
        }
        System.out.println(counter);
        long timetaken = System.currentTimeMillis()-start;
        System.out.println("Time Taken = " + timetaken+" ms.");

    }
}
/*This is insane speed. primes uptil 10m are counted in 50 milliseconds and upto 100m are counted in 800ms*/
