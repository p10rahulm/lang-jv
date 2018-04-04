public class RecursiveSquares {
    public static void main(String[] args){
        //int n = Integer.parseInt(args[0]);
        for (int i = 0; i < 8; i++) {
            StdDraw.clear();
            draw_recursive_squares(0.5,0.5,0.25,i);
            StdDraw.save("RecursiveSquares/recursive_squares2_"+i+".png");
        }

    }
    public static void draw_recursive_squares(double center_x, double center_y, double halfsize, int current_level){
        if(current_level==0)return;

        draw_recursive_squares(center_x-halfsize,center_y-halfsize,halfsize/2,current_level-1);
        draw_recursive_squares(center_x+halfsize,center_y-halfsize,halfsize/2,current_level-1);
        draw_recursive_squares(center_x-halfsize,center_y+halfsize,halfsize/2,current_level-1);
        draw_recursive_squares(center_x+halfsize,center_y+halfsize,halfsize/2,current_level-1);
        //StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenColor(Random.randbetween(0,255),   Random.randbetween(0,255),   Random.randbetween(0,255));
        StdDraw.filledSquare(center_x,center_y,halfsize);
        //StdDraw.setPenColor(Random.randbetween(0,255),   Random.randbetween(0,255),   Random.randbetween(0,255));
        //StdDraw.setPenColor(StdDraw.BLACK);
        //StdDraw.square(center_x,center_y,halfsize);
    }
}
