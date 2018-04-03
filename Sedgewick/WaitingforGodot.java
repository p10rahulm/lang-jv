//This class is dedicated to the immensity of samuel beckett (who's play "waiting for godot" dodo performed).
// He also wrote a novel called quad. Quad has a quirk.
// Adjoining scenes have one change in actors. ie either any actor enters, or one of the actors on stage exits
// No 2 sets of actors across all the scenes are ever the same.
// The number of permutations of 4 actors s 2^4 = 16 scenes (each actor can be there or not in a scene)
// But the interesting question is how to order these 16?
public class WaitingforGodot {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        boolean[][] gray_codes = gray_codes(n);
        MatrixOps.print_matrix(gray_codes);
        for (int i = 1; i < gray_codes.length; i++) {
            String mymove = say_move(gray_codes[i],gray_codes[i-1]);
            StdOut.println(mymove);
        }

    }
    public static String say_move(boolean[] step1,boolean[] step0){
        String a = "";
        for (int i = 0; i < step1.length; i++) {
            if(step1[i] ^ step0[i]){
                a = "Actor "+(step1.length-i)+" has moved ";
                if(step1[i]){a = a+"in";} else{a = a+"out";}
            }
        }
        return a;
    }


    public static boolean[][] gray_codes(int n){
        if(n==1){
            return new boolean[][]{{false},{true}} ;
        }
        boolean[][] out = new boolean[MMath.twopower(n)][n];
        boolean[][] sub = gray_codes(n-1);
        for(int i=0;i<MMath.twopower(n);i++) {
            out[i][0] = !(i < MMath.twopower(n - 1));
        }
        for(int i=0;i < MMath.twopower(n-1);i++){
            for (int j = 1; j < n; j++) {
                out[i][j] = sub[i][j-1];
            }
        }
        int nsubrows = MMath.twopower(n-1);
        StdOut.println(nsubrows);
        for(int i=0;i < MMath.twopower(n-1);i++){
            for (int j = 1; j < n; j++) {
                out[MMath.twopower(n-1)+i][j] = sub[nsubrows-1-i][j-1];
            }
        }
        return out;
    }
}
