import java.awt.*;

public class PaperSizes {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(0,2);
        StdDraw.setYscale(0,2);
        Drawcut(1,1,Math.sqrt(2)/2,0.5,true,n);
        StdDraw.setPenColor(Color.orange);
        StdDraw.setPenRadius(0.01);
        StdDraw.rectangle(1,1,Math.sqrt(2)/2,0.5);
    }
    public static void Drawcut(double x_center,double y_center,double half_width,double half_height,boolean landscape_mode,int level){
        if(level==0)return;
        if(landscape_mode){
            StdDraw.setPenRadius();
            StdDraw.setPenColor(Color.BLUE);
            //StdDraw.rectangle(x_center,y_center,half_width,half_height);
            //StdDraw.setPenRadius(0.005);
            StdDraw.line(x_center,y_center-half_height,x_center,y_center+half_height);
            Drawcut(x_center-half_width/2,y_center,half_width/2,half_height,false,level-1);
            Drawcut(x_center+half_width/2,y_center,half_width/2,half_height,false,level-1);

        } else{
            StdDraw.setPenRadius();
            StdDraw.setPenColor(Color.BLACK);
            //StdDraw.rectangle(x_center,y_center,half_width,half_height);
            //StdDraw.setPenRadius(0.005);
            StdDraw.line(x_center-half_width,y_center,x_center+half_width,y_center);
            Drawcut(x_center,y_center-half_height/2,half_width,half_height/2,true,level-1);
            Drawcut(x_center,y_center+half_height/2,half_width,half_height/2,true,level-1);
        }
        return;
    }

}
