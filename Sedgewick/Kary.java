public class Kary {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        int base = Integer.parseInt(args[1]);
        int asciichar;
        int divisor = 1;
        while(divisor<=num/base){
            divisor = divisor*base;
        }
        int current_num = num;
        while(divisor>0){
            if(current_num<divisor)System.out.print(0);
            else{
                if(current_num/divisor>9){
                    asciichar = current_num/divisor +55;
                    System.out.print((char) asciichar);
                } else {
                    System.out.print(current_num/divisor);
                }
                current_num -= (current_num/divisor) * divisor;
            }
            divisor = divisor/base;
        }
        System.out.println();
    }
}
