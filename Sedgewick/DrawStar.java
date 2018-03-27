// was asked to me in some stupid interview at GlobalShiksha!
public class DrawStar {
    public static void main(String[] args){
        double upward_triangle_lowline_y = 1-Math.tan(Math.PI/3)*0.5;
        double downward_triangle_upline_y = Math.tan(Math.PI/3)*0.5;
        StdDraw.line(0,upward_triangle_lowline_y,1,upward_triangle_lowline_y);
        StdDraw.line(0,upward_triangle_lowline_y,0.5,1);
        StdDraw.line(0.5,1,1,upward_triangle_lowline_y);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(1,upward_triangle_lowline_y,0.25,(1+upward_triangle_lowline_y)/2);
        StdDraw.line(0,((1+upward_triangle_lowline_y)/2-upward_triangle_lowline_y)*4/3 + upward_triangle_lowline_y,0.25,(1+upward_triangle_lowline_y)/2);
        downward_triangle_upline_y = ((1+upward_triangle_lowline_y)/2-upward_triangle_lowline_y)*4/3 + upward_triangle_lowline_y;
        StdDraw.setPenRadius(0.01);
        StdDraw.line(0,downward_triangle_upline_y,1,downward_triangle_upline_y);
        StdDraw.line(0,downward_triangle_upline_y,0.5,0);
        StdDraw.line(0.5,0,1,downward_triangle_upline_y);




    }
}
