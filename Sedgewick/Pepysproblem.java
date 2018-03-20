public class Pepysproblem {
    public static void main(String args[]){
        int numtrials = Integer.parseInt(args[0]);
        int counter_sixthrowsatleastonce = 0;
        for(int i =0;i<numtrials;i++){
            if(findnum_throwdicentimes(6,1,6))            {counter_sixthrowsatleastonce++;}
        }
        double p = (double)counter_sixthrowsatleastonce/numtrials;
        System.out.println("Probability for atleast 1 six when throwing die 6 times = " + p);
        int counter_twelvethrowsatleasttwice = 0;
        for(int i =0;i<numtrials;i++){
            if(findnum_throwdicentimes(6,2,12))            {counter_twelvethrowsatleasttwice++;}
        }
        p = (double)counter_twelvethrowsatleasttwice/numtrials;
        System.out.println("Probability for atleast 2 sixes when throwing die 12 times = " + p);

    }
    private static boolean findnum_throwdicentimes(int num, int numtimes,int ndice){
        int throwdice;
        int countedthrow = 0;
        for(int i =0;i<ndice;i++){
            throwdice = (int) (Math.random()*6) + 1;
            if(throwdice==num){countedthrow++;}
            if(countedthrow==numtimes)return(true);
        }
        return(false);
    }
}
