public class ISBN_checksum {
    public static void main(String[] args){
        if(args[0].length()!=9){
            System.out.println("Please enter a 9 digit string");
            return;
        }
        int input = Integer.parseInt(args[0]);
        int sumsofar = 0;
        for(int i =1;i<=9;i++){
            sumsofar = sumsofar + (i+1)*(input%10);
            input/=10;
        }
        int first_digit;
        for(first_digit =0;(sumsofar+first_digit)%11!=0;first_digit++){}

        System.out.println(first_digit);
    }
}
