import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class Test03_POST {

	@Test
//	givenThatIPerformAPostRequest_whenIGetTheResponseStatusCode_thenTheResponseStatusCodeIs200
	public void statusCodeIs200() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("thumbnail", "Hodor");
		jsonObject.put("name", "Hodor");
		jsonObject.put("realName", "Hodor");
		jsonObject.put("location", "Winterfell");
		jsonObject.put("isAlive", true);

		given()
				.header("Content-type", "application/json")
				.contentType(ContentType.JSON)
				.body(jsonObject.toString())
				.when()
				.post("https://restool-sample-app.herokuapp.com/api/character")
				.then()
				.statusCode(200);
	}

	@Test
//	givenThatIPerformAGetRequest_whenIGetTheResponseTime_thenTheResponseTimeIsBelow900
	public void responseTimeIsLessThan900ms() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("thumbnail", "Hodor");
		jsonObject.put("name", "Hodor");
		jsonObject.put("realName", "Hodor");
		jsonObject.put("location", "Winterfell");
		jsonObject.put("isAlive", true);

		given()
				.header("Content-type", "application/json")
				.contentType(ContentType.JSON)
				.body(jsonObject.toString())
				.when()
				.post("https://restool-sample-app.herokuapp.com/api/character")
				.then()
				.time(lessThan(900L));
	}

	@Test
	public void saveCharacter() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("thumbnail", "Hodor");
		jsonObject.put("name", "Hodor");
		jsonObject.put("realName", "Hodor");
		jsonObject.put("location", "Winterfell");
		jsonObject.put("isAlive", true);
		given()
				.header("Content-type", "application/json")
				.contentType(ContentType.JSON)
				.body(jsonObject.toString())
				.when()
				.post("https://restool-sample-app.herokuapp.com/api/character")
				.then()
				.body("name", equalTo("Hodor"));
	}
}
