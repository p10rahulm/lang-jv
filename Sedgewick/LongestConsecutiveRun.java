public class LongestConsecutiveRun {
    public static void main(String[] args){
        int longest_run = 0;
        int longest_num = Integer.MIN_VALUE;
        int current = longest_num,previous,current_run_length=0,current_run_num=current;
        while(!StdIn.isEmpty()){
            previous = current;
            current = StdIn.readInt();
            if(current==previous){
                current_run_length+=1;
            } else {
                current_run_length=1;
                current_run_num=current;
            }
            if(current_run_length>longest_run){
                longest_run = current_run_length;
                longest_num = current_run_num;
            }

        }
        StdOut.printf("Longest Run: %d consecutive %d\n",longest_run,longest_num);
    }
}
