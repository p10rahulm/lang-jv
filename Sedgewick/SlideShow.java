import java.awt.Color;

import static java.lang.Thread.sleep;

public class SlideShow {
    public static void main(String[] args){
        String[] filenames = args;
        Picture pic = new Picture(512,512);
        Picture[] pictures = new Picture[filenames.length];
        for (int i = 0; i < filenames.length; i++) {
            pictures[i] = ScalePicture.scalePic(new Picture(filenames[i]),pic.width(),pic.height()) ;
        }
        for (int i = 0; i < pictures.length; i++) {
            fade_from_black(pic,pictures[i],25);
            Show_pic_for_n_milliseconds(pic,3000l);
            fade_to_black(pic,pictures[i],25);
        }
    }
    public static void Show_pic_for_n_milliseconds(Picture display,long n){
        display.show();
        try {
            sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void fade_from_black(Picture display,Picture displaypic,int number_of_intermediaries){
        Picture black = new Picture(display.width(),display.height());
        for (int i = 0; i < display.width(); i++) {
            for (int j = 0; j < display.height(); j++) {
                black.set(i,j,Color.BLACK);
            }
        }
        for (int t = 0; t < number_of_intermediaries; t++) {
            for (int i = 0; i < display.width(); i++) {
                for (int j = 0; j < display.height(); j++) {
                    display.set(i,j,BlendPicture.get_color_blend(black.get(i,j),displaypic.get(i,j),(double)t/number_of_intermediaries));
                }
            }
            display.show();
        }
    }
    public static void fade_to_black(Picture display,Picture displaypic,int number_of_intermediaries){
        Picture black = new Picture(display.width(),display.height());
        for (int i = 0; i < display.width(); i++) {
            for (int j = 0; j < display.height(); j++) {
                black.set(i,j,Color.BLACK);
            }
        }
        for (int t = 0; t < number_of_intermediaries; t++) {
            for (int i = 0; i < display.width(); i++) {
                for (int j = 0; j < display.height(); j++) {
                    display.set(i,j,BlendPicture.get_color_blend(displaypic.get(i,j),black.get(i,j),(double)t/number_of_intermediaries));
                }
            }
            display.show();
        }
    }
}
