import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test_Public_API {

    @Test
    public void givenThatPerfomAPostResquest_whenIGetTheResponseCode_thenTheResponseStatusCodeIs200(){
        JSONObject jsonObject = new JSONObject();
            jsonObject.put("","");
    }
    // https://api.thecatapi.com/v1/favourites
}
