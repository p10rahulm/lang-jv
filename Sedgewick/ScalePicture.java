//java ScalePicture data/pics/autumn.jpg
public class ScalePicture {
    public static void main(String[] args){
        Picture pic = new Picture(args[0]);
        {
            int w = pic.width()/2;
            int h = pic.height()/4;
            Picture scaledpic = scalePic(pic,w,h);
            pic.show();
            scaledpic.show();
        }
        {
            int w = pic.width()*2;
            int h = (int) (pic.height()/1.5);
            Picture scaledpic = scalePic(pic,w,h);
            pic.show();
            scaledpic.show();
        }

    }
    public static Picture scalePic(Picture pic,int w,int h){
        Picture scaled_pic = new Picture(w,h);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int sourcew = i*pic.width()/w;
                int sourceh = j*pic.height()/h;
                scaled_pic.set(i,j,pic.get(sourcew,sourceh));
            }
        }
        return scaled_pic;
    }
}
