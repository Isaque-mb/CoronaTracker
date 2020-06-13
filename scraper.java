import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class scraper {

    public static void main(String[] args) throws Exception {

        final Document doc = Jsoup.connect("https://www.cdc.gov/coronavirus/2019-ncov/cases-updates/cases-in-us.html").get();

        String confirmed = doc.getElementsByClass("count").text();
        String newConfirmed = doc.getElementsByClass("new-cases").text();
        String cases = "";
        String newCases = "";
        String deaths = "";
        String newDeaths = "";

        // modifies confirmed data
        for(int i = 0; i < confirmed.length(); i++){
            String s = confirmed.substring(i,i+1);
            if(s.equals(" ")){
                cases = confirmed.substring(0,i);
                deaths = confirmed.substring(i+1,(confirmed.length()-1));
            }
        }

        // modifies new data
        for(int j = 0; j < newConfirmed.length()-1; j++){
            String s2 = newConfirmed.substring(j,j+1);
            if(s2.equals("*")){
                newCases = newConfirmed.substring(0,j);
                newDeaths = newConfirmed.substring(j+1,(newConfirmed.length()-1));
            }
        }

        System.out.print("Corona Virus Tracker - USA");
        System.out.println();
        System.out.print(" - Confirmed Cases: " + cases + " ( " + newCases + " )");
        System.out.println();
        System.out.print(" - Confirmed Deaths: " + deaths + " ( " + newDeaths + " )");
        System.out.println();
        System.out.print("Made by Isaque Brandao");
    }
}