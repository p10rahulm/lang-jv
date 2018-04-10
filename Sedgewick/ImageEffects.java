//java ImageEffects data/pics/sadbeauty.jpg
// You would notice breaks in the transformation of the picture form beautiful patterns!

import java.awt.Color;
public class ImageEffects {
    public static void main(String[] args){
        Picture pic = new Picture(args[0]);
        pic.show();
        rotation_filter(pic,Math.PI/6);
        //rotation_filter_sedgewick(pic,Math.PI/6);
        swirl_filter(pic);
        wave_filter(pic,20,128);
        wave_filter(pic,10,128);
        wave_filter(pic,10,256);
        wave_filter(pic,10,512);
        wave_filter(pic,10,64);
        glass_filter(pic,5);
    }
    public static void glass_filter(Picture pic,int randomization_pixels){
        Picture picout = new Picture(pic.width(),pic.height());
        for (int i = 0; i < picout.width(); i++) {
            for (int j = 0; j < picout.height(); j++) {
                int x_random = (int)Random.gaussian(0,randomization_pixels);
                int y_random = (int)Random.gaussian(0,randomization_pixels);
                Color col = pic.get(Math.min(Math.max(i+x_random,0),pic.width()-1),Math.min(Math.max(j+y_random,0),pic.height()-1));
                picout.set(i,j,col);
            }
        }
        picout.show();
    }
    public static void wave_filter(Picture pic,int param_multiplier, int param_pixels){
        Picture picout = new Picture(pic.width(),pic.height());
        int c_i = pic.width()/2;
        int c_j = pic.height()/2;
        double max_radius = Math.sqrt(c_i*c_i+c_j*c_j);
        for (int i = 0; i < picout.width(); i++) {
            for (int j = 0; j < picout.height(); j++) {
                Color col = pic.get(i,j);
                int target_i = i;
                int target_j_transformed = (int)((j-c_j)+param_multiplier*Math.sin(Math.PI*(j-c_j)/param_pixels));
                int target_j = Math.min(Math.max(target_j_transformed + c_j,0),pic.height()-1);

                picout.set(target_i,target_j,col);
            }
        }
        picout.show();
    }
    public static void swirl_filter(Picture pic){
        // Lets get to Pi/4 at pic edges
        Picture picout = new Picture(pic.width(),pic.height());
        int c_i = pic.width()/2;
        int c_j = pic.height()/2;
        double max_radius = Math.sqrt(c_i*c_i+c_j*c_j);
        for (int i = 0; i < picout.width(); i++) {
            for (int j = 0; j < picout.height(); j++) {
                Color col = pic.get(i,j);
                double radius = Math.sqrt((i-c_i)*(i-c_i)+(j-c_j)*(j-c_j));
                double earlier_angle = Math.atan2((j-c_j),(i-c_i));
                double theta = radius/max_radius*Math.PI/2;
                double changed_angle = earlier_angle+theta;
                int target_i_transformed = (int)(radius*Math.cos(changed_angle));
                int target_i = Math.min(Math.max(target_i_transformed + c_i,0),pic.width()-1);
                int target_j_transformed = (int)(radius*Math.sin(changed_angle));
                int target_j = Math.min(Math.max(target_j_transformed + c_j,0),pic.height()-1);

                picout.set(target_i,target_j,col);
            }
        }
        picout.show();
    }
    public static void rotation_filter_sedgewick(Picture pic, double theta){
        Picture picout = new Picture(pic.width(),pic.height());
        int c_i = pic.width()/2;
        int c_j = pic.height()/2;
        //StdOut.printf("pic width is %d pic height is %d, center x is %d center y is %d\n",pic.width(),pic.height(),c_i,c_j);
        for (int i = 0; i < picout.width(); i++) {
            for (int j = 0; j < picout.height(); j++) {
                Color col = pic.get(i,j);
                int target_i = (int)(-(i-c_i)*Math.cos(theta)+(j-c_j)*Math.sin(theta));
                int target_j = (int)(-(i-c_i)*Math.sin(theta)+(j-c_j)*Math.cos(theta));
                target_i = Math.min(Math.max(target_i + c_i,0),pic.width()-1);
                target_j = Math.min(Math.max(target_j + c_j,0),pic.height()-1);
                picout.set(target_i,target_j,col);
            }
        }
        picout.show();
    }
    public static void rotation_filter(Picture pic, double theta){
        Picture picout = new Picture(pic.width(),pic.height());
        int c_i = pic.width()/2;
        int c_j = pic.height()/2;
        for (int i = 0; i < picout.width(); i++) {
            for (int j = 0; j < picout.height(); j++) {
                Color col = pic.get(i,j);
                int sourcei_post_transformation = i-c_i;
                int sourcej_post_transformation = j-c_j;
                double radius = Math.sqrt(sourcei_post_transformation*sourcei_post_transformation+sourcej_post_transformation*sourcej_post_transformation);
                double earlier_angle = Math.atan2(sourcej_post_transformation,sourcei_post_transformation);
                double changed_angle = earlier_angle+theta;
                int target_i_transformed = (int)(radius*Math.cos(changed_angle));
                int target_i = Math.min(Math.max(target_i_transformed + c_i,0),pic.width()-1);
                int target_j_transformed = (int)(radius*Math.sin(changed_angle));
                int target_j = Math.min(Math.max(target_j_transformed + c_j,0),pic.height()-1);

                picout.set(target_i,target_j,col);
            }
        }
        picout.show();
    }
}
