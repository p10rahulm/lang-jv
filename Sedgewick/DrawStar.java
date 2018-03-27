// was asked to me in some stupid interview at GlobalShiksha!
public class DrawStar {
    public static void main(String[] args){
        /*  Lets draw the lower line first, and then the higher line.
            We know the downward triangle is of height sqrt(3)/2 and width 1. The upward is also same.
            The difference in height of the two is the question.
            The angle bisector of any of the upper angles of the downward triangle meets at the axis points x = 0 or x = 1.
            The angle bisector meets the opposite side at (0.25,sqrt(3)/4) from (1,sqrt(3)/2). Therefore it meets x=0 at (0,sqrt(3)/2-(sqrt(3)/2-sqrt(3)/4)*1/(1-0.25))
        */
        double DT_y_up = Math.sqrt(3)/2;
        double DT_ymid = Math.sqrt(3)/4;
        double DT_ylow = 0;
        double DT_x_mid = 0.25;
        double DT_x_up = 1;
        double DT_x_low = 0;
        double intersection = DT_y_up-(DT_y_up-DT_ymid)*(DT_x_up-DT_x_low)/(DT_x_up-DT_x_mid);
        // The height of the upper triangle is sqrt(3)/2 from this intersection point. Therefore total y scale is intersection + sqrt(3)/2
        double UT_height = Math.sqrt(3)/2;
        double total_height = intersection + UT_height;
        StdDraw.setYscale(0,total_height);
        //Now let's draw the downward triangle
        StdDraw.line(0.5,0,0,DT_y_up);
        StdDraw.line(0.5,0,1,DT_y_up);
        StdDraw.line(0,DT_y_up,1,DT_y_up);
        //Now let's draw the upward triangle
        StdDraw.line(0,intersection,0.5,total_height);
        StdDraw.line(1,intersection,0.5,total_height);
        StdDraw.line(0,intersection,1,intersection);
    }
}
