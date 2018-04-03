public class Harmonic {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        double harmonic_n = H_small(n);
        System.out.println("H" + n +" = "+harmonic_n);
        System.out.println("Recursive H" + n +" = "+H_recursive(n));
    }
    public static double H_recursive(int n){
        if(n==1){return 1;}
        return(1.0/n+H_recursive(n-1));
    }

    public static double H_small(int n){
        double harmonic_n = 0;
        for(int i =1;i<=n;i++){
            harmonic_n += 1.0/i;
        }
        return harmonic_n;
    }
}
