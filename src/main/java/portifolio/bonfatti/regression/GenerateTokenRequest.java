package portifolio.bonfatti.regression;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenerateTokenRequest {
    @JsonProperty("grant_type")
    private String Type;
    @JsonProperty("client_id")
    private String Id;
    @JsonProperty("client_secret")
    private String Secret;
    @JsonProperty("refresh_token")
    private String refreshToken;
}
