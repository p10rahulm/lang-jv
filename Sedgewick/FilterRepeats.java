//Go out by pressing ctrl+Z in a new window in windows;
public class FilterRepeats {
    public static void main(String[] args){
        int current=Integer.MIN_VALUE,previous;
        while(!StdIn.isEmpty()){
            previous = current;
            current = StdIn.readInt();
            if(current!=previous){System.out.print(current + " ");}
        }
    }
}

