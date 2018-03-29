public class PlayWaveFile {
    public static void main(String[] args){
        double rate = Double.parseDouble(args[1]);
        String filename = args[0];
        double[] a = StdAudio.read(filename);
        double[] b = new double[(int) (rate*a.length)];
        int b_runner=0,a_runner=0;
        while(b_runner<=(b.length-1)&&a_runner<=(a.length-1)) {
            if (b_runner == (int) (a_runner * rate)) {
                b[b_runner] = a[a_runner];
                a_runner++;
                b_runner++;
            } else if (rate > 1) {
                    b[b_runner] = a[a_runner];
                    b_runner++;
            } else {
                    a_runner++;
            }
        }
        StdAudio.play(b);
        }
}
