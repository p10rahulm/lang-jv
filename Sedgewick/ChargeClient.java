public class ChargeClient {
    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        Charge c1 = new Charge(Math.random(),Math.random(),Math.random());
        Charge c2 = new Charge(Math.random(),Math.random(),Math.random());
        double v1 = c1.potentialAt(x,y);
        double v2 = c2.potentialAt(x,y);
        StdOut.printf("v1 = %f, v2 = %f",v1,v2);
    }
}
