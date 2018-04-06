import java.awt.Color;
public class Luminance {
    public static void main(String [] args){
        Color c1 = new Color(Random.randbetween(0,255),Random.randbetween(0,255),Random.randbetween(0,255));
        Color c2 = new Color(Random.randbetween(0,255),Random.randbetween(0,255),Random.randbetween(0,255));
        AlbersSquares.drawsquares(c1,c2);
        String r="";
        if(!compatible(c1,c2)){r = "no ";}
        StdOut.printf("There is %sluminance compatibility between colors (%d,%d,%d) and (%d,%d,%d)",r,c1.getRed(),c1.getGreen(),c1.getBlue(),c2.getRed(),c2.getGreen(),c2.getBlue());

    }
    public static boolean compatible(Color c1,Color c2){
        return(Math.abs(luminance(c1)- luminance(c2))>=128);
    }
    public static int luminance(Color c1){
        int r = c1.getRed();
        int g = c1.getGreen();
        int b = c1.getBlue();
        return (int)(0.299*r + 0.587*g + 0.114*b);
    }
    public static Color toGray(Color color){
        int y = luminance(color);
        //return (new Color(y,y,y));
        Color gray = new Color(y,y,y);
        return (gray);
    }
}
