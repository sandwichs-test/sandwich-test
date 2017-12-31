package com.hwforever.business.model;
/**
 * @Author： Likai
 * @Description：
 * @Date： Created in 12:40 2017/12/30
 */
public class Case_Discern {

	private Case _case;
	private Discern_column discern_column;
	private Discern_type discern_type;
	public Case get_case() {
		return _case;
	}
	public void set_case(Case _case) {
		this._case = _case;
	}
	public Discern_column getDiscern_column() {
		return discern_column;
	}
	public void setDiscern_column(Discern_column discern_column) {
		this.discern_column = discern_column;
	}
	public Discern_type getDiscern_type() {
		return discern_type;
	}
	public void setDiscern_type(Discern_type discern_type) {
		this.discern_type = discern_type;
	}
	public Case_Discern(Case _case, Discern_column discern_column, Discern_type discern_type) {
		super();
		this._case = _case;
		this.discern_column = discern_column;
		this.discern_type = discern_type;
	}
	public Case_Discern() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Case_Discern {"+
				"_case=" + _case + 
				", discern_column=" + discern_column + 
				", discern_type=" + discern_type
				+ "}";
	}
	
}
