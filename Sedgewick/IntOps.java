public class IntOps {
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int mul = a*b;
        int quo = a/b;
        int rem = a%b;
        System.out.println(a + " * " + b +" = "+ mul);
        System.out.println(a + " / " + b +" = "+ quo);
        System.out.println(a + " % " + b +" = "+ rem);
        System.out.println(a + " = "+ quo+ " * " + b+ " + "+ rem);
    }
}
