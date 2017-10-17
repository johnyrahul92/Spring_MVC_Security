package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "country_fileds")
public class CountryFieldsDo {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "country_id")
	private String countryId;
	
	@Column(name = "mandatory")
	private String mandatory;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "field_id", nullable = false)
	private BeneFieldsDo beneFieldsDo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	public String getMandatory() {
		return mandatory;
	}
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	public BeneFieldsDo getBeneFieldsDo() {
		return beneFieldsDo;
	}
	public void setBeneFieldsDo(BeneFieldsDo beneFieldsDo) {
		this.beneFieldsDo = beneFieldsDo;
	}
	
	
	

}
