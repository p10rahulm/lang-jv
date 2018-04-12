/*
Attempting to solve the problem of drawing bounding boxes around images
Going to focus on hue as saturation and brightness change with shadow and other like effects (actually saturation unsure)

For every pixel, we will take a circular (or rectangular for easy computation) box and attempt to find most popular hue
in that rectangle.

First step will be to create an image with just those hues and standard saturation and brightness
 */


import java.awt.Color;
import java.util.Arrays;

public class PictureClusters {
    public static void main(String[] args){
        String filename = args[0];
        String filename_base = StringMethods.filename_extension(args[0])[0];
        Picture pic = new Picture(filename);
        /*for (int i :new int[]{2,3,5,7,10,15}) {
            Picture hued = mostpopularhue_filter(pic,i);
            hued.save(filename_base+"_modefilter_"+i+".jpg");
        }*/
        Picture hued = mostpopularhue_filter(pic,3);
        hued.save(filename_base+"_modefilter_"+3+".jpg");

    }
    public static Picture mostpopularhue_filter(Picture pic,int size){
        StdOut.printf("pic.width = %d and pic height = %d\n",pic.width(),pic.height());
        Picture newpic = new Picture(pic.width(),pic.height());
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                int startw = ((i<size/2)?0:((i>pic.width()-1-size/2)?pic.width()-size-1:(i-size/2)));
                int starth = ((j<size/2)?0:((j>pic.height()-1-size/2)?pic.height()-size-1:(j-size/2)));
                float[] hues = new float[size*size];
                int p = 0;
                for (int k = 0; k < size; k++) {
                    for (int l = 0; l < size; l++) {
                        Color col = pic.get(startw+k,starth+l);
                        float[] hsbvals = new float[3];
                        Color.RGBtoHSB(col.getRed(),col.getGreen(),col.getBlue(),hsbvals);
                        hues[p]=hsbvals[0];
                        p++;
                    }
                }
                Arrays.sort(hues);
                float mode_hue = VectorOps.mode(hues);
                Color col = Color.getHSBColor(mode_hue,0.8f,0.8f);
                //Color col = Color.getHSBColor(mode_hue+0.25f,0.8f,0.8f);
                //Color col = Color.getHSBColor(mode_hue,0.5f,0.5f);
                newpic.set(i,j,col);
            }
        }
        newpic.show();
        return newpic;
    }
}
