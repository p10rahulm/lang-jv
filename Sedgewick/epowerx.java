public class epowerx {
    public static double epowerx(double x){
        double sum=1,currentsum=x;

        for(int i = 2;sum!=sum+currentsum;i++){
            sum +=currentsum;
            currentsum*=x/i;
        }
        return(sum);
    }
    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);
        System.out.println(epowerx(x));
        long start = System.currentTimeMillis();
        for(int i =0;i<100000;i++){epowerx(i/1000);}
        System.out.println("Time taken for 100000 loops with epowerx = " + (System.currentTimeMillis()-start));
        start = System.currentTimeMillis();
        for(int i =0;i<100000;i++){Math.exp(i/1000);}
        System.out.println("Time taken for 100000 loops with Math.exp = " + (System.currentTimeMillis()-start));



    }
}
