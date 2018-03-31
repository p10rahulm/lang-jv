import java.awt.*;

public class DrawTriangle {
    public static void main(String[] args){
        double top_point_y = 0.5*Math.tan(Math.PI/3);
        double mid_point_y = 0.5*Math.tan(Math.PI/6);
        DrawTriangle(0,0,1,0,0.5,top_point_y);
        /*StdDraw.line(0,0,1,0);
        StdDraw.line(1,0,0.5,top_point_y);
        StdDraw.line(0,0,0.5,top_point_y);*/
        StdDraw.setPenRadius(0.025);
        StdDraw.point(0.5,mid_point_y);

    }
    public static void DrawTriangle(double x0,double y0,double x1,double y1,double x2, double y2,Color MyColor,double penRadius ){
        StdDraw.setPenRadius(penRadius);
        StdDraw.setPenColor(MyColor);
        StdDraw.line(x0,y0,x1,y1);
        StdDraw.line(x0,y0,x2,y2);
        StdDraw.line(x1,y1,x2,y2);
    }
    public static void DrawTriangle(double x0,double y0,double x1,double y1,double x2, double y2,double penRadius ){
        StdDraw.setPenRadius(penRadius);
        StdDraw.line(x0,y0,x1,y1);
        StdDraw.line(x0,y0,x2,y2);
        StdDraw.line(x1,y1,x2,y2);
    }
    public static void DrawTriangle(double x0,double y0,double x1,double y1,double x2, double y2,Color MyColor ){
        StdDraw.setPenColor(MyColor);
        StdDraw.line(x0,y0,x1,y1);
        StdDraw.line(x0,y0,x2,y2);
        StdDraw.line(x1,y1,x2,y2);
    }
    public static void DrawTriangle(double x0,double y0,double x1,double y1,double x2, double y2){
        StdDraw.line(x0,y0,x1,y1);
        StdDraw.line(x0,y0,x2,y2);
        StdDraw.line(x1,y1,x2,y2);
    }
}
