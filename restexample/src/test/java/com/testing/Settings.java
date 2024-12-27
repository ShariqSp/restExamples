
package com.testing;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "theme",
    "notificationsEnabled"
})

public class Settings {

    @JsonProperty("theme")
    private String theme;
    @JsonProperty("notificationsEnabled")
    private Boolean notificationsEnabled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("theme")
    public String getTheme() {
        return theme;
    }

    @JsonProperty("theme")
    public void setTheme(String theme) {
        this.theme = theme;
    }

    @JsonProperty("notificationsEnabled")
    public Boolean getNotificationsEnabled() {
        return notificationsEnabled;
    }

    @JsonProperty("notificationsEnabled")
    public void setNotificationsEnabled(Boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
