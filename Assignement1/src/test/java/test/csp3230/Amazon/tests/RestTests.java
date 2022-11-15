package test.csp3230.Amazon.tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.um.cps3230.Alert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestTests {

    Alert alert;

    @BeforeEach
    public void setup(){
        alert = new Alert("object", "dummy object", "https://www.amazon.com/", "https://picsum.photos/200/300.jpg", "100");
    }

    @AfterEach
    public void teardown(){
        alert = null;
    }

    @Test
    public void sendDeleteRequest() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.delete("https://api.marketalertum.com/Alert?userId=24680").asString();
        Assertions.assertEquals("OK", response.getStatusText());
    }

    @Test
    public void sendPostRequest() throws UnirestException{
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://api.marketalertum.com/Alert")
                .header("Content-Type", "application/json")
                .body("{\n\"alertType\": 6,\n\"heading\": \""+ alert.getTitle()+"\",\n\"description\": \""+alert.getDescripion()+"\",\n\"url\": \""+alert.getUrl()+"\",\n\"imageUrl\" : \""+alert.getImageUrl()+"\",\n\"postedBy\": \"24680\",\n\"priceInCents\": "+alert.getPrice()+"\n}").asString();

        Assertions.assertEquals("Created", response.getStatusText());
    }
}
