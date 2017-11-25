package com.sapient.metallica.beans;

public class CounterParty {

	private String code;
	private String description;

	public CounterParty(String code, String description) {

		this.code = code;
		this.description=description;
	}

	public CounterParty(String counterParty) {
		this.code = code;
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
		builder.append("CounterParty [code=").append(code).append(", description=").append(description).append("]");
		return builder.toString();
	}

}
