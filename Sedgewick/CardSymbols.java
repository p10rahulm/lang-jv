public class CardSymbols
{
    public static void DrawHeart(double centre_x,double centre_y,double size){
        StdDraw.setPenColor(StdDraw.RED);//color for Heart & Diamond
        double[] xh = { -size+centre_x,  centre_x, size+centre_x, centre_x };
        double[] yh = {  centre_y, -size+centre_y, centre_y, size +centre_y};
        StdDraw.filledPolygon(xh, yh); //diamond
        StdDraw.filledCircle(+size/2+centre_x, size/2+centre_y, size / Math.sqrt(2)); //half circles
        StdDraw.filledCircle(-size/2+centre_x, size/2+centre_y, size / Math.sqrt(2)); //half circles
    }
    public static void DrawSpade(double centre_x,double centre_y,double size){
        StdDraw.setPenColor(StdDraw.BLACK);//color for Heart & Diamond
        double[] xh = { -size+centre_x,  centre_x, size+centre_x, centre_x };
        double[] yh = {  centre_y, -size+centre_y, centre_y, size +centre_y};
        StdDraw.filledPolygon(xh, yh); //diamond
        StdDraw.filledCircle(+size/2+centre_x, -size/2+centre_y, size / Math.sqrt(2)); //half circles
        StdDraw.filledCircle(-size/2+centre_x, -size/2+centre_y, size / Math.sqrt(2)); //half circles
        double[] ltx = {  centre_x, -size/2+centre_x, size/2+centre_x};
        double[] lty = { -size+centre_y,  -size+centre_y-size/2, -size+centre_y-size/2};
        StdDraw.filledPolygon(ltx, lty); //triangle
    }
    public static void DrawDiamond(double centre_x,double centre_y,double size){
        StdDraw.setPenColor(StdDraw.RED);//color for Heart & Diamond
        double[] xh = { -size+centre_x,  centre_x, size+centre_x, centre_x };
        double[] yh = {  centre_y, -size+centre_y, centre_y, size +centre_y};
        StdDraw.filledPolygon(xh, yh); //diamond
    }
    public static void DrawClubs(double centre_x,double centre_y,double size){
        StdDraw.setPenColor(StdDraw.BLACK);//color for Heart & Diamond
        StdDraw.filledCircle(+size/2+centre_x, centre_y, size /2); //half circles
        StdDraw.filledCircle(-size/2+centre_x, centre_y, size / 2); //half circles
        StdDraw.filledCircle(centre_x, size/Math.sqrt(2)+centre_y, size / 2); //half circles
        double[] ltx = {  centre_x,                   -size/1.7+centre_x,       size/1.7+centre_x};
        double[] lty = { centre_y+size/4,  -1.25*size+centre_y, -1.25*size+centre_y};
        StdDraw.filledPolygon(ltx, lty); //triangle
    }
    public static void main(String[] args)
    {

        DrawHeart(0.15,0.5,0.05);
        DrawDiamond(0.4,0.5,0.05);
        DrawSpade(0.6,0.5,0.05);
        DrawClubs(0.85,0.5,0.05);

    }

}

