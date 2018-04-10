import java.awt.Color;

/*
format as follows
int w int h
int r_1 int g_1 int b_1
int r_2 int g_2 int b_2
...
...
int r_wh int g_wh int b_wh
 */
public class RawPicture {
    public static void main(String[] args){
        Picture pic = new Picture(args[0]);
        pic.show();
        write_raw_picture(pic,args[1]);
        Picture pic2 = read_raw_picture(args[1]);
        pic2.show();
    }
    public static Picture read_raw_picture(String filename){
        In picfile = new In(filename);
        int w = picfile.readInt();
        int h = picfile.readInt();
        Picture pic = new Picture(w,h);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int r = picfile.readInt();
                int g = picfile.readInt();
                int b = picfile.readInt();
                Color col = new Color(r,g,b);
                pic.set(i,j,col);
            }
        }
        return pic;
    }
    public static void write_raw_picture(Picture pic, String write_to_filename){
        Out outfile = new Out(write_to_filename);
        outfile.print(pic.width()+" ");
        outfile.print(pic.height()+"\n");
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                Color col = pic.get(i,j);
                outfile.print(col.getRed()+" ");
                outfile.print(col.getGreen()+" ");
                outfile.print(col.getBlue());
                outfile.print("\n");
            }
        }
    }
}
