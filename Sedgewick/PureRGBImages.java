//java PureRGBImages data/pics/sadbeauty.jpg
import java.awt.Color;

public class PureRGBImages {
    public static void main(String[] args){
        Picture pic = new Picture(args[0]);
        pic = ScalePicture.scalePic(pic,512,512);
        show_rgb_pics(pic);
    }
    public static void show_rgb_pics(Picture pic){
        Picture picr = new Picture(pic.width(),pic.height());
        Picture picg = new Picture(pic.width(),pic.height());
        Picture picb = new Picture(pic.width(),pic.height());
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                Color col = pic.get(i,j);
                Color r = new Color(col.getRed(),0,0);
                Color g = new Color(0,col.getGreen(),0);
                Color b = new Color(0,0,col.getBlue());
                picr.set(i,j,r);
                picg.set(i,j,g);
                picb.set(i,j,b);
            }
        }
        picr.show();
        picg.show();
        picb.show();
    }
}
