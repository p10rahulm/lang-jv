//java Music_Random_Generator 100 0.125 | java Music
public class Music_Random_Generator {
    public static void main(String[] args){
        double duration = Double.parseDouble(args[0]); //in seconds
        double beat_time = Double.parseDouble(args[1]);
        int[] major_pitches = new int[22];
        double[] probabilities = new double[22];
        double[] times = new double[]{beat_time,beat_time/2,beat_time*2,beat_time/4};
        double[] prob_times = new double[]{0.5,0.75,0.9,1};

        int[] major_scale = new int[]{0, 2, 4, 5, 7, 9, 11};
        major_pitches[0] = -100;
        probabilities[0] = 0.15;
        for (int i =0;i<21;i++){
            if((i+1)/7==0) {
                major_pitches[i+1]=major_scale[i%7];
            } else
            if((i+1)/7==1){
                major_pitches[i+1]=major_scale[i%7]-12;
            } else if((i+1)/7==2){
                major_pitches[i+1]=major_scale[i%7]+12;
            }

        }
        double sumprob=0;
        for (int i =1;i<22;i++){
            double p = (double)1/(i+1);
            probabilities[i] = p;
            sumprob+=p;
        }
        for (int i =0;i<22;i++){probabilities[i] /= sumprob;}
        for (int i =1;i<22;i++){probabilities[i] += probabilities[i-1];}
        double trandom = Math.random();
        int duratn_rounder;
        for (duratn_rounder = 0; duratn_rounder < 3 && prob_times[duratn_rounder] <= trandom; duratn_rounder++) {}
        double time_so_far = 0;
        //VectorOps.printvector(major_pitches);
        while(times[duratn_rounder]+time_so_far<duration) {
            double prandom = Math.random();
            int pitch_rounder;
            for (pitch_rounder = 0; pitch_rounder < 22 && probabilities[pitch_rounder] <= prandom; pitch_rounder++) {
            }

            System.out.println(major_pitches[pitch_rounder] + " " + times[duratn_rounder]);
            time_so_far+=times[duratn_rounder];
            trandom = Math.random();
            for (duratn_rounder = 0; duratn_rounder < 3 && prob_times[duratn_rounder] <= trandom; duratn_rounder++) {}

        }

    }
}
