public class distance_from_origin {
    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double d = Math.pow(x*x+y*y,0.5);
        System.out.println("distance from origin = " + d);
    }
}
