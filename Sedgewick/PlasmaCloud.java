import java.awt.*;

public class PlasmaCloud {
    public static void main(String[] args){
        //plasma2(0.5,0.5,0.5,1.0,Math.random(),Math.random(),Math.random(),Math.random());
        for (int i =0;i<4;i++) {
            for (double stdev:new double[]{0.05,0.25,0.5,1}) {
                //plasma(0.5,0.5,0.5,stdev,7,0.5f,"h",0.8f,0.8f);
                //plasma3(0.5,0.5,0.5,0.1,5,0.5f,"h",0.8f,0.8f);
                plasma4(0.5f,0.5f,0.5f,.5f,
                        "h",0.8f,0.8f,0.5,0.5,0.5,stdev,8);
                StdOut.print("done" + stdev);
                StdDraw.save("PlasmaCloud/pc4_stdev_"+stdev+"h_variation_attempt"+i+".png");
                plasma4(0.5f,0.5f,0.5f,.5f,
                        "s",(float) Math.random(),0.8f,0.5,0.5,0.5,stdev,8);
                StdOut.print("done" + stdev);
                StdDraw.save("PlasmaCloud/pc4_stdev_"+stdev+"s_variation_attempt"+i+".png");
                plasma4(0.5f,0.5f,0.5f,.5f,
                        "b",(float) Math.random(),0.8f,0.5,0.5,0.5,stdev,8);
                StdOut.print("done" + stdev);
                StdDraw.save("PlasmaCloud/pc4_stdev_"+stdev+"b_variation_attempt"+i+".png");
            }
        }
    }

