package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Path_Query {
	@Test
	void testPathQuery() {

		/*https://reqres.in/api/users?page=2&id=5
		  this is the request url which contain path&query parameters.
		  till api it is common for every api so no need of mention api in path param(). 
		 */
		given()
		.pathParam("mypath", "users")
		//it should mention in key & value pair,name of the key can be our wish and value should as per url
		.queryParam("page", 2)//here also key(before the = and value(after the =)
		.queryParam("id", 5)
		.when()
		.get("https://reqres.in/api/{mypath}")
		/*
		  here no need of adding query bcos query parameter will go along with the request.
		  but for path paramneter we should mention.path parameters are like our own created variable(mypath like a key) 
		  we only refer path parameter and we reffering the variable inside the request 
		 and we can give any name for the variable like mypath  but query paremeters are not variables 
		 and we can't another name for the key(page,id) we should write as it is.
		 */
		.then()
		.statusCode(200)
		.log()
		.all();
	}
}
