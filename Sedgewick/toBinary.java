public class toBinary {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        int base = 2; //Integer.parseInt(args[1]);
        int v = 1;
        while(v<=num/base){
            v = v*base;
        }
        int n = num;
        while(v>0){
            if(n<v)System.out.print(0);
            else{
                System.out.print(1);
                n -=v;
            }
            v = v/base;
        }
        System.out.println();
    }
}
