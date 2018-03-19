public class FactorIntegers {
    public static void main(String[] args){
        long n = Long.parseLong(args[0]);
        int i = 2;
        while(i<=n/i){
            if(n%i==0) {
                n=n/i;
                System.out.print(i+ " ");
            }
            //else {i+=1;System.out.println("i = "+i + ", n = "+n);}
            else i+=1;
        }
        System.out.print(n);
    }
}
