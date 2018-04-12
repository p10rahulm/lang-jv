/*
Attempting to solve the problem of drawing bounding boxes around images
Going to focus on hue as saturation and brightness change with shadow and other like effects (actually saturation unsure)

For every pixel, we will take a circular (or rectangular for easy computation) box and attempt to find most popular hue
in that rectangle.

First step will be to create an image with just those hues and standard saturation and brightness
 */

// Send error stream to error.txt and stdout stream to out.txt
// $> java PictureClusters data/pics/sadbeauty.jpg > errorlogs/out.txt 2> errorlogs/error.txt

// Change stack size by doing the following
// $> java -Xss64m PictureClusters data/pics/sadbeauty.jpg > errorlogs/out.txt 2> errorlogs/error.txt


import java.awt.Color;
import java.util.Arrays;

public class PictureClusters {
    public static void main(String[] args){
        String filename = args[0];
        String filename_base = StringMethods.filename_extension(args[0])[0];
        Picture pic = new Picture(filename);
        /*
        for (int i :new int[]{2,3,5,7,10,15}) {
            Picture hued = mostpopularhue_filter(pic,i);
            hued.save(filename_base+"_modefilter_"+i+".jpg");
        }
        Picture hues = averagehue_filter(pic,3);
        hues.save(filename_base+"_avgfilter_"+3+".jpg");
        Picture hue_recurse = modehuerecursive_filter(pic,3, 3);
        hue_recurse.save(filename_base+"_recursedmodefilter_"+3+".jpg");
        Picture avghues = averagehue_filter(avgmode,3);
        avghues.save(filename_base+"_avgrab3filter_"+3+".jpg");
        */
        Picture hued = mostpopularhue_filter(pic,3);
        //hued.save(filename_base+"_modefilter_"+3+".jpg");
        Picture avgmode = removeabberations_filter(hued,3,3);
        //avgmode.save(filename_base+"_rab3mode3filter_.jpg");
        Picture percolated = percolate(avgmode,pic.width()/2,pic.height()/2,0.05f);
        percolated.show();
        percolated.save(filename_base+"percolated_avgmode.jpg");

    }
    public static Picture percolate(Picture pic,int startx_pixel,int starty_pixel,float threshold){
        // works at scale /10;
        // works at scale 1 if a stack size of 64m is used (see use of -Xss64m while calling java).
        // now working only at 128m stack on moving coordinates
        int scale = 1;
        Picture scaled_pic = ScalePicture.scalePic(pic,pic.width()/scale,pic.height()/scale);
        int scaled_x=startx_pixel/scale;
        int scaled_y=starty_pixel/scale;
        float[][] hues = new float[scaled_pic.width()][scaled_pic.height()];
        boolean[][] done = new boolean[scaled_pic.width()][scaled_pic.height()];
        for (int i = 0; i < scaled_pic.width(); i++) {
            for (int j = 0; j < scaled_pic.height(); j++) {
                Color col = scaled_pic.get(i,j);
                hues[i][j]=Color.RGBtoHSB(col.getRed(),col.getGreen(),col.getBlue(),null)[0];
            }
        }
        hues = percolate_recurse(done,hues,scaled_x,scaled_y,threshold,hues[scaled_x][scaled_y]);
        for (int i = 0; i < scaled_pic.width(); i++) {
            for (int j = 0; j < scaled_pic.height(); j++) {
                Color col = Color.getHSBColor(hues[i][j],0.8f,0.8f);
                scaled_pic.set(i,j,col);
            }
        }
        return scaled_pic;
    }
    public static float[][] percolate_recurse(boolean[][] done,float[][] hues,int currentx,int currenty,float threshold,float start_hue){
        if(currentx<0||currentx==done.length||currenty<0||currenty>=done[0].length)return hues;
        //StdOut.printf("Current_x = %d, current_y = %d done[c_x][c_y] = %b\n",currentx,currenty,done[currentx][currenty]);
        //StdOut.println("Go 2");
        if(done[currentx][currenty])return hues;
        //StdOut.println("Go 3");
        done[currentx][currenty] = true;
        //StdOut.printf("Current_x = %d, current_y = %d done[c_x][c_y] = %b\n",currentx,currenty,done[currentx][currenty]);
        if(Math.abs(hues[currentx][currenty]-start_hue)>threshold){
            //StdOut.println("Go 4a");
            return hues;
        }
        hues[currentx][currenty]=start_hue;
        //StdOut.println("Go 4b");
        hues = percolate_recurse(done,hues,currentx+1,currenty+0,threshold,start_hue);
        hues = percolate_recurse(done,hues,currentx+0,currenty+1,threshold,start_hue);
        hues = percolate_recurse(done,hues,currentx-1,currenty+0,threshold,start_hue);
        hues = percolate_recurse(done,hues,currentx+0,currenty-1,threshold,start_hue);
        return hues;
    }
    public static Picture removeabberations_filter(Picture pic,int size,int iterations){
        if(iterations==0){pic.show();return pic;}
        StdOut.printf("pic.width = %d and pic height = %d\n",pic.width(),pic.height());
        Picture newpic = new Picture(pic.width(),pic.height());
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                newpic.set(i,j,pic.get(i,j));
            }
        }
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                int startw = ((i<size/2)?0:((i>pic.width()-1-size/2)?pic.width()-size-1:(i-size/2)));
                int starth = ((j<size/2)?0:((j>pic.height()-1-size/2)?pic.height()-size-1:(j-size/2)));
                float[] hues = new float[size*size];
                int p = 0;
                for (int k = 0; k < size; k++) {
                    for (int l = 0; l < size; l++) {
                        Color col = newpic.get(startw+k,starth+l);
                        hues[p]=Color.RGBtoHSB(col.getRed(),col.getGreen(),col.getBlue(),null)[0];
                        p++;
                    }
                }
                //Arrays.sort(hues);
                float final_hue = VectorOps.mode(hues);
                if(i==10&&(j<=5)){
                    VectorOps.printvector(hues);
                    StdOut.println(final_hue);
                }
                Color col = Color.getHSBColor(final_hue,0.8f,0.8f);
                newpic.set(i,j,col);
            }
        }
        return removeabberations_filter(newpic,size,iterations-1);
    }
    public static Picture averagehue_filter(Picture pic,int size){
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
                        hues[p]=Color.RGBtoHSB(col.getRed(),col.getGreen(),col.getBlue(),null)[0];
                        p++;
                    }
                }
                //Arrays.sort(hues);
                float final_hue = ArrayStats.mean(hues);
                Color col = Color.getHSBColor(final_hue,0.8f,0.8f);
                newpic.set(i,j,col);
            }
        }
        newpic.show();
        return newpic;
    }
    public static Picture modehuerecursive_filter(Picture pic,int size, int passes){
        if(passes==0)return pic;
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
                        //float[] hsbvals = new float[3];
                        //float[] hsbvals = Color.RGBtoHSB(col.getRed(),col.getGreen(),col.getBlue(),null);
                        hues[p]=Color.RGBtoHSB(col.getRed(),col.getGreen(),col.getBlue(),null)[0];
                        p++;
                    }
                }
                //Arrays.sort(hues);
                float final_hue = VectorOps.mode(hues);
                /*if(i==10&&(j<=5)){
                    VectorOps.printvector(hues);
                    StdOut.println(final_hue);
                }*/
                Color col = Color.getHSBColor(final_hue,0.8f,0.8f);
                //Color col = Color.getHSBColor(mode_hue+0.25f,0.8f,0.8f);
                //Color col = Color.getHSBColor(mode_hue,0.5f,0.5f);
                newpic.set(i,j,col);
            }
        }
        newpic.show();
        return modehuerecursive_filter(newpic,size, passes-1);
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
                        //float[] hsbvals = new float[3];
                        //float[] hsbvals = Color.RGBtoHSB(col.getRed(),col.getGreen(),col.getBlue(),null);
                        hues[p]=Color.RGBtoHSB(col.getRed(),col.getGreen(),col.getBlue(),null)[0];
                        p++;
                    }
                }
                //Arrays.sort(hues);
                float final_hue = VectorOps.mode(hues);
                /*if(i==10&&(j<=5)){
                    VectorOps.printvector(hues);
                    StdOut.println(final_hue);
                }*/
                Color col = Color.getHSBColor(final_hue,0.8f,0.8f);
                //Color col = Color.getHSBColor(mode_hue+0.25f,0.8f,0.8f);
                //Color col = Color.getHSBColor(mode_hue,0.5f,0.5f);
                newpic.set(i,j,col);
            }
        }
        newpic.show();
        return newpic;
    }
}
