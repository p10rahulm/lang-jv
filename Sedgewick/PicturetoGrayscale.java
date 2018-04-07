//java PicturetoGrayscale data/pics/headshot1.png

import java.awt.Color;
public class PicturetoGrayscale {
    public static void main(String[] args){
        String filename = args[0];
        Picture pic = new Picture(filename);
        pic.show();
        convert_to_grayscale(pic);
        pic.show();
    }

    public static Picture convert_to_grayscale(Picture pic){
        for(int i =0;i<pic.width();i++){
            for (int j = 0; j < pic.height(); j++) {
                Color color = pic.get(i,j);
                pic.set(i,j,Luminance.toGray(color));
            }
        }
        return pic;

    }
}
