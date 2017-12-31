package com.hwforever.business.model;

public class Discern_type {

	private Integer discern_key;
	private String description;

	public Integer getDiscern_key() {
		return discern_key;
	}

	public void setDiscern_key(Integer discern_key) {
		this.discern_key = discern_key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Discern_type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Discern_type(Integer discern_key, String description) {
		super();
		this.discern_key = discern_key;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Discern_type{" + "discern_key=" + discern_key + ", description='" + description + '\'' + '}';
	}

}
