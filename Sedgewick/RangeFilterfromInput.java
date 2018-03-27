// Usage: Type all numbers separated by a space or by enters. Everytime you press enter the filter displays output
// Use Ctrl + Z when you want to end.
public class RangeFilterfromInput {
    public static void main(String[] args){
        int range1 = Integer.parseInt(args[0]);
        int range2 = Integer.parseInt(args[1]);
        int lo,hi;
        if(range1<range2){lo = range1;hi=range2;} else {lo = range2;hi=range1;}
        System.out.println("lo = "+lo+", hi = "+hi);
        while(!StdIn.isEmpty()){
            double num = StdIn.readDouble();
            if(num>=lo&&num<=hi){
                System.out.print(num+", ");
            }

        }
        System.out.print("\b");
        // backspace out the last comma and space
        System.out.println();
    }
}
