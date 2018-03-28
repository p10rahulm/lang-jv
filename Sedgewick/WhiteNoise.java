// White Noise
public class WhiteNoise {
    public  static void main(String[] args){
        double total_seconds = 10.0;
        int sampling_rate = 44100; //samples per second
        //Let's play major C
        int freq = 440;
        int N = (int) (total_seconds*sampling_rate);
        double[] audio = new double[N];
        for(int i =0;i<N;i++){
            audio[i] = Math.random(); //sin(2*PI*t/T) where t is time in seconds and T is time period. T = sampling_rate/freq
        }
        StdAudio.play(audio);
    }
}
