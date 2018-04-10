//java VisualizeAudio < data/elise.txt
public class VisualizeAudio {
    public static int sampling_rate = 44100;
    public static void main(String[] args){

        while(!StdIn.isEmpty()){
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double freq = 440 * Math.pow(2, pitch / 12.0);
            {
                // Animation part
                StdDraw.clear();
                int plotted = (int) (0.005*sampling_rate);
                double[] y = new double[plotted];
                double coeff = 2*Math.PI/(sampling_rate/freq);
                for(int t=0;t<plotted;t++){
                    y[t]=Math.sin(coeff*t);
                }
                StdDraw.setYscale(-1,1);
                StdDraw.setXscale(0,plotted );
                for (int t =1;t<plotted;t++) {
                    StdDraw.setPenRadius(0.01);
                    StdDraw.point(t-1,y[t-1]);
                    //StdDraw.setPenRadius(0.005);
                    //StdDraw.line(t-1,y[t-1],t,y[t]);
                }
                StdDraw.pause((int)(duration*1000));
            }


            {
                // Audio part
                int audio_length = (int)(duration*sampling_rate);
                double[] audio = new double [audio_length];

                double coeff =  2*Math.PI*freq/sampling_rate;
                for(int i =0;i<audio_length;i++){
                    audio[i] = Math.sin(coeff * i); //sin(2*Math.PI*t/T); T = (sampling_rate/freq)
                }
                StdAudio.play(audio);
            }

        }
        System.exit(0);

    }
}
