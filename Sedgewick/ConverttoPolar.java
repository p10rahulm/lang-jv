public class ConverttoPolar {
    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double[] r_theta = convert_to_polar(x,y);
        double r = r_theta[0];
        double theta = r_theta[1];

        System.out.println("theta = "+ theta + ", r = " + r);
    }
    public static double[] convert_to_polar(double x,double y){
        double[] output = new double[2];
        output[0] = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        output[1] = Math.atan2(y,x);
        return output;
    }

}
