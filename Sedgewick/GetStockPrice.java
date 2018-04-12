public class GetStockPrice {
    public static void main(String[] args){
        System.out.println(get_price(args[0]));
    }
    public static double get_price(String stock){
        In stockpage = new In("https://finance.yahoo.com/quote/"+stock+"?ltr=1");
        String in = stockpage.readAll();
        //price required is as follows: "\"currentPrice\":{\"raw\":1007.04,\"fmt\":\"1,007.04\"}" when the price is 1007.04
        int curr_price_index = in.indexOf("\"currentPrice\":{\"raw\":");
        int formatted_price_index = in.indexOf(",\"fmt\":",curr_price_index);
        //StdOut.printf("The indices are %d,%d\n",curr_price_index,formatted_price_index);
        String price_string = in.substring(curr_price_index+22,formatted_price_index);
        double price = Double.parseDouble(price_string);
        return price;
    }
}
