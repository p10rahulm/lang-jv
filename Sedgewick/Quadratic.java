public class Quadratic {
    public static void main(String[] args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        if(a==0){
            System.out.println("root1 = "+b/c);
        }
        else {
            double discriminant = b * b - 4 * a * c;
            double root1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a);
            double root2 = (-b - Math.pow(discriminant, 0.5)) / (2 * a);
            System.out.println("root1 = " + root1);
            System.out.println("root2 = " + root2);
        }

    }
}
