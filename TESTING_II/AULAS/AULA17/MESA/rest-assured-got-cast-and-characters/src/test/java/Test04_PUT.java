import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.lessThan;

public class Test04_PUT {

	@Test
//	givenThatIPerformAPutRequest_whenIGetTheResponseStatusCode_thenTheResponseStatusCodeIs200
	public void statusCodeIs200() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("location", "Kings Landing");

		given()
				.header("Content-type", "application/json")
				.contentType(ContentType.JSON)
				.pathParam("id", "qtw21XN4NUai")
				.body(jsonObject.toString())
				.when()
				.put("https://restool-sample-app.herokuapp.com/api/character/{id}")
				.then()
				.statusCode(200);
	}

	@Test
//	givenThatIPerformAGetRequest_whenIGetTheResponseTime_thenTheResponseTimeIsBelow900
	public void responseTimeIsLessThan900ms() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("location", "Kings Landing");

		given()
				.header("Content-type", "application/json")
				.contentType(ContentType.JSON)
				.pathParam("id", "qtw21XN4NUai")
				.body(jsonObject.toString())
				.when()
				.put("https://restool-sample-app.herokuapp.com/api/character/{id}")
				.then()
				.time(lessThan(900L));
	}

	@Test
	public void responseContainsOk() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("location", "Kings Landing");

		given()
				.header("Content-type", "application/json")
				.contentType(ContentType.JSON)
				.pathParam("id", "qtw21XN4NUai")
				.body(jsonObject.toString())
				.when()
				.put("https://restool-sample-app.herokuapp.com/api/character/{id}")
				.then()
				.body("", contains("ok"));
	}
}
