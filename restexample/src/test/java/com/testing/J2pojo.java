
package com.testing;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userId",
    "username",
    "profile",
    "roles",
    "settings"
})

public class J2pojo {

    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("profile")
    private Profile profile;
    @JsonProperty("roles")
    private List<Role> roles;
    @JsonProperty("settings")
    private Settings settings;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("profile")
    public Profile getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JsonProperty("roles")
    public List<Role> getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @JsonProperty("settings")
    public Settings getSettings() {
        return settings;
    }

    @JsonProperty("settings")
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public J2pojo(Integer userId, String username, Profile profile, List<Role> roles, Settings settings,
			Map<String, Object> additionalProperties) {
		super();
		this.userId = userId;
		this.username = username;
		this.profile = profile;
		this.roles = roles;
		this.settings = settings;
		this.additionalProperties = additionalProperties;
	}
    
    

}
