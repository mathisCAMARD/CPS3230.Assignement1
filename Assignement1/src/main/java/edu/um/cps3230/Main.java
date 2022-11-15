package edu.um.cps3230;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws UnirestException {

        EcommerceWebPage amaz = new EcommerceWebPage();
        List<Alert> alertList = new ArrayList<>();
        int j=0;

        amaz.setup();
        amaz.typeInTheSearchBar();
        amaz.clickToSearchPoduct();

        List<WebElement> title = amaz.scrapeMyProductTitle();
        List<WebElement> image = amaz.scrapeMyProductImage();
        List<WebElement> price = amaz.scrapeMyProductPrice();
        List<WebElement> url = amaz.scrapeMyProductUrl();

        for (int i = 0; i<5; i++){

            String[] parts = title.get(i).getText().split("\\s+");
            String prix = price.get(i).getAttribute("innerText").replaceAll("\\$", "");
            prix = prix.replaceAll("\\.", "");

            Alert alert = new Alert(parts[0] + " " + parts[1]+ " " + parts[2], title.get(i).getText(), url.get(j).getAttribute("href"), image.get(i).getAttribute("src"), prix);
            alertList.add(alert);
            j +=2;
        }

        for(int i = 0; i< alertList.size(); i++) {
             System.out.println("ALERT N° " + i);
             Alert.displayAlert(alertList.get(i));
             System.out.println("*************************************************");


            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("https://api.marketalertum.com/Alert")
                    .header("Content-Type", "application/json")
                    .body("{\n\"alertType\": 6,\n\"heading\": \""+ alertList.get(i).getTitle()+"\",\n\"description\": \""+alertList.get(i).getDescripion()+"\",\n\"url\": \""+alertList.get(i).getUrl()+"\",\n\"imageUrl\" : \""+alertList.get(i).getImageUrl()+"\",\n\"postedBy\": \"24680\",\n\"priceInCents\": "+alertList.get(i).getPrice()+"\n}").asString();

        }



        amaz.teardown();
    }
}