public class GoldenFibonacci {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        int temp,f=0, g=1;
        double golden=1.0;
        for(int i =0;i<=num;i++){
            System.out.println(f);
            temp = f;f=f+g;g=temp;
            if(g>1){golden = (double) f/g;}
            System.out.println("Golden Ratio Estimate: " + golden);
        }
    }
}
