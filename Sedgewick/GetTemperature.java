//Google doesn't allow. Says forbidden 403 htm.

@Deprecated
class GetTemperature_Google {
    public static void main(String[] args){
        StdOut.println(get_temperature("koramangala"));
    }
    public static double get_temperature(String location){
        //String link =   "https://www.google.co.in/search?q=weather+"+location;
        String link =      "https://www.google.co.in/search?q=weather+koramangala";
        In temperature = new In(link);
        String pagecontents = temperature.readAll();
        int index_start = pagecontents.indexOf("<span class=\"wob_t\" id=\"wob_tm\" style=\"display:inline\">");
        int index_end = pagecontents.indexOf("</span>",index_start);
        double temprt = Double.parseDouble(pagecontents.substring(index_start+56,index_end));
        return temprt;
    }

}
