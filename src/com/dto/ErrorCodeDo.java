package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enet_errors")
public class ErrorCodeDo {
	
	
	@Id
    @Column(name = "error_code")
	private int errorCode;
	@Column(name = "error_desc_eng")
	private String errorDescEng;
	@Column(name = "error_desc_ara")
	private String errorDescAra;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescEng() {
		return errorDescEng;
	}
	public void setErrorDescEng(String errorDescEng) {
		this.errorDescEng = errorDescEng;
	}
	public String getErrorDescAra() {
		return errorDescAra;
	}
	public void setErrorDescAra(String errorDescAra) {
		this.errorDescAra = errorDescAra;
	}
	
	
	
	

}
