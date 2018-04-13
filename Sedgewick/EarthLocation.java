//represents lat and long
public class EarthLocation {
    private final double latitude,longitude;
    public EarthLocation(double lat,double lon){
        this.latitude = lat;
        this.longitude = lon;
    }
    public double distance_in_km(EarthLocation place){
        double dist = GreatCircleDistance.great_circle_distance_km(this.latitude,this.longitude,place.latitude,place.longitude);
        return dist;
    }
    public double distance_in_miles(EarthLocation place){
        double dist = GreatCircleDistance.great_circle_distance_miles(this.latitude,this.longitude,place.latitude,place.longitude);
        return dist;
    }
    public double distance_in_nautical_miles(EarthLocation place){
        double dist = GreatCircleDistance.great_circle_distance_nautical_miles(this.latitude,this.longitude,place.latitude,place.longitude);
        return dist;
    }

    public static void main(String[] args){
        EarthLocation NYC = new EarthLocation(40.7128,74.0060);
        EarthLocation SanFran = new EarthLocation(37.7749,122.4194);
        EarthLocation Bangalore = new EarthLocation(12.9716,-77.5946);
        EarthLocation London = new EarthLocation(51.5074,+0.1278);
        //Bangalore
        StdOut.println(Bangalore.distance_in_km(London));
        StdOut.println(Bangalore.distance_in_km(NYC));
        StdOut.println(Bangalore.distance_in_km(SanFran));


        //London
        StdOut.println(London.distance_in_km(NYC));
        StdOut.println(London.distance_in_km(SanFran));

        //USA
        StdOut.println(NYC.distance_in_km(SanFran));

    }
}
