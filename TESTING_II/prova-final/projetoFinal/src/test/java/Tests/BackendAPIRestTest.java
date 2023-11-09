package Tests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BackendAPIRestTest {

    @BeforeEach
    public void openSite(){
        RestAssured.baseURI = "https://parabank.parasoft.com/parabank/";
    }

    public void login(){
        Map<String, Object> jsonObject = new HashMap<>();

        jsonObject.put("username", "FlorRosa");
        jsonObject.put("password", "LOS14OIC8XX");

        given()
                .body(jsonObject)
                .and()
                .when()
                .post("login.html");

    }

    @Test
    public void RegisterTest() {
        Map<String, Object> jsonObject = new HashMap<>();

        jsonObject.put("customer.firstName", "Rosa");
        jsonObject.put("customer.lastName", "Flores");
        jsonObject.put("customer.address", "street: Jardim das flores");
        jsonObject.put("customer.address", "city: Flores de Setembro");
        jsonObject.put("customer.address", "state: Algum lugar bonito");
        jsonObject.put("customer.address", "zipCode: 1234521");
        jsonObject.put("customer.phoneNumber", "58-1861-7590");
        jsonObject.put("customer.ssn", "23451236");
        jsonObject.put("customer.username", "FlorRosa");
        jsonObject.put("customer.password", "LOS14OIC8XX");

        given()
                .body(new Gson().toJson(jsonObject))
                .and()
                .when()
                .get("register.htm")
                .then()
                .statusCode(200);
    }

    @Test
    public void NewAcountTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("customerId", "12545");
        jsonObject.put("newAccountType", "1");
        jsonObject.put("fromAccountId", "14526");

        given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .post("services_proxy/bank/createAccount?customerId=12545&newAccountType=1&fromAccountId=14526")
                .then()
                .statusCode(401);
    }

    @Test
    public void OverviewTest() {
        given()
                .when()
                .get("overview.htm")
                .then()
                .statusCode(500);
    }

    @Test
    public void TranferFunds() {
        given()
                .when()
                .post("https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13566&toAccountId=13677&amount=300")
                .then()
                .statusCode(401);
    }

    @Test
    public void AccountActivity(){
        given()
                .when()
                .get("https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All")
                .then()
                .statusCode(401);
    }
}
