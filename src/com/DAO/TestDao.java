package com.DAO;


import com.dto.ErrorCodeDo;
import com.dto.TestBeanDo;
import com.pojo.CountryFieldResponse;

public interface TestDao {
	
	public void addTest(TestBeanDo testBean);
	
	public ErrorCodeDo findDescription(int code);

	public CountryFieldResponse getFieldByCountryId(String countryId);	

	public TestBeanDo getTest(int id);

	public String clearCache(int id);

}
