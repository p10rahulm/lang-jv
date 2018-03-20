public class DisprovingEulersConjecture {
    public static void main(String[] args){
        long max_num = Long.parseLong(args[0]);
        long max_checked = (long) Math.pow(max_num/4,0.2) + 1;
        long max_rhs_checked = (long) Math.pow(max_num,0.2) + 1;
        System.out.println(max_num);
        System.out.println(max_rhs_checked);
        System.out.println(max_checked);
        long lhssum,rhssum;
        for(int a =1;a<max_checked;a++){
            for(int b = a+1;b<max_checked;b++){
                for(int c =b+1;c<max_checked;c++){
                    for(int d =c+1;d<max_checked;d++){
                        for(int e =d+1;e<max_checked;e++){
                            lhssum = (long)(Math.pow(a,5)+Math.pow(b,5)+Math.pow(c,5)+Math.pow(d,5));
                            rhssum = (long)(Math.pow(e,5));
                            if(lhssum==rhssum){
                                System.out.println("a = "+ a +", b = "+ b +", c = "+ c+", d  = "+ d+", e = "+ e+", sum = "+ rhssum);
                            }
                        }
                    }
                }
            }
        }
    }
}
// One may receive output at java DisprovingEulersConjecture 300000000000