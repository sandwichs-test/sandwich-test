package com.hwforever.business.model;
/**
 * @Author： Likai
 * @Description：
 * @Date： Created in 12:35 2017/12/30
 */
public class Discern_column {

	private Integer id;
	private Integer case_id;
	private String discern_name;
	private Integer discern_type_id;
	private String discern_value;
	@Override
	public String toString() {
		return "Discern_column {"+
				"id=" + id +
                ", case_id=" + case_id + 
                ", discern_name='" + discern_name + '\'' +
                ", discern_type_id=" + discern_type_id +
                ",discern_value='" + discern_value + '\'';
	}
	public Discern_column() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Discern_column(Integer id, Integer case_id, String discern_name, Integer discern_type_id) {
		super();
		this.id = id;
		this.case_id = case_id;
		this.discern_name = discern_name;
		this.discern_type_id = discern_type_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCase_id() {
		return case_id;
	}
	public void setCase_id(Integer case_id) {
		this.case_id = case_id;
	}
	public String getDiscern_name() {
		return discern_name;
	}
	public void setDiscern_name(String discern_name) {
		this.discern_name = discern_name;
	}
	public Integer getDiscern_type_id() {
		return discern_type_id;
	}
	public void setDiscern_type_id(Integer discern_type_id) {
		this.discern_type_id = discern_type_id;
	}
	public String getDiscern_value() {
		return discern_value;
	}
	public void setDiscern_value(String discern_value) {
		this.discern_value = discern_value;
	}
}
