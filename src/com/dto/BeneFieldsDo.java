package com.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bene_fields")
public class BeneFieldsDo {
	
	
	@Id
	@Column(name = "field_id")
	private String fieldId;
	@Column(name = "filed_name")
	private String fieldName;
	@Column(name = "label_name")
	private String labelName;
	@Column(name = "max_length")
	private String maxLength;
	@Column(name = "field_status")
	private String fieldStatus;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "beneFieldsDo")
	private Set<CountryFieldsDo> countryFieldsDos = new HashSet<CountryFieldsDo>();
	
	public Set<CountryFieldsDo> getCountryFieldsDos() {
		return countryFieldsDos;
	}
	public void setCountryFieldsDos(Set<CountryFieldsDo> countryFieldsDos) {
		this.countryFieldsDos = countryFieldsDos;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}
	public String getFieldStatus() {
		return fieldStatus;
	}
	public void setFieldStatus(String fieldStatus) {
		this.fieldStatus = fieldStatus;
	}
	
	

}
