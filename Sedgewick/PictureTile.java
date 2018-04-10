//java PictureTile data/pics/sadbeauty.jpg 7 10 512 512
public class PictureTile {
    public static void main(String[] args){
        String filename = args[0];
        int num_images_wide = Integer.parseInt(args[1]);
        int num_images_tall = Integer.parseInt(args[2]);
        int total_width = Integer.parseInt(args[3]);
        int total_height = Integer.parseInt(args[4]);

        show_tiled_picture(filename, num_images_wide, num_images_tall,total_width, total_height);

    }
    public static void show_tiled_picture(String filename, int num_images_wide, int num_images_tall,int total_width, int total_height){
        Picture tile_pic =ScalePicture.scalePic(new Picture(filename),total_width/num_images_wide,total_height/num_images_tall);
        Picture pic = new Picture(total_width,total_height);
        for (int i = 0; i < num_images_wide; i++) {
            for (int j = 0; j < num_images_tall; j++) {
                for (int k = 0; k < tile_pic.width(); k++) {
                    for (int l = 0; l < tile_pic.height(); l++) {
                        pic.set(i*tile_pic.width()+k,j*tile_pic.height()+l,tile_pic.get(k,l));
                    }
                }
            }
        }
        pic.show();
    }
}
