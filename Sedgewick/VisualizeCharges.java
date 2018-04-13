import java.awt.*;

public class VisualizeCharges {

    public static void main(String[] args){
        double[][] location_and_charges = MatrixOps.readDouble2D();
        Charge[] charges = load_charges(location_and_charges);
        int size = 512;
        draw_charges(charges,512,300,1,1);

    }
    public static void draw_charges(Charge[] charges,int pic_width,int pic_height,double space_width,double space_height){
        Picture pic = new Picture(pic_width,pic_height);
        double[][] potentials = new double[pic_width][pic_height];
        for (int i = 0; i < pic_width; i++) {
            for (int j = 0; j < pic_height; j++) {
                for (int k = 0; k < charges.length; k++) {
                    potentials[i][j]+=charges[k].potentialAt((double) i/pic_width*space_width,(double)j/pic_height*space_height);

                }
            }
        }
        int[][] potential_at_scaled = scaled_potential(potentials);
        for (int i = 0; i < pic_width; i++) {
            for (int j = 0; j < pic_height; j++) {
                int col_gray = potential_at_scaled[i][j];
                Color color = new Color(col_gray,col_gray,col_gray);
                pic.set(i,j,color);
            }
        }
        pic.show();
        //StdOut.print("The grayscale visualization should appear on a different window");
    }
    private static int[][] scaled_potential (double[][] potentials){
        int[][]scaled_potential = new int[potentials.length][potentials[0].length];
        for (int i = 0; i < potentials.length; i++) {
            for (int j = 0; j < potentials[0].length; j++) {
                int g = 128+(int)(potentials[i][j]/2e10);
                g = (g<0?0:g);
                g = (g>255?255:g);
                scaled_potential[i][j]=g;
            }
        }
        return scaled_potential;
    }
    public static Charge[] load_charges(double[][] location_of_charges){
        Charge[] all_charges = new Charge[location_of_charges.length];
        for (int i = 0; i < all_charges.length; i++) {
            all_charges[i] = new Charge(location_of_charges[i][0],location_of_charges[i][1],location_of_charges[i][2]);
        }
        return all_charges;
    }
}
