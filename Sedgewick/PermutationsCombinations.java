import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermutationsCombinations {
    public static void main(String[] args){
        String[] input_array = new String[]{"a","b","c","d","e","f"};
        check_permutations(input_array);
        check_combinations(input_array);


    }
    public static void check_combinations(String[] input_array){
        // Permutations was a tough problem, combinations should be much easier.
        // I'm going to iterate over all numbers till 2^n (not including 2^n).
        // Each numbers binary representation tells us whether the corresponding (binary) digit element exists or not from our output.
        // We filter for only certain number of 1s in the binary representation through a bit counter, for combinations with k elements.
        int n =32;
        StdOut.println("The number of bits in n = "+n+" = " + MMath.bitcounter(n));



    }

    public static void check_permutations(String[] input_array){
        ArrayList<String[]> output = new ArrayList<String[]>();
        permute(input_array,output,input_array.length,0);
        System.out.println("The number of permutations of all = "+ output.size());

        output = new ArrayList<String[]>();
        permute(input_array,output,2,0);
        System.out.println("The number of permutations of 2 elements from 6 = "+ output.size());

        output = new ArrayList<String[]>();
        permute(input_array,output,3,0);
        System.out.println("The number of permutations of 3 elements from 6 = "+ output.size());

        timing();
    }


    public static ArrayList<String[]> permute(String[] str_array,ArrayList<String[]> output_Arraylist,int levels_to_permute,int current_permuted_levels){
        if(current_permuted_levels==levels_to_permute){
            String[] out = new String[levels_to_permute];
            for (int i = 0; i < levels_to_permute; i++) {
                out[i]=str_array[i];
            }
            output_Arraylist.add(out);
            return output_Arraylist;
        } else {
            for (int i = current_permuted_levels; i < str_array.length; i++) {
                swap(str_array,current_permuted_levels,i);
                permute(str_array,output_Arraylist,levels_to_permute,current_permuted_levels+1);
                //swap_back for the next loop
                swap(str_array,current_permuted_levels,i);
            }
        }
        return output_Arraylist;
    }
    public static void swap(String[] array,int x,int y){
        String temp = array[x];
        array[x]=array[y];
        array[y] = temp;
        return;
    }

    private static void timing(){
        //Swap Method
        long startTime = System.nanoTime();
        String[] input_array = new String[]{"a","b","c","d","e","f"};
        ArrayList<String[]> output = new ArrayList<String[]>();
        permute(input_array,output,input_array.length,0);
        //System.out.println("The number of permutations of all = "+ output.size());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("permute 6 elements from 6 "+duration/1000+"Mu.s");

        //Partial Permutes using above method
        startTime = System.nanoTime();
        output = new ArrayList<String[]>();
        permute(input_array,output,2,0);
        //System.out.println("The number of permutations of 2 elements from 6 = "+ output.size());
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("permute 2 elements from 6 "+duration/1000000+"Mu.s");


        //Set method
        startTime = System.nanoTime();
        String[] b = new String[]{"a","b","c","d","e","f"};
        permute_array(b);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("permute_array(String) took "+duration/1000000+"ms");
    }
    public static ArrayList<String> permute_array(String[] arr){
        Set<String> currentnums = new HashSet<String>();
        for (int i = 0; i < arr.length; i++) {currentnums.add(arr[i]);}
        ArrayList<String> permutations = new ArrayList<String>();
        recurse_nums(currentnums,"",permutations);
        return permutations;
    }
    public static ArrayList<String> recurse_nums(Set<String> currentnums, String currentstring, ArrayList<String> list_of_permutes){
        if(currentnums.size()==1){
            String elem = currentnums.iterator().next();
            list_of_permutes.add(currentstring + elem);
            return list_of_permutes;
        }
        for(String a:currentnums){
            String newstring = currentstring + a;
            HashSet<String> newnums = new HashSet<>();
            newnums.addAll(currentnums);
            newnums.remove(a);
            recurse_nums(newnums, newstring,list_of_permutes);
        }
        return list_of_permutes;
    }

}
