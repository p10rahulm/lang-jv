public class InternetLinks {
    public static void main(String[] args){
        String s = "http://www.yoyoma.com";
        StdOut.printf("The string %s is %sa link.\n",s,(islink(s)?"":"not "));
        s = "http://www.google.com/q?s=hi%20hello";
        StdOut.println(get_domain_type(s));
        s = "cs.iitm.ac.in";
        StdOut.println(reverse_domain(s));

    }
    public static String reverse_domain(String domain){
        StringBuilder s = new StringBuilder("");
        int dot_index = domain.lastIndexOf('.');
        while(dot_index>0){
            dot_index = domain.lastIndexOf('.');
            s.append(domain.substring(dot_index+1));
            if(dot_index>0){
                s.append(".");
                domain = domain.substring(0,dot_index);
            }
        }
        return s.toString();
    }
    public static String get_domain_type(String s){
        int forward_slash_index = s.indexOf('/',8);
        String subst = s.substring(0,forward_slash_index);
        int dot_index = s.lastIndexOf('.');
        return subst.substring(dot_index+1);
    }
    public static boolean islink(String s){
        return s.startsWith("http://")&&(s.contains(".com")||s.contains(".edu")||s.contains(".org")||s.contains(".in"));
    }

}
