public class PlotUSACities {
    public static void main(String[] args){
        double x_min = StdIn.readDouble();
        double y_min = StdIn.readDouble();
        double x_max = StdIn.readDouble();
        double y_max = StdIn.readDouble();
        StdDraw.setXscale(x_min,x_max);
        StdDraw.setYscale(y_min,y_max);
        while(!StdIn.isEmpty()){
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            StdDraw.point(x,y);
        }
    }
}
