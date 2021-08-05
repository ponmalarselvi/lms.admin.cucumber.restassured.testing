package stepDefinitions;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Steps {

	private static Response response;

	private static final String BASE_URL = "https://lms-admin-rest-service.herokuapp.com";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "password";
	private static int programId = 0;

	@When("load all the programs")
	public void load_all_the_programs() {
		response = given().auth().basic(USERNAME, PASSWORD).when().get(BASE_URL + "/programs");
	}

	@Then("all programs are displayed")
	public void all_programs_are_displayed() {
		String programId = response.jsonPath().getString("programId[0]");
		Assert.assertNotNull(programId);
	}

	@When("Authorized User add program")
	public void authorized_user_add_program() {

		JSONObject request = new JSONObject();
		request.put("programName", "cucumber learning");
		request.put("programDescription", "cucumber learning");
		request.put("isOnline", false);

		response = given().auth().basic(USERNAME, PASSWORD).header("Content-type", "application/json").and()
				.body(request).when().post(BASE_URL + "/programs").then().extract().response();

		System.out.println("Response Body is: " + response.getBody().asString());

	}

	@Then("program is added")
	public void program_is_added() {
		JsonPath jsonPathEvaluator = response.jsonPath();

		Integer apiProgramId = jsonPathEvaluator.get("programId");

		Assert.assertNotNull(apiProgramId);
		programId = apiProgramId.intValue();
	}

	@When("Authorized User view program")
	public void authorized_user_view_program() {

		response = given().auth().basic("admin", "password").when().get(BASE_URL + "/programs/" + programId);

		System.out.println(response.asString());

	}

	@Then("program is displayed")
	public void program_is_displayed() {
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: programId (Note: You should not put $. in the Java
		// code)
		Integer apiProgramId = jsonPathEvaluator.get("programId");

		// Validate the response
		Assert.assertNotNull(apiProgramId);
		Assert.assertTrue(programId == apiProgramId.intValue());
	}

	@When("Authorized User update program")
	public void authorized_user_update_program() {
		JSONObject request = new JSONObject();
		request.put("programName", "cucumber learning modified");
		request.put("programDescription", "cucumber learning");
		request.put("isOnline", false);

		response = given().auth().basic("admin", "password").header("Content-type", "application/json").and()
				.body(request).when().put(BASE_URL + "/programs/" + programId).then().extract().response();

		System.out.println("authorized_user_update_program Response Body is: " + response.getBody().asString());
	}

	@Then("program is updated")
	public void program_is_updated() {

		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: programId (Note: You should not put $. in the Java
		// code)
		String programNameUdt = jsonPathEvaluator.get("programName");
		System.out.println("From APi " + programNameUdt);

		Assert.assertEquals("cucumber learning modified", programNameUdt);
	}

	@When("Authorized User delete program")
	public void authorized_user_delete_program() {

		response = given().auth().basic("admin", "password").header("Content-type", "application/json").when()
				.delete(BASE_URL + "/programs/" + programId).then().extract().response();

	}

	@Then("program is deleted")
	public void program_is_deleted() {
		System.out.println("Response Body is: " + response.getBody().asString());

		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);
	}

}
