package com.sapient.metallica.beans;

public class Commodity {

	private String code;
	private String description;

	public Commodity(String code, String description) {

		this.code = code;
		this.description = description;
	}

	public Commodity(String commodity) {
		this.code = commodity;
	}

	public Commodity() {
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
		builder.append("Commodity [code=").append(code).append(", description=").append(description).append("]");
		return builder.toString();
	}

}
