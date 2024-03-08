package day1_Http_Requests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
public class Create_User {
	int id;
	@Test
	void createUser() {
		HashMap hm=new HashMap();
		hm.put("name", "Nagamani");
		hm.put("job", "Tester");	
		id=given()
		.contentType("application/json")
		.body(hm)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		//.then()
		//.statusCode(201)
		//.log().all();
	}
}
