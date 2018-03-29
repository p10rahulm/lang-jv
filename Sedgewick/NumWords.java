import java.util.regex.Pattern;
import java.util.Scanner;

public class NumWords {
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    private static final Pattern EMPTY_PATTERN = Pattern.compile("");

    public static void main(String[] args){
        int numwords =0;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            try {
                sc.useDelimiter(WHITESPACE_PATTERN);
                String a = sc.next();
                numwords += 1;
                //StdOut.print("newword: <a= " + a + ", numwords = " + numwords + ">, ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        StdOut.println("The number of words is " + numwords);

    }
}
