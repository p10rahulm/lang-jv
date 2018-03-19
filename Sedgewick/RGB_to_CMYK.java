public class RGB_to_CMYK {
    public static void main(String[] args){
        double r = Double.parseDouble(args[0]);
        double g = Double.parseDouble(args[1]);
        double b = Double.parseDouble(args[2]);
        double w = Math.max(r/255, Math.max(g/255,b/255));
        double c = 1-r/w/255;
        double m = 1-g/w/255;
        double y = 1-b/w/255;
        double k = 1-w;
        System.out.println("c = " + c + ", m = " + m + ", y = " + y + ", k = " + k);
    }
}
