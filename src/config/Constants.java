package config;

public class Constants {
	//List of System Variables
	 public static final String URL = "http://172.16.0.220:8001/";
	 public static final String HDDV = "http://172.16.0.220:8001/HD01ServiceContract";
	 public static final String HDNK = "http://172.16.0.220:8001/IB01ReceiptContract";
	 public static final String LinkToKhai = "http://172.16.0.220:8001/IB02CustomDeclaration";
	 public static final String LinkDSPhieuNhap = "http://172.16.0.220:8001/IB03ReceiptNote";
	 public static final String LinkDSSanLuong = "http://172.16.0.220:8001/T31FeeProduction";
	 public static final String LinkDSPhieuxuat = "http://172.16.0.220:8001/OB02ShippingNote";
	 public static final String LinkK05TonKhoSanPham = "http://172.16.0.220:8001/K05InventoryByItem";

	 
	 public static final String Path_TestData = "D:\\oanhpttt\\Selenium\\DataEngine.xlsx";
	 public static final String Path_OR = "D:\\oanhpttt\\Selenium\\OR.properties";
	 public static final String File_TestData = "DataEngine.xlsx";
	 

	 
//	 //List of Data Sheet Column Numbers
//	 public static final int Col_TestCaseID = 0; 
//	 public static final int Col_TestScenarioID = 1 ;
//	 //This is the new column for 'Page Object'
//	 public static final int Col_PageObject = 4 ;
//	 //This column is shifted from 3 to 4
//	 public static final int Col_ActionKeyword =5 ;
//	 public static final int Col_RunMode =2 ;
//	 
//	 public static final int Col_Result =3 ;
//	 public static final int Col_Loop_TestCase =4 ;
//	 public static final int Col_Date_TestCase =5 ;
//	 public static final int Col_DataSet =6 ;
//	 public static final int Col_TestStepResult =7 ;
	 
	 
	 //List of Data Sheet Column Numbers
	 public static final int Col_TestCaseID = 0; 
	 public static final int Col_TestScenarioID = 1;
	 //This is the new column for 'Page Object'
	 public static final int Col_PageObject = 2;
	 //This column is shifted from 3 to 4
	 public static final int Col_ActionKeyword = 3;
	 public static final int Col_RunMode =2 ;
	 
	 public static final int Col_Result =3 ;
	 public static final int Col_Loop_TestCase =4 ;
	 public static final int Col_Date_TestCase =5 ;
	 public static final int Col_DataSet = 4;
	 public static final int Col_TestStepResult = 5;
	 
	 
	 public static final String KEYWORD_FAIL = "FAIL";
	 public static final String KEYWORD_PASS = "PASS";
	 
	 //List of Data Engine Excel sheets
	 public static final String Sheet_TestSteps = "Test Steps";
	 //New entry in Constant variable
	 public static final String Sheet_TestCases = "Test Cases";
	//*[@id="gridHD01ServiceContract"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[3]/div/a

}
