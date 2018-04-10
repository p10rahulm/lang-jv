public class VisualizeSound {
    public static void main(String[] args){
        double[] audio = StdAudio.read(args[0]);
        VectorOps.printvector(audio);
    }
}
