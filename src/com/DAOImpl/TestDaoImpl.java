package com.DAOImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.TestDao;
import com.dto.CountryFieldsDo;
import com.dto.ErrorCodeDo;
import com.dto.TestBeanDo;
import com.pojo.BeneField;
import com.pojo.CountryFieldResponse;

@Component("testDao")
@EnableTransactionManagement
public class TestDaoImpl implements TestDao {

	@Autowired
	private LocalSessionFactoryBean logSessionFactory;	

	@Override
	@Transactional
	public void addTest(TestBeanDo testBean) {
		// TODO Auto-generated method stub

		/*
		 * TestBeanDo beanDo = new TestBeanDo();
		 * 
		 * beanDo.setId(testBean.getId()); beanDo.setName(testBean.getName());
		 */

		Session session = logSessionFactory.getObject().getCurrentSession();

		//session.saveOrUpdate(testBean);
		
		 String hqlUpdate = "update TestBeanDo ks set ks.id = :id,ks.name = :name,"
		 		+ "ks.description = :description, ks.updatedDate = :updatedDate"
		 		+ " where ks.id = :id";
	        int updatedEntities = session.createQuery(hqlUpdate)
	        		.setInteger("id", testBean.getId())
	        		.setString("name", testBean.getName())
	        		.setString("description", testBean.getDescription())
	        		.setTimestamp("updatedDate", testBean.getUpdatedDate())
	        		.executeUpdate();
	        
	        System.out.println(updatedEntities);
		
		
		
	}

	@Override
	@Transactional
	public ErrorCodeDo findDescription(int code) {
		// TODO Auto-generated method stub
		Session session = logSessionFactory.getObject().getCurrentSession();
		ErrorCodeDo errorCodeDo = null;

		if (code != 0) {

			Criteria cr = session.createCriteria(ErrorCodeDo.class);
			cr.add(Restrictions.eq("errorCode", code));
			errorCodeDo = (ErrorCodeDo) cr.uniqueResult();

		}
		return errorCodeDo;
	}
	
	


	@Override
	@Transactional
	public CountryFieldResponse getFieldByCountryId(String countryId) {

		CountryFieldResponse countryFieldResponse = new CountryFieldResponse();
		
		Set<BeneField> beneFieldList = new HashSet<>(); 

		Session session = logSessionFactory.getObject().getCurrentSession();
		Criteria cr = session.createCriteria(CountryFieldsDo.class);
		cr.add(Restrictions.eq("countryId", countryId));

		List<CountryFieldsDo> countryFieldsDos = null;
		

		countryFieldsDos = cr.list();

		for (CountryFieldsDo countryFieldsDo : countryFieldsDos) {

			BeneField beneField = new BeneField();
			
			
			beneField.setFieldId(countryFieldsDo.getBeneFieldsDo().getFieldId());
			beneField.setFieldName(countryFieldsDo.getBeneFieldsDo().getFieldName());
			beneField.setFieldStatus(countryFieldsDo.getBeneFieldsDo().getFieldStatus());
			beneField.setLabelName(countryFieldsDo.getBeneFieldsDo().getLabelName());
			beneField.setMandatory(countryFieldsDo.getMandatory());
			beneField.setMaxLength(countryFieldsDo.getBeneFieldsDo().getMaxLength());
			
			beneFieldList.add(beneField);
		}
			
		countryFieldResponse.setBeneFields(beneFieldList);
		// TODO Auto-generated method stub
		return countryFieldResponse;
	}
	
	
	@Override
	@Cacheable(value="test", key="#id")
	@Transactional
	public TestBeanDo getTest(int id) {
		Session session = logSessionFactory.getObject().getCurrentSession();
		
		TestBeanDo beanDo = null;
		
		Criteria cr = session.createCriteria(TestBeanDo.class);
		cr.add(Restrictions.eq("id",id));
		beanDo = (TestBeanDo) cr.uniqueResult();
		// TODO Auto-generated method stub
		return beanDo;
	}

	@Override
	@CacheEvict(value="test", key="#id")
	public String clearCache(int id) {
		// TODO Auto-generated method stub
		return "Cleared cache for Id : " + id;
	}

	
}
