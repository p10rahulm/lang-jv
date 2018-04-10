//java SafePassword acbgh1213A#
public class SafePassword {
    public static void main(String[] args){
        String password = args[0];
        StdOut.println(is_safe_password(password));
    }
    public static boolean is_safe_password(String s){
        if(s.length()<8) return false;
        String upper_case_pattern = "(.*)[A-Z]+(.*)+";
        boolean ContainsUpperCase = s.matches(upper_case_pattern);
        String numericpattern = "(.*)[0-9]+(.*)+";
        boolean ContainsNumeric = s.matches(numericpattern);
        String lower_case_pattern = "(.*)[a-z]+(.*)+";
        boolean ContainsLowerCase = s.matches(lower_case_pattern);
        String notalphanumeric_pattern = "(.*)[^A-Za-z0-9]+(.*)+";
        boolean ContainsNonAN = s.matches(notalphanumeric_pattern);
        return ContainsUpperCase&&ContainsNumeric&&ContainsLowerCase&&ContainsNonAN;
    }
}