    public static void plasma3(double x_center,double y_center,double halfsize,double stdev, int level, float hsbvalue, String hsb,float val2, float val3){
        // val2 and val3 are used for those color values that are not being randomized.

        /* Implementing the following model for h. Here r's and p's are Gaussian variables with mean 0 and stdev
        L0
        a
        L1 - note that a single recursion goes 2 steps, due to x and y
        a-r1+r2 |a+r2      	a+r2    |a+r1+r2
        a-r1    |a   		a       |a+r1

        a-r1    |a          a       |a+r1
        a-r1-r2 |a-r2		a-r2    |a+r1-r2

        ...
         */

        if(level<=0)return;
        {
            if(hsb=="h"){
                Color color = Color.getHSBColor(hsbvalue, val2, val3);
                StdDraw.setPenColor(color);
            } else if(hsb=="s") {
                Color color = Color.getHSBColor(val2,hsbvalue, val3);
                StdDraw.setPenColor(color);
            } else if(hsb=="b") {
                Color color = Color.getHSBColor(val2,val3, hsbvalue);
                StdDraw.setPenColor(color);
            } else{
                throw new ArithmeticException("yoyo");
            }
            StdDraw.filledSquare(x_center, y_center, halfsize);
        }

        float r1 = (float) Random.gaussian(0,stdev);
        float r2 = (float) Random.gaussian(0,stdev);

        //Top right guys
        plasma3(x_center+halfsize/2+halfsize/4,y_center+halfsize/2+halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue+r1+r2, hsb,val2, val3);
        plasma3(x_center+halfsize/2+halfsize/4,y_center+halfsize/2-halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue+r1, hsb,val2, val3);
        plasma3(x_center+halfsize/2-halfsize/4,y_center+halfsize/2+halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue+r2, hsb,val2, val3);
        plasma3(x_center+halfsize/2-halfsize/4,y_center+halfsize/2-halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue, hsb,val2, val3);

        //Bottom right guys
        plasma3(x_center+halfsize/2+halfsize/4,y_center-halfsize/2-halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue+r1-r2, hsb,val2, val3);
        plasma3(x_center+halfsize/2+halfsize/4,y_center-halfsize/2+halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue+r1, hsb,val2, val3);
        plasma3(x_center+halfsize/2-halfsize/4,y_center-halfsize/2-halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue-r2, hsb,val2, val3);
        plasma3(x_center+halfsize/2-halfsize/4,y_center-halfsize/2+halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue, hsb,val2, val3);
        //Top left guys
        plasma3(x_center-halfsize/2-halfsize/4,y_center+halfsize/2+halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue-r1+r2, hsb,val2, val3);
        plasma3(x_center-halfsize/2-halfsize/4,y_center+halfsize/2-halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue-r1, hsb,val2, val3);
        plasma3(x_center-halfsize/2+halfsize/4,y_center+halfsize/2+halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue+r2, hsb,val2, val3);
        plasma3(x_center-halfsize/2+halfsize/4,y_center+halfsize/2-halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue, hsb,val2, val3);


        //Bottom left guys
        plasma3(x_center-halfsize/2-halfsize/4,y_center-halfsize/2-halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue-r1-r2, hsb,val2, val3);
        plasma3(x_center-halfsize/2-halfsize/4,y_center-halfsize/2+halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue-r1, hsb,val2, val3);
        plasma3(x_center-halfsize/2+halfsize/4,y_center-halfsize/2-halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue-r2, hsb,val2, val3);
        plasma3(x_center-halfsize/2+halfsize/4,y_center-halfsize/2+halfsize/4,halfsize/4,stdev/4,level-1,
                hsbvalue, hsb,val2, val3);

    }
    public static void plasma4(float hsbvalue_tr,float hsbvalue_br,float hsbvalue_tl,float hsbvalue_bl,
                               String hsb,float val2, float val3,
                                double x_center,double y_center,double halfsize,double stdev, int level){
        /* Implementing the following model for h. Here r's and p's are Gaussian variables with mean 0 and stdev
        L0
        a
        L1: a = (tl+tr+bl+br)/4
        tl          |(tl+tr)/2  (tl+tr)/2   |tr
        (tl+bl)/2   |a   		a           |(tr+br)/2

        (tl+bl)/2   |a          a           |(tr+br)/2
        bl          |a-r2		a-r2        |br

        ...
         */

        if(level<=0)return;

        float a=(hsbvalue_bl+hsbvalue_tl+hsbvalue_br+hsbvalue_tr)/4;
        float displacement = (float)Random.gaussian(0, stdev);
        if(hsb=="h"){
            Color color = Color.getHSBColor(a+displacement, val2, val3);
            StdDraw.setPenColor(color);
        } else if(hsb=="s") {
            Color color = Color.getHSBColor(val2,a+displacement, val3);
            StdDraw.setPenColor(color);
        } else if(hsb=="b") {
            Color color = Color.getHSBColor(val2,val3, a+displacement);
            StdDraw.setPenColor(color);
        } else{
            throw new ArithmeticException("yoyo");
        }
        StdDraw.filledSquare(x_center, y_center, halfsize);

        float right = (float) ((hsbvalue_tr+hsbvalue_br)/2.0);
        float top = (float) ((hsbvalue_tr+hsbvalue_tl)/2.0);
        float left = (float) ((hsbvalue_tl+hsbvalue_bl)/2.0);
        float bottom = (float) ((hsbvalue_bl+hsbvalue_br)/2.0);

        //Top right guys
        plasma4(hsbvalue_tr,right,top,a+displacement,
                hsb,val2, val3,x_center+halfsize/2,y_center+halfsize/2,halfsize/2,stdev/2,level-1);

        //Bottom right guys
        plasma4(right,hsbvalue_br,a+displacement,bottom,
                hsb,val2, val3,x_center+halfsize/2,y_center-halfsize/2,halfsize/2,stdev/2,level-1);

        //Top left guys
        plasma4(top,a+displacement,hsbvalue_tl,left,
                hsb,val2, val3,x_center-halfsize/2,y_center+halfsize/2,halfsize/2,stdev/2,level-1);

        //Bottom left guys
        plasma4(a+displacement,bottom,left,hsbvalue_bl,
                hsb,val2, val3,x_center-halfsize/2,y_center-halfsize/2,halfsize/2,stdev/2,level-1);


    }


