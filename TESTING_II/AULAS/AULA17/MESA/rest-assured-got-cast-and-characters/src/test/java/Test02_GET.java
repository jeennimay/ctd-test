import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class Test02_GET {

	@Test
//	givenThatIPerformAGetRequest_whenIGetTheResponseStatusCode_thenTheResponseStatusCodeIs200
	public void statusCodeIs200() {
		given()
				.pathParam("characterName", "Tyrion Lannister")
				.when()
				.get("https://restool-sample-app.herokuapp.com/api/character?search={characterName}")
				.then()
				.statusCode(200);
	}

	@Test
//	givenThatIPerformAGetRequest_whenIGetTheResponseTime_thenTheResponseTimeIsBelow900
	public void responseTimeIsLessThan900ms() {
		given()
				.pathParam("characterName", "Tyrion Lannister")
				.when()
				.get("https://restool-sample-app.herokuapp.com/api/character?search={characterName}")
				.then()
				.time(lessThan(900L));
	}

	@Test
	public void searchByCharacterName() {
		given()
				.pathParam("characterName", "Tyrion Lannister")
				.when()
				.get("https://restool-sample-app.herokuapp.com/api/character?search={characterName}")
				.then()
				.body("items[0].name", equalTo("Tyrion Lannister"));
	}
}
