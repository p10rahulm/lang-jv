// outputs (cos(t) + cost(2t)+...+cos(nt))/n
public class FourierSpikes {
    public static void main(String[] args){
        int n =Integer.parseInt(args[0]);
        int spaces = 500;
        double[] fourierspikes = new double[spaces];
        double[] angles = new double[spaces];
        for(int i =0;i<spaces;i++){
            angles[i] = (double)(i-(int)(spaces/2))/(spaces/4)*(Math.PI);
            for(int j =0;j<n;j++){
                fourierspikes[i]+=Math.cos(angles[i]*j);
            }
            fourierspikes[i]/=(double)n;
        }
        PlotFunction.plot_function(angles,fourierspikes,false,0.001);
    }
}
