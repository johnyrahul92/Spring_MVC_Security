package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries_wu")
public class CountryWuDO {

	@Id
	@Column(name = "country_id")
	private String countryId;
	@Column(name = "country_name")
	private String countryName;
	@Column(name = "country_status")
	private String countryStatus;

}
