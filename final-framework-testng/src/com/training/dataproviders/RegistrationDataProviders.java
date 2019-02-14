package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RegistrationBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RegistrationDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class RegistrationDataProviders {
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RegistrationBean> list = new RegistrationDAO().getRegistrations(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegistrationBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName(); 
			obj[2] = temp.geteMail();
			obj[3] = temp.getUserName();
			obj[4] = temp.getPass();
			obj[5] = temp.getConfirmPass();
			obj[6] = temp.getPhone();
			obj[7] = temp.getLanguage();
			
			result[count ++] = obj; 
		}
			
		return result;
	}
	
	/*@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
	//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; ///<satya>/change path as given in ApachePOIReadexcel java class
	//String fileName="C:\\Users\\SatyaKumari\\Desktop\\Selenium\\Project\\ComplexLevelTestCases6Febto15Feb\\TestDataSheet.xlsx";
    String fileName="C:\\Users\\SatyaKumari\\Desktop\\TestDataSheet.xlsx";		
	System.out.println("Filename inside Dataprovider:"+fileName);
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}*/
	
	@DataProvider(name = "excel_input_TC_76")//data provider name 
	public Object[][] getExcelDataTC76(){
	String fileName="./resources/TestDataSheet.xlsx";
	String sheetName="TC_76";
	System.out.println("Filename inside Dataprovider:"+fileName);
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel_input_TC_77")//data provider name 
	public Object[][] getExcelDataTC77(){
	String fileName="./resources/TestDataSheet.xlsx";
	String sheetName="TC_77";
	System.out.println("Filename inside Dataprovider:"+fileName);
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	@DataProvider(name = "excel_input_TC_80")//data provider name 
	public Object[][] getExcelDataTC80(){
	String fileName="./resources/TestDataSheet.xlsx";
	String sheetName="TC_80";
	System.out.println("Filename inside Dataprovider:"+fileName);
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}


}
