public class Music_Random {
    public static void main(String[] args){
        int duration = Integer.parseInt(args[0]); //in seconds
        double beat_time = Double.parseDouble(args[1]);
        double[] major_pitches = new double[24];
        double[] probabilities = new double[24];
        double[] times = new double[]{beat_time,beat_time/2,beat_time*2,beat_time/4};
        double[] prob_times = new double[]{0.7,0.2,0.05,0.05};

        double[] major_scale = new double[]{0, 2, 4, 5, 7, 9, 11};
        for (int i =0;i<24;i++){
            if(i/8==0) {
                major_pitches[i]=major_scale[i%8];
            } else
            if(i/8==1){
                major_pitches[i]=major_scale[i%8]-1212;
            } else if(i/8==2){
                major_pitches[i]=major_scale[i%8]+12;
            }

        }
        double sumprob=0;
        for (int i =0;i<24;i++){
            double p = 1/(i+1);
            probabilities[i] = p;
            sumprob+=p;
        }
        for (int i =0;i<24;i++){
            probabilities[i] /= sumprob;
        }




    }
}
