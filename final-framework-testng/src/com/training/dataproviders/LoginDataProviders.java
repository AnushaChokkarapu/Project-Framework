package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ApachePOIExcelRead1;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[7]; 
			obj[0] = temp.getFirstName();
			obj[1] = temp.getLastName();
			obj[2] = temp.getEmail();
			obj[3] = temp.getUserName(); 
			obj[4] = temp.getPassword(); 
			obj[5] = temp.getConfirmPassword();
			obj[6] = temp.getPhone();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\AnushaChokkarapu\\Desktop\\Selenium Training\\Project\\TestData_ELearning.xlsx"; 
		String SheetName = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Users\\AnushaChokkarapu\\Desktop\\Selenium Training\\Project\\TestData_ELearning.xlsx"; 
		String SheetName = "Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Users\\AnushaChokkarapu\\Desktop\\Selenium Training\\Project\\TestData_ELearning.xlsx"; 
		String SheetName = "Sheet3";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
