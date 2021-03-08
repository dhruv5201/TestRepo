package com.xsit.testdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "lastname", "address", "phoneNumbers", "url", "cities", "tank" })
public class TestData {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("address")
	private String address;
	@JsonProperty("phoneNumbers")
	private List<Integer> phoneNumbers = null;
	@JsonProperty("url")
	private String url;
	@JsonProperty("cities")
	private List<String> cities = null;
	@JsonProperty("tank")
	private List<String> tank = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("lastname")
	public String getLastname() {
		return lastname;
	}

	@JsonProperty("lastname")
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("phoneNumbers")
	public List<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}

	@JsonProperty("phoneNumbers")
	public void setPhoneNumbers(List<Integer> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("cities")
	public List<String> getCities() {
		return cities;
	}

	@JsonProperty("cities")
	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	@JsonProperty("tank")
	public List<String> getTank() {
		return tank;
	}

	@JsonProperty("tank")
	public void setTank(List<String> tank) {
		this.tank = tank;
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
