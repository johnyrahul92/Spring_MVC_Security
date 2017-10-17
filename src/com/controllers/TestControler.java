package com.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

import com.DAO.TestDao;
import com.dto.ErrorCodeDo;
import com.dto.TestBeanDo;
import com.pojo.CountryFieldResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

@Controller
public class TestControler {
	
	@Value("${testprop}")
	String description;
	
	@Autowired
	TestDao testDao;
	
	
	@Scheduled(fixedRate = 100000L)
    protected void autoScheduledClean() {

        System.out.println("Rahul Johnnyyyy");
    }

	

	@RequestMapping(value = "/testPage", method = RequestMethod.GET)
	public String printTestPage(ModelMap model) {
		model.addAttribute("Meaasge", "Test Page");
		
		return "testPage";
		
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/httpPost", method = RequestMethod.GET)
	public String httpPost() {			
		return "httpPost";		
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody TestBeanDo saveTest() {
		
		TestBeanDo testBean =  new TestBeanDo();
		
		testBean.setId(0);
		testBean.setName("Rahul");
		testBean.setDescription("'description'");
		testBean.setUpdatedDate(new Date());		
		testDao.addTest(testBean);		
		
		
		return testBean;
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody TestBeanDo getTest(@RequestParam int id) {		
		
			
		System.out.println("getting from Db for id" + id
				);
		TestBeanDo testBean= testDao.getTest(id);
		
		
		
		return testBean;
	}
	
	@RequestMapping(value = "/clearCache", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String clearCache(@RequestParam int id) {
		
		
		String text =testDao.clearCache(id);
		
		
		
		return text;
	}
	
	@RequestMapping(value = "/getErrorByCode", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ErrorCodeDo paymentInitiation(@RequestParam int code) {
		
		ErrorCodeDo errorCodeDo =  testDao.findDescription(code);
	
		
		if (errorCodeDo == null) {
			
			
			
		}else {
			errorCodeDo = testDao.findDescription(code);
		}
		
		
		return errorCodeDo;
	}
	@RequestMapping(value = "/getFieldByCountryId", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody CountryFieldResponse getFieldByCountryId(@RequestParam String countryId) {
		
		CountryFieldResponse countryFieldResponse = null;
		
		countryFieldResponse = testDao.getFieldByCountryId(countryId);
		
		return countryFieldResponse;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody int add(@RequestParam int a,@RequestParam int b) {
		
		Calculator calculator = new Calculator();
		
		CalculatorSoap calculatorSoap = calculator.getCalculatorSoap();
		
		calculatorSoap.add(a, b);
		
		
		
		
		return calculatorSoap.add(a, b);
	}
	
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody void add(@RequestParam("file") MultipartFile file,@RequestParam("username") String username, HttpServletResponse response) {
		
		System.out.println("+++++++++Uploaded+++++++++");
		//System.out.println(username);
		System.out.println(file.toString());
		String content;
		try {
            FileUtils.writeByteArrayToFile(new File("C://Users/online09/Desktop/Rahul_Johny/Portal-XML/08212017/sd.txt"),
                IOUtils.toByteArray(file.getInputStream()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		try {
			content = new String(file.getBytes());
			response.setContentType("text/plain");
			response.setHeader("Content-Disposition","attachment;filename=changedFile.txt");
			ServletOutputStream out = response.getOutputStream();
			out.println(content);
		    out.flush();
		    out.close();
			System.out.println(content);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
//	@RequestMapping(value = "/fileupload", method = RequestMethod.POST, produces = "application/json")
//	public @ResponseBody int add(@RequestParam("file") MultipartFile file,@RequestParam("username") String username) {
//		
//		System.out.println("+++++++++Uploaded+++++++++");
//		//System.out.println(username);
//		System.out.println(file.toString());
//		String content;
//		try {
//			content = new String(file.getBytes());
//			System.out.println(content);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(file.getOriginalFilename());
//		System.out.println(username);
//		
//		
//		
//		
//		
//		return 9999;
//	}
//	
//	
}
