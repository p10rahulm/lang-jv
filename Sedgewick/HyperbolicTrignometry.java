public class HyperbolicTrignometry {
    public static double sinh(double theta){
        return((Math.exp(theta)-Math.exp(-theta))/2);
    }
    public static double cosh(double theta){
        return((Math.exp(theta)+Math.exp(-theta))/2);
    }
    public static double tanh(double theta){
        return(sinh(theta)/cosh(theta));
    }
    public static double coth(double theta){
        return(cosh(theta)/sinh(theta));
    }
    public static double sech(double theta){
        return(1.0/cosh(theta));
    }
    public static double cosech(double theta){
        return(1.0/sinh(theta));
    }
}
