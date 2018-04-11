/*
Attempting to solve the problem of drawing bounding boxes around images
Going to focus on hue as saturation and brightness change with shadow and other like effects (actually saturation unsure)

For every pixel, we will take a circular (or rectangular for easy computation) box and attempt to find most popular hue
in that rectangle.

First step will be to create an image with just those hues and standard saturation and brightness
 */


import java.awt.Color;

public class PictureClusters {
    public static void main(String[] args){
        String filename = args[0];
        Picture pic = new Picture(filename);
        Picture hued = mostpopularhue_filter(pic,5);
    }
    public static Picture mostpopularhue_filter(Picture pic,int size){
        for (int i = 0; i < pic.width(); i++) {

        }
        Color col = null;
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                col = pic.get(i,j);
                int r = col.getRed();
                int g = col.getGreen();
                int b = col.getBlue();
            }
        }
        return pic;
    }
}
