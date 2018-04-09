//concatenates all files into the last file in the String args
//$> java CatFiles data/GenomeTiny.txt data/GenomeVirus.txt data/Genomes_both.txt
public class CatFiles {
    public static void main(String[] args){
        Out out = new Out(args[args.length-1]);
        for (int i = 0; i < args.length-1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
        }
    }
}
