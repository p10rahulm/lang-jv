public class Charge {
    private final double x0,y0,q;

    Charge(double x0, double y0, double q){
        this.x0=x0;
        this.y0=y0;
        this.q=q;
    };
    public double potentialAt(double x, double y){
        return(8.99e9*q/Math.sqrt((x-x0)*(x-x0)+(y-y0)*(y-y0)));
    }
    public String toString(){
        return "charge "+ q +" at <"+ x0 + "," + y0 + ">";
    }

}
