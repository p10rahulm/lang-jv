public class Marsaglia_SpherePoint {
    public static void main(String[] args){
        /*Marsaglia's method: Pick a random point (a,b) in (note,can be inside) a unit disk. From this point, you can get a point on the surface of the sphere using some formulas.
        we will get (a,b) based on conversion from polar coordinates. In particular from (r,theta) where r  belongs to [0,1] and theta belongs to [0,2pi)
        */
        double r = Math.random();
        double theta = 2*Math.PI*Math.random();
        double a = r*Math.sin(theta);
        double b = r*Math.cos(theta);
        double x = 2*a*Math.sqrt(1-a*a-b*b);
        double y = 2*b*Math.sqrt(1-a*a-b*b);
        double z = 1-2*(a*a + b*b);
        System.out.println("(x,y,z) = ("+ x+", "+y+", "+z+")");
        double sum = Math.pow(x,2) +Math.pow(y,2)+Math.pow(z,2);
        System.out.println("(x^2+y^2+z^2) = " + sum);

    }
}
