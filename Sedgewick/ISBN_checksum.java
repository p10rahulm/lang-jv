//java ISBN_checksum 123456784
public class ISBN_checksum {
    public static void main(String[] args){
        print_first_digit(args[0]);
        StdOut.print(check_valid_isbn("123-456-7849"));

    }
    public static boolean check_valid_isbn(String isbn){
        /*int num_digits=0,total = 0;
        String pattern= "^[0-9]+$";
        for (int i = 0; i < isbn.length(); i++) {
            if(isbn.substring(i,i+1).matches(pattern)){
                num_digits++;
                total+=(10-i)*Integer.parseInt(isbn.substring(i,i+1));
            }
        }
        if(num_digits==10&&total%11==0){
            return true;
        }else {
            return false;
        }*/

        //Another method!
        isbn = isbn.replaceAll("\\D+","");
        if(isbn.length()!=10)return false;
        int total = 0;
        for (int i = 0; i < isbn.length(); i++) {
            total+=(isbn.charAt(i)-'0')*(10-i);
        }
        if(total%11==0)return true;
        return false;
    }
    public static void print_first_digit(String input_str){
        if(input_str.length()!=9){
            System.out.println("Please enter a 9 digit string");
            return;
        }
        int input = Integer.parseInt(input_str);
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
