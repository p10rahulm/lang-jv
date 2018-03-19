public class convert_to_polar {
    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double theta = Math.atan2(y,x);
        double r = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        System.out.println("theta = "+ theta + ", r = " + r);

    }
}
