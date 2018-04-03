public class Ruler {
    public static void main(String args[]){

        StdDraw.setXscale(-0.05,1.05);
        StdDraw.line(0,0.5,1,0.5);
        rules(0.5,0.5,1,0.05,5);
    }
    public static void rules(double x_center,double y_center,double width, double scale_height,int steps){
        if(steps==0)return;
        StdDraw.line(x_center,y_center,x_center,y_center-scale_height);
        StdDraw.line(x_center+width/2,y_center,x_center+width/2,y_center-scale_height);
        StdDraw.line(x_center-width/2,y_center,x_center-width/2,y_center-scale_height);
        rules(x_center-width/4,y_center,width/2,scale_height*3/4,steps-1);
        rules(x_center+width/4,y_center,width/2,scale_height*3/4,steps-1);

    }


}
