public class MultiplyRecursively {
    public static int multiply (int a , int b){
        if(b==0)return 0;
        if(b%2==0)return multiply(a+a,b/2);
        return (multiply(a+a,b/2)+a);

    }
    public static void main(String[] args){
        System.out.println(multiply(2,25));
        System.out.println(multiply(2,2));
        System.out.println(multiply(2,16));
        System.out.println(multiply(2,15));
        System.out.println(multiply(2,17));
        System.out.println(multiply(3,11));
        System.out.println(multiply(317,873));

    }
}
