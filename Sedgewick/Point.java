public class Point {
    public final double x, y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(x,y) = ("+x+","+y+")";
    }
    public double euclidean_distance_to(Point A){
        return Math.sqrt((x-A.x)*(x-A.x)+(y-A.y)*(y-A.y));
    }
    public static void main(String[] args){
        Point A = new Point(1,1);
        Point B = new Point(0,0);
        StdOut.println(A.euclidean_distance_to(B));
    }

}
