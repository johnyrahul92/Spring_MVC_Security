package com.security;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class TokenDetails extends WebAuthenticationDetails {
    private static final String HTTP_HEADER_X_FORWARDED_FOR = "X-Forwarded-For";
    private Long userId;
    private String fldRemoteAddress, userAgent, userIP;
    private String datetime;
    private String timeZone;
    private Long idcustomer;
    private String errormsg;
    private boolean flagforcechangepassword;
    private boolean flagForcechangeusername;
    private String fldLoginUserId;
    private String watermarkAvaliable;
    private  String fldSessionId;

   
    public TokenDetails(HttpServletRequest request) {
    	
    	
        super(request);
       
    }

    public Long getUserId() {
        return userId;
    }

    public String getFldRemoteAddress() {
        return fldRemoteAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getUserIP() {
        return userIP;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    private static String getOriginalRemoteAddress(HttpServletRequest request) {
        String remoteAddress = request.getRemoteAddr();
        Enumeration<String> forwardedFor = request.getHeaders(HTTP_HEADER_X_FORWARDED_FOR);
        if (forwardedFor.hasMoreElements()) {
            remoteAddress = forwardedFor.nextElement();
        }
        return remoteAddress;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isFlagforcechangepassword() {
        return flagforcechangepassword;
    }

    public void setFlagforcechangepassword(boolean flagforcechangepassword) {
        this.flagforcechangepassword = flagforcechangepassword;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public Long getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Long idcustomer) {
        this.idcustomer = idcustomer;
    }

    public boolean getFlagForcechangeusername() {
        return flagForcechangeusername;
    }

    public void setFlagForcechangeusername(boolean flagForcechangeusername) {
        this.flagForcechangeusername = flagForcechangeusername;
    }

    public String getFldLoginUserId() {
        return fldLoginUserId;
    }

    public void setFldLoginUserId(String fldLoginUserId) {
        this.fldLoginUserId = fldLoginUserId;
    }

    public String getWatermarkAvaliable() {
        return watermarkAvaliable;
    }

    public void setWatermarkAvaliable(String watermarkAvaliable) {
        this.watermarkAvaliable = watermarkAvaliable;
    }

    public String getFldSessionId() {
        return fldSessionId;
    }

    public void setFldSessionId(String fldSessionId) {
        this.fldSessionId = fldSessionId;
    }
}
