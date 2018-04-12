import java.math.BigInteger;

public class CheckRounding {
    public static void main(String[] args){
        System.out.println(6.023e23);
        System.out.println(Math.round(6.023e23));
        Double p = 6.023e23;
        System.out.println(p);
        //BigInteger p = 602300000000000000000000;
        // above won't compile
        //System.out.println(p);

    }
}

