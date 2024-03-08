package Day2_DiffWaysToCreatePOSTrequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;



public class CreatePostUsingJsonLibrary {
	@Test(priority=1)
	void createPostJson() {
		JSONObject hm=new JSONObject();  
		hm.put("name", "AmmaNanna");
		hm.put("location", "Annavaram");
		hm.put("phone_number", "673436");
		//store the input values in an array make it as one value as input for courses field
		String[] coursesarry= {"java","automation"};
		hm.put("Courses",coursesarry);
		given()
		.contentType("application/json")
		.body(hm.toString())//convert the data into string form then pass the body so it will take it as json
		.when()
		.post("http://localhost:3000/students")
		.then()
		.body("name",equalTo("AmmaNanna"))
		//name is the field ,and equal to is the expected result
		.body("location",equalTo("Annavaram"))
		.body("phone_number", equalTo("673436"))
		.body("Courses[0]", equalTo("java"))
		.body("Courses[1]",equalTo("automation"))
		.statusCode(201)
		.log().all();		
	}
	@Test(priority=2)
	void deleteStudentRecord() {
		when()
		.delete("http://localhost:3000/students/6")
		.then()
		.statusCode(200);
	}
}
