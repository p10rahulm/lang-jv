public class Erosthenes_PrimeCounter {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        int wheretill = Integer.parseInt(args[0]);
        boolean[] isprime = new boolean[wheretill];
        for(int i=1;i<wheretill;i++){isprime[i]=true;}
        for(int num=1;num<=wheretill/num;num++){
            if(isprime[num-1]){
                for(int j=2;num*j<=wheretill;j++){

                    isprime[num*j-1] = false;
                }
            }
        }
        int primescounter=0;
        for(int i=0;i<wheretill;i++){
            if(isprime[i]){primescounter++;}
        }
        //for(int i=0;i<wheretill;i++){System.out.print(isprime[i]);}
        System.out.println(primescounter);
        long timetaken = System.currentTimeMillis()-start;
        System.out.println("Time Taken = " + timetaken+" ms.");
    }
}
