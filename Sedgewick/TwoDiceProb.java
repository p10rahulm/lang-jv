public class TwoDiceProb {
    public static void main(String[] args){
        double[] dist = new double[12];
        for(int i =0;i<6;i++){
            for(int j =0;j<6;j++){
                dist[i+j]+=1;
            }
        }
        for(int i =0;i<dist.length;i++){
            dist[i] /=36;
        }
        double[] two_dice_throws = new double[12];
        int n = Integer.parseInt(args[0]);
        int sumoftwodice;
        for(int i =0;i<n;i++){
            sumoftwodice = (int)(Math.random()*6)+(int)(Math.random()*6);
            two_dice_throws[sumoftwodice]+=1;
        }
        for(int i =0;i<dist.length;i++){
            two_dice_throws[i] /=n;
        }
        VectorOps.printvector(dist);
        //System.out.println(Arrays.toString(dist));
        VectorOps.printvector(two_dice_throws);
        //System.out.println(Arrays.toString(two_dice_throws));
        double euclidean_distance = VectorOps.euclidean_distance(two_dice_throws,dist);
        System.out.println(euclidean_distance);
    }
}
//java TwoDiceProb 100000
//makes the outputs match to ~3 decimals