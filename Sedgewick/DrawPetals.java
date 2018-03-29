
//witnes beauty! java DrawPetals 10 0.9 1000

import java.awt.*;

public class DrawPetals {
    public static void main(String[] args){
        int numpetals = Integer.parseInt(args[0]);
        double radius = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        double anglediff = 2*Math.PI/n;
        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);
        StdDraw.setPenColor(Color.GRAY);
        for(int i=1;i<=n;i++){
            double angle = 2*Math.PI/n*i;
            double r = radius*Math.sin(numpetals*angle);
            double x=r*Math.cos(angle);
            double y=r*Math.sin(angle);;
            double prv_angle = angle - anglediff;
            double prv_r = radius*Math.sin(numpetals*prv_angle);
            double prv_x=prv_r*Math.cos(prv_angle);
            double prv_y=prv_r*Math.sin(prv_angle);;
            StdDraw.line(x,y,prv_x,prv_y);
        }
    }
}
