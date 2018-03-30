//java Music < data/elise.txt
public class Music {
    public static int SAMPLING_RATE = 44100;
    public static void main(String[] args){
        while(!StdIn.isEmpty()){
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            instrument(pitch,duration);
        }
        System.exit(0);
    }
    public static void instrument(int pitch, double duration){

        double[] freq = new double[10];
        double[] power = new double[10];

        freq[0] = 440 * Math.pow(2, pitch / 12.0);
        power[0] = 1;
        for(int i = 1;i<10;i++){
            freq[i] = freq[0]*(i+1);
        }

        for(int i = 1;i<10;i++){
            power[i] = power[0]/(4*i+1);
        }
        double attenuation_c = 1000;
        double[] audio = fourier_et_al(freq,power,duration*2,attenuation_c);
        StdAudio.play(audio);


    }
    private static double[] fourier_et_al(double[] freq,double[] power,double duration,double attenuation_c){
        int audio_length = (int)(duration*SAMPLING_RATE);
        double[] audio = new double [audio_length];
        double[]coeff = new double[freq.length];
        for(int i =0;i<freq.length;i++) {
            coeff[i] = 2 * Math.PI * freq[i] / SAMPLING_RATE;
        }
        for (int j = 0; j < audio_length; j++) {
            for(int i =0;i<freq.length;i++) {
                /* sin(2*Math.PI*t/T); T = (sampling_rate/freq)
                audio[j] = power[i]*Math.sin(coeff[i] * j);
                Let's introduce attenuation*/
                //below sounds like a guitar which is being damped at attenuation_c of 100
                //audio[j] += power[i]*Math.sin(coeff[i] * j)*Math.pow(2,(double)(-j/attenuation_c));
                //below sounds like violin
                //audio[j] += power[i]*Math.sin(coeff[i] * j)*(double)j/SAMPLING_RATE;
                //audio[j] += power[i]*Math.sin(coeff[i] * j)*(double)j/attenuation_c;
                //below sounds like violin, but maybe more natural than above as there is attenuation as well
                audio[j] += power[i]*Math.sin(coeff[i] * j)*(audio_length/2 - Math.abs(audio_length/2 - j))/attenuation_c;
            }
        }
        return(audio);
    }


}
