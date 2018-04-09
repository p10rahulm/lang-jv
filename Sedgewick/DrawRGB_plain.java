//java DrawRGB_plain 123 127 225

import java.awt.*;

public class DrawRGB_plain {
    public static void main(String[] args){
        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        int size_x = 256, size_y = 256;
        Color col = new Color(r,g,b);
        Picture out = new Picture(size_x,size_y);
        for (int i = 0; i < out.width(); i++) {
            for (int j = 0; j < out.height(); j++) {
                out.set(i,j,col);
            }
        }
        out.show();
    }
}
