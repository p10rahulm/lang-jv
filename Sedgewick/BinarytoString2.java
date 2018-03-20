public class BinarytoString2 {
    /*public static void main(String[] args){
        String s ="";

        int input = Integer.parseInt(args[0]);
        //See below carefully. Think it's a brilliant method
        for(int n = input; n > 0; n /= 2){
            s= n%2+s;
        }
        System.out.println(s);
    }*/
    // Alternative version using stringbuilder
    public static void main(String[] args){
        StringBuilder s = new StringBuilder();
        int input = Integer.parseInt(args[0]);
        //See below carefully. Think it's a brilliant method
        for(int n = input; n > 0; n /= 2){
            s.append(n%2);
        }
        String out = s.reverse().toString();
        System.out.println(out);
    }
}
