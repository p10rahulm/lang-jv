public class EPowerx {

    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);
        System.out.println(MMath.epowerx(x));
        long start = System.currentTimeMillis();
        for(int i =0;i<100000;i++){MMath.epowerx(i/1000);}
        System.out.println("Time taken for 100000 loops with epowerx = " + (System.currentTimeMillis()-start));
        start = System.currentTimeMillis();
        for(int i =0;i<100000;i++){Math.exp(i/1000);}
        System.out.println("Time taken for 100000 loops with Math.exp = " + (System.currentTimeMillis()-start));



    }
}
