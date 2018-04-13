/*
The mandelbrot is one large interesting set of points. We are sampling it based on a center_x, center_y and a particular zoom level. This generates images as per below
Run it at the following points for some interesting graphs
java Mandelbrot -1.4745 -0 0.0000001
java Mandelbrot -0.5 0 2
java Mandelbrot -0.1015 -0.633 0.01
java Mandelbrot 0.1015 -0.633 0.01
java Mandelbrot 0.1015 -0.633 1
java Mandelbrot 0.1015 -0.633 0.001
java Mandelbrot -0.5 -0.2 0.01
java Mandelbrot -0.5 -0.2 3
java Mandelbrot -1 -0 3
java Mandelbrot -1 -0 1
java Mandelbrot -1.5 -0 0.1
java Mandelbrot -1.5 -0 0.01
java Mandelbrot -1.5 -0 0.001
java Mandelbrot -1.47 -0 0.1
java Mandelbrot -1.475 -0 0.011
java Mandelbrot -1.475 -0 0.001
java Mandelbrot -1.474 -0 0.001
java Mandelbrot -1.4745 -0 0.001
java Mandelbrot -1.4745 -0 0.0001
java Mandelbrot -1.4745 -0 0.00001
java Mandelbrot -1.4745 -0 0.000001
java Mandelbrot -1.4745 -0 0.0000001
 */

import java.awt.Color;

public class Mandelbrot {
    private static int mand(Complex z0,int max_iterations){
        //StdOut.println("in here");
        Complex z = z0;
        for (int i = 0; i < max_iterations; i++) {
            //StdOut.printf("z.abs()=%f,iters =  %d\n",z.abs(),i);
            if(z.abs()>2){
                return i;
            }
            z=z.times(z).plus(z0);
            //StdOut.println(z);
        }
        return max_iterations;
    }
    public static Picture draw_mandelbrot(double center_x,double center_y, double size){
        int pixels  = 512;
        Picture pic = new Picture(pixels,pixels);
        for (int i = 0; i < pixels; i++) {
            for (int j = 0; j < pixels; j++) {
                double x0 = center_x - size/2 +size*i/pixels;
                double y0 = center_y - size/2 +size*j/pixels;
                Complex z0 = new Complex(x0,y0);
                //StdOut.println(z0);
                int mconst = 255 - mand(z0,255);
                Color col = new Color(mconst,mconst,mconst);
                pic.set(i,pixels-1-j,col);
            }
        }
        pic.show();
        return pic;
    }
    public static void main(String[] args){
        double xc = Double.parseDouble(args[0]);
        double yc = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);
        Picture pic = draw_mandelbrot(xc,yc,size);
        pic.save("Mandelbrot/Mandelbrot_xc"+args[0]+"_yc"+args[1]+"_size"+args[2]+".jpg");
    }

}
