package portifolio.bonfatti.test.institutionBonfatti.statements;

import portifolio.bonfatti.regression.GenerateTokenClient;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import portifolio.bonfatti.test.utils.Constants;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

class StatementTest {

    private static String token;


    @BeforeAll
    static void setup() {
        token = GenerateTokenClient.authorize();
    }

    @Test
    @DisplayName("When requesting an account statement Then you must return with the correct data")
    void getSuccessfulPmaExtract() {
        given()
                .header("x-api-key", Constants.x_api_key)
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .queryParam("start_period", "20230505000000")
                .queryParam("end_period", "20230605000000")
                .queryParam("page", "1")
                .queryParam("limit", "2")
                .when()
                .get(Constants.BASE_URL + "extract")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .contentType(containsString("utf-8"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/statement/extract.json"));
    }

    @Test
    @DisplayName("When requesting an Account Statement with invalid parameters, then it should return “400 invalid_request")
    void getTreasuryAccountStatementSuccess() {
        given()
                .header("x-api-key", Constants.x_api_key)
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .queryParam("start_period", "xpto0505000000")
                .queryParam("end_period", "erro0605000000")
                .queryParam("page", "1")
                .queryParam("limit", "")
                .when()
                .get(Constants.BASE_URL + "extratoErro")
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .contentType(containsString("utf-8"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/statement/extractErro.json"));
    }

}
