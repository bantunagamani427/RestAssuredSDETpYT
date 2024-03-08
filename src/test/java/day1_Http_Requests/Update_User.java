package day1_Http_Requests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Update_User {
	int id;
@Test
void updateUser() {
	HashMap hm=new HashMap();
	hm.put("name", "baby");
	hm.put("job","Automation");
	
	given()
	.contentType("application/json")
	.body(hm)
	.when()
	.put("https://reqres.in/api/users/"+id)
	.then()
	.statusCode(200)
	.log().all();
}
	
}
