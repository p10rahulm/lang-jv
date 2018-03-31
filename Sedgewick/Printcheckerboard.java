public class Printcheckerboard {
    public static void main(String[] args){
        int size = Integer.parseInt(args[0]);
        System.out.print(" ");
        for(int i=0;i<size;i++){
            System.out.print(" - ");
        }
        System.out.println();
        for(int i=0;i<size;i++){
            System.out.print("|");
            for(int j=0;j<size;j++){
                if((i+j)%2==0)System.out.print(" x ");
                else System.out.print("   ");
            }
            System.out.println("|");
        }
        System.out.print(" ");
        for(int i=0;i<size;i++){
            System.out.print(" - ");
        }
    }
}
