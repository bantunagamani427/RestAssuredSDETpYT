package Day2_DiffWaysToCreatePOSTrequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UsingPOJO_PostRequest {
	@Test(priority=1)
	void createPOSTRequestusingPOJO() {
		POJO_postRequest_Class data=new POJO_postRequest_Class();
		data.setName("Naga");
		//these are just adding the data to the variables,if we want to get the data 
		//from the variables we can use getName() like that.
		data.setLocation("AvmGpm");
		data.setPhone_number("9838478");
		String[] courses= {"C","C++"};
		data.setCourses(courses);
		given()
		.body(data)
		.contentType("application/json")
		.when()
		.post("http://localhost:3000/students")
		.then()
		.body("name", equalTo("Naga"))
		.body("location", equalTo("AvmGpm"))
		.body("phone_number",equalTo("9838478"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.statusCode(201)	
		.log().all();	
	}
	@Test(priority=2)
	void deleteStudentData() {
		when()
		.delete("http://localhost:3000/students/8")
		.then()
		.statusCode(200);
	}
}