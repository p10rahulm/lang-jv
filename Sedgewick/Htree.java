public class Htree {
    public static void drawHtree(int n, double half_size, double x_center, double y_center){
        if(n==0)return;
        double x0 = x_center-half_size/2,x1 = x_center+half_size/2;
        double y0 = y_center-half_size/2,y1 = y_center+half_size/2;
        StdDraw.line(x0,y_center,x1,y_center);
        StdDraw.line(x0,y0,x0,y1);
        StdDraw.line(x1,y0,x1,y1);
        drawHtree(n-1,half_size/2,x0,y0);
        drawHtree(n-1,half_size/2,x0,y1);
        drawHtree(n-1,half_size/2,x1,y0);
        drawHtree(n-1,half_size/2,x1,y1);
    }
    public static void drawHtriangle(int n, double half_size, double x_center, double y_center){
        if(n==0)return;
        double x0 = x_center-half_size/2,x1 = x_center+half_size/2;
        double y0 = y_center-half_size/2,y1 = y_center+half_size/2;
        StdDraw.line(x_center,y_center,x0,y0);
        StdDraw.line(x_center,y_center,x0,y1);
        StdDraw.line(x_center,y_center,x1,y0);
        StdDraw.line(x_center,y_center,x1,y1);
        drawHtriangle(n-1,half_size/2,x0,y0);
        drawHtriangle(n-1,half_size/2,x0,y1);
        drawHtriangle(n-1,half_size/2,x1,y0);
        drawHtriangle(n-1,half_size/2,x1,y1);
    }
    public static void drawHtriangle2(int n, double half_size, double x_center, double y_center){
        if(n==0)return;
        double x0 = x_center-half_size/2,x1 = x_center+half_size/2;
        double y0 = y_center-half_size/2,y1 = y_center+half_size/2;
        StdDraw.line(x_center,y_center,(x_center+x0)/2,(y_center+y0)/2);
        StdDraw.line(x_center,y_center,(x_center+x0)/2,(y_center+y1)/2);
        StdDraw.line(x_center,y_center,(x_center+x1)/2,(y_center+y0)/2);
        StdDraw.line(x_center,y_center,(x_center+x1)/2,(y_center+y1)/2);
        drawHtriangle2(n-1,half_size/2,x0,y_center);
        drawHtriangle2(n-1,half_size/2,x1,y_center);
        drawHtriangle2(n-1,half_size/2,x_center,y0);
        drawHtriangle2(n-1,half_size/2,x_center,y1);
    }

    public static void drawHcircle(int n, double half_size, double x_center, double y_center){
        if(n==0)return;
        double x0 = x_center-half_size/2,x1 = x_center+half_size/2;
        double y0 = y_center-half_size/2,y1 = y_center+half_size/2;
        StdDraw.circle(x_center,y_center,half_size);
        StdDraw.circle(x0,y_center,half_size/2);
        StdDraw.circle(x1,y_center,half_size/2);
        drawHcircle(n-1,half_size/2,x0,y0);
        drawHcircle(n-1,half_size/2,x0,y1);
        drawHcircle(n-1,half_size/2,x1,y0);
        drawHcircle(n-1,half_size/2,x1,y1);
    }
    public static void drawHcircle_end(int n, double half_size, double x_center, double y_center){
        if(n==0)return;
        double x0 = x_center-half_size/2,x1 = x_center+half_size/2;
        double y0 = y_center-half_size/2,y1 = y_center+half_size/2;
        if(n==1) {
            StdDraw.circle(x_center, y_center, half_size);
            StdDraw.circle(x0, y_center, half_size / 2);
            StdDraw.circle(x1, y_center, half_size / 2);
        }
        drawHcircle_end(n-1,half_size/2,x0,y0);
        drawHcircle_end(n-1,half_size/2,x0,y1);
        drawHcircle_end(n-1,half_size/2,x1,y0);
        drawHcircle_end(n-1,half_size/2,x1,y1);
    }
    public static void drawHtriangle_halves(int n, double half_size, double x_center, double y_center){
        if(n==0)return;
        double x0 = x_center-half_size/2,x1 = x_center+half_size/2;
        double y0 = y_center-half_size/2,y1 = y_center+half_size/2;
        if(n%2==0){
            StdDraw.line(x_center,y_center,x0,y0);
            StdDraw.line(x_center,y_center,x1,y1);
        } else{
            StdDraw.line(x_center,y_center,x0,y1);
            StdDraw.line(x_center,y_center,x1,y0);
        }
        drawHtriangle_halves(n-1,half_size/2,x0,y0);
        drawHtriangle_halves(n-1,half_size/2,x0,y1);
        drawHtriangle_halves(n-1,half_size/2,x1,y0);
        drawHtriangle_halves(n-1,half_size/2,x1,y1);
    }
    public static void main(String[] args){
        for (int n = 0; n < 3;n++) {
            drawHtree(n,0.5,0.5,0.5);
            StdDraw.save("RecursiveFractals/Htree_"+n+".png");
            StdOut.println("saved"+"RecursiveFractals/Htree_"+n+".png");
        }
        StdDraw.clear();
        for (int n = 0; n < 3;n++) {
            drawHcircle(n,0.5,0.5,0.5);
            StdDraw.save("RecursiveFractals/Hcircle_"+n+".png");
            StdOut.println("saved"+"RecursiveFractals/Hcircle_"+n+".png");
        }

        for (int n = 0; n < 3;n++) {

            drawHcircle_end(n,0.5,0.5,0.5);
            StdDraw.save("RecursiveFractals/Hcircle_end_"+n+".png");
            StdOut.println("saved"+"RecursiveFractals/Hcircle_end_"+n+".png");
        }
        StdDraw.clear();
        for (int n = 0; n < 3;n++) {
            StdDraw.clear();
            drawHtriangle(n,0.5,0.5,0.5);
            StdDraw.save("RecursiveFractals/Htriangle_"+n+".png");
            StdOut.println("saved"+"RecursiveFractals/Htriangle_"+n+".png");
        }
        StdDraw.clear();
        for (int n = 0; n < 3;n++) {
            StdDraw.clear();
            drawHtriangle_halves(n,0.5,0.5,0.5);
            StdDraw.save("RecursiveFractals/Htriangle_halves_"+n+".png");
            StdOut.println("saved"+"RecursiveFractals/Htriangle_halves_"+n+".png");
        }
        StdDraw.clear();
        for (int n = 0; n < 7;n++) {
            StdDraw.clear();
            drawHtriangle2(n,0.5,0.5,0.5);
            StdDraw.save("RecursiveFractals/Hdiag_"+n+".png");
            StdOut.println("saved"+"RecursiveFractals/Hdiag_"+n+".png");
        }




    }
}
