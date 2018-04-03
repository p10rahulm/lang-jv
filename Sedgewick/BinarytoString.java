/*$> java BinarytoString 221342

110110000010011110
tobinary2 took 1ms
110110000010011110
tobin2 took 0ms
110110000010011110
tobin took 40ms
110110000010011110
tobinary1 took 14ms
110110000010011110
tobinrecursive took 20ms

 */
public class BinarytoString {

    public static void main(String[] args){
        int number = Integer.parseInt(args[0]);
        //
        long startTime = System.nanoTime();
        tobinary2(number);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("tobinary2 took "+duration/1000000+"ms");
        startTime = System.nanoTime();
        tobin2(number);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("tobin2 took "+duration/1000000+"ms");
        startTime = System.nanoTime();
        tobin(number);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("tobin took "+duration/1000000+"ms");

        startTime = System.nanoTime();
        tobinary1(number);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("tobinary1 took "+duration/1000000+"ms");
        startTime = System.nanoTime();
        System.out.println(tobinrecursive(number));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("tobinrecursive took "+duration/1000000+"ms");
    }
    public static String tobinrecursive(int num){
        if(num==0||num==1)return(Integer.toString(num));
        return (tobinrecursive(num/2)+Integer.toString(num%2));
    }

    public static void tobin(int num){
        String s ="";
        for(int n = num; n > 0; n /= 2){s= n%2+s;}
        System.out.println(s);
    }
    public static void tobin2(int num){
        StringBuilder s = new StringBuilder();
        //See below carefully. Think it's a brilliant method
        for(int n = num; n > 0; n /= 2){
            s.append(n%2);
        }
        String out = s.reverse().toString();
        System.out.println(out);
    }

    public static void tobinary1(int num){
        String s = "";
        int currentdivisor = 1;
        int currentnumber = num;
        while(currentdivisor*2<=currentnumber)currentdivisor*=2;
        while(currentdivisor!=0){
            if(currentnumber/currentdivisor==1){
                s+="1";
                currentnumber-=currentdivisor;
            }
            else s+="0";
            currentdivisor/=2;
        }
        System.out.println(s);
    }
    //Alternative version using stringbuilder below
    public static void tobinary2(int number){
        StringBuilder s = new StringBuilder();
        int currentdivisor = 1;
        int currentnumber = number;
        while(currentdivisor*2<=currentnumber)currentdivisor*=2;
        while(currentdivisor!=0){
            if(currentnumber/currentdivisor==1){
                s.append("1");
                currentnumber-=currentdivisor;
            }
            else s.append("0");
            currentdivisor/=2;
        }
        String out = s.toString();
        System.out.println(out);
    }
}
