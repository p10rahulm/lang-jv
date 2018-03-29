public class SomeDiagrams {
    public static void main(String[] args){
        draw_diagram_1();
        draw_diagram_2();
        draw_diagram_3();
        draw_diagram_4();

    }
    public static void draw_diagram_4(){
        {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(0.5,0.5,0.5);
        }

        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {0,0.25,0.5,0.25};
            double[] py = {0.25,0,0.25,0.5};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {1-0,1-0.25,1-0.5,1-0.25};
            double[] py = {0.25,0,0.25,0.5};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {1-0,1-0.25,1-0.5,1-0.25};
            double[] py = {1-0.25,1-0,1-0.25,1-0.5};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {0,0.25,0.5,0.25};
            double[] py = {1-0.25,1-0,1-0.25,1-0.5};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.GRAY);
            double[] px = {0,0.5,1,0.5};
            double[] py = {0.5,0,0.5,1};
            StdDraw.filledPolygon(px,py);
            StdDraw.filledSquare(0.125,0.125,0.125);
            StdDraw.filledSquare(1-0.125,0.125,0.125);
            StdDraw.filledSquare(1-0.125,1-0.125,0.125);
            StdDraw.filledSquare(0.125,1-0.125,0.125);
        }
    }

    public static void draw_diagram_3(){
        {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(0.5,0.5,0.5);
        }

        {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(0.125,0.125,0.125);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(1-0.125,0.125,0.125);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(1-0.125,1-0.125,0.125);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(0.125,1-0.125,0.125);
        }
        {
            StdDraw.setPenColor(StdDraw.GRAY);
            double[] px = {0,0.5,1,0.5};
            double[] py = {0.5,0,0.5,1};
            StdDraw.filledPolygon(px,py);
        }
    }

    public static void draw_diagram_2(){
        {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(0.5,0.5,0.5);
        }

        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {0,0.25,0.5,0.25};
            double[] py = {0.25,0,0.25,0.5};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {1-0,1-0.25,1-0.5,1-0.25};
            double[] py = {0.25,0,0.25,0.5};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {1-0,1-0.25,1-0.5,1-0.25};
            double[] py = {1-0.25,1-0,1-0.25,1-0.5};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {0,0.25,0.5,0.25};
            double[] py = {1-0.25,1-0,1-0.25,1-0.5};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.GRAY);
            double[] px = {0,0.5,1,0.5};
            double[] py = {0.5,0,0.5,1};
            StdDraw.filledPolygon(px,py);
        }
    }
    public static void draw_diagram_1(){
        {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(0.5,0.5,0.5);
        }
        {
            StdDraw.setPenColor(StdDraw.GRAY);
            double[] px = {0,0.5,1,0.5};
            double[] py = {0.5,0,0.5,1};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {0,0.25,0.25};
            double[] py = {0.25,0.25,0};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {1,1-0.25,1-0.25};
            double[] py = {0.25,0.25,0};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {1-0,1-0.25,1-0.25};
            double[] py = {1-0.25,1-0.25,1-0};
            StdDraw.filledPolygon(px,py);
        }
        {
            StdDraw.setPenColor(StdDraw.WHITE);
            double[] px = {0,0.25,0.25};
            double[] py = {1-0.25,1-0.25,1-0};
            StdDraw.filledPolygon(px,py);
        }
    }
}
