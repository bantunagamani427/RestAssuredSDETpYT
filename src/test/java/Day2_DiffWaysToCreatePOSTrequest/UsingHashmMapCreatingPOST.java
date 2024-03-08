package Day2_DiffWaysToCreatePOSTrequest;
/*
 * 1)using mashmap
 * 2)using pojo(plain old java object
 * 3)using json file
 * 4)using org.json
 */

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class UsingHashmMapCreatingPOST {
	@Test(priority=1)
	void createPostUsingHashmap() {
		HashMap hm=new HashMap();
		hm.put("name", "AkshithDevansh");
		hm.put("Location", "Gpm");
		hm.put("phone_number", "123456");
		//store the input values in an array make it as one value as input for courses field
		String[] coursesarry= {"phython","selenium"};
		hm.put("Courses",coursesarry);
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.body("name",equalTo("AkshithDevansh"))
		//name is the field ,and equal to is the expected result
		.body("Location",equalTo("Gpm"))
		.body("phone_number", equalTo("123456"))
		.body("Courses[0]", equalTo("phython"))
		.body("Courses[1]",equalTo("selenium"))
		.statusCode(201)
		.log().all();
	}
	@Test(priority=2)
	void deleteStudentRecord() {
		given()
		.when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(200);
	}
}
