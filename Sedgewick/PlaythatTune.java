public class PlaythatTune {

    public static void main(String[] args){

        int sampling_rate = 44100;
        while(!StdIn.isEmpty()){
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double freq = 440 * Math.pow(2, pitch / 12.0);
            /*System.out.println(freq);
            freq = 440 * Math.pow(2, pitch / 12); // wow such a large difference on changing 12.0 to 12!
            System.out.println(freq);*/

            int audio_length = (int)(duration*sampling_rate);
            double[] audio = new double [audio_length];

            //audio is sin(2*Math.PI*t/T); T = (sampling_rate/freq); Other than t everythign is fixed
            double coeff =  2*Math.PI*freq/sampling_rate;
            for(int i =0;i<audio_length;i++){
                audio[i] = Math.sin(coeff * i); //sin(2*Math.PI*t/T); T = (sampling_rate/freq)
            }
            StdAudio.play(audio);

        }
        System.exit(0);

    }
}
