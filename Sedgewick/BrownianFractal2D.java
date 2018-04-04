// aim is to get a drawing of an island :/ unsuccessful so far
public class BrownianFractal2D {
    public static void main(String[] args){
        //double H = Double.parseDouble(args[0]); // if we want to take input from user
        // Hurst exponents close to 1 look like mountains, lower than 0.5 look like stock prices!
        // This is the continuous fractal version of the random walk problem
        //for (double H:new double[]{0.05,0.1,0.25,0.5,0.75,1,2,4}) {

        for (int i = 0;i<10;i++) {
            for (double H:new double[]{0.75,1}) {
                StdDraw.clear();
                double s = Math.pow(2,2*H);
                curve(0.5,0.5,0.5,0.5,0.16,s,10);
                //StdOut.println("printed");
                StdDraw.save("BrownianFractals/bf2D_attempt_"+i+"_"+H+".png");
            }
        }
    }
    public static void curve(double x0,double y0,double x1,double y1, double var, double s,int n ){
        if((Math.abs(x1-x0)<0.01||Math.abs(y1-y0)<0.01)&&n<0){
            StdDraw.line(x0,y0,x1,y1);
            return;
        }
        double xm = (x1+x0)/2;
        double ym = (y1+y0)/2;
        //delta is the variation. This is defined by the Hurst parameter
        double delta_x = Random.gaussian(0,Math.sqrt(var));
        double delta_y = Random.gaussian(0,Math.sqrt(var));
        curve(x0,y0,xm+delta_x,ym+delta_y,var/s,s,n-1);
        curve(xm+delta_x,ym+delta_y,x1,y1,var/s,s,n-1);
    }
}
