import java.awt.Color;
public class AlbersSquares {
    public static void main(String[] args){
        Color color1 = new Color(Random.randbetween(0,255),Random.randbetween(0,255),Random.randbetween(0,255));
        Color color2 = new Color(Random.randbetween(0,255),Random.randbetween(0,255),Random.randbetween(0,255));
        drawsquares(color1,color2);
    }
    public static void drawsquares(Color color1,Color color2){
        StdDraw.setPenColor(color1);
        StdDraw.filledSquare(0.25,0.5,0.2);
        StdDraw.setPenColor(color2);
        StdDraw.filledSquare(0.25,0.5,0.1);
        StdDraw.filledSquare(0.75,0.5,0.2);
        StdDraw.setPenColor(color1);
        StdDraw.filledSquare(0.75,0.5,0.1);
    }
}
