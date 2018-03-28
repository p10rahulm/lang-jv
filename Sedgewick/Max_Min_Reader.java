
public class Max_Min_Reader {
    public static void main(String[] args){
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        while(!StdIn.isEmpty()){
            int a=StdIn.readInt();
            if(a<0){StdOut.println("Please enter a number greater than 0."); continue;}
            if(a>max){                max=a;            }
            if(a<min){                min=a;            }

        }
        System.out.println("max = "+max+", min = " +min);
    }
    public static void main2(String[] args){
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        while(!StdIn.isEmpty()){
            int a=StdIn.readInt();
            if(a>max){                max=a;            }
            if(a<min){                min=a;            }

        }
        System.out.println("max = "+max+", min = " +min);
    }
}