    public static void plasma(double x_center,double y_center,double halfsize,double stdev, int level, float hsbvalue, String hsb,float val2, float val3){
        // val2 and val3 are used for those color values that are not being randomized.

        /* Implementing the following model for h. Here r's and p's are Gaussian variables with mean 0 and stdev
        L0
        a
        L1
        a-r1+r2|a+r1+r2
        a-r1-r2|a+r1-r2
        L2
        a-r1+r2|a+r1+r2   	a-r1+r2|a+r1+r2
        a-r1-r2|a+r1-r2		a-r1-r2|a+r1-r2

        a-r1+r2|a+r1+r2   	a-r1+r2|a+r1+r2
        a-r1-r2|a+r1-r2		a-r1-r2|a+r1-r2


        (b-p1+p2)-r1+r2|(b-p1+p2)+r1+r2   	(b+p1+p2)-r1+r2|(b+p1+p2)+r1+r2
        (b-p1+p2)-r1-r2|(b-p1+p2)+r1-r2		(b+p1+p2)-r1-r2|(b+p1+p2)+r1-r2

        (b-p1-p2)-r1+r2|(b-p1-p2)+r1+r2   	(b+p1-p2)-r1+r2|(b+p1-p2)+r1+r2
        (b-p1-p2)-r1-r2|(b-p1-p2)+r1-r2		(b+p1-p2)-r1-r2|(b+p1-p2)+r1-r2
        ...
         */

        if(level<=0)return;
        {
            if(hsb=="h"){
                        Color color = Color.getHSBColor(hsbvalue, val2, val3);
                        StdDraw.setPenColor(color);
                    } else if(hsb=="s") {
                        Color color = Color.getHSBColor(val2,hsbvalue, val3);
                        StdDraw.setPenColor(color);
                    } else if(hsb=="b") {
                        Color color = Color.getHSBColor(val2,val3, hsbvalue);
                        StdDraw.setPenColor(color);
                    } else{
                        throw new ArithmeticException("yoyo");
                    }
            StdDraw.filledSquare(x_center, y_center, halfsize);
        }

        float r1 = (float) Random.gaussian(0,stdev);
        float r2 = (float) Random.gaussian(0,stdev);

        plasma(x_center+halfsize/2,y_center+halfsize/2,halfsize/2,stdev/2,level-1,
                hsbvalue+r1+r2, hsb,val2, val3);
        plasma(x_center+halfsize/2,y_center-halfsize/2,halfsize/2,stdev/2,level-1,
                hsbvalue+r1-r2, hsb,val2, val3);
        plasma(x_center-halfsize/2,y_center+halfsize/2,halfsize/2,stdev/2,level-1,
                hsbvalue-r1+r2, hsb,val2, val3);
        plasma(x_center-halfsize/2,y_center-halfsize/2,halfsize/2,stdev/2,level-1,
                hsbvalue-r1-r2, hsb,val2, val3);

    }

    public static void plasma2(double x,  double y,  double size, double stddev,
                              double c1, double c2, double c3,   double c4) {

        // base case
        if (size <= 0.001) return;

        // calculate new color of midpoint using random displacement
        double displacement = Random.gaussian(0, stddev);
        double cM = (c1 + c2 + c3 + c4) / 4.0 + displacement;

        // draw a colored square
        Color color = Color.getHSBColor((float) cM, 0.8f, 0.8f);
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(x, y, size);

        double cT = (c1 + c2) / 2.0;    // top
        double cB = (c3 + c4) / 2.0;    // bottom
        double cL = (c1 + c3) / 2.0;    // left
        double cR = (c2 + c4) / 2.0;    // right
        /* arrangement as follows
        c1|c2
        c3|c4
         */

        plasma2(x - size/2, y - size/2, size/2, stddev/2, cL, cM, c3, cB);
        plasma2(x + size/2, y - size/2, size/2, stddev/2, cM, cR, cB, c4);
        plasma2(x - size/2, y + size/2, size/2, stddev/2, c1, cT, cL, cM);
        plasma2(x + size/2, y + size/2, size/2, stddev/2, cT, c2, cM, cR);
    }

}
