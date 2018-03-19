public class StdGaussian {
    public static void main(String[] args){
        double v = Math.random();
        double u = Math.random();
        double w = Math.sin(2*Math.PI*v)*Math.sqrt(-2*Math.log(u));
        System.out.println(w);

    }
}
