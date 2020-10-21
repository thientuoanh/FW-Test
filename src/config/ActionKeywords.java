package config;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
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
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import executionEngine.DiWMS_AutoTest_GUI;
import executionEngine.main_run_gui;
import utility.Log;

public class ActionKeywords {

	public static WebDriver driver;
	public static Actions action;
	



	static Date obDate = new Date();
	static SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	static String tenemail = null;

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

	public static void Upload(String object, String data) {
		try {
			WebElement uploadElement = driver.findElement(By.xpath(OR.getProperty(object)));
			uploadElement.sendKeys(data);
		} catch (Exception e) {
			Log.error("Upload that bai --- " + e.getMessage());
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
		} catch (Exception e) {
			Log.error("Call Capture that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void SendMail(String filename, String data, String titlemail, String bodymail) {
		try {
			// Create object of Property file
			Properties props = new Properties();

			// this will set host of server- you can change based on your requirement
			props.put("mail.smtp.host", "smtp.gmail.com");

			// set the port of socket factory
			props.put("mail.smtp.socketFactory.port", "465");

			// set socket factory
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

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
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(data));

				// Add the subject link
//				message.setSubject("Image Capture");
				message.setSubject(titlemail);

				// Create object to add multimedia type content
				BodyPart messageBodyPart1 = new MimeBodyPart();

				// Set the body of email
//				messageBodyPart1.setText("Email system auto sending");
				messageBodyPart1.setText(bodymail);

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

		} catch (Exception e) {
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
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

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
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(data));

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

		} catch (Exception e) {
			Log.error("Send Mail that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void ReadFileTXT(String s) {
		try {
			final String dir = System.getProperty("user.dir");
			FileReader fr = new FileReader(dir + "\\Email.txt");
			BufferedReader br = new BufferedReader(fr);
			s = "";
			s = br.readLine();
			System.out.println(s);
			tenemail = s;

		} catch (Exception e) {
			Log.error("Read File txt that bai --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	
	
	
}