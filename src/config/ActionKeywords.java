package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//import static executionEngine.DiWMS_AutoTest_GUI.OR;
import static executionEngine.main_run_gui.OR;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import executionEngine.DiWMS_AutoTest_GUI;
import executionEngine.main_run_gui;
import utility.Log;

public class ActionKeywords {

	public static WebDriver driver;
	static String tchddv = null;
	static String tcsohddv = null;

	static String tchdnk1 = null;
	static String tchdnk2 = null;

	static String tokhai1 = null;
	static String tokhai2 = null;

	static String maphieunhap1 = null;
	static String maphieunhap2 = null;
	static String phieunhap1 = null;
	static String phieunhap2 = null;

	static String maphieuxuat1 = null;
	static String maphieuxuat2 = null;
	static String phieuxuat1 = null;
	static String phieuxuat2 = null;

	static String phieuchuyenkho1 = null;
	static String phieuchuyenkho2 = null;

	static int NhapSoLuongTon1 = 0;
	static int NhapSoLuongTon2 = 0;
	static String SoLuongThucNhap = null;

	static int XuatSoLuongTon1 = 0;
	static int XuatSoLuongTon2 = 0;
	static String SoLuongThucXuat = null;

	static int ChuyenKhoSoLuongTon1 = 0;
	static int ChuyenKhoSoLuongTon2 = 0;
	static int ChuyenKhoSoLuongTon3 = 0;
	static int ChuyenKhoSoLuongTon4 = 0;
	static String SoLuongYeuCauChuyen = null;
//	static int SoLuongDaXuatChuyenKho = 0;

	static String sanpham1 = null;
	static String sanpham2 = null;

	static String Kit01_1 = null;
	static String Kit01_2 = null;
	static String Ma_Kit01 = null;

	static String Kit02_1 = null;
	static String Kit02_2 = null;

	static String maphieuchuyenkhoK12_1 = null;
	static String maphieuchuyenkhoK12_2 = null;

	static String maphieuk31_1 = null;
	static String maphieuk31_2 = null;

	static int STNhapSoLuongTon1 = 0;
	static int STNhapSoLuongTon2 = 0;
	static String SoLuongNhapST = null;

	static String maphieuPO_1 = null;
	static String maphieuPO_2 = null;

	static int STXuatSoLuongTon1 = 0;
	static int STXuatSoLuongTon2 = 0;
	static String SoLuongSO = null;
	static String maphieuSO_1 = null;
	static String maphieuSO_2 = null;
	static String maphieuShipment_1 = null;
	static String maphieuShipment_2 = null;
	static int SumQtyShippedSI = 0;
	static int SumQtyTonKho1 = 0;
	static int SumQtyTonKho2 = 0;
	static int SumQtyShippedLine = 0;
	static Long SumQtyAvailable = null;
	static int ItemQtyAvailable = 0;
	static int ItemQtyAvailableSI = 0;
	static Long OrderQtySO = null;

	static Date obDate = new Date();
	static SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	static String tenemail = null;
	
	static String emailminerva = null;
	static String phoneminerva = null;

	public static void openBrowser(String object, String data) {

		try {
			if (data.equals("Mozilla")) {
				driver = new FirefoxDriver();
				Log.info("Mozilla browser started");
			} else if (data.equals("IE")) {
				// Dummy Code, Implement you own code
				driver = new InternetExplorerDriver();
				Log.info("IE browser started");
			} else if (data.equals("Chrome")) {
				// Dummy Code, Implement you own code
				String drivePath = System.getProperty("user.dir") + "\\chromedriver.exe";
				driver = new ChromeDriver();
				driver.manage().window().maximize();

			}

			int implicitWaitTime = (10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.info("Khong the mo Browser --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetLinkPage(String object, String data) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(OR.getProperty(object));
		} catch (Exception e) {
			Log.info("khong the chuyen huong --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkLogin(String object, String data) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL);
		} catch (Exception e) {
			Log.info("khong the chuyen huong --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void Input(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data);
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputByID(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.id(OR.getProperty(object.trim()))).sendKeys(data);
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputNoWait(String object, String data) {
		try {

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data);
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void ActionSenkey(String object, String data) {
		try {

			WebElement element = driver.findElement(By.xpath(OR.getProperty(object)));
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(data);
			actions.build().perform();
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void SelectByTextID(String object, String data) {
		try {

			WaitElement(object, data);

			Select sl = new Select(driver.findElement(By.xpath(OR.getProperty(object))));
			sl.selectByVisibleText(data);

		} catch (Exception e) {
			Log.error("Khong the select --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void click(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			Log.error("Khong the click --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void clickByID(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.id(OR.getProperty(object))).click();
		} catch (Exception e) {
			Log.error("Khong the click --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void WaitElement(String object, String data) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 120, 1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
		} catch (Exception e) {
			Log.error("Khong tim thay Element de doi --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void waitFor3s(String object, String data) throws Exception {
		try {

			Thread.sleep(3000);
		} catch (Exception e) {
			Log.error("Khong the doi --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void waitFor5s(String object, String data) throws Exception {
		try {

			Thread.sleep(5000);
		} catch (Exception e) {
			Log.error("Khong the doi --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void waitFor10s(String object, String data) throws Exception {
		try {

			Thread.sleep(10000);
		} catch (Exception e) {
			Log.error("Khong the doi --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void waitFor1s(String object, String data) throws Exception {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			Log.error("Khong the doi --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void waitFor500ms(String object, String data) throws Exception {
		try {

			Thread.sleep(500);
		} catch (Exception e) {
			Log.error("Khong the doi --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void closeBrowser(String object, String data) {
		try {

			driver.quit();
		} catch (Exception e) {
			Log.error("Khong the dong Browser --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void ActionMouse(String object, String data) {
		try {

			WaitElement(object, data);
			WebElement element = driver.findElement(By.xpath(OR.getProperty(object)));
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(data);
			actions.build().perform();

			tcsohddv = data;
			System.out.println("HDDV1:" + " " + data);
			Log.info("HDDV1:" + " " + data);
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void Enter(String object, String data) {
		try {
			;
			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			Log.error("Khong the enter --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void KeoThanhScrollCuoiTrang(String object, String data) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
		} catch (Exception e) {
			Log.error("Khong the keo scroll xuong cuoi trang --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void KeoThanhScrollDauTrang(String object, String data) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");
		} catch (Exception e) {
			Log.error("Khong the keo scroll xuong cuoi trang --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void KeoThanhScrollNgang(String object, String data) {
		try {

			WebElement vitrikeoden = driver.findElement(By.xpath(OR.getProperty(object)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", vitrikeoden);
		} catch (Exception e) {
			Log.error("Khong the keo thanh scroll ngang --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void RefreshPage(String object, String data) {
		try {

			driver.navigate().refresh();
		} catch (Exception e) {
			Log.error("Khong the refresh --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LayPhanTuDauTien(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.DOWN);
		} catch (Exception e) {
			Log.error("Khong the lay phan tu dau tien --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndEnter(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.chord(Keys.CONTROL, "a"), data,
					Keys.ENTER);
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndClear(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.chord(Keys.CONTROL, "a"), data);
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndTab(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.chord(Keys.CONTROL, "a"), data,
					Keys.TAB);
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void Tab(String object, String data) {
		try {
//			Log.info("Ctrl + A du lieu sau do senkey roi nhan phim Enter");
			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.TAB);
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void Clear(String object, String data) {
		try {
//			Log.info("Ctrl + A du lieu sau do senkey roi nhan phim Enter");
			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).clear();
			;
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void ClearByID(String object, String data) {
		try {
//			Log.info("Ctrl + A du lieu sau do senkey roi nhan phim Enter");
			WaitElement(object, data);
			driver.findElement(By.id(OR.getProperty(object))).clear();
			;
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void ClearAndInput(String object, String data) {
		try {
//			Log.info("Ctrl + A du lieu sau do senkey roi nhan phim Enter");
			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.chord(Keys.CONTROL, "a"), data);
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void switch_To_Popup(String object, String data) {
		try {
//			Log.info("Wating pop up apper to switch ");
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
		} catch (Exception e) {
			Log.error("Not appear pop up to switch" + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void SwitchTab4(String object, String data) {
		try {
//			Log.info("Chuyen sang tab 2");
			ArrayList<String> tabs4 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs4.get(3));
		} catch (Exception e) {
			Log.error("Chuyen tab that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void SwitchTab3(String object, String data) {
		try {
//			Log.info("Chuyen sang tab 2");
			ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs3.get(2));
		} catch (Exception e) {
			Log.error("Chuyen tab that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void SwitchTab2(String object, String data) {
		try {
//			Log.info("Chuyen sang tab 2");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
		} catch (Exception e) {
			Log.error("Chuyen tab that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void SwitchTab1(String object, String data) {
		try {
			ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(0));
		} catch (Exception e) {
			Log.error("Chuyen tab that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndRandomNumber(String object, String data) {
		try {

//			Random generator = new Random();
//			int a = generator.nextInt(1000000) + 1;

			String s = RandomStringUtils.randomAlphabetic(6);

			String n = RandomStringUtils.randomNumeric(6);

//			String uuid = UUID.randomUUID().toString();

//			String randomnumber = Integer.toString(a);
//			data = randomnumber + s;
			data = n + s;

//			System.out.println("Random No : " + n + s);

//			for (int iCount = 0; iCount < 10; iCount++) {
//				int i = generator.nextInt(9);
//				System.out.println("Random No : " + i);
//				String randomnumber = Integer.toString(i);
//				data = randomnumber;
//			}

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data);

		} catch (Exception e) {
			Log.error("random that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static void CallCaptureScreen(String object, String data) {
		try {
//			takeSnapShot(driver, "D:\\test.png");
//			Date obDate = new Date();
//			SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			String n = RandomStringUtils.randomNumeric(6);
			takeSnapShot(driver, (OR.getProperty(object)) + n + "_" + obDateFormat.format(obDate.getTime()) + ".png");
		}
		catch (Exception e) {
			Log.error("Call Capture that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	
	
	public static void SendMail(String filename, String data) {
		try {
			// Create object of Property file
			Properties props = new Properties();
	 
			// this will set host of server- you can change based on your requirement 
			props.put("mail.smtp.host", "smtp.gmail.com");
	 
			// set the port of socket factory 
			props.put("mail.smtp.socketFactory.port", "465");
	 
			// set socket factory
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	 
			// set the authentication to true
			props.put("mail.smtp.auth", "true");
	 
			// set the port of SMTP server
			props.put("mail.smtp.port", "465");
	 
			// This will handle the complete authentication
			Session session = Session.getDefaultInstance(props,
	 
					new javax.mail.Authenticator() {
	 
						protected PasswordAuthentication getPasswordAuthentication() {
	 
						return new PasswordAuthentication("phanthientuoanh@gmail.com", "01665495266");
	 
						}
	 
					});
	 
			try {
				
	 
				// Create object of MimeMessage class
				Message message = new MimeMessage(session);
	 
				// Set the from address
				message.setFrom(new InternetAddress(data));
	 
				// Set the recipient address
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(data));
	            
	                        // Add the subject link
				message.setSubject("Image Capture");
	 
				// Create object to add multimedia type content
				BodyPart messageBodyPart1 = new MimeBodyPart();
	 
				// Set the body of email
				messageBodyPart1.setText("Email system auto sending");
	 
				// Create another object to add another content
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	 
				// Mention the file which you want to send
//				String filename = OR.getProperty(object);
//				String Filename = "";
//				Filename = filename;
				
	 
				// Create data source and pass the filename
				DataSource source = new FileDataSource(filename);
	 
				// set the handler
				messageBodyPart2.setDataHandler(new DataHandler(source));
	 
				// set the file
				messageBodyPart2.setFileName(filename);
	 
				// Create object of MimeMultipart class
				Multipart multipart = new MimeMultipart();
	 
				// add body part 1
				multipart.addBodyPart(messageBodyPart2);
	 
				// add body part 2
				multipart.addBodyPart(messageBodyPart1);
	 
				// set the content
				message.setContent(multipart);
	 
				// finally send the email
				Transport.send(message);
	 
				System.out.println("=====Email Sent=====");
	 
			} catch (MessagingException e) {
	 
				throw new RuntimeException(e);
	 
			}

		}
		catch (Exception e) {
			Log.error("Send Mail that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void SendMailCall(String object, String data) {
		try {
			// Create object of Property file
			Properties props = new Properties();
	 
			// this will set host of server- you can change based on your requirement 
			props.put("mail.smtp.host", "smtp.gmail.com");
	 
			// set the port of socket factory 
			props.put("mail.smtp.socketFactory.port", "465");
	 
			// set socket factory
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	 
			// set the authentication to true
			props.put("mail.smtp.auth", "true");
	 
			// set the port of SMTP server
			props.put("mail.smtp.port", "465");
	 
			// This will handle the complete authentication
			Session session = Session.getDefaultInstance(props,
	 
					new javax.mail.Authenticator() {
	 
						protected PasswordAuthentication getPasswordAuthentication() {
	 
						return new PasswordAuthentication("phanthientuoanh@gmail.com", "01665495266");
	 
						}
	 
					});
	 
			try {
				
	 
				// Create object of MimeMessage class
				Message message = new MimeMessage(session);
	 
				// Set the from address
				message.setFrom(new InternetAddress(data));
	 
				// Set the recipient address
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(data));
	            
	                        // Add the subject link
				message.setSubject("Image Capture");
	 
				// Create object to add multimedia type content
				BodyPart messageBodyPart1 = new MimeBodyPart();
	 
				// Set the body of email
				messageBodyPart1.setText("Email system auto sending");
	 
				// Create another object to add another content
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	 
				// Mention the file which you want to send
//				String filename = OR.getProperty(object);
//				String Filename = "";
//				Filename = filename;
//				String filename = "D:\\oanhpttt\\Selenium\\NewProject 2019\\ProjectTest\\JSON_API_Test.json";
	 
				// Create data source and pass the filename
				DataSource source = new FileDataSource(OR.getProperty(object));
	 
				// set the handler
				messageBodyPart2.setDataHandler(new DataHandler(source));
	 
				// set the file
				messageBodyPart2.setFileName(OR.getProperty(object));
	 
				// Create object of MimeMultipart class
				Multipart multipart = new MimeMultipart();
	 
				// add body part 1
				multipart.addBodyPart(messageBodyPart2);
	 
				// add body part 2
				multipart.addBodyPart(messageBodyPart1);
	 
				// set the content
				message.setContent(multipart);
	 
				// finally send the email
				Transport.send(message);
	 
				System.out.println("=====Email Sent Call=====");
	 
			} catch (MessagingException e) {
	 
				throw new RuntimeException(e);
	 
			}

		}
		catch (Exception e) {
			Log.error("Send Mail that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void ReadFileTXT(String s) {
		try {
			final String dir = System.getProperty("user.dir");
			FileReader fr = new FileReader(dir + "\\Email.txt");
	        BufferedReader br = new BufferedReader(fr);
	        s="";
	        s=br.readLine();
	        System.out.println(s);
	        tenemail = s;

		}
		catch (Exception e) {
			Log.error("Read File txt that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	// CODE DANH CHO CAC HAM DUNG CHUNG

//*********************************************************************************************************************************************************************//	
//*********************************************************************************************************************************************************************//	
//*********************************************************************************************************************************************************************//	

	// CODE DANH CHO HAM KIEM TRA
	
	// CDOE FOR MINERVA
	public static void InputEmailMinerva(String object, String data) {
		try {

			
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			emailminerva = data;
			System.out.println("Nguoi dung nhap dia chi email la:" + " " + emailminerva);
			Log.info("Nguoi dung nhap dia chi email la:" + " " + emailminerva);

		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void InputPhoneMinerva(String object, String data) {
		try {
			
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			phoneminerva = data;
			System.out.println("Nguoi dung nhap so phone la:" + " " + phoneminerva);
			Log.info("Nguoi dung nhap so phone la:" + " " + phoneminerva);

		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void CheckMuaHangMinerva(String object, String data) {
		try {
			
			String emailminerva2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/dl/dd[1]")).getText();
			String phonenminerva2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/dl/dd[3]")).getText();
			if (emailminerva.equals(emailminerva2) && phoneminerva.equals(phonenminerva2)) {
				System.out.println("Submit thanh cong");
				Log.info("Submit thanh cong");
				
				takeSnapShot(driver, "CaptureAfterOrder\\InformationOrder" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				ReadFileTXT(tenemail);
				SendMail(("CaptureAfterOrder\\InformationOrder" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);


			} else {
				System.out.println("Submit that bai");
				Log.info("Submit that bai");
			}
			
						
		} catch (Exception e) {
			Log.error("Khong the kiem tra --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	
	// CDOE FOR MINERVA
	
	public static void InputAndEnterSLThucNhap(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.chord(Keys.CONTROL, "a"), data,
					Keys.ENTER);
			SoLuongThucNhap = data;
			System.out.println("So luong nhap moi vao kho la:" + " " + SoLuongThucNhap);
			Log.info("So luong nhap moi vao kho la:" + " " + SoLuongThucNhap);

		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndEnterSLThucXuat(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.chord(Keys.CONTROL, "a"), data,
					Keys.ENTER);
			SoLuongThucXuat = data;
			System.out.println("So luong yeu cau xuat kho la:" + " " + SoLuongThucXuat);
			Log.info("So luong yeu cau xuat kho la:" + " " + SoLuongThucXuat);

		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndEnterSLYeuCauChuyen(String object, String data) {
		try {

			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.chord(Keys.CONTROL, "a"), data,
					Keys.ENTER);
			SoLuongYeuCauChuyen = data;
			System.out.println("So luong yeu cau chuyen kho la:" + " " + SoLuongYeuCauChuyen);
			Log.info("So luong yeu cau chuyen kho la:" + " " + SoLuongYeuCauChuyen);

		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkHDDV(String object, String data) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.HDDV);

		} catch (Exception e) {
			Log.info("Get link HDDV that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}

	}

	public static void CheckHDDV(String object, String data) {
		try {

			WaitElement(object, data);
			WebElement hddv = driver.findElement(By.xpath(OR.getProperty(object)));

			tchddv = hddv.getText();
			System.out.println("HDDV2:" + "  " + tchddv);
			Log.info("HDDV2:" + " " + tchddv);
			if (tchddv.equals(tcsohddv)) {
				System.out.println("Tao HDDV thanh cong");
				Log.info("Tao HDDV thanh cong");

			} else
				System.out.println("Tao HDDV that bai");
			Thread.sleep(3000);

		} catch (Exception e) {
			Log.info("Tao HDDV that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}

	}

	public static void LinkHDNK(String object, String data) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.HDNK);

		} catch (Exception e) {
			Log.info("Khong link duoc HDNK --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckHDNK(String object, String data) {
		try {

			WaitElement(object, data);
			WebElement hdnk = driver.findElement(By.xpath(OR.getProperty(object)));

			tchdnk1 = hdnk.getText();
			System.out.println("HDNK2" + "  " + tchdnk1);
			Log.info("HDNK2" + "  " + tchdnk1);
			if (tchdnk1.equals(tchdnk2)) {
				System.out.println("Tao HDNK thanh cong");
				Log.info("Tao HDNK thanh cong");
			} else
				System.out.println("Tao HDNK that bai");
			Thread.sleep(3000);

		} catch (Exception e) {
			Log.info("Tao HDNK that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkToKhai(String object, String data) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.LinkToKhai);

		} catch (Exception e) {
			Log.info("khong link duoc trang To Khai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckToKhai(String object, String data) {
		try {

			WaitElement(object, data);
			WebElement tokhai = driver.findElement(By.xpath(OR.getProperty(object)));

			tokhai2 = tokhai.getText();
			System.out.println("To Khai 2" + "  " + tokhai2);
			Log.info("To Khai 2" + "  " + tokhai2);
			if (tokhai2.equals(tokhai1)) {
				System.out.println("Tao To Khai thanh cong");
				Log.info("Tao To Khai  thanh cong");
			} else
				System.out.println("Tao To Khai  that bai");
			Thread.sleep(3000);

		} catch (Exception e) {
			Log.info("Tao To Khai  that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetLinkPhieuNhap1(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			phieunhap1 = currentURL;
			System.out.println("Link Phieu nhap 1" + " " + phieunhap1);
			Log.info("Link Phieu nhap 1" + " " + phieunhap1);

		} catch (Exception e) {
			Log.info("khong get duoc link Phieu nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetLinkPhieuNhap2(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			phieunhap2 = currentURL;
			System.out.println("Link Phieu nhap 2" + " " + phieunhap2);
			Log.info("Link Phieu nhap 2" + " " + phieunhap2);
			Thread.sleep(1000);

			if (phieunhap1.equals(phieunhap2)) {
				System.out.println("Tao phieu nhap thanh cong");
				Log.info("Tao phieu nhap thanh cong");
			} else {
				System.out.println("Tao phieu nhap that bai");
				Log.info("Tao phieu nhap that bai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc link Phieu nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkPhieuNhap(String object, String data) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.LinkDSPhieuNhap);

			WebElement maphieunhap = driver.findElement(By.xpath(OR.getProperty(object)));
			maphieunhap.click();

		} catch (Exception e) {
			Log.info("khong link duoc trang Phieu nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkPhieuNhap2(String object, String data) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.LinkDSPhieuNhap);
		} catch (Exception e) {
			Log.info("khong link duoc trang Phieu nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetLinkPhieuXuat1(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			phieuxuat1 = currentURL;
			System.out.println("Link Phieu xuat 1" + " " + phieuxuat1);
			Log.info("Link Phieu xuat 1" + " " + phieuxuat1);

		} catch (Exception e) {
			Log.info("khong get duoc link Phieu xuat --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetLinkPhieuXuat2(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			phieuxuat2 = currentURL;
			System.out.println("Link Phieu xuat 2" + " " + phieuxuat2);
			Log.info("Link Phieu xuat 2" + " " + phieuxuat2);
			Thread.sleep(1000);

			if (phieuxuat1.equals(phieuxuat2)) {
				System.out.println("Tao phieu xuat thanh cong");
				Log.info("Tao phieu xuat thanh cong");
			} else {
				System.out.println("Tao phieu xuat that bai");
				Log.info("Tao phieu xuat that bai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc link Phieu xuat --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkPhieuXuat2(String object, String data) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.LinkDSPhieuxuat);
		} catch (Exception e) {
			Log.info("khong link duoc trang Phieu xuat --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkPhieuXuat1(String object, String data) {
		try {

//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.get(Constants.LinkDSPhieuxuat);
			WebElement maphieuxuat = driver.findElement(By.xpath(OR.getProperty(object)));
			maphieuxuat.click();

		} catch (Exception e) {
			Log.info("khong link duoc trang Phieu xuat --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKho1(String object, String data) {
		try {
			WebElement nodata = driver.findElement(By.xpath("//*[@id=\'gridMD03Product\']/div/div[6]/span"));
			if (nodata.isDisplayed()) {
				NhapSoLuongTon1 = 0;
			} else {
				String Soluongton1 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
				NhapSoLuongTon1 = Integer.parseInt(Soluongton1);
			}

			System.out.println("So luong ton kho truoc nhap la:" + " " + NhapSoLuongTon1);
			Log.info("So luong ton kho truoc nhap la:" + " " + NhapSoLuongTon1);

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKho2(String object, String data) {
		try {

			WebElement nodata = driver.findElement(By.xpath("//*[@id=\'gridMD03Product\']/div/div[6]/span"));
			if (nodata.isDisplayed()) {
				NhapSoLuongTon2 = 0;
			} else {
				String Soluongton2 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
				NhapSoLuongTon2 = Integer.parseInt(Soluongton2);
			}

			System.out.println("So luong ton kho sau nhap la:" + " " + NhapSoLuongTon2);
			Log.info("So luong ton kho sau nhap la:" + " " + NhapSoLuongTon2);

			int sltn = Integer.parseInt(SoLuongThucNhap);
			int tonsaunhap = NhapSoLuongTon1 + sltn;

			if (tonsaunhap == NhapSoLuongTon2) {
				System.out.println("Ton kho Nhap dung");
				Log.info("Ton kho Nhap dung");
			} else {
				System.out.println("Ton kho sai");
				Log.info("Ton kho sai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoChuyenKho1(String object, String data) {
		try {

			WebElement nodata = driver.findElement(By.xpath("//*[@id=\'gridMD03Product\']/div/div[6]/span"));
			if (nodata.isDisplayed()) {
				ChuyenKhoSoLuongTon1 = 0;
			} else {
				String Soluongton1 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
				ChuyenKhoSoLuongTon1 = Integer.parseInt(Soluongton1);
			}

			System.out
					.println("So luong ton kho san pham Kho Nguon truoc chuyen kho la: " + " " + ChuyenKhoSoLuongTon1);
			Log.info("So luong ton kho san pham Kho Nguon truoc chuyen kho la: " + " " + ChuyenKhoSoLuongTon1);

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoChuyenKho2(String object, String data) {
		try {

			WebElement nodata = driver.findElement(By.xpath("//*[@id=\'gridMD03Product\']/div/div[6]/span"));
			if (nodata.isDisplayed()) {
				ChuyenKhoSoLuongTon2 = 0;
			} else {
				String Soluongton2 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
				ChuyenKhoSoLuongTon2 = Integer.parseInt(Soluongton2);
			}

			System.out.println(
					"So luong ton kho san pham Kho Nguon sau xuat chuyen kho la:" + " " + ChuyenKhoSoLuongTon2);
			Log.info("So luong ton kho san pham Kho Nguon sau xuat chuyen kho la:" + " " + ChuyenKhoSoLuongTon2);

			int slycck = Integer.parseInt(SoLuongYeuCauChuyen);
			int tonsauxuat = ChuyenKhoSoLuongTon1 - slycck;

			if (tonsauxuat == ChuyenKhoSoLuongTon2) {
				System.out.println("Ton kho sau khi Xuat Chuyen Kho la dung");
				Log.info("Ton kho sau khi Xuat Chuyen Kho la dung");
			} else {
				System.out.println("Ton kho sau khi Xuat Chuyen Kho la sai");
				Log.info("Ton kho sau khi Xuat Chuyen Kho la sai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoChuyenKho3(String object, String data) {
		try {

			WebElement nodata = driver.findElement(By.xpath("//*[@id=\'gridMD03Product\']/div/div[6]/span"));
			if (nodata.isDisplayed()) {
				ChuyenKhoSoLuongTon4 = 0;
			} else {
				String Soluongton3 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
				ChuyenKhoSoLuongTon4 = Integer.parseInt(Soluongton3);
			}

			System.out.println("Ton kho san pham Kho Dich sau khi Nhap Chuyen Kho la : " + ChuyenKhoSoLuongTon4);
			Log.info("Ton kho san pham Kho Dich sau khi Nhap Chuyen Kho la : " + ChuyenKhoSoLuongTon4);

			int slycck = Integer.parseInt(SoLuongYeuCauChuyen);

			System.out.println("So luong yeu cau nhap la:" + " " + slycck);
			Log.info("So luong yeu cau nhap la:" + " " + slycck);

			int tonsaunhap = ChuyenKhoSoLuongTon3 + slycck;

			if (tonsaunhap == ChuyenKhoSoLuongTon4) {
				System.out.println("Ton kho sau khi Nhap Chuyen Kho la dung");
				Log.info("Ton kho sau khi Nhap Chuyen Kho la dung");
			} else {
				System.out.println("Ton kho sau khi Nhap Chuyen Kho la sai");
				Log.info("Ton kho sau khi Nhap Chuyen Kho la sai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoChuyenKho4(String object, String data) {
		try {

			WebElement nodata = driver.findElement(By.xpath("//*[@id=\'gridMD03Product\']/div/div[6]/span"));
			if (nodata.isDisplayed()) {
				ChuyenKhoSoLuongTon3 = 0;
			} else {
				String Soluongton3 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
				ChuyenKhoSoLuongTon3 = Integer.parseInt(Soluongton3);
			}

			System.out.println("Ton kho san pham cua Kho Dich truoc khi Nhap Chuyen la: " + ChuyenKhoSoLuongTon3);
			Log.info("Ton kho san pham cua Kho Dich truoc khi Nhap Chuyen la: " + ChuyenKhoSoLuongTon3);

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoXuat1(String object, String data) {
		try {

			WebElement nodata = driver.findElement(By.xpath("//*[@id=\'gridMD03Product\']/div/div[6]/span"));
			if (nodata.isDisplayed()) {
				XuatSoLuongTon1 = 0;
			} else {
				String Soluongton1 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
				XuatSoLuongTon1 = Integer.parseInt(Soluongton1);
			}

			System.out.println("So luong ton kho truoc xuat la:" + " " + XuatSoLuongTon1);
			Log.info("So luong ton kho truoc xuat la:" + " " + XuatSoLuongTon1);

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoXuat2(String object, String data) {
		try {

			WebElement nodata = driver.findElement(By.xpath("//*[@id=\'gridMD03Product\']/div/div[6]/span"));
			if (nodata.isDisplayed()) {
				XuatSoLuongTon2 = 0;
			} else {
				String Soluongton2 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
				XuatSoLuongTon2 = Integer.parseInt(Soluongton2);
			}

			System.out.println("So luong ton kho sau xuat la:" + " " + XuatSoLuongTon2);
			Log.info("So luong ton kho sau xuat la:" + " " + XuatSoLuongTon2);

			int sltx = Integer.parseInt(SoLuongThucXuat);
			int tonsauxuat = XuatSoLuongTon1 - sltx;

			if (tonsauxuat == XuatSoLuongTon2) {
				System.out.println("Ton kho Xuat dung");
				Log.info("Ton kho Xuat dung");
			} else {
				System.out.println("Ton kho Xuat sai");
				Log.info("Ton kho Xuat sai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongDaXuatChuyenKho(String object, String data) {
		try {

			String Soluongdaxuatchuyenkho2 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			int sldxck = Integer.parseInt(Soluongdaxuatchuyenkho2);

			int slycck = Integer.parseInt(SoLuongYeuCauChuyen);
			System.out.println("So luong da xuat chuyen kho la:" + " " + sldxck);
			Log.info("So luong da xuat chuyen kho la:" + " " + sldxck);

			if (sldxck == slycck) {
				System.out.println("Xuat chuyen kho thanh cong");
				Log.info("Xuat chuyen kho thanh cong");
			} else {
				System.out.println("Xuat chuyen kho that bai");
				Log.info("Xuat chuyen kho that bai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong da xuat --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongDaNhapChuyenKho(String object, String data) {
		try {

			String Soluongdanhapchuyenkho = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			int sldnck = Integer.parseInt(Soluongdanhapchuyenkho);

			int slycck = Integer.parseInt(SoLuongYeuCauChuyen);
			System.out.println("So luong da nhap chuyen kho la:" + " " + sldnck);
			Log.info("So luong da nhap chuyen kho la:" + " " + sldnck);

			if (sldnck == slycck) {
				System.out.println("Nhap chuyen kho thanh cong");
				Log.info("Nhap chuyen kho thanh cong");
			} else {
				System.out.println("Nhap chuyen kho that bai");
				Log.info("Nhap chuyen kho that bai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong da Nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetLinkPhieuChuyenKho1(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			phieuchuyenkho1 = currentURL;
			System.out.println("Link Phieu Chuyen Kho 1 la: " + " " + phieuchuyenkho1);
			Log.info("Link Phieu Chuyen Kho 1 la: " + " " + phieuchuyenkho1);

		} catch (Exception e) {
			Log.info("khong get duoc link Phieu Chuyen Kho --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkChiTietK09(String object, String data) {
		try {
			WaitElement(object, data);
			WebElement linkphieuchuyenkho = driver.findElement(By.xpath(OR.getProperty(object)));
			linkphieuchuyenkho.click();

		} catch (Exception e) {
			Log.info("khong get duoc link Phieu Chuyen Kho --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetLinkPhieuChuyenKho2(String object, String data) {
		try {
			String currentURL = driver.getCurrentUrl();
			phieuchuyenkho2 = currentURL;
			System.out.println("Link Phieu Chuyen Kho 2" + " " + phieuchuyenkho2);
			Log.info("Link Phieu Chuyen Kho 2" + " " + phieuchuyenkho2);
			Thread.sleep(1000);

			if (phieuchuyenkho1.equals(phieuchuyenkho2)) {
				System.out.println("Hoan tat chuyen kho thanh cong");
				Log.info("Hoan tat chuyen kho thanh cong");
			} else {
				System.out.println("Hoan tat chuyen kho that bai");
				Log.info("Hoan tat chuyen kho that bai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc link Phieu chuyen kho --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkSanLuong(String object, String data) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.LinkDSSanLuong);
			WaitElement(object, data);
			WebElement maphieunhapSL = driver.findElement(By.xpath(OR.getProperty(object)));

			phieunhap2 = maphieunhapSL.getText();
			System.out.println("Phieu nhap 2" + " " + phieunhap2);
			Log.info("Phieu nhap 2" + " " + phieunhap1);
			Thread.sleep(2000);
			if (phieunhap1.equals(phieunhap2)) {
				System.out.println("Phieu nhap da sinh ra san luong");
				Log.info("Phieu nhap da sinh ra san luong");
			} else
				System.out.println("Phieu nhap khong sinh ra san luong");
			Log.info("Phieu nhap khong sinh ra san luong");

		} catch (Exception e) {
			Log.info("khong link duoc trang Phieu nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	// SAN PHAM
	public static void LinkSanPham1(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			sanpham1 = currentURL;
			System.out.println("Link San pham 1" + " " + sanpham1);
			Log.info("Link San pham 1" + " " + sanpham1);

		} catch (Exception e) {
			Log.info("khong get duoc link San pham --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkSanPham2(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			sanpham2 = currentURL;
			System.out.println("Link San pham 2" + " " + sanpham2);
			Log.info("Link San pham 2" + " " + sanpham2);
			Thread.sleep(1000);

			if (sanpham1.equals(sanpham2)) {
				System.out.println("Tao San pham thanh cong");
				Log.info("Tao San pham thanh cong");
			} else {
				System.out.println("Tao San pham that bai");
				Log.info("Tao San pham that bai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc link San pham --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	// SAN PHAM

	// HDNK
	public static void InputSoHDNK(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			tchdnk2 = data;
			System.out.println("HDNK1" + " " + data);
			Log.info("HDNK1" + " " + data);
		} catch (Exception e) {
			Log.error("Khong the nhap So hop dong --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputToKhai(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			tokhai1 = data;
			System.out.println("To Khai 1" + " " + data);
			Log.info("To Khai 1" + " " + data);
		} catch (Exception e) {
			Log.error("Khong the nhap ToKhai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	// HDNK

	// KIT
	public static void LinkKIT02_1(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			Kit02_1 = currentURL;
			System.out.println("Link Kit02 1" + " " + Kit02_1);
			Log.info("Link Kit02 1" + " " + Kit02_1);

		} catch (Exception e) {
			Log.info("khong get duoc link Order Kit --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkKIT02_2(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			Kit02_2 = currentURL;
			System.out.println("Link Kit02 2" + " " + Kit02_2);
			Log.info("Link Kit02 2" + " " + Kit02_2);
			Thread.sleep(1000);

			if (Kit02_1.equals(Kit02_2)) {
				System.out.println("Tao Kit Order thanh cong");
				Log.info("Tao Kit Order thanh cong");
			} else {
				System.out.println("Tao Kit Order that bai");
				Log.info("Tao Kit Order that bai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc link Order Kit --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkChiTietKit01(String object, String data) {
		try {
			WaitElement(object, data);
			WebElement linkphieudacta = driver.findElement(By.xpath(OR.getProperty(object)));
			linkphieudacta.click();

			Ma_Kit01 = driver.findElement(By.xpath(OR.getProperty(object))).getText();

		} catch (Exception e) {
			Log.info("khong get duoc link Phieu Chuyen Kho --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputMaKit01(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Ma_Kit01);

			System.out.println("Ma Kit01 la: " + " " + Ma_Kit01);
			Log.info("Ma Kit01 la: " + " " + Ma_Kit01);
		} catch (Exception e) {
			Log.error("Khong get duoc ma kit01 --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkKIT01_1(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			Kit01_1 = currentURL;
			System.out.println("Link Kit01 1" + " " + Kit01_1);
			Log.info("Link San pham 1" + " " + Kit01_1);

		} catch (Exception e) {
			Log.info("khong get duoc link dac ta Kit --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void LinkKIT01_2(String object, String data) {
		try {

			String currentURL = driver.getCurrentUrl();
			Kit01_2 = currentURL;
			System.out.println("Link Kit01 2" + " " + Kit01_2);
			Log.info("Link Kit01 2" + " " + Kit01_2);
			Thread.sleep(1000);

			if (Kit01_1.equals(Kit01_2)) {
				System.out.println("Tao dac ta Kit thanh cong");
				Log.info("Tao dac ta Kit thanh cong");
			} else {
				System.out.println("Tao dac ta Kit that bai");
				Log.info("Tao dac ta Kit that bai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc link dac ta Kit --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputRandomKit02(String object, String data) {
		try {

			String a = RandomStringUtils.randomNumeric(1);
			String b = RandomStringUtils.randomAlphabetic(4);
			String c = RandomStringUtils.randomNumeric(2);
			String d = RandomStringUtils.randomAlphabetic(4);
			String e = RandomStringUtils.randomNumeric(6);

			data = a + b + c + d + e;
			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data, Keys.ENTER);

		} catch (Exception e) {
			Log.error("random that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	// KIT

	// Connection Database
//		public static void ConnectDB(String object, String data) {

	public static void GetMaPhieuNhap1(String object, String data) {
		try {
			WaitElement(object, data);

			WebElement txtbox = driver.findElement(By.xpath(OR.getProperty(object)));
			maphieunhap1 = txtbox.getAttribute("value");

			System.out.println("Ma phieu nhap tren Web la: " + maphieunhap1);

		} catch (Exception e) {
			Log.info("khong get duoc ma phieu nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckDBPhieuNhap(String object, String data) throws ClassNotFoundException, SQLException {

//	        String dbUrl = "jdbc:sqlserver://172.16.0.149;databasename=DiEInvoicePortal";	
		String dbUrl = "jdbc:sqlserver://172.16.0.149;databasename=wmsvn_saas_dic_demo_withkit";

		// Database Username
		String username = "sa";

		// Database Password
		String password = "sa@1234567";

		// Query to Execute
//			String query = "select* from InvoiceHeader where TenantID = 6;";	

		// Load sql server jdbc driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);

		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(OR.getProperty(object) + "'" + maphieunhap1 + "'");

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			String a = rs.getString(1);
//	                    String b = rs.getString(2);
//	                    String c = rs.getString(3);	
//	                    System. out.println(a + "  " + b + "  " + c);	
			System.out.println("Ma phieu nhap trong database la: " + a);
			maphieunhap2 = a;
		}
		if (maphieunhap1.equals(maphieunhap2)) {
			System.out.println("Tao phieu nhap thanh cong");
			Log.info("Tao phieu nhap thanh cong");
		} else {
			System.out.println("Tao phieu nhap that bai");
			Log.info("Tao phieu nhap that bai");
		}

		// closing DB Connection
		con.close();
	}

	// Connection Database

	// Check Phieu Xuat
	public static void GetMaPhieuXuat(String object, String data) {
		try {
			WaitElement(object, data);

			WebElement txtbox = driver.findElement(By.xpath(OR.getProperty(object)));
			maphieuxuat1 = txtbox.getAttribute("value");

			System.out.println("Ma phieu xuat tren Web la: " + maphieuxuat1);

		} catch (Exception e) {
			Log.info("khong get duoc ma phieu xuat --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckDBPhieuXuat(String object, String data) throws ClassNotFoundException, SQLException {

		String dbUrl = "jdbc:sqlserver://172.16.0.149;databasename=wmsvn_saas_dic_demo_withkit";

		// Database Username
		String username = "sa";

		// Database Password
		String password = "sa@1234567";

		// Load sql server jdbc driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);

		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(OR.getProperty(object) + "'" + maphieuxuat1 + "'");

		while (rs.next()) {
			String a = rs.getString(1);
			System.out.println("Ma phieu xuat trong database la: " + a);
			maphieuxuat2 = a;
		}
		if (maphieuxuat1.equals(maphieuxuat2)) {
			System.out.println("Tao phieu xuat thanh cong");
			Log.info("Tao phieu xuat thanh cong");
		} else {
			System.out.println("Tao phieu xuat that bai");
			Log.info("Tao phieu xuat that bai");
		}

		// closing DB Connection
		con.close();
	}
	// Check Phieu Xuat

	// Check Phieu Chuyen Kho K12
	public static void GetMaPhieuChuyenKhoK12(String object, String data) {
		try {
			WaitElement(object, data);

			WebElement txtbox = driver.findElement(By.xpath(OR.getProperty(object)));
			maphieuchuyenkhoK12_1 = txtbox.getAttribute("value");

			System.out.println("Ma phieu K12 tren Web la: " + maphieuchuyenkhoK12_1);

		} catch (Exception e) {
			Log.info("khong get duoc ma phieu K12 --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckDBPhieuChuyenKhoK12(String object, String data)
			throws ClassNotFoundException, SQLException {

		String dbUrl = "jdbc:sqlserver://172.16.0.149;databasename=wmsvn_saas_dic_demo_withkit";

		// Database Username
		String username = "sa";

		// Database Password
		String password = "sa@1234567";

		// Load sql server jdbc driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);

		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(OR.getProperty(object) + "'" + maphieuchuyenkhoK12_1 + "'");

		while (rs.next()) {
			String a = rs.getString(2);
			System.out.println("Ma phieu chuyen kho K12 trong database la: " + a);
			maphieuchuyenkhoK12_2 = a;
		}
		if (maphieuchuyenkhoK12_1.equals(maphieuchuyenkhoK12_2)) {
			System.out.println("Tao phieu chuyen kho K12 thanh cong");
			Log.info("Tao phieu chuyen kho K12 thanh cong");
		} else {
			System.out.println("Tao phieu chuyen kho K12 that bai");
			Log.info("Tao phieu chuyen kho K12 that bai");
		}

		// closing DB Connection
		con.close();
	}
	// Check Phieu Chuyen Kho K12

	// Check Phieu Kiem Ke K31
	public static void GetMaPhieuKiemKeK31(String object, String data) {
		try {
			WaitElement(object, data);

			WebElement txtbox = driver.findElement(By.xpath(OR.getProperty(object)));
			maphieuk31_1 = txtbox.getAttribute("value");

			System.out.println("Ma phieu K31 tren Web la: " + maphieuk31_1);

		} catch (Exception e) {
			Log.info("khong get duoc maphieuk31_1 --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckDBPhieuKiemKeK31(String object, String data) throws ClassNotFoundException, SQLException {

		String dbUrl = "jdbc:sqlserver://172.16.0.149;databasename=wmsvn_saas_dic_demo_withkit";

		// Database Username
		String username = "sa";

		// Database Password
		String password = "sa@1234567";

		// Load sql server jdbc driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);

		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(OR.getProperty(object) + "'" + maphieuk31_1 + "'");

		while (rs.next()) {
			String a = rs.getString(2);
			System.out.println("Ma phieu K31 trong database la: " + a);
			maphieuk31_2 = a;
		}
		if (maphieuk31_1.equals(maphieuk31_2)) {
			System.out.println("Tao phieu kiem ke thanh cong");
			Log.info("Tao phieu kiem ke thanh cong");
		} else {
			System.out.println("Tao phieu kiem ke that bai");
			Log.info("Tao phieu kiem ke that bai");
		}

		// closing DB Connection
		con.close();
	}
	// Check Phieu Kiem Ke K31

	// *****************
	// CHECK SMART TURN

	public static void GetSoLuongTonKhoST1(String object, String data) {
		try {
			String nodata = driver.findElement(By.xpath("//*[@id=\'QuantityByItemListPage\']/tbody/tr/td")).getText();
			if (nodata.equals("There are no items in this list.")) {
				STNhapSoLuongTon1 = 0;
			} else {
//				String Soluongton1 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
//				
//				String Soluongton2 = Soluongton1.replaceAll("[^0-9]", "");
//				
//				STNhapSoLuongTon1 = Integer.parseInt(Soluongton2);
//				

				List<WebElement> rowCount = driver.findElements(By.xpath("//*[@id='QuantityByItemListPage']/tbody/tr"));
				System.out.println("Num rows: " + rowCount.size());

				String index = OR.getProperty(object);
				try {
					for (int i = 1; i <= rowCount.size(); i++) {
						String Soluongton1 = driver.findElement(By.xpath(index.replace("@index", Integer.toString(i))))
								.getText();

						String Soluongton2 = Soluongton1.replaceAll("[^0-9]", "");
						STNhapSoLuongTon1 = Integer.parseInt(Soluongton2);
						System.out.println("So luong ton san pham " + i + " truoc la: " + STNhapSoLuongTon1);
						Log.info("So luong ton san pham " + i + " truoc la: " + STNhapSoLuongTon1);
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoST2(String object, String data) {
		try {
			String nodata = driver.findElement(By.xpath("//*[@id=\'QuantityByItemListPage\']/tbody/tr/td")).getText();
			if (nodata.equals("There are no items in this list.")) {
				STNhapSoLuongTon1 = 0;
			} else {
//				String Soluongton1 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
//				
//				String Soluongton2 = Soluongton1.replaceAll("[^0-9]", "");
//				
//				STNhapSoLuongTon2 = Integer.parseInt(Soluongton2);

				List<WebElement> rowCount = driver.findElements(By.xpath("//*[@id='QuantityByItemListPage']/tbody/tr"));
//				System.out.println("Num rows: " + rowCount.size());

				String index = OR.getProperty(object);
				try {
					for (int i = 1; i <= rowCount.size(); i++) {
						String Soluongton1 = driver.findElement(By.xpath(index.replace("@index", Integer.toString(i))))
								.getText();

						String Soluongton2 = Soluongton1.replaceAll("[^0-9]", "");
						STNhapSoLuongTon2 = Integer.parseInt(Soluongton2);
						System.out.println("So luong ton san pham " + i + " sau la: " + STNhapSoLuongTon2);
						Log.info("So luong ton san pham " + i + " sau la: " + STNhapSoLuongTon2);
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

			int slycnhap = Integer.parseInt(SoLuongNhapST);
			int tonkhonhap = STNhapSoLuongTon1 + slycnhap;

			if (tonkhonhap == STNhapSoLuongTon2) {
				System.out.println("Ton kho Nhap dung");
				Log.info("Ton kho Nhap dung");
			} else {
				System.out.println("Ton kho Nhap sai");
				Log.info("Ton kho Nhap sai");
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndClearSLNhapST(String object, String data) {
		try {

			List<WebElement> rowCount = driver
					.findElements(By.xpath("//*[@id='PurchaseOrders_ProfilePage_ItemGrid']/tbody/tr"));
			String index = OR.getProperty(object);
			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					driver.findElement(By.xpath(index.replace("@index", Integer.toString(i))))
							.sendKeys(Keys.chord(Keys.CONTROL, "a"), data);
					SoLuongNhapST = data;
					SoLuongSO = SoLuongNhapST;
					System.out.println("So luong yeu cau item " + i + " la: " + SoLuongNhapST);
					Log.info("So luong yeu cau cua item " + i + " la: " + SoLuongNhapST);
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndClearLocationST(String object, String data) {
		try {

			List<WebElement> rowCount = driver
					.findElements(By.xpath("//*[@id='ReceipLineItemsGridProfilePage']/tbody/tr"));
//			System.out.println("Num rows: " + rowCount.size());
			String index = OR.getProperty(object);
			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					driver.findElement(By.xpath(index.replace("@index", Integer.toString(i)))).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(index.replace("@index", Integer.toString(i))))
							.sendKeys(Keys.chord(Keys.CONTROL, "a"), data);

				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndClearLocationClickST(String object, String data) {
		try {

			List<WebElement> rowCount = driver
					.findElements(By.xpath("//*[@id='PurchaseOrders_ProfilePage_ItemGrid']/tbody/tr"));
//			System.out.println("Num rows: " + rowCount.size());
			String index = OR.getProperty(object);
			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					driver.findElement(By.xpath(index.replace("@index", Integer.toString(i)))).click();

				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetMaPhieuPO(String object, String data) {
		try {

			WaitElement(object, data);
			String maphieupo = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			maphieuPO_1 = maphieupo;
			System.out.println("Ma phieu sau khi tao la:" + " " + maphieuPO_1);
			Log.info("Ma phieu sau khi tao la:" + " " + maphieuPO_1);

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckMaPhieuPO(String object, String data) {
		try {

			WaitElement(object, data);
			String maphieupo2 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			maphieuPO_2 = maphieupo2;
			System.out.println("Ma phieu tren list la:" + " " + maphieuPO_2);
			Log.info("Ma phieu tren list la:" + " " + maphieuPO_2);

			if (maphieuPO_2.equals(maphieuPO_1)) {
				System.out.println("Tao phieu thanh cong");
				Log.info("Tao phieu thanh cong");
			} else {
				System.out.println("Tao that bai");
				Log.info("Tao that bai");
			}

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	// *** SO
	// ***************************************************************************************************
	public static void GetMaPhieuSO(String object, String data) {
		try {

			WaitElement(object, data);
			String maphieupo = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			maphieuSO_1 = maphieupo;
			System.out.println("\n *****GET MA PHIEU SO*****");
			Log.info("*****GET MA PHIEU SO*****");
			System.out.println("Ma phieu SO sau khi tao la:" + " " + maphieuSO_1);
			Log.info("Ma phieu SO sau khi tao la:" + " " + maphieuSO_1 + "\n");
//			takeSnapShot(driver, "CaptureError\\MaPhieuSO_1.png");

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckMaPhieuSO(String object, String data) {
		try {

			WaitElement(object, data);
			String maphieupo2 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			maphieuSO_2 = maphieupo2;

			System.out.println("\n *****KIEM TRA SO TAO THANH CONG HAY THAT BAI*****");
			Log.info("*****KIEM TRA SO TAO THANH CONG HAY THAT BAI*****");
			System.out.println("Ma phieu SO tren list la:" + " " + maphieuSO_2);
			Log.info("Ma phieu SO tren list la:" + " " + maphieuSO_2);
//			takeSnapShot(driver, (OR.getProperty(object))  + "MaPhieuSO_2.png");

			if (maphieuSO_2.equals(maphieuSO_1)) {
				System.out.println("Tao phieu SO thanh cong");
				Log.info("Tao phieu SO thanh cong" + "\n");
			} else {
				System.out.println("Tao that bai");
				Log.info("Tao that bai" + "\n");
				takeSnapShot(driver, "CaptureError\\MaPhieuSO_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\MaPhieuSO_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				main_run_gui.bResult = false;
			}

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckStatusSOList(String object, String data) {
		try {
			System.out.println("\n *****KIEM TRA STATUS CUA SO TREN LIST*****");
			Log.info("*****KIEM TRA STATUS CUA SO TREN LIST*****");

			WaitElement(object, data);
			String statussolist = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			System.out.println("Status cua SO tren list la: " + statussolist);
			Log.info("Status cua SO tren list la: " + statussolist);
//			takeSnapShot(driver, (OR.getProperty(object))  + "StatusSOList.png");
			String statussolist2 = "In Progress";

			if (statussolist.equals(statussolist2)) {
				System.out.println("Status cua SO tren list dung");
				Log.info("Status cua SO tren list dung" + "\n");
			} else {
				System.out.println("Status cua SO tren list sai");
				Log.info("Status cua SO tren list sai" + "\n");				
				takeSnapShot(driver, "CaptureError\\StatusSOList_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\StatusSOList_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				main_run_gui.bResult = false;
			}

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckMaPhieuShipmentSO(String object, String data) {
		try {

			WaitElement(object, data);

			System.out.println("\n *****KIEM TRA SHIPMENT TAO THANH CONG HAY THAT BAI*****");
			Log.info("*****KIEM TRA SHIPMENT TAO THANH CONG HAY THAT BAI*****");

			String mpshipmentlist = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			maphieuShipment_2 = mpshipmentlist;

			System.out.println("Ma phieu Shipment tren list la:" + " " + maphieuShipment_2);
			Log.info("Ma phieu Shipment tren list la:" + " " + maphieuShipment_2);
//			takeSnapShot(driver, (OR.getProperty(object))  + "MaPhieuShipment_2.png");

			if (maphieuShipment_2.equals(maphieuShipment_1)) {
				System.out.println("Tao phieu Shipment thanh cong");
				Log.info("Tao phieu Shipment thanh cong" + "\n");
			} else {
				System.out.println("Tao Shipment that bai");
				Log.info("Tao Shipment that bai" + "\n");
				takeSnapShot(driver, "CaptureError\\MaPhieuShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\MaPhieuShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), "");
				main_run_gui.bResult = false;
			}

			Thread.sleep(1000);

			// Check status SI tren list
			System.out.println("\n *****KIEM TRA STATUS SHIPMENT TREN LIST*****");
			Log.info("*****KIEM TRA STATUS SHIPMENT TREN LIST*****");

			String statusSIlist = driver
					.findElement(By.xpath("//*[@id=\'ViewShipmentsListPage\']/tbody/tr[1]/td[7]/span")).getText();
			String statusSIlist2 = "Closed";
			System.out.println("Status SI tren list la: " + statusSIlist);
			Log.info("Status SI tren list la: " + statusSIlist);
//			takeSnapShot(driver, (OR.getProperty(object))  + "StatusShipmentList.png");
			if (statusSIlist.equals(statusSIlist2)) {
				System.out.println("Status Shipment tren list DUNG");
				Log.info("Status Shipment tren list DUNG" + "\n");
			} else {
				System.out.println("Status Shipment tren list Sai");
				Log.info("Status Shipment tren list Sai" + "\n");
				takeSnapShot(driver, "CaptureError\\StatusShipmentList_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\StatusShipmentList_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				main_run_gui.bResult = false;
			}

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckPartialSO(String object, String data) {
		try {

			System.out.println("\n *****KIEM TRA CHECKBOX PARTIAL SHIPMENT*****");
			Log.info("*****KIEM TRA CHECKBOX PARTIAL SHIPMENT*****");
			WaitElement(object, data);
			Boolean partial = driver.findElement(By.xpath(OR.getProperty(object))).isSelected();
			WebElement partial2 = driver.findElement(By.xpath(OR.getProperty(object)));
			if (partial == true) {
				System.out.println("Checkbox Partial Shipment is CHECKED");
				Log.info("Checkbox Partial Shipment is CHECKED" + "\n");
				

				takeSnapShot(driver, "CheckPartialShipment" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				ReadFileTXT(tenemail);
				SendMail(("CheckPartialShipment" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
			} else {
				System.out.println("Checkbox Partial Shipment UNCHECK");
				Log.info("Checkbox Partial Shipment UNCHECK" + "\n");

				takeSnapShot(driver, "CaptureError\\UnCheckPartialShipment" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\UnCheckPartialShipment" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				main_run_gui.bResult = false;
				partial2.click();
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckSOSauKhiShip(String object, String data) {
		try {

			// Status SO
			String status = driver
					.findElement(By
							.xpath("//*[@id=\'frmMaster\']/div/div/section[2]/div[1]/div[1]/div/div/div/dl/dd[8]/span"))
					.getText();

			System.out.println("\n *****KIEM TRA STATUS SO DETAIL*****");
			Log.info("*****KIEM TRA STATUS SO DETAIL*****");
			System.out.println("Status SO detail la: " + status);
			Log.info("Status SO detail la: " + status);
//			takeSnapShot(driver, (OR.getProperty(object))  + "StatusSODetail.png");
			String status2 = "In Progress";

			if (status.equals(status2)) {
				System.out.println("Status SO detail dung");
				Log.info("Status SO detail dung" + "\n");
			} else {
				System.out.println("Status SO detail sai");
				Log.info("Status SO detail sai" + "\n");
				takeSnapShot(driver, "CaptureError\\StatusSODetail_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\StatusSODetail_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				main_run_gui.bResult = false;
			}

			// Ordered qty SO
			System.out.println("\n *****KIEM TRA ORDERED QTY SO*****");
			Log.info("*****KIEM TRA ORDERED QTY SO*****");

			List<WebElement> rowCount = driver
					.findElements(By.xpath("//*[@id='SalesOrders_ProfilePage_ItemGrid']/tbody/tr"));
			String index4 = "//*[@id=\'SalesOrders_ProfilePage_ItemGrid\']/tbody/tr[@index]/td[6]/span";
			String index5 = "//*[@id=\"SalesOrders_ProfilePage_ItemGrid\"]/tbody/tr[@index]/td[3]/a";
			int slso = Integer.parseInt(SoLuongSO);
			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					String pd = driver.findElement(By.xpath(index5.replace("@index", Integer.toString(i)))).getText();
					String slqty = driver.findElement(By.xpath(index4.replace("@index", Integer.toString(i))))
							.getText();
					System.out.println("Item#: " + pd + " so luong Ordered Qty la: " + slqty);
					Log.info("Item#: " + pd + " so luong Ordered Qty la: " + slqty);
//					takeSnapShot(driver, (OR.getProperty(object))  + "OrderQty.png");

					int slqty2 = Integer.parseInt(slqty.replaceAll("[^0-9]", ""));
					OrderQtySO = (long) slqty2;
					if (slqty2 == slso) {
						System.out.println("Ordered qty SO " + pd + " dung voi Ordered qty ban dau");
						Log.info("Ordered qty SO " + pd + " dung voi Ordered qty ban dau" + "\n");
					} else {
						System.out.println("Ordered qty SO " + pd + " sai");
						Log.info("Ordered qty SO " + pd + " sai" + "\n");
						takeSnapShot(driver, "CaptureError\\OrderQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
						SendMail(("CaptureError\\OrderQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
						main_run_gui.bResult = false;
					}
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

			// Previously qty SO
			System.out.println("\n *****KIEM TRA PREVIOUSLY QTY SO*****");
			Log.info("*****KIEM TRA PREVIOUSLY QTY SO*****");

			String previouslyqty2 = "//*[@id=\'SalesOrders_ProfilePage_ItemGrid\']/tbody/tr[@index]/td[7]/span";
			String tensp = "//*[@id=\'SalesOrders_ProfilePage_ItemGrid\']/tbody/tr[@index]/td[3]/a";

			int previouslyqty1 = 0;
			int sum = 0;

			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					String previouslyqty = driver
							.findElement(By.xpath(previouslyqty2.replace("@index", Integer.toString(i)))).getText();
					String tensp2 = driver.findElement(By.xpath(tensp.replace("@index", Integer.toString(i))))
							.getText();

					previouslyqty1 = Integer.parseInt(previouslyqty.replaceAll("[^0-9]", ""));
					sum = sum + previouslyqty1;

					System.out.println("Item#: " + tensp2 + " --- co so luong Previously qty la: " + previouslyqty1);
					Log.info("Item#: " + tensp2 + " --- co so luong Previously qty la: " + previouslyqty1);
//					takeSnapShot(driver, (OR.getProperty(object))  + "PreviouslyQty.png");
				}
				System.out.println("SUM so luong da ship = " + SumQtyShippedSI);
				System.out.println("SUM so luong Previously = " + sum);

				if (sum == SumQtyShippedSI) {
					System.out.println("Previously qty SO dung voi so luong da ship");
					Log.info("Previously qty SO dung voi so luong da ship" + "\n");
				} else {
					System.out.println("Previously qty SO khong dung voi so luong da ship");
					Log.info("Previously qty SO khong dung voi so luong da ship" + "\n");
					takeSnapShot(driver, "CaptureError\\PreviouslyQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
					SendMail(("CaptureError\\PreviouslyQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
					main_run_gui.bResult = false;
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

			// Pending qty SO
			System.out.println("\n *****KIEM TRA PENDING QTY SO*****");
			Log.info("*****KIEM TRA PENDING QTY SO*****");

			String index6 = "//*[@id=\'SalesOrders_ProfilePage_ItemGrid\']/tbody/tr[@index]/td[8]/span";
			String index7 = "//*[@id=\'SalesOrders_ProfilePage_ItemGrid\']/tbody/tr[@index]/td[6]/span";
			String index8 = "//*[@id=\'SalesOrders_ProfilePage_ItemGrid\']/tbody/tr[@index]/td[7]/span";

			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					String pd = driver.findElement(By.xpath(index5.replace("@index", Integer.toString(i)))).getText();
					String slqpending = driver.findElement(By.xpath(index6.replace("@index", Integer.toString(i))))
							.getText();
					String slorderqy = driver.findElement(By.xpath(index7.replace("@index", Integer.toString(i))))
							.getText();
					String slpreviously = driver.findElement(By.xpath(index8.replace("@index", Integer.toString(i))))
							.getText();

					int slqpending2 = Integer.parseInt(slqpending.replaceAll("[^0-9]", ""));
					int slorderqy2 = Integer.parseInt(slorderqy.replaceAll("[^0-9]", ""));
					int slpreviously2 = Integer.parseInt(slpreviously.replaceAll("[^0-9]", ""));

					int slchuaship = slorderqy2 - slpreviously2;

					System.out.println("Item#: " + pd + " So luong khong du ship la: " + slchuaship);
					Log.info("Item#: " + pd + " So luong khong du ship la: " + slchuaship);
//					takeSnapShot(driver, (OR.getProperty(object))  + "PendingQty.png");

					if (slchuaship <= 0) {
						slchuaship = 0;
					}

					if (slchuaship == slqpending2) {
						System.out.println("Pending qty SO dung");
						Log.info("Pending qty SO dung" + "\n");
					} else {
						System.out.println("Pending qty SO sai");
						Log.info("Pending qty SO sai" + "\n");
						takeSnapShot(driver, "CaptureError\\PendingQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
						SendMail(("CaptureError\\PendingQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
						main_run_gui.bResult = false;
					}

				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

			// Item Status SO
			String index = "//*[@id=\'SalesOrders_ProfilePage_ItemGrid\']/tbody/tr[@index]/td[9]/span";

			System.out.println("\n *****KIEM TRA STATUS TREN MOI ITEM SO*****");
			Log.info("*****KIEM TRA STATUS TREN MOI ITEM SO*****");
			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					String statusitem = driver.findElement(By.xpath(index.replace("@index", Integer.toString(i))))
							.getText();
					System.out.println("Status tren item SO " + i + " la: " + statusitem);
					Log.info("Status tren item SO " + i + " la: " + statusitem);
//					takeSnapShot(driver, (OR.getProperty(object))  + "StatusItemSO.png");
					String statusitem2 = "In Progress";
					if (statusitem.equals(statusitem2)) {
						System.out.println("Status tren Item SO dung");
						Log.info("Status tren Item SO dung" + "\n");
					} else {
						System.out.println("Status tren Item SO sai");
						Log.info("Status tren Item SO sai" + "\n");
						takeSnapShot(driver, "CaptureError\\StatusItemSO_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
						SendMail(("CaptureError\\StatusItemSO_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
						main_run_gui.bResult = false;
					}
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetErrorMsg1(String object, String data) {
		try {
			System.out.println("\n *****CHECK ERROR MESSAGE*****");
			Log.info("*****CHECK ERROR MESSAGE*****");

			String msgerror = OR.getProperty(object);
			List<WebElement> rowCount = driver.findElements(By.xpath("//*[@id=\'divError\']/div/div/div/div/div"));

			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					String msg = driver.findElement(By.xpath(msgerror.replace("@index", Integer.toString(i))))
							.getText();

					WebElement msg2 = driver.findElement(By.xpath(msgerror.replace("@index", Integer.toString(i))));
					if (msg2.isDisplayed()) {
						System.out.println("Message error: " + msg);
						Log.info("Message error: " + msg + "\n");

						takeSnapShot(driver,"Display_MessageError" + "_" + obDateFormat.format(obDate.getTime()) + ".png");

					} else {
						System.out.println("Message error not display");
						Log.info("Message error not display" + "\n");
						takeSnapShot(driver, "CaptureError\\NotDisplay_MessageError" + "_"
								+ obDateFormat.format(obDate.getTime()) + ".png");
						SendMail(("CaptureError\\NotDisplay_MessageError" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
						main_run_gui.bResult = false;
					}

				}
				SendMail(("Display_MessageError" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				

			} catch (Exception e2) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputMaPhieuSO(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.chord(Keys.CONTROL, "a"), maphieuSO_1);
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputMaPhieuSI(String object, String data) {
		try {

			WaitElement(object, data);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.chord(Keys.CONTROL, "a"),
					maphieuShipment_1);
		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputAndClearSoLuongYeuCauSOT(String object, String data) {
		try {
			List<WebElement> rowCount = driver
					.findElements(By.xpath("//*[@id='SalesOrders_ProfilePage_ItemGrid']/tbody/tr"));
			String index = OR.getProperty(object);
			System.out.println("\n *****SO LUONG YEU CAU CUA SO*****");
			Log.info("*****SO LUONG YEU CAU CUA SO*****");
			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					Thread.sleep(1000);
					driver.findElement(By.xpath(index.replace("@index", Integer.toString(i))))
							.sendKeys(Keys.chord(Keys.CONTROL, "a"), data);
					SoLuongSO = data;

					System.out.println("So luong yeu cau SO item " + i + " la: " + SoLuongSO);
					Log.info("So luong yeu cau cua SO item" + i + " la: " + SoLuongSO + "\n");
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			Log.error("Khong the senkey --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoXuatST2(String object, String data) {
		try {
			System.out.println("\n *****KIEM TRA TON KHO SAU KHI SHIP*****");
			Log.info("*****KIEM TRA TON KHO SAU KHI SHIP*****");

			String nodata = driver.findElement(By.xpath("//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr/td"))
					.getText();
			List<TonKho> names = new ArrayList<TonKho>();

			if (nodata.equals("There are no items in this list.")) {
				STXuatSoLuongTon2 = 0;

				System.out.println("So luong ton kho sau Xuat SO la:" + " " + STXuatSoLuongTon2);
				Log.info("So luong ton kho sau Xuat SO la:" + " " + STXuatSoLuongTon2);

			} else {

				List<WebElement> rowCount = driver
						.findElements(By.xpath("//*[@id='InventoryManagersDetailListPage']/tbody/tr"));

				String index = OR.getProperty(object);
				String index2 = "//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr[@index]/td[1]/a";
				String index3 = "//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr[@index]/td[9]/span";
				int tona = 0;
				int sum = 0;

				try {
					for (int i = 1; i <= rowCount.size(); i++) {
						String a = driver.findElement(By.xpath(index.replace("@index", Integer.toString(i)))).getText();
						String b = driver.findElement(By.xpath(index2.replace("@index", Integer.toString(i))))
								.getText();
						String c = driver.findElement(By.xpath(index3.replace("@index", Integer.toString(i))))
								.getText();
						tona = Integer.parseInt(a.replaceAll("[^0-9]", ""));

						TonKho name = new TonKho(b, tona);
						names.add(name);

						System.out.println(
								"Product: " + b + " co Qty on hand sau khi Ship la: " + a + " ---Location: " + c);
						Log.info("Product: " + b + " co Qty on hand sau khi Ship la: " + a + " ---Location: " + c);
//						takeSnapShot(driver, (OR.getProperty(object))  + "TonKho2.png");
						sum = sum + tona;
					}
					SumQtyTonKho2 = sum;

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			Map<String, Long> result = names.stream()
					.collect(Collectors.groupingBy(TonKho::getPName, Collectors.summingLong(TonKho::getPQty)));

			for (Map.Entry<String, Long> entry : result.entrySet()) {
				String name = entry.getKey();
				Long number = entry.getValue();

				System.out.println("SUM: " + name + " co tong Qty on hand sau khi Ship la: " + number);
				Log.info("SUM: " + name + " co tong Qty on hand sau khi Ship la: " + number);

			}

			int tonkhoso = SumQtyTonKho1 - SumQtyShippedSI;
			if (tonkhoso < 0) {
				tonkhoso = 0;
			}

			System.out.println("Ton kho ban dau = " + SumQtyTonKho1);
			Log.info("Ton kho ban dau = " + SumQtyTonKho1);
			System.out.println("So luong da ship = " + SumQtyShippedSI);
			Log.info("So luong da ship = " + SumQtyShippedSI);
			System.out.println("So luong ton kho theo tinh toan = " + tonkhoso);
			Log.info("So luong ton kho theo tinh toan = " + tonkhoso);
			System.out.println("So luong ton kho sau khi ship = " + SumQtyTonKho2);
			Log.info("So luong ton kho sau khi ship = " + SumQtyTonKho2);

			if (tonkhoso == SumQtyTonKho2) {
				System.out.println("Ton kho sau khi Xuat SO dung");
				Log.info("Ton kho sau khi Xuat SO dung" + "\n");
			} else {
				System.out.println("Ton kho sau khi Xuat SO sai");
				Log.info("Ton kho sau khi Xuat SO sai" + "\n");
				takeSnapShot(driver, "CaptureError\\TonKho2_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\TonKho2_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				main_run_gui.bResult = false;
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoXuatST1(String object, String data) {
		try {
			String nodata = driver.findElement(By.xpath("//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr/td"))
					.getText();
			if (nodata.equals("There are no items in this list.")) {
				STXuatSoLuongTon1 = 0;
				System.out.println("So luong ton kho truoc xuat la:" + " " + STXuatSoLuongTon1);
				Log.info("So luong ton kho truoc xuat la:" + " " + STXuatSoLuongTon1);

			} else {
				List<WebElement> rowCount = driver
						.findElements(By.xpath("//*[@id='InventoryManagersDetailListPage']/tbody/tr"));

				String index = OR.getProperty(object);
				String index2 = "//*[@id=\"InventoryManagersDetailListPage\"]/tbody/tr[@index]/td[1]/a";
				int tona = 0;
				int sum = 0;
				System.out.println("*****KIEM TRA TON TRUOC KHI SHIP*****");
				Log.info("*****KIEM TRA TON TRUOC KHI SHIP*****");

				// Khai bao list de chua item
				List<TonKho> names = new ArrayList<TonKho>();
				try {
					// Chay vong lap for de lay ra duoc cac gia tri Ten san pham va so luong tren
					// table
					for (int i = 1; i <= rowCount.size(); i++) {
						String a = driver.findElement(By.xpath(index.replace("@index", Integer.toString(i)))).getText();
						String b = driver.findElement(By.xpath(index2.replace("@index", Integer.toString(i))))
								.getText();
						tona = Integer.parseInt(a.replaceAll("[^0-9]", ""));

						// Khai bao List TonKho moi de chua cac du lieu vua lay duoc o vong lap for
						TonKho name = new TonKho(b, tona);

						// Add cac gia tri da duoc lay o vong lap for vao List TonKho khai bao ban dau
						names.add(name);

						System.out.println("Product: " + b + " co Qty on hand truoc khi Ship la: " + a);
						Log.info("Product: " + b + " co Qty on hand truoc khi Ship la: " + a);
//						takeSnapShot(driver, "CaptureError\\TonKho1.png");
						sum = sum + tona;
					}
					SumQtyTonKho1 = sum;
					System.out.println("SUM ton kho truoc khi Ship la: " + SumQtyTonKho1);
					Log.info("SUM ton kho truoc khi Ship la: " + SumQtyTonKho1);

				} catch (Exception e2) {
					// TODO: handle exception
				}

				// Khai bao Map de GroupBy Ten san pham, sau do Sum so luong
				Map<String, Long> result = names.stream()
						.collect(Collectors.groupingBy(TonKho::getPName, Collectors.summingLong(TonKho::getPQty)));

				for (Map.Entry<String, Long> entry : result.entrySet()) {
					String name = entry.getKey();
					Long number = entry.getValue();

					System.out.println("Product: " + name + " co tong Qty on hand la: " + number);
					Log.info("Product: " + name + " co tong Qty on hand la: " + number + "\n");
				}

			}
		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetSoLuongTonKhoAvailableGrouBy(String object, String data) {
		try {
			String nodata = driver.findElement(By.xpath("//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr/td"))
					.getText();
			if (nodata.equals("There are no items in this list.")) {
				STXuatSoLuongTon1 = 0;
				System.out.println("So luong ton kho truoc xuat la:" + " " + STXuatSoLuongTon1);
				Log.info("So luong ton kho truoc xuat la:" + " " + STXuatSoLuongTon1);

			} else {
				List<WebElement> rowCount = driver
						.findElements(By.xpath("//*[@id='InventoryManagersDetailListPage']/tbody/tr"));

				String index = OR.getProperty(object);
				String index2 = "//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr[@index]/td[1]/a";
				String index3 = "//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr[@index]/td[10]/span";
				String index4 = "//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr[@index]/td[11]/span";

				int tona = 0;
				int tonc = 0;
				int tond = 0;
				System.out.println("*****GROUP BY SO LUONG TON KHO AVAILABLE TRUOC KHI SHIP*****");
				Log.info("*****GROUP BY SO LUONG TON KHO AVAILABLE TRUOC KHI SHIP*****");

				// Khai bao list de chua item
				List<TonKho2> names = new ArrayList<TonKho2>();

				try {
					// Chay vong lap for de lay ra duoc cac gia tri Ten san pham va so luong tren
					// table
					for (int i = 1; i <= rowCount.size(); i++) {
						String a = driver.findElement(By.xpath(index.replace("@index", Integer.toString(i)))).getText();
						String b = driver.findElement(By.xpath(index2.replace("@index", Integer.toString(i))))
								.getText();
						String c = driver.findElement(By.xpath(index3.replace("@index", Integer.toString(i))))
								.getText();
						String d = driver.findElement(By.xpath(index4.replace("@index", Integer.toString(i))))
								.getText();

						tonc = Integer.parseInt(c.replaceAll("[^0-9]", ""));
						tond = Integer.parseInt(d.replaceAll("[^0-9]", ""));
						tona = Integer.parseInt(a.replaceAll("[^0-9]", ""));
						TonKho2 name = new TonKho2(b, tona, tonc, tond);
						names.add(name);

					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

				Long qtyonhand = null;
				Long qtyfullfilment = null;
				Long qtyedit = null;
				Long qtyavailable = null;
				String nameavailble = null;

				// Khai bao list de chua cac gia tri trong Product Name va So luong sau khi SUM
				// cua 4 cot tren table Ton Kho
				List<String> lsItemNo = new ArrayList<String>();
				List<Long> lsQty = new ArrayList<Long>();
				List<Long> lsQty1 = new ArrayList<Long>();
				List<Long> lsQty2 = new ArrayList<Long>();

				// Khai bao Map de GroupBy Ten san pham, sau do Sum so luong
				Map<String, Long> result = names.stream()
						.collect(Collectors.groupingBy(TonKho2::getPName, Collectors.summingLong(TonKho2::getPQty)));
				for (Map.Entry<String, Long> entry : result.entrySet()) {
					String name = entry.getKey();
					Long number = entry.getValue();
					lsItemNo.add(name);
					lsQty.add(number);

					System.out.println("Product: " + name + " co tong Qty On Hand la: " + number);
					Log.info("Product: " + name + " co tong Qty on hand la: " + number);
				}

				Map<String, Long> result2 = names.stream()
						.collect(Collectors.groupingBy(TonKho2::getPName, Collectors.summingLong(TonKho2::getPQty2)));
				for (Map.Entry<String, Long> entry : result2.entrySet()) {
					String name = entry.getKey();
					Long number = entry.getValue();
					lsQty1.add(number);

					System.out.println("Product: " + name + " co tong Qty Soft Alloc Fulfillment la: " + number);
					Log.info("Product: " + name + " co tong Qty Soft Alloc Fulfillment la: " + number);
				}

				Map<String, Long> result3 = names.stream()
						.collect(Collectors.groupingBy(TonKho2::getPName, Collectors.summingLong(TonKho2::getPQty3)));
				for (Map.Entry<String, Long> entry : result3.entrySet()) {
					String name = entry.getKey();
					Long number = entry.getValue();
					lsQty2.add(number);
					System.out.println("Product: " + name + " co tong Qty Soft Alloc Edit la: " + number);
					Log.info("Product: " + name + " co tong Qty Soft Alloc Edit la: " + number);
				}

				for (int i = 0; i < lsItemNo.size(); i++) {
					nameavailble = lsItemNo.get(i);
					qtyonhand = lsQty.get(i);
					qtyfullfilment = lsQty1.get(i);
					qtyedit = lsQty2.get(i);
					qtyavailable = qtyonhand - (qtyfullfilment + qtyedit);
					SumQtyAvailable = qtyavailable;
					System.out.println("Product: " + nameavailble + " co tong Available la: " + SumQtyAvailable);
					Log.info("Product: " + nameavailble + " co tong Available la: " + SumQtyAvailable + "\n");

				}

			}
		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetAvailableItemTonKho(String object, String data) {
		try {

			List<WebElement> rowCount = driver
					.findElements(By.xpath("//*[@id='InventoryManagersDetailListPage']/tbody/tr"));

			String index = OR.getProperty(object);
			String index2 = "//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr[@index]/td[1]/a";
			String index3 = "//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr[@index]/td[10]/span";
			String index4 = "//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr[@index]/td[11]/span";
			String index5 = "//*[@id=\'InventoryManagersDetailListPage\']/tbody/tr[@index]/td[9]/span";
			int tona = 0;
			int tonc = 0;
			int tond = 0;
			int sum = 0;

			System.out.println("\n *****SHOW SO LUONG AVAILABLE CUA MOI ITEM TRONG TON KHO*****");
			Log.info("*****SHOW SO LUONG AVAILABLE CUA MOI ITEM TRONG TON KHO*****");

			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					String a = driver.findElement(By.xpath(index.replace("@index", Integer.toString(i)))).getText();
					String b = driver.findElement(By.xpath(index2.replace("@index", Integer.toString(i)))).getText();
					String c = driver.findElement(By.xpath(index3.replace("@index", Integer.toString(i)))).getText();
					String d = driver.findElement(By.xpath(index4.replace("@index", Integer.toString(i)))).getText();
					String e = driver.findElement(By.xpath(index5.replace("@index", Integer.toString(i)))).getText();

					tona = Integer.parseInt(a.replaceAll("[^0-9]", ""));
					tonc = Integer.parseInt(c.replaceAll("[^0-9]", ""));
					tond = Integer.parseInt(d.replaceAll("[^0-9]", ""));

					int available = tona - (tonc + tond);
					sum = sum + available;

					System.out.println("SO#/Line#: " + b + " --- So luong Available cua item trong Ton Kho la: "
							+ available + " ---Location " + e);
					Log.info("SO#/Line#: " + b + " --- So luong Available cua item trong Ton Kho la: " + available
							+ " ---Location " + e + "\n");
//					takeSnapShot(driver, "CaptureError\\AvailableItemTonKho.png");
				}
				ItemQtyAvailable = sum;

			} catch (Exception e2) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetAvailableQtySI(String object, String data) {
		try {

			List<WebElement> rowCount = driver
					.findElements(By.xpath("//*[@id='ShipmentItemsGridProfilePage']/tbody/tr"));

			String index = OR.getProperty(object);
			String index2 = "//*[@id='ShipmentItemsGridProfilePage']/tbody/tr[@index]/td[3]/span";
			String index3 = "//*[@id='ShipmentItemsGridProfilePage']/tbody/tr[@index]/td[12]/span";
			int tona = 0;
			int sum = 0;
			System.out.println("\n *****SHOW SO LUONG AVAILABLE CUA MOI ITEM DUOC PHEP SHIP TREN SHIPMENT*****");
			Log.info("*****SHOW SO LUONG AVAILABLE CUA MOI ITEM DUOC PHEP SHIP TREN SHIPMENT*****");

			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					String a = driver.findElement(By.xpath(index.replace("@index", Integer.toString(i)))).getText();
					String b = driver.findElement(By.xpath(index2.replace("@index", Integer.toString(i)))).getText();
					String c = driver.findElement(By.xpath(index3.replace("@index", Integer.toString(i)))).getText();

					tona = Integer.parseInt(a.replaceAll("[^0-9]", ""));

					System.out.println("SO#/Line#: " + b + " --- co so luong Available tren SI la: "
							+ ItemQtyAvailableSI + " ---Location " + c);
					Log.info("SO#/Line#: " + b + " --- co so luong Available tren SI la: " + ItemQtyAvailableSI
							+ " ---Location " + c);
//					takeSnapShot(driver, (OR.getProperty(object))  + "AvailableItemShipment.png");
					sum = sum + tona;
				}
				ItemQtyAvailableSI = sum;
				System.out.println("Sum availabel o SI la: " + ItemQtyAvailableSI);
				System.out.println("Sum availabel o Ton kho  la: " + ItemQtyAvailableSI);

			} catch (Exception e2) {
				// TODO: handle exception
			}

			if (ItemQtyAvailableSI == ItemQtyAvailable) {
				System.out.println("So luong available cua moi item DUNG");
				Log.info("So luong available cua moi item DUNG" + "\n");
			} else {
				System.out.println("So luong available cua moi item SAI");
				Log.info("So luong available cua moi item SAI" + "\n");
				takeSnapShot(driver, "CaptureError\\AvailableItemShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\AvailableItemShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				main_run_gui.bResult = false;
			}

		} catch (Exception e) {
			Log.info("khong get duoc so luong ton --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void GetInfoShipment(String object, String data) {
		try {

			String mashipment = driver
					.findElement(
							By.xpath("//*[@id=\'frmMaster\']/div/div/section[2]/div[1]/div[2]/div/div/div/dl/dd[1]"))
					.getText();
			System.out.println("\n *****SHOW MA PHIEU SHIPMENT*****");
			Log.info("*****SHOW MA PHIEU SHIPMENT*****");
			maphieuShipment_1 = mashipment;
			System.out.println("Ma phieu Shipment sau khi tao la: " + maphieuShipment_1);
			Log.info("Ma phieu Shipment sau khi tao la: " + maphieuShipment_1 + "\n");
//			takeSnapShot(driver, (OR.getProperty(object))  + "MaPhieuShipment1.png");

			// Status Shipment
			String status = driver
					.findElement(
							By.xpath("//*[@id=\'frmMaster\']/div/div/section[2]/div[1]/div[2]/div/div/div/dl/dd[2]"))
					.getText();

			System.out.println("\n *****KIEM TRA STATUS CUA SHIPMENT*****");
			Log.info("*****KIEM TRA STATUS CUA SHIPMENT*****");
			System.out.println("Status Shipment la: " + status);
			Log.info("Status Shipment la: " + status);

			String status2 = "Closed";

			if (status.equals(status2)) {
				System.out.println("Status Shipment dung");
				Log.info("Status Shipment dung" + "\n");
			} else {
				System.out.println("Status Shipment sai");
				Log.info("Status Shipment sai" + "\n");
				takeSnapShot(driver, "CaptureError\\StatusShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\StatusShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				main_run_gui.bResult = false;
			}

			// Show du lieu item hien thi tren shipment
			List<WebElement> rowCount = driver
					.findElements(By.xpath("//*[@id='ShipmentItemsGridProfilePage']/tbody/tr"));

			String index = "//*[@id=\'ShipmentItemsGridProfilePage\']/tbody/tr[@index]/td[11]/span";
			String index2 = "//*[@id='ShipmentItemsGridProfilePage']/tbody/tr[@index]/td[3]/span";

			int qtyshipment = 0;
			int sumqty = 0;

			System.out.println("\n *****SHOW QTY SHIPPED CUA SHIPMENT TREN MOI ITEM*****");
			Log.info("*****SHOW QTY SHIPPED CUA SHIPMENT TREN MOI ITEM*****");
			List<TonKho> names = new ArrayList<TonKho>();
			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					String a = driver.findElement(By.xpath(index.replace("@index", Integer.toString(i)))).getText();
					String b = driver.findElement(By.xpath(index2.replace("@index", Integer.toString(i)))).getText();
					qtyshipment = Integer.parseInt(a.replaceAll("[^0-9]", ""));

					TonKho name = new TonKho(b, qtyshipment);
					names.add(name);

					System.out.println("SO#/Line#: " + b + " --- Qty Shipped tren Shipment la: " + a);
					Log.info("SO#/Line#: " + b + " --- Qty Shipped tren Shipment la: " + a);
//					takeSnapShot(driver, (OR.getProperty(object))  + "QtyShipped.png");
					sumqty = sumqty + qtyshipment;
				}
				SumQtyShippedSI = sumqty;
				System.out.println("Tong Qty Shipped cua cac item la: " + SumQtyShippedSI);
				Log.info("Tong Qty Shipped cua cac item la: " + SumQtyShippedSI + "\n");

				Map<String, Long> result = names.stream()
						.collect(Collectors.groupingBy(TonKho::getPName, Collectors.summingLong(TonKho::getPQty)));

				for (Map.Entry<String, Long> entry : result.entrySet()) {
					String name = entry.getKey();
					Long number = entry.getValue();

					System.out.println("SO#/Line#: " + name + " co tong Qty Shipped la: " + number);
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

			// Total Qty shipped on Shipment
			int totalqty1 = 0;
			String totalqty2 = driver
					.findElement(By.xpath("//*[@id=\'frmMaster\']/div/div/section[2]/div[4]/div[2]/div/div/dl/dd[3]"))
					.getText();
			totalqty1 = Integer.parseInt(totalqty2.replaceAll("[^0-9]", ""));

			System.out.println("\n *****KIEM TRA GIA TRI TOTAL QTY TRONG SHIPMENT*****");
			Log.info("*****KIEM TRA GIA TRI TOTAL QTY TRONG SHIPMENT*****");
			System.out.println("Gia tri Total Qty trong trang Shipment detail la: " + totalqty1);
			Log.info("Gia tri Total Qty trong trang Shipment detail la: " + totalqty1);

			if (totalqty1 == SumQtyShippedSI) {
				System.out.println("Total Qty Shipment dung");
				Log.info("Total Qty Shipment dung" + "\n");
			} else {
				System.out.println("Total Qty Shipment sai");
				Log.info("Total Qty Shipment sai" + "\n");
				takeSnapShot(driver, "CaptureError\\TotalQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureError\\TotalQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
				main_run_gui.bResult = false;
			}

			// Item status Shipment
			String index3 = "//*[@id=\'ShipmentItemsGridProfilePage\']/tbody/tr[@index]/td[5]/span";
			System.out.println("\n *****KIEM TRA STATUS TREN MOI ITEM CUA SHIPPENT*****");
			Log.info("*****KIEM TRA STATUS TREN MOI ITEM CUA SHIPPENT*****");
			try {
				for (int i = 1; i <= rowCount.size(); i++) {
					String statusitem = driver.findElement(By.xpath(index3.replace("@index", Integer.toString(i))))
							.getText();
					System.out.println("Status tren item Shipment " + i + " la: " + statusitem);
					Log.info("Status tren item Shipment " + i + " la: " + statusitem);
					String statusitem2 = "Closed";
					if (statusitem.equals(statusitem2)) {
						System.out.println("Status tren Item Shipment dung");
						Log.info("Status tren Item Shipment dung" + "\n");
					} else {
						System.out.println("Status tren Item Shipment sai");
						Log.info("Status tren Item Shipment sai" + "\n");
						takeSnapShot(driver, "CaptureError\\StatusItemShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
						SendMail(("CaptureError\\StatusItemShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
						main_run_gui.bResult = false;
					}
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			Log.error("Khong the get ma phieu --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	// *** SO ***

	// CHECK SMART TURN
	// *****************
	
	
	
	// CHECK Universal Adapter
	// ***********************
	public static void DragAndDropSOAP(String object, String data) {
		try {

			//Element which needs to drag.    		
        	WebElement From=driver.findElement
        			(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div[1]/div[3]/div/div/div/div[2]/div[2]/ng-include/div/div[2]/div/div/div[4]/a/div[1]/img"));	
         
         //Element on which need to drop.		
         WebElement To=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div[1]/div[3]/div/div/div/div[1]/div/div/div[2]/div[1]"));					
         		
         //Using Action class for drag and drop.		
         Actions act=new Actions(driver);					

	//Dragged and dropped.		
         act.dragAndDrop(From, To).build().perform();		

		} catch (Exception e) {
			Log.info("khong link duoc trang To Khai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	

}