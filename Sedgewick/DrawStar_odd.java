public class DrawStar_odd {
    public static void main(String[] args){
        /*
        int numsides = Integer.parseInt(args[0]);
        if(numsides%2==0){
            throw new ArithmeticException("Please enter even number of digits");
        }
         */
        for (int i = 1; i < 5; i++) {
            drawStar(64*i+1);
        }


    }
    public static void drawStar(int n){
        StdDraw.clear();
        Turtle OddStar = new Turtle(0.5,0,Math.PI*(1.0-1.0/n)/2);
        for (int i = 0; i < n; i++) {
            OddStar.forward(1);
            OddStar.turn_left(Math.PI*(1.0-1.0/n));
        }
        StdDraw.save("stars/star_"+n+".jpg");
    }
}
