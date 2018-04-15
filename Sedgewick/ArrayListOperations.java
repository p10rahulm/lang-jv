import java.text.DecimalFormat;
import java.util.ArrayList;

public class ArrayListOperations {
    public static String print_arraylist(ArrayList<Double> list){
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            double a = list.get(i);
            s.append(a+",");
        }
        //s.deleteCharAt(s.length()-1);
        s.replace(s.length()-1,s.length(),"]");
        StdOut.println(s);
        return s.toString();
    }
    public static void print_ArrayListString(ArrayList<String> list){
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i);
            s.append(a+",");
        }
        //s.deleteCharAt(s.length()-1);
        s.replace(s.length()-1,s.length(),"]");
        StdOut.println(s);
        return;
    }
    public static String print_arraylist(ArrayList<Double> list,int numdecmals){
        DecimalFormat d = new DecimalFormat();
        d.setMaximumFractionDigits(numdecmals);
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            double a = list.get(i);
            s.append(d.format(a)+",");
        }
        //s.deleteCharAt(s.length()-1);
        s.replace(s.length()-1,s.length(),"]");
        StdOut.println(s);
        return s.toString();
    }
}
