public class BooleanOps {
    public static boolean all(boolean[] input){
        for(int i =0;i<input.length;i++){
            if(!input[i]) {return(false);}
        }
        return(true);
    }
    public static boolean any(boolean[] input){
        for(int i =0;i<input.length;i++){
            if(input[i]) {return(true);}
        }
        return(false);
    }
}
