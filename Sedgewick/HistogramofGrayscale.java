import java.awt.*;

public class HistogramofGrayscale {
    public static void main(String[] args){
        String grayscale_image_filename = args[0];
        Picture grayscale_pic = new Picture(grayscale_image_filename);
        int[] luminance_frequencies = new int[256];
        for(int i =0;i<grayscale_pic.width();i++){
            for (int j = 0; j < grayscale_pic.height(); j++) {
                Color mycolor = new Color(grayscale_pic.getRGB(i,j));
                int lum = Luminance.luminance(Luminance.toGray(mycolor));
                luminance_frequencies[lum]+=1;
            }
        }
        Histogram
    }
}
