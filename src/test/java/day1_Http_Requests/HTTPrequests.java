package day1_Http_Requests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
public class HTTPrequests {
	int id;//make the id as global variable(we should not hardcode the id so make it global)
	@Test(priority=1)
	void getUser() {
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority=2)
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
		//jsonpath will return the id keep it in given() and id is integer so getInt.
		//and this id goes to global variable
	}
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser() {
		HashMap hm=new HashMap();
		hm.put("name","Naga");
		hm.put("job", "Automation");
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.put("https://reqres.in/api/users/"+id)
		//id should not hardcoded so take global variable id as userid
		.then()
		.statusCode(200)
		.log().all();
		}
	@Test(priority=4)
	void deleteUser() {
		when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log()
		.all();
	}
}

