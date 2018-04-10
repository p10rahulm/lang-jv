//java MergeFilestoCSV data/stocks/djia_Date.txt data/stocks/djia_Close.txt data/stocks/djia_Volume.txt data/stocks/djia_Merged_file.csv
// check the speed of above!

public class MergeFilestoCSV {
    public static void main(String[] args){
        String[] filenames = new String[args.length-1];
        for (int i = 0; i < args.length-1; i++) {
            filenames[i] = args[i];
        }
        String outfilename = args[args.length-1];
        Out outfile = new Out(outfilename);
        In[] infiles = new In[filenames.length];
        for (int i = 0; i < infiles.length; i++) {
            infiles[i] = new In(filenames[i]);
        }
        while(!infiles[0].isEmpty()){
            for(int i =0;i<infiles.length-1;i++){
                String s = infiles[i].readLine();
                outfile.print(s+",");
            }
            outfile.print(infiles[infiles.length-1].readLine());
            outfile.print("\n");
        }
        closefiles(infiles,outfile);
    }
    private static void closefiles(In[] infiles, Out outfile){
        for (int i = 0; i < infiles.length; i++) {
            infiles[i].close();
        }
        outfile.close();
    }
}
