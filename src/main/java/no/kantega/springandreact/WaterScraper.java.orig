package no.kantega.springandreact;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WaterScraper {

    public static void getWaterData(){


        //Temporary zip code, should call Google api for location specifics
        String zipCode = "78705";

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

//                    try{
//                        final Document contaminantDoc = Jsoup.connect(contaminantUrl).get();
//
//                        for(Element contaminantRow: document.select(
//                                "table.mrl-exceeded.mrl-list"
//                        )){
//                            if(row.select("td:nth-of-type(1)").text().equals("")){
//                                continue;
//                            }else{
//                                String contaminant = row.select("td:nth-of-type(1)").text();
//                                String level = row.select("td:nth-of-type(2)").text();
//
//                                System.out.println(contaminant +", "+level);
//                            }
//                        }
//
//                        //String waterDataPerProvider = row.select("")
//
//                    }
//                    catch (Exception e2){
//                        e2.printStackTrace();
//                    }

                }
            }

            //System.out.println(document.outerHtml());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
