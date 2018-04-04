public class NumHellos {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        for(int i =1;i<=num;i++){
            String helloi = "This is the ";
            if((i%100)/10!=1){
                if(i%10 == 1){helloi = helloi + i + "st Hello.";}
                else if(i%10 == 2){helloi = helloi + i + "nd Hello.";}
                else if(i%10 == 3){helloi = helloi + i + "rd Hello.";}
                else {helloi = helloi + i + "th Hello.";}
            } else{
                helloi = helloi + i + "th Hello.";
            }
            System.out.println(helloi);
        }
    }
}
