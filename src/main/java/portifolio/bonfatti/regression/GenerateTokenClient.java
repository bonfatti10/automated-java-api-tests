package portifolio.bonfatti.regression;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

@Slf4j
public final class GenerateTokenClient {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String TYPE = System.getProperty("type");
    private static final String ID = System.getProperty("id");
    private static final String SECRET = System.getProperty("secret");
    private static final String REFRESH_TOKEN = "";

    private static final String BASE_URL = System.getProperty("base_url");
    private static final String X_API_KEY = System.getProperty("x_api_key");

    private GenerateTokenClient() {
    }

    public static String authorize() {
        try {
            String requestBody = createPayload();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(BodyPublishers.ofString(requestBody))
                    .uri(new URI(BASE_URL + "auth/" + ID + "/token"))
                    .header("x-api-key", X_API_KEY)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            GenerateTokenResponse tokenResponse = MAPPER.readValue(response.body(), GenerateTokenResponse.class);
            return tokenResponse.getAccessToken();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createPayload() throws JsonProcessingException {
        return MAPPER.writerWithDefaultPrettyPrinter()
                .writeValueAsString(createPayloadRequest());
    }

    private static GenerateTokenRequest createPayloadRequest() {
        return GenerateTokenRequest.builder()
                .grantType(TYPE)
                .clientId(ID)
                .clientSecret(SECRET)
                .refreshToken(REFRESH_TOKEN)
                .build();
    }

    public static void main(String[] args) {
        new GenerateTokenClient().authorize();
    }
}
