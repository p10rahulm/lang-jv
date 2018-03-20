public class RamanujamNumbers {
    public static void main(String[] args){
        int max_num = Integer.parseInt(args[0]);
        int max_num_thirdroot = (int) Math.pow(max_num,0.333) + 1;
        int a,b,c,d,ramanujams_number;
        //System.out.println(max_num_thirdroot);
        for(a = 1;a<=max_num_thirdroot;a++){
            for(c=a+1;c<=max_num_thirdroot;c++){
                for(d=c+1;d<=max_num_thirdroot;d++){
                    for(b=d+1;b<=max_num_thirdroot;b++){
                        // Debugging Print
                        // System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
                        if(Math.pow(a,3)+Math.pow(b,3)==Math.pow(c,3)+Math.pow(d,3)) {
                            ramanujams_number = (int) (Math.pow(c,3)+Math.pow(d,3));
                            System.out.println(ramanujams_number);
                        }
                    }
                }
            }
        }

    }
}
