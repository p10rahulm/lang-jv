import java.util.*;

public class PermutationsCombinations2 {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        StdOut.println(permute_till_n(6));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("permute_till_n took "+duration/1000000+"ms");



        startTime = System.nanoTime();
        int[] a = new int[]{1,2,3,4,5,6};
        StdOut.println(permute_array(a));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("permute_array took "+duration/1000000+"ms");

        startTime = System.nanoTime();
        String[] b = new String[]{"a","b","c","d","e","f"};
        StdOut.println(permute_array(b));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("permute_array(String) took "+duration/1000000+"ms");


        startTime = System.nanoTime();
        String str = "abcdef";
        int n = str.length();
        permute(str, 0, n-1);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("swapping method took "+duration/1000000+"ms");


    }

    public static ArrayList permute_array(int[] arr){
        // permute all the numbers till n,
        // ie if we have n = 3, output should be [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        // or correspondingly with 0 1 2

        // Hmm this looks like a decently hard problem.
        Set<Integer> currentnums = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {currentnums.add(arr[i]);}
        ArrayList permutations = new ArrayList();
        recurse_nums(currentnums,"",permutations);
        return permutations;
    }
    public static ArrayList permute_array(String[] arr){
        HashSet<String> currentnums = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {currentnums.add(arr[i]);}
        ArrayList permutations = new ArrayList();
        recurse_nums(currentnums,"",permutations);
        return permutations;
    }
    public static ArrayList permute_till_n(int n){
        Set<Integer> currentnums = new HashSet<>();
        for (int i = 0; i < n; i++) {currentnums.add(i+1);}
        ArrayList permutations = new ArrayList();
        recurse_nums(currentnums,"",permutations);
        return permutations;
    }
    public static ArrayList recurse_nums(Set<Integer> currentnums, String currentstring, ArrayList list_of_permutes){
        if(currentnums.size()==1){
            int elem = currentnums.iterator().next();
            list_of_permutes.add(currentstring + Integer.toString(elem));
            return list_of_permutes;
        }
        for(int a:currentnums){
            String newstring = currentstring + a;
            Set<Integer> newnums = new HashSet<>();
            newnums.addAll(currentnums);
            newnums.remove(a);
            recurse_nums(newnums, newstring,list_of_permutes);
        }
        return list_of_permutes;
    }
    public static ArrayList recurse_nums(HashSet<String> currentnums, String currentstring, ArrayList list_of_permutes){
        if(currentnums.size()==1){
            //StdOut.println("in1");
            String elem = currentnums.iterator().next();
            //StdOut.println(currentstring + elem);
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

    private static void permute(String str, int l, int r) {
        /**
         * permutation function
         * @param str string to calculate permutation for
         * @param l starting index
         * @param r end index
         */
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
    public static String swap(String a, int i, int j){
        /**
         * Swap Characters at position
         * @param a string value
         * @param i position 1
         * @param j position 2
         * @return swapped string
         */
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }




}
