package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class TestHeaders {
	@Test
	void testHeaders() {
		given()
		.when()
		.get("https://www.google.co.in/")
		.then()
		//validating the headers information
		.header("Content-Encoding", "gzip")
		.header("Server", "gws")
		.header("Content-Type", "text/html; charset=ISO-8859-1");
		//to get the header information
	}
}
