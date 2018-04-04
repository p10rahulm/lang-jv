public class SierpinskiRecursive {
    public static void main(String[] args){
        for (int i = 0; i < 8; i++) {
            StdDraw.clear();
            draw_recursive_triangle(0.5,1.0/3,1.0/Math.sqrt(3),i);
            StdDraw.save("Sierpinski/sierpinski_"+i+".png");
        }
        for (int i = 0; i < 8; i++) {
            StdDraw.clear();
            draw_filled_recursive_triangle(0.5,1.0/3,1.0/Math.sqrt(3),i);
            StdDraw.save("Sierpinski/sierpinski_filled_"+i+".png");
        }
        StdOut.println("Done!");

    }
    public static void draw_filled_recursive_triangle(double center_x,double center_y,double circumradius,int level){
        if(level ==0)return;
        DrawFilledTriangle(center_x,center_y,circumradius);
        draw_filled_recursive_triangle(center_x+circumradius*Math.cos(90.0/360*2*Math.PI)/2,center_y+circumradius*Math.sin(90.0/360*2*Math.PI)/2,circumradius/2,level-1);
        draw_filled_recursive_triangle(center_x+circumradius*Math.cos(210.0/360*2*Math.PI)/2,center_y+circumradius*Math.sin(210.0/360*2*Math.PI)/2,circumradius/2,level-1);
        draw_filled_recursive_triangle(center_x+circumradius*Math.cos(330.0/360*2*Math.PI)/2,center_y+circumradius*Math.sin(330.0/360*2*Math.PI)/2,circumradius/2,level-1);
    }
    public static void draw_recursive_triangle(double center_x,double center_y,double circumradius,int level){
        if(level ==0)return;
        DrawTriangle(center_x,center_y,circumradius);
        draw_recursive_triangle(center_x+circumradius*Math.cos(90.0/360*2*Math.PI)/2,center_y+circumradius*Math.sin(90.0/360*2*Math.PI)/2,circumradius/2,level-1);
        draw_recursive_triangle(center_x+circumradius*Math.cos(210.0/360*2*Math.PI)/2,center_y+circumradius*Math.sin(210.0/360*2*Math.PI)/2,circumradius/2,level-1);
        draw_recursive_triangle(center_x+circumradius*Math.cos(330.0/360*2*Math.PI)/2,center_y+circumradius*Math.sin(330.0/360*2*Math.PI)/2,circumradius/2,level-1);
    }
    public static void DrawTriangle(double center_x,double center_y,double circumradius){
        //StdOut.printf("center of x is %.2f, center of y is %.2f. circumradius is %.2f\n",center_x,center_y,circumradius);
        double[] x = new double[]{center_x+circumradius*Math.cos(Math.PI/2),center_x+circumradius*Math.cos(210.0/360*2*Math.PI),center_x+circumradius*Math.cos(330.0/360*2*Math.PI)};
        double[] y = new double[]{center_y+circumradius*Math.sin(Math.PI/2),center_y+circumradius*Math.sin(210.0/360*2*Math.PI),center_y+circumradius*Math.sin(330.0/360*2*Math.PI)};
        //VectorOps.printvector(x);
        //VectorOps.printvector(y);
        StdDraw.setRandomPenColour();
        StdDraw.polygon(x,y);
    }
    public static void DrawFilledTriangle(double center_x,double center_y,double circumradius){
        //StdOut.printf("center of x is %.2f, center of y is %.2f. circumradius is %.2f\n",center_x,center_y,circumradius);
        double[] x = new double[]{center_x+circumradius*Math.cos(Math.PI/2),center_x+circumradius*Math.cos(210.0/360*2*Math.PI),center_x+circumradius*Math.cos(330.0/360*2*Math.PI)};
        double[] y = new double[]{center_y+circumradius*Math.sin(Math.PI/2),center_y+circumradius*Math.sin(210.0/360*2*Math.PI),center_y+circumradius*Math.sin(330.0/360*2*Math.PI)};
        //VectorOps.printvector(x);
        //VectorOps.printvector(y);
        StdDraw.setRandomPenColour();
        StdDraw.filledPolygon(x,y);
    }
}
