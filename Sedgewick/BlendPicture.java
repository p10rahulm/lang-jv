//java BlendPicture data/pics/autumn.jpg data/pics/sadbeauty.jpg
import java.awt.*;

public class BlendPicture {
    public static void main(String[] args){
        Picture source = new Picture(args[0]);
        Picture target = new Picture(args[1]);
        int intermediary_pics = 20;
        get_blended_pic(source,target,intermediary_pics);
    }
    public static void get_blended_pic(Picture pic1,Picture pic2,int number_of_intermediaries){
        int w = get_blended_width(pic1,pic2);
        int h = get_blended_height(pic1,pic2);
        pic1 = ScalePicture.scalePic(pic1,w,h);
        pic2 = ScalePicture.scalePic(pic2,w,h);
        Picture picout = new Picture(w,h);
        for (int t = 0; t < number_of_intermediaries; t++) {
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    picout.set(i,j,get_color_blend(pic1.get(i,j),pic2.get(i,j),(double)t/number_of_intermediaries));
                }
            }
            picout.show();
        }
    }
    public static Color get_color_blend(Color col1, Color col2, double alpha){
        int r = (int)(alpha*col2.getRed() +(1-alpha)*col1.getRed());
        int g = (int)(alpha*col2.getGreen() +(1-alpha)*col1.getGreen());
        int b = (int)(alpha*col2.getBlue() +(1-alpha)*col1.getBlue());
        Color output = new Color(r,g,b);
        return output;
    }
    private static int get_blended_width(Picture pic1, Picture pics2){
        return pic1.width()<pics2.width()?pic1.width():pics2.width();
    }
    private static int get_blended_height(Picture pic1, Picture pics2){
        return pic1.height()<pics2.height()?pic1.height():pics2.height();
    }
}
