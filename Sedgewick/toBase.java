public class toBase {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        int base = Integer.parseInt(args[1]);
        int v = 1;
        while(v<=num/base){
            v = v*base;
        }
        int n = num;
        while(v>0){
            if(n<v)System.out.print(0);
            else{
                System.out.print(n/v);
                //n -= (int)(n/v) * v;
                // Above i got warning that casting (n/v) into int is redundant so another try below
                n -= (n/v) * v;
            }
            v = v/base;
        }
        System.out.println();
    }
}
