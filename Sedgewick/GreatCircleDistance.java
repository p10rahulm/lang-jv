public class GreatCircleDistance {
    public static void main(String[] args){
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        double d = great_circle_distance_nautical_miles(x1,y1,x2,y2);
        System.out.println("Great Circle Distance (in nautical miles) = " + d);
    }
    public static double great_circle_distance_nautical_miles(double latitude_1,double longitude_1,double latitude_2,double longitude_2){
        double d = 60*Math.toDegrees(Math.acos(Math.sin(Math.toRadians(latitude_1))*Math.sin(Math.toRadians(latitude_2)) +
                Math.cos(Math.toRadians(latitude_1))*Math.cos(Math.toRadians(latitude_2))*Math.cos(Math.toRadians(longitude_1-longitude_2))));
        return d;
    }
    public static double great_circle_distance_km(double latitude_1,double longitude_1,double latitude_2,double longitude_2){
        double d = 1.852*60*Math.toDegrees(Math.acos(Math.sin(Math.toRadians(latitude_1))*Math.sin(Math.toRadians(latitude_2)) +
                Math.cos(Math.toRadians(latitude_1))*Math.cos(Math.toRadians(latitude_2))*Math.cos(Math.toRadians(longitude_1-longitude_2))));
        return d;
    }
    public static double great_circle_distance_miles(double latitude_1,double longitude_1,double latitude_2,double longitude_2){
        double d = 1.15078*60*Math.toDegrees(Math.acos(Math.sin(Math.toRadians(latitude_1))*Math.sin(Math.toRadians(latitude_2)) +
                Math.cos(Math.toRadians(latitude_1))*Math.cos(Math.toRadians(latitude_2))*Math.cos(Math.toRadians(longitude_1-longitude_2))));
        return d;
    }
}
