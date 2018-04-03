public class GCD_Euclid {
    public static void main(String[] args){
        int input1 = Integer.parseInt(args[0]);
        int input2 = Integer.parseInt(args[1]);
        System.out.println(gcd_iter(input1,input2));
    }
    public static int gcd_iter(int input1, int input2){
        if(input1%input2 ==0)return(input2);
        if(input2%input1 ==0)return(input1);
        if(input1>input2) return gcd_iter(input1%input2,input2);
        if(input2>input1) return gcd_iter(input2%input1,input1);
        return 0;
    }

    public static long gcd_iter(long input1, long input2) {
        if(input1%input2 ==0)return(input2);
        if(input2%input1 ==0)return(input1);
        if(input1>input2) return gcd_iter(input1%input2,input2);
        if(input2>input1) return gcd_iter(input2%input1,input1);
        return 0;
    }
}
