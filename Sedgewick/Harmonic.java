public class Harmonic {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        double answer = 0;
        for(int i =1;i<=n;i++){
            answer += 1.0/i;
        }
        System.out.println("H" + n +" = "+answer);
    }
}
