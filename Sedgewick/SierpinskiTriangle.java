public class SierpinskiTriangle {
    public static void main(String[] args){
        draw_Sierpinski_Triangle(100000,0.002);
    }
    public static void draw_Sierpinski_Triangle(int n, double penradius){
        double[] triangle_x = {0,1,0.5};
        double[] triangle_y = {0,0,Math.sqrt(3)/2};
        double current_x = 0, current_y=0;
        StdDraw.setPenRadius(penradius);
        for(int i =0;i<n;i++){
            StdDraw.point(current_x,current_y);
            int r = (int) (Math.random()*3);
            current_x=(current_x+triangle_x[r])/2;
            current_y=(current_y+triangle_y[r])/2;
        }
    }
}
