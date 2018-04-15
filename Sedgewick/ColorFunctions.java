import java.awt.*;

public class ColorFunctions {
    public static Color[] get_good_colors(int n){
        In file = new In("data/colors.txt");
        int ITERS  = Math.min(n,255);
        // read in color map
        Color[] colors = new Color[ITERS];
        for (int t = 0; t < ITERS; t++) {
            int r = file.readInt();
            int g = file.readInt();
            int b = file.readInt();
            colors[t] = new Color(r, g, b);
        }
        return colors;
    }
}
