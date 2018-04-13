public class Charge {
    private final double x0,y0,q;

    Charge(double x0, double y0, double q){
        this.x0=x0;
        this.y0=y0;
        this.q=q;
    }
    public double potentialAt(double x, double y){
        return(8.99e9*q/Math.sqrt((x-x0)*(x-x0)+(y-y0)*(y-y0)));
    }
    public String toString(){
        return "charge "+ q +" at <"+ x0 + "," + y0 + ">";
    }
    public static void main(String[] args){
        Charge c1 = new Charge(0.5,0.8,1);
        Charge c2 = new Charge(0.55,0.75,0.7);
        double v1 = c1.potentialAt(0.5,0.5);
        double v2 = c2.potentialAt(0.5,0.5);
        StdOut.printf("The potential at (0.5,0.5) due to charge 1 is %.2f and due to charge 2 is%.2f",v1,v2);
    }
}
