package projectName.entries.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Entries {
    @JsonProperty("API")
    private String api;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Auth")
    private String auth;
    @JsonProperty("HTTPS")
    private Boolean https;
    @JsonProperty("Cors")
    private String cors;
    @JsonProperty("Link")
    private String link;
    @JsonProperty("Category")
    private String category;
}
