public class Randomwalk2d_Hitedge {
    public static void main(String[] args){
        int size = Integer.parseInt(args[0]);
        int x=0,y = 0,steps=0;
        double random;
        while(Math.abs(x)<size&&Math.abs(y)<size){
            random = Math.random();
            if(random<=0.25)x-=1;
            else if(random<=0.5)y-=1;
            else if(random<=0.75)x+=1;
            else y+=1;
            steps+=1;
        }
        System.out.println(steps);
    }
}
