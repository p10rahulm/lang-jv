// test client:
// $>java CompareDocuments 5 10000 < data/documents/documents.txt
public class Document {
    public final String id;
    public final Vector profile;
    public Document(String name, int length_of_ngram,int vector_dimension){
        this.id = name;
        String s = (new In(name)).readAll();
        int numchars = s.length();
        double[] freq = new double[vector_dimension];
        for (int i = 0; i < numchars-length_of_ngram; i++) {
            String subtext = s.substring(i,i+length_of_ngram);
            int h = ((subtext.hashCode()+vector_dimension)%vector_dimension);
            freq[h]++;
        }
        profile = (new Vector(freq)).direction();
    }
    public double similarity_score(Document b){
        return profile.dot(b.profile);
    }
    public String toString(){
        return id;
    }
    public String get_name(){
        return id;
    }

}
