public class BinarytoString {
    /*
    public static void main(String[] args){
        String s = "";
        int number = Integer.parseInt(args[0]);
        int currentdivisor = 1;
        int currentnumber = number;
        while(currentdivisor*2<=currentnumber)currentdivisor*=2;
        while(currentdivisor!=0){
            if(currentnumber/currentdivisor==1){
                s+='1';
                currentnumber-=currentdivisor;
            }
            else s+='0';
            currentdivisor/=2;
        }
        System.out.println(s);


    }
    */
    //Alternative version using stringbuilder below
    public static void main(String[] args){
        StringBuilder s = new StringBuilder();
        int number = Integer.parseInt(args[0]);
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
