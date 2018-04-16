
/*
 * ************************************************************************
 *  *
 *  * CodeFRA India
 *  * __________________
 *  *
 *  *  Copyright (c) 2018 : Code for Research Applications
 *  *  All Rights Reserved.
 *  *
 *  *  This file is part of JavaLang which is released under GPL.
 *  *  See license in adjoining project for full details.
 *  *  Please visit: https://www.codefra.in
 *  * /
 */

//java CompareDocuments 5 10000 < data/documents/documents.txt

public class CompareDocuments {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        String[] filenames = StdIn.readAllStrings();
        int n = filenames.length;

        //Create Documents
        Document[] documents = new Document[n];
        for (int i = 0; i < n; i++) {
            documents[i] = new Document(filenames[i], k, d);
        }

        // print header
        StdOut.printf("%8s"," ");
        for (int i = 0; i < n; i++) {
            String p = filenames[i].substring(filenames[i].lastIndexOf("/")+1,filenames[i].length());
            StdOut.printf("%12.8s", p);
        }
        StdOut.println();

        // print n-by-n table
        for (int i = 0; i < n; i++) {
            String p = filenames[i].substring(filenames[i].lastIndexOf("/")+1,filenames[i].length());
            StdOut.printf("%.8s", p);
            for (int j = 0; j < n; j++) {
                StdOut.printf("%12.2f", documents[i].similarity_score(documents[j]));
            }
            StdOut.println();
        }
    }
}