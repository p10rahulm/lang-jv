public class Counter implements Comparable<Counter>{
    private final String name;
    private final int max;
    private int count;

    public Counter(String name, int max) {
        this.name = name;
        this.max = max;
        this.count =0;
    }
    public int compareTo(Counter b){
        if(count<b.count)return -1;
        if(count>b.count)return 1;
        return 0;
    }
    public void increment(){
        if(count<max){count+=1;}
    }
    public int value(){
        return count;
    }
    public String toString(){
        return name+ " : "+count;
    }
    public static void main(String[] args){
        int n = 6;
        int t = 10000;
        Counter[] hits = new Counter[n];
        for (int i = 0; i < n; i++) {
            hits[i] = new Counter("candidate "+i + " votes",t);
        }
        for (int i = 0; i < t; i++) {
            hits[Random.uniform(n)].increment();
        }
        for (int i = 0; i < n; i++) {
            StdOut.println(hits[i]);
        }


    }
}
