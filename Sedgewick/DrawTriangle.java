public class DrawTriangle {
    public static void main(String[] args){
        double top_point_y = 0.5*Math.tan(Math.PI/3);
        double mid_point_y = 0.5*Math.tan(Math.PI/6);
        StdDraw.line(0,0,1,0);
        StdDraw.line(1,0,0.5,top_point_y);
        StdDraw.line(0,0,0.5,top_point_y);
        StdDraw.setPenRadius(0.025);
        StdDraw.point(0.5,mid_point_y);

    }
}
