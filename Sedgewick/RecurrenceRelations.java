public class RecurrenceRelations {
    public static void main(String[] args){
        for (int i = 0; i < 8; i++) {
            int n = MMath.twopower(i);
            StdOut.println(i);
            StdOut.println(n);
            StdOut.println("nby2plusone = "+nby2plusone(n));
            StdOut.println("twonby2plusone = "+twonby2plusone(n));
            StdOut.println("twonby2plusn = "+twonby2plusn(n));
            StdOut.println("fournby2plus3 = "+fournby2plus3(n));
        }
    }
    public static int nby2plusone(int n){
        if(n<=1)return 1;
        return (1+nby2plusone(n/2));
        //i+1
    }
    public static int twonby2plusone(int n){
        if(n<=1)return 1;
        return (1+2*twonby2plusone(n/2));
        //2^(n+1)-1
    }
    public static int twonby2plusn(int n){
        if(n<=1)return 1;
        return (n+2*twonby2plusn(n/2));
        //2^(i)*(i+1)
    }
    public static int fournby2plus3(int n){
        if(n<=1)return 1;
        return (3+4*fournby2plus3(n/2));
        //2^(2i+1)-1
    }
}
