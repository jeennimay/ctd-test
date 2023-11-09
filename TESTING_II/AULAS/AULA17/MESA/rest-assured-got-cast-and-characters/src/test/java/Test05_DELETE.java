import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.lessThan;

public class Test05_DELETE {

	@Test
//	givenThatIPerformADeleteRequest_whenIGetTheResponseStatusCode_thenTheResponseStatusCodeIs200
	public void statusCodeIs200() {
		given()
				.pathParam("id", "qtw21XN4NUai")
				.when()
				.delete("https://restool-sample-app.herokuapp.com/api/character/{id}")
				.then()
				.statusCode(200);
	}

	@Test
//	givenThatIPerformAGetRequest_whenIGetTheResponseTime_thenTheResponseTimeIsBelow900
	public void responseTimeIsLessThan900ms() {
		given()
				.pathParam("id", "qtw21XN4NUai")
				.when()
				.delete("https://restool-sample-app.herokuapp.com/api/character/{id}")
				.then()
				.time(lessThan(900L));
	}

	@Test
//	givenThatIPerformADeleteRequest_whenIGetTheResponseBodyContent_thenTheResponseBodyContentContainsOk
	public void responseContainsOk() {
		given()
				.pathParam("id", "qtw21XN4NUai")
				.when()
				.delete("https://restool-sample-app.herokuapp.com/api/character/{id}")
				.then()
				.body("", contains("ok"));
	}
}
