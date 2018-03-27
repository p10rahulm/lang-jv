public class PlotFunction {
    public static void main(String[] args){
        double x_min = 0;
        double x_max = 10* Math.PI;
        plotsinex(x_min,x_max);


    }
    public static void plotsinex(double x_min,double x_max){
        double[]x = new double[500];
        double[]y = new double[500];
        double y_min = Double.POSITIVE_INFINITY,y_max=Double.NEGATIVE_INFINITY;
        for(int i = 0; i <500; i++){
            x[i] = x_min + (x_max-x_min)/49*i;
            y[i] = Math.sin(x[i]);
            if(y[i]<y_min){y_min = y[i];}
            if(y[i]>y_max){y_max = y[i];}
        }
        StdDraw.setXscale(x_min,x_max);
        StdDraw.setYscale(y_min,y_max);
        StdDraw.setPenRadius(0.02);
        for(int i = 0;i<50;i++){StdDraw.point(x[i],y[i]);}
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        for(int i = 1;i<50;i++){StdDraw.line(x[i-1],y[i-1],x[i],y[i]);}


    }
}
