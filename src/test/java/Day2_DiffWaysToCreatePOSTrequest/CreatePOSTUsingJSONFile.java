package Day2_DiffWaysToCreatePOSTrequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class CreatePOSTUsingJSONFile {
	@Test
	void createPostJsonLibrary() throws FileNotFoundException {
		File f=new File(".\\body.json");
		/*File class import from java.io package
		 * here the dot means current project location till before the filename
(C:\Users\Nagamani\eclipse-workspace\RestAssuredTraining\Body.json)
and give the file name.f is the file and to read the data from the file
we have 2 classes FileReader(java.io) and JSONtokener(import from org.json)
from the file class we open the file and from FileReader class we read the data and from 
JSONTokener we extract the data
		 */
		FileReader fr=new FileReader(f);
		//here we split(extract) the json data using JSONTokener 
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject();//we get the json data from JSONObject
		data.put("name", "AthaMama");
		data.put("location", "Gopavaram");
		data.put("phone_number", "9847837");
		String[] coursesarr= {"C","C++"};
		data.put("Courses", coursesarr);	
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.log().all();
	}
	@Test(priority=2)
	void deleteStudentData() {
		when()
		.delete("http://localhost:3000/students/10")
		.then()
		.statusCode(200);
	}
}