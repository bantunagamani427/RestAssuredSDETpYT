package day1_Http_Requests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Delete_User {
int id;
@Test
void deleteUser() {
	given()
	.when()
	.delete("https://reqres.in/api/users/2"+id)
	.then()
	.statusCode(204)
	.log().all();
}
}
