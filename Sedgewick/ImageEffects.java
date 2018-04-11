//java ImageEffects data/pics/sadbeauty.jpg
// You would notice breaks in the transformation of the picture form beautiful patterns!

import java.awt.Color;
public class ImageEffects {
    public static void main(String[] args){
        Picture pic = new Picture(args[0]);
        String filename_base = StringMethods.filename_extension(args[0])[0];
        pic.show();
        rotation_filter(pic,Math.PI/6).save(filename_base+"rotational_filter.jpg");
        //rotation_filter_sedgewick(pic,Math.PI/6);
        swirl_filter(pic).save(filename_base+"swirl_filter.jpg");
        wave_filter(pic,20,128).save(filename_base+"wave_filter_20mult_128pix.jpg");
        wave_filter(pic,10,128).save(filename_base+"wave_filter_10mult_128pix.jpg");
        wave_filter(pic,10,256).save(filename_base+"wave_filter_10mult_256pix.jpg");
        wave_filter(pic,10,512).save(filename_base+"wave_filter_10mult_512pix.jpg");
        wave_filter(pic,10,64).save(filename_base+"wave_filter_10mult_64pix.jpg");
        glass_filter(pic,5).save(filename_base+"glass_filter_5_rcount.jpg");
        glass_filter(pic,3).save(filename_base+"glass_filter_3_rcount.jpg");
        glass_filter(pic,1).save(filename_base+"glass_filter_1_rcount.jpg");
        glass_filter(pic,10).save(filename_base+"glass_filter_10_rcount.jpg");
        digital_zoom(pic,5,0.5,0.5).save(filename_base+"digitalzoom_5_zoom_0.5x_0.5y.jpg");
        digital_zoom(pic,2,0,0).save(filename_base+"digitalzoom_2_zoom_0x_0y.jpg");
    }
    public static Picture glass_filter(Picture pic,int randomization_pixels){
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
        return picout;
    }
    public static Picture digital_zoom(Picture pic,int zoom, double center_x,double center_y){
        // center_x and center_y are between 0 and 1. zoomx is an int (say below 15). the output width and height are same as input.
        // We need to calculate input width and height to scale post digital zoom.
        int input_width = pic.width()/zoom;
        int input_height = pic.height()/zoom;
        int start_x,start_y,end_x,end_y;
        center_x = center_x*pic.width();
        center_y = center_y*pic.height();
        if(center_x>input_width/2){
            start_x=(int)(center_x-input_width/2);
            end_x =(int)(center_x+input_width/2);
        } else{
            start_x = 0;
            end_x = input_width;
        }
        if(center_y>input_height/2){
            start_y=(int)(center_y-input_height/2);
            end_y =(int)(center_y+input_height/2);
        } else{
            start_y = 0;
            end_y = input_height;
        }
        Picture unscaled_pic = new Picture(input_width,input_height);
        for (int i = 0; i < unscaled_pic.width(); i++) {
            for (int j = 0; j < unscaled_pic.height(); j++) {
                Color col = pic.get(start_x+i,start_y+j);
                unscaled_pic.set(i,j,col);
            }
        }
        Picture scaled_pic = ScalePicture.scalePic(unscaled_pic,pic.width(),pic.height());
        scaled_pic.show();
        return scaled_pic;
    }
    public static Picture wave_filter(Picture pic,int param_multiplier, int param_pixels){
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
        return picout;
    }

    public static Picture swirl_filter(Picture pic){
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
        return picout;
    }
    public static Picture rotation_filter_sedgewick(Picture pic, double theta){
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
        return picout;
    }
    public static Picture rotation_filter(Picture pic, double theta){
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
        return picout;
    }
}
