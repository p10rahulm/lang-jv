public class Rumor_pass {
    public static void main(String[] args){
        int num_people = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int num_times_everyoneheard=0,total_num_people_heard=0;
        for(int i=0;i<trials;i++){
            boolean[] heard_before = new boolean[num_people-1];
            heard_before[0] = true;
            boolean repeat_hearing = false;
            int num_people_heard = 1, previous = 0,myself =0;
            while(num_people_heard != (num_people-1) && !repeat_hearing){
                int next_rand = (int) (Math.random() * (num_people-1));
                if(myself==next_rand)continue;
                if(previous==next_rand)continue;
                if(heard_before[next_rand]){
                    repeat_hearing=true;
                } else{
                    heard_before[next_rand] = true;
                    num_people_heard+=1;
                }
                previous = myself;
                myself = next_rand;
            }
            if(num_people_heard==(num_people -1)){
                num_times_everyoneheard+=1;
            }
            total_num_people_heard+=num_people_heard;
        }
        double prob_everyone_hearing = (double) num_times_everyoneheard / trials;
        double expected_people_hearing = (double) total_num_people_heard / trials;
        System.out.println("total probability of everyone hearing = " + prob_everyone_hearing);
        System.out.println("expected number of people hearing = " + expected_people_hearing);
    }
}
