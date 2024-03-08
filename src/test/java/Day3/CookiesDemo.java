package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class CookiesDemo {
	@Test(priority=1)
	void cookiesInfo() {
		given()
		.when()
		.get("https://www.google.co.in/")
		.then()
		.cookie("AEC","Ae3NU9M8L5zpyIMgtRHJ4vr82N8QJxdbvFdcQ4eYSrJC3qjwkk3Rk-FC6sg")
		//cookie is present in key and value pairs.definetely assertion will fail
		//bcos generated value is not same everytime
		.log().all();
	}
	//if we want to capture the multiple Cookies value information
	@Test(priority=2)
	void GettingMultipleCookiesinfo() {
		Response res = when()
				.get("https://www.google.co.in/");
		//for getting single cookie information
		//String cookie_value = res.getCookie("AEC");
		//System.out.println("Cookie value===>"+cookie_value);
		//for getting multiple cookie values
		Map<String,String> cookies_values = res.getCookies();
		/*here cookies are in the form of key and value pairs.so those values are stored in Map
		 * becos in map only the data is stored in key & value pairs i.e in string format
		 */
		System.out.println(cookies_values.keySet());//all keys are printed here
		for(String k:cookies_values.keySet()) {
			//to get the each value ,we need to iterate every key 
			String cookie_value=res.getCookie(k);
			//every cookie value we can get from the getCookie method and 
			//store it in variable which is of string type
			System.out.println(k+"       "+cookie_value);
			//here key and value is printed.
		}
	}
}