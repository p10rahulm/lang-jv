
public class DragonCurves_basic {
    public static void main(String[] args){
        String D1 = "F";
        String D2 = D1 + "L" + StringMethods.reverse_string(D1.replace("R","X").replace("L","R").replace("X","L"));
        String D3 = D2 + "L" + StringMethods.reverse_string(D2.replace("R","X").replace("L","R").replace("X","L"));
        String D4 = D3 + "L" + StringMethods.reverse_string(D3.replace("R","X").replace("L","R").replace("X","L"));
        String D5 = D4 + "L" + StringMethods.reverse_string(D4.replace("R","X").replace("L","R").replace("X","L"));
        System.out.println(D1);
        System.out.println(D2);
        System.out.println(D3);
        System.out.println(D4);
        System.out.println(D5);

    }
    /*
    private static String reverse(String source){
        int i, len = source.length();
        StringBuilder dest = new StringBuilder(len);
        for (i = (len - 1); i >= 0; i--){
            dest.append(source.charAt(i));
        }
        return dest.toString();
    }*/
}

