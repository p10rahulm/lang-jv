// we will get the temperature by scraping https://weather.com/en-IN/weather/today/l/INXX0202:1:IN based on the codes in https://weather.codes/india/
// Thus we get temperature given city name
// $>java GetTemperature Bangalore
// $>java GetTemperature Chennai

public class GetTemperature {
    public static void main(String[] args){
        String city_name = args[0];
        try {
            String city_code = get_city_code(city_name);
            String temperature = get_city_temp(city_code);
            StdOut.println(temperature);
        } catch (Exception e) {
            StdOut.println(e.getMessage());
            StdOut.println("Please try with another city name in India. For ex: Bangalore or Chennai");

        }

    }
    public static String get_city_temp(String city_code){
        In weathercom = new In("https://weather.com/en-IN/weather/today/l/" + city_code+":1:IN");
        String weatherpage = weathercom.readAll();
        int temp_start = weatherpage.indexOf("<div class=\"today_nowcard-temp\"><span class=\"\">")+47;
        int temp_close = weatherpage.indexOf("<sup>",temp_start);
        String temp = weatherpage.substring(temp_start,temp_close);
        return temp;
    }
    public static String get_city_code(String city_name) throws Exception {
        In codefile = new In("https://weather.codes/india/");
        String codes = codefile.readAll();
        int city = codes.indexOf(city_name);
        if(city==-1)throw new Exception("City does not exist in database");
        String city_code = codes.substring(city-17,city-9);
        return city_code;
    }
}
