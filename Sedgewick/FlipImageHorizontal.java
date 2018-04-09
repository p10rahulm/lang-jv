//java FlipImageHorizontal data/pics/sadbeauty.jpg
import java.awt.*;

public class FlipImageHorizontal {
    public static void main(String[] args){
        Picture pic = new Picture(args[0]);
        Picture flipped = new Picture(pic.width(),pic.height());
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                Color col = pic.get(pic.width()-1-i,j);
                flipped.set(i,j,col);
            }
        }
        flipped.show();
    }
}
