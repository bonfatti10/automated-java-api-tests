package portifolio.bonfatti.test.institutionBonfatti.transfers;

import portifolio.bonfatti.regression.GenerateTokenClient;
import portifolio.bonfatti.test.utils.DataTransfers;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import portifolio.bonfatti.test.utils.Constants;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class TransferTest {
    DataTransfers data = new DataTransfers();
    private static String token;

    @BeforeAll
    static void setup() {
        token = GenerateTokenClient.authorize();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("When performing a transfer with correct data, the transfer must be successful")
    void transferWithSucess() {
        Map body = data.transfer();

        System.out.println(body);
        given()
                .header("x-api-key", Constants.x_api_key)
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(Constants.BASE_URL + "transfers")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .contentType(containsString("utf-8"))
                .body("response_code", is(0))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemasTransfers/transfers.json"));
    }
}
