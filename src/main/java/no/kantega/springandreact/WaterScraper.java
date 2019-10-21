package no.kantega.springandreact;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WaterScraper {

    public static void getWaterData(){


        //Temporary zip code, should call Google api for location specifics
        String zipCode = "76103";
        int count = 0;

        final String url =
                "https://mytapwater.org/zip/"+zipCode+"/";

        try{
            final Document document = Jsoup.connect(url).get();

            for(Element row: document.select(
                    "table.search-results-table tr"
            )){
                if(row.select("td:nth-of-type(1)").text().equals("")){
                    continue;
                }else{
                    //Element cell = row.select("td:nth-of-type(1)").attr("href");
                    String waterProvider = row.select("td:nth-of-type(1)").text();

                    Elements link = row.select("td:nth-of-type(1) > a");

                    final String contaminantUrl = link.attr("href");

                    //print out waterProvider
                    System.out.print(waterProvider + ": -->");
                    //print to look at contaminant URL
                    System.out.println(contaminantUrl);

                    //only getting first 10;
                    count++;

                    try{
                        if(count < 10) {
                            final Document contaminantDoc = Jsoup.connect(contaminantUrl).get();



                            Element contaminantRow = contaminantDoc.select("tr.exceeded").first();
                            Element contaminant = contaminantDoc.select("div.contaminant").select("h4").first();

                          //  String contaminant = contaminantRow.select("td:nth-of-type(1)").text();
                            String year = contaminantRow.select("td:nth-of-type(1)").text();
                            String level = contaminantRow.select("td:nth-of-type(5)").text();

                            System.out.println("Contaminant: " + contaminant.id().toString() + ", Year: " + year + ", Test Result: " + level);


                            //String waterDataPerProvider = row.select("")
                        }

                    }
                    catch (Exception e2){
                        e2.printStackTrace();
                    }

                }
            }

            //System.out.println(document.outerHtml());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

   // public static void main(String[] args){
     //   getWaterData();
    }
//}
