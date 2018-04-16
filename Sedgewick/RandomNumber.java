public class RandomNumber {
    public long last;
    private final long a = 3141592621L;
    private final long b = 2718281829L;
    public RandomNumber(int seed){
        last = a*seed+b;
    }
    public RandomNumber(){
        last = 0;
        int rem = 42;
        last = (a*last+b)%42;
    }
    public int nextInt(int maxint){
        last = (last*a+b)%maxint;
        return (int) last;
    }
    public static void main(String[] args){
        RandomNumber r = new RandomNumber();
        StdOut.println(r.nextInt(100));
        StdOut.println(r.nextInt(100));
        StdOut.println(r.nextInt(100));
        StdOut.println(r.nextInt(100));
        StdOut.println(r.nextInt(1000));
        StdOut.println(r.nextInt(2));
        StdOut.println(r.nextInt(2));
        StdOut.println(r.nextInt(2));
        StdOut.println(r.nextInt(2));
    }

}
