public class DivisorPattern {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        for(int i= 1;i<=n;i++){
            System.out.print(i);
            for(int j =1;j<=n;j++){
                if(j%i==0 || i%j ==0) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
