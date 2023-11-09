import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class Test01_GET {

	@Test
//	givenThatIPerformAGetRequest_whenIGetTheResponseStatusCode_thenTheResponseStatusCodeIs200
	public void statusCodeIs200() {
		given()
				.when()
				.get("https://restool-sample-app.herokuapp.com/api/character")
				.then()
				.statusCode(200);
	}

	@Test
//	givenThatIPerformAGetRequest_whenIGetTheResponseTime_thenTheResponseTimeIsBelow900
	public void responseTimeIsLessThan900ms() {
		given()
				.when()
				.get("https://restool-sample-app.herokuapp.com/api/character")
				.then()
				.time(lessThan(900L));
	}

	@Test
	public void checkOneCharacterFromArray() {
		given()
				.when()
				.get("https://restool-sample-app.herokuapp.com/api/character")
				.then()
				.body("items[1].name", equalTo("Cersei Lannister"))
				.body("items[1].realName", equalTo("Lena Headey"))
				.body("items[1].location", equalTo("Kings Landing"));
	}
}
