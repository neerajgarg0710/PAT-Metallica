package com.sapient.metallica.beans;

public class Location {

	private String code;
	private String description;

	public Location(String code, String description) {

		this.code = code;
		this.description = description;
	}

	public Location(String location) {
		this.code = location;
	}

	public Location() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Location [code=").append(code).append(", description=").append(description).append("]");
		return builder.toString();
	}

}
