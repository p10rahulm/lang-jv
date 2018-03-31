public class TilePatterns {
    public static void main(String[] args){
        for(int i =0;i<6;i++){
            for(int j=0;j<6;j++){
                if((i+j)%2==1){
                    draw_my_tile(((double)1/12+(double)i/6),((double)1/12+(double)j/6),(double)1/12 );
                }
            }
        }
        for(int i =0;i<6;i++){
            for(int j=0;j<6;j++){

                    draw_my_tile(((double)1/12+(double)i/6),((double)1/12+(double)j/6),(double)1/12 );

            }
        }
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(0.5,0.5,0.5);
        for(int i =0;i<6;i++){
            for(int j=0;j<6;j++){
                if ((i + j) % 2==1) {
                    draw_my_tile2(((double)1/12+(double)i/6),((double)1/12+(double)j/6),(double)1/12 );
                }
            }
        }
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(0.5,0.5,0.5);
        for(int i =0;i<6;i++){
            for(int j=0;j<6;j++){
                if ((i + j) % 2==1) {
                    draw_my_tile2(((double)1/12+(double)i/6),((double)1/12+(double)j/6),(double)1/12 );
                }
            }
        }
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(0.5,0.5,0.5);
        for(int i =0;i<6;i++){
            for(int j=0;j<6;j++){
                if ((i + j) % 2==1) {
                    draw_my_tile3(((double)1/12+(double)i/6),((double)1/12+(double)j/6),(double)1/12 );
                }
            }
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(0.5,0.5,0.5);
        for(int i =0;i<6;i++){
            for(int j=0;j<6;j++){
                if ((i + j) % 2==0) {
                    draw_my_tile3(((double)1/12+(double)i/6),((double)1/12+(double)j/6),(double)1/12 );
                }
            }
        }
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.filledSquare(0.5,0.5,0.5);
        for(int i =0;i<6;i++){
            for(int j=0;j<6;j++){
                if ((i + j) % 2==1) {
                    draw_my_tile4(((double)1/12+(double)i/6),((double)1/12+(double)j/6),(double)1/12 );
                }
            }
        }

    }
    public static void draw_my_tile4(double x_center,double y_center,double half_size){
        //StdOut.println("x_center = "+ x_center+", y_center = "+y_center+", half_size = "+half_size);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(x_center,y_center,half_size);


        //Smaller Squares
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x_center-3*half_size/4,y_center-3*half_size/4,half_size/4);
        StdDraw.filledSquare(x_center+3*half_size/4,y_center-3*half_size/4,half_size/4);
        StdDraw.filledSquare(x_center+3*half_size/4,y_center+3*half_size/4,half_size/4);
        StdDraw.filledSquare(x_center-3*half_size/4,y_center+3*half_size/4,half_size/4);
    }
    public static void draw_my_tile3(double x_center,double y_center,double half_size){
        //StdOut.println("x_center = "+ x_center+", y_center = "+y_center+", half_size = "+half_size);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(x_center,y_center,half_size);


        //Smaller Squares
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.filledSquare(x_center-3*half_size/4,y_center-3*half_size/4,half_size/4);
        StdDraw.filledSquare(x_center+3*half_size/4,y_center-3*half_size/4,half_size/4);
        StdDraw.filledSquare(x_center+3*half_size/4,y_center+3*half_size/4,half_size/4);
        StdDraw.filledSquare(x_center-3*half_size/4,y_center+3*half_size/4,half_size/4);

        //Center Square
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] x = {x_center-half_size,x_center,x_center+half_size,x_center};
        double[] y = {y_center,y_center-half_size,y_center,y_center+half_size};
        StdDraw.filledPolygon(x,y);
    }

    public static void draw_my_tile2(double x_center,double y_center,double half_size){
        //StdOut.println("x_center = "+ x_center+", y_center = "+y_center+", half_size = "+half_size);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(x_center,y_center,half_size);


        //Smaller Squares
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        double[] x1 = {x_center-half_size,x_center-half_size/2,x_center,x_center-half_size/2};
        double[] y1 = {y_center-half_size/2,y_center-half_size,y_center-half_size/2,y_center};
        StdDraw.filledPolygon(x1,y1);
        double[] x2 = {x_center+half_size,x_center+half_size/2,x_center,x_center+half_size/2};
        double[] y2 = {y_center-half_size/2,y_center-half_size,y_center-half_size/2,y_center};
        StdDraw.filledPolygon(x2,y2);
        double[] x3 = {x_center+half_size,x_center+half_size/2,x_center,x_center+half_size/2};
        double[] y3 = {y_center+half_size/2,y_center+half_size,y_center+half_size/2,y_center};
        StdDraw.filledPolygon(x3,y3);
        double[] x4 = {x_center-half_size,x_center-half_size/2,x_center,x_center-half_size/2};
        double[] y4 = {y_center+half_size/2,y_center+half_size,y_center+half_size/2,y_center};
        StdDraw.filledPolygon(x4,y4);

        //Center Square
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        double[] x = {x_center-half_size,x_center,x_center+half_size,x_center};
        double[] y = {y_center,y_center-half_size,y_center,y_center+half_size};
        StdDraw.filledPolygon(x,y);
    }
    public static void draw_my_tile(double x_center,double y_center,double half_size){
        //StdOut.println("x_center = "+ x_center+", y_center = "+y_center+", half_size = "+half_size);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(x_center,y_center,half_size);

        StdDraw.setPenColor(StdDraw.GRAY);
        double[] x = {x_center-half_size,x_center,x_center+half_size,x_center};
        double[] y = {y_center,y_center-half_size,y_center,y_center+half_size};
        StdDraw.filledPolygon(x,y);
        //Triangles
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] x1 = {x_center-half_size,x_center-half_size/2,x_center-half_size/2};
        double[] y1 = {y_center-half_size/2,y_center-half_size/2,y_center-half_size};
        StdDraw.filledPolygon(x1,y1);
        double[] x2 = {x_center+half_size,x_center+half_size/2,x_center+half_size/2};
        double[] y2 = {y_center-half_size/2,y_center-half_size/2,y_center-half_size};
        StdDraw.filledPolygon(x2,y2);
        double[] x3 = {x_center+half_size,x_center+half_size/2,x_center+half_size/2};
        double[] y3 = {y_center+half_size/2,y_center+half_size/2,y_center+half_size};
        StdDraw.filledPolygon(x3,y3);
        double[] x4 = {x_center-half_size,x_center-half_size/2,x_center-half_size/2};
        double[] y4 = {y_center+half_size/2,y_center+half_size/2,y_center+half_size};
        StdDraw.filledPolygon(x4,y4);
    }
}
