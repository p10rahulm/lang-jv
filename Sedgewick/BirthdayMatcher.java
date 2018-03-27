public class BirthdayMatcher {
    public static void main(String[] args){
        int numtrials = Integer.parseInt(args[0]);
        int totalsteps = 0,maxsteps = 0;
        for(int i =0; i<numtrials;i++){
            int steps =0;boolean nomatch=true;
            boolean[] birthdays_sofar = new boolean[365];
            while(nomatch){
                int birthday = (int) (Math.random() * 365);
                if(birthdays_sofar[birthday]){
                    nomatch = false;
                } else{
                    birthdays_sofar[birthday] = true;
                }
                steps++;
            }
            totalsteps += steps;
            if(steps>maxsteps){maxsteps=steps;}
        }
        System.out.println("average number of people entering = " + ((double)totalsteps/numtrials));
        System.out.println("Maximum number of people entering = " + ((double)maxsteps));
    }
}
