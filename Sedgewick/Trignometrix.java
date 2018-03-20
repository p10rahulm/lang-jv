public class Trignometrix {
    public static double sinx(double x){
        double sum=0,currentsum=x;
        for(int i = 2;sum!=sum+currentsum;i=i+2){
            sum +=currentsum;
            currentsum*=-x*x/((i+1)*i);
            //System.out.println(currentsum);
        }
        return(sum);
    }



    public static double cosx(double x){
        double sum=1,currentsum=-x*x/2,epsilon=1e-10;
        for(int i = 2;sum!=sum+currentsum;i+=2){
            sum +=currentsum;
            currentsum*=-x*x/((i+2)*(i+1));
            //System.out.println(currentsum);
        }
        return(sum);
    }
    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);

        System.out.println("sin(x) = " + sinx(x));
        System.out.println("cos(x) = " + cosx(x));
    }
}
