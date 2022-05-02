package apiTest;


import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.junit.Test;
import org.json.simple.JSONObject;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;


public class RestApi {
	//AOI root
	public String API_ROOT = "https://petstore.swagger.io";


	@Test//get request, status code 200, and response body check
	public void getUserLogin() {
		given()
				.when()
				.get(API_ROOT + "/v2/user/login?username=test&password=tester")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("type", Matchers.equalTo("unknown"))
				.body("message", Matchers.anything());
	}



	@Test//post Json Array Object request, status code 200, and response body check
	public void postCreateWithList () {
		JSONArray ja = new JSONArray();
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", "10");
		requestParams.put("username", "test");
		requestParams.put("firstName", "test");
		requestParams.put("lastName", "tester");
		requestParams.put("email", "abcd@test.com");
		requestParams.put("password", "abd");
		requestParams.put("phone", "5901111111");
		requestParams.put("userStatus", "1");
		ja.put(requestParams);

		given()
				.header("Content-Type", "application/json")
				.body(ja.toString())
				.post(API_ROOT + "/v2/user/createWithList")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("type", Matchers.equalTo("unknown"))
				.body("message", Matchers.equalTo("ok"));

	}

	@Test //delete request, status code 404 check
	public void deleteUser() {
		given()
				.header("Content-Type", "application/json")
				.delete(API_ROOT + "/v2/user/testtt")
				.then()
				.statusCode(HttpStatus.SC_NOT_FOUND);

	}

	@Test //post Json request, status code 200, and response body check
	public void postCreateUser () {
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", "10");
		requestParams.put("username", "test");
		requestParams.put("lastname", "tester");
		requestParams.put("email", "abcd@test.com");
		requestParams.put("password", "abd");
		requestParams.put("phone", "5901111111");
		requestParams.put("userStatus", "1");

		given()
				.header("Content-Type", "application/json") // Add the Json to the body of the request
				.body(requestParams.toJSONString())
				.post(API_ROOT + "/v2/user")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("type", Matchers.equalTo("unknown"))
				.body("message", Matchers.equalTo("10"));

	}
}

