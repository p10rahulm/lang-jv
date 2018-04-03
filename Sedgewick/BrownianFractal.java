//java BrownianFractal 0.8
public class BrownianFractal {
    public static void main(String[] args){
        //double H = Double.parseDouble(args[0]); // if we want to take input from user
        // Hurst exponents close to 1 look like mountains, lower than 0.5 look like stock prices!
        // This is the continuous fractal version of the random walk problem
        for (double H:new double[]{-0.05,0.05,0.1,0.25,0.5,1,2,4}) {
            StdDraw.clear();
            double s = Math.pow(2,2*H);
            curve(0,0.5,1.0,0.5,0.01,s);
            StdDraw.save("BrownianFractals/bf_"+H+".png");
        }

    }
    public static void curve(double x0,double y0,double x1,double y1, double var, double s){
        if((x1-x0)<0.01){
            StdDraw.line(x0,y0,x1,y1);
            return;
        }
        double xm = (x1+x0)/2;
        double ym = (y1+y0)/2;
        //delta is the variation. This is defined by the Hurst parameter
        double delta = Random.gaussian(0,Math.sqrt(var));
        curve(x0,y0,xm,ym+delta,var/s,s);
        curve(xm,ym+delta,x1,y1,var/s,s);
    }

}
