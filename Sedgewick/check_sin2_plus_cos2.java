public class check_sin2_plus_cos2 {
    public static void main(String[] args){
        double  a = Math.pow(Math.sin(Double.parseDouble(args[0])),2);
        double  b = Math.pow(Math.cos(Double.parseDouble(args[0])),2);
        System.out.println(a+b);
        // Some print output checks
        System.out.println(2 + "bc");
        System.out.println(2 + 3 + "bc");
        System.out.println((2+3) + "bc");
        System.out.println("bc"+(2+3));
        System.out.println("bc"+2+3);
        }
}
