public class FindMissingValue_1toN {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        boolean[] filled = new boolean[n];
        int unfilled;
        for(int i =0;i<n-1;i++){
            int a = StdIn.readInt();
            filled[a] = true;
        }
        int i;
        for(i=0;i<n&&filled[i];i++){}
        System.out.println("The missing number is " + i);
        
    }
}
