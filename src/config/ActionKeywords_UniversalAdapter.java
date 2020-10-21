package config;

import static executionEngine.main_run_gui.OR;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import executionEngine.main_run_gui;
import utility.Log;

public class ActionKeywords_UniversalAdapter extends ActionKeywords {
	

//	public ActionKeywords_KeThua () {
//		super();
//	}
	static WebElement Des = null;
	static String RecipeName = null;
	static String MapName = null;
	static String XMLProfileName = null;
	static String JSONProfileName = null;
	static String DiskConnectionName = null;
	static String DiskOPerationName = null;
	static String HTTPConnectionName = null;
	static String HTTPOPerationName = null;

	public static void DragElementActivity(WebElement from, WebElement to) {
		final String JS_DRAG_AND_DROP = "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEff"
				+ "ect:'',effectAllowed:'all',files:[],items:{},types:[],setData:f"
				+ "unction(format,data){this.items[format]=data;this.types.append("
				+ "format);},getData:function(format){return this.items[format];},"
				+ "clearData:function(format){}};var emit=function(event,target){v"
				+ "ar evt=document.createEvent('Event');evt.initEvent(event,true,f"
				+ "alse);evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);}"
				+ ";emit('dragstart',src);emit('dragenter',tgt);emit('dragover',tg"
				+ "t);emit('drop',tgt);emit('dragend',src);";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(JS_DRAG_AND_DROP, new Object[] { from, to });
	}

	public static void DragAndDrop(WebElement from, WebElement to) {
		Actions action = new Actions(driver);
		action.dragAndDrop(from, to).perform();
	}

	public static void DragToPostion(WebElement element, int from, int to) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, from, to).build().perform();
	}

	public static void DragAndDropSOAP(String object, String data) {
		try {

			// Element which needs to drag.
			WebElement SOAP = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[1]/app-workflow-toolbox/div/div[2]/div[1]/div[4]/div/div[2]/h4"));

			// Element on which need to drop.
//			WebElement Destination = driver.findElement(By.xpath(
//					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface"));

			Des = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface"));

			DragAndDrop(SOAP, Des);

			Thread.sleep(1000);

			WebElement SOAPpositon = driver.findElement(By.xpath(OR.getProperty(object.trim())));

			DragToPostion(SOAPpositon, 50, -300);

		} catch (Exception e) {
			Log.info("Drag failled --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void DragAndDropHTTP(String object, String data) {
		try {

			// Element which needs to drag.
			WebElement HTTP = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[1]/app-workflow-toolbox/div/div[2]/div[1]/div[5]/div/div[2]/h4"));
			
			Des = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface"));

			
			DragAndDrop(HTTP, Des);

			Thread.sleep(1000);

			WebElement HTTPpositon = driver.findElement(By.xpath(OR.getProperty(object.trim())));

			DragToPostion(HTTPpositon, 50, -300);

		} catch (Exception e) {
			Log.info("Drag failled --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void DragStartEnd(String object, String data) {
		try {

			WebElement Start = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[1]/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface/div/div[1]/div[2]"));

			WebElement StartSOAP = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[1]/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface/div/div[1]/div[7]"));

			WebElement EndSOAP = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[1]/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface/div/div[1]/div[6]"));

			WebElement StartMap = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[1]/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface/div/div[1]/div[10]"));

			WebElement EndMap = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[1]/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface/div/div[1]/div[9]"));

			WebElement StartDisk = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[1]/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface/div/div[1]/div[13]"));

			WebElement EndDisk = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[1]/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface/div/div[1]/div[12]"));
			
			WebElement End = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[1]/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[2]/app-workflow-canvas/jsplumb-surface/div/div[1]/div[4]"));

			DragAndDrop(Start, StartSOAP);

//			Thread.sleep(1000);

			DragAndDrop(EndSOAP, StartMap);
			DragAndDrop(EndMap, StartDisk);
			DragAndDrop(EndDisk, End);

		} catch (Exception e) {
			Log.info("Drag failled --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void DragAndDropMap(String object, String data) {
		try {

			// Element which needs to drag.
			WebElement Map = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[1]/app-workflow-toolbox/div/div[2]/div[1]/div[6]/div/div[2]/h4"));

			DragAndDrop(Map, Des);

			Thread.sleep(1000);

			WebElement Mappositon = driver.findElement(By.xpath(OR.getProperty(object.trim())));

			DragToPostion(Mappositon, 50, -150);

		} catch (Exception e) {
			Log.info("Drag failled --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void DragElementMap(WebElement from, WebElement to) throws AWTException {
		Point coordinates1 = from.getLocation();
		Point coordinates2 = to.getLocation();
		Robot robot = new Robot();
		robot.mouseMove(coordinates1.getX(), coordinates1.getY());
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(coordinates2.getX(), coordinates2.getY());
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

	}

	public static void DragAndDropNodeMapXML(String object, String data) {
		try {

			// Keo Node Root
			WebElement S_NodeRoot = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[3]/ul/li[2]/ul/li[2]"));			         
			WebElement D_NodeRoot = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[3]/ul/li[2]/ul/li[2]"));
			DragElementMap(S_NodeRoot, D_NodeRoot);

			Thread.sleep(1000);
			// Keo Node result
			WebElement S_NodeResult = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[3]/ul/li[2]/ul/li[5]/span"));
			WebElement D_NodeResult = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[3]/ul/li[2]/ul/li[5]/span"));
			DragElementMap(S_NodeResult, D_NodeResult);

			Thread.sleep(1000);
			// Keo Node Business Affiliates
			WebElement S_NodeBA= driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[3]/ul/li[3]/ul/li[4]/ul/li[1]/span"));
			WebElement D_NodeBA = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[3]/ul/li[3]/ul/li[4]/ul/li[1]/span"));
			DragElementMap(S_NodeBA, D_NodeBA);
				
			Thread.sleep(1000);
			// Keo Node CompanyName
			WebElement S_NodeCompanyName= driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[3]/ul/li[3]/ul/li[5]/ul/li[1]/span"));
			WebElement D_NodeCompanyName = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[3]/ul/li[3]/ul/li[5]/ul/li[1]/span"));
			DragElementMap(S_NodeCompanyName, D_NodeCompanyName);
			
			Thread.sleep(1000);
			// Keo Node CompanyCode
			WebElement S_NodeCompanyCode= driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[3]/ul/li[3]/ul/li[6]/ul/li[1]/span"));
			WebElement D_NodeCompanyCode = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[3]/ul/li[3]/ul/li[6]/ul/li[1]/span"));
			DragElementMap(S_NodeCompanyCode, D_NodeCompanyCode);
			
			Thread.sleep(1000);
			// Keo Node CustomerStatus
			WebElement S_NodeCustomerStatus = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[3]/ul/li[3]/ul/li[7]/ul/li[1]/span"));
			WebElement D_NodeCustomerStatus = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[3]/ul/li[3]/ul/li[7]/ul/li[1]/span"));
			DragElementMap(S_NodeCustomerStatus, D_NodeCustomerStatus);
			
		} catch (Exception e) {
			Log.info("Drag failled --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void DragAndDropNodeMapJSON(String object, String data) {
		try {

			// Keo Node Root
			WebElement S_NodeRoot = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[4]/ul/li[1]"));			         
			WebElement D_NodeRoot = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[4]/ul/li[1]"));
			DragElementMap(S_NodeRoot, D_NodeRoot);

			Thread.sleep(1000);
			// Keo Node Login
			WebElement S_NodeLogin = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[1]"));			
			WebElement D_NodeLogin = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[1]"));
			DragElementMap(S_NodeLogin, D_NodeLogin);
			
			Thread.sleep(1000);
			// Keo Node Avatar
			WebElement S_NodeAvatar= driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[2]/ul/li"));			      
			WebElement D_NodeAvatar = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[2]/ul/li"));
			DragElementMap(S_NodeAvatar, D_NodeAvatar);
				
			Thread.sleep(1000);
			// Keo Node Users
			WebElement S_NodeUsers= driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[3]/ul/li"));
			WebElement D_NodeUsers = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[3]/ul/li"));
			DragElementMap(S_NodeUsers, D_NodeUsers);
			
			Thread.sleep(1000);
			// Keo Node Element
			WebElement S_NodeElement= driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[4]/ul/li"));
			WebElement D_NodeElement = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[4]/ul/li"));
			DragElementMap(S_NodeElement, D_NodeElement);
			
			Thread.sleep(1000);
			// Keo Node ID
			WebElement S_NodeID = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[5]/ul/li"));
			WebElement D_NodeID = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[5]/ul/li"));
			DragElementMap(S_NodeID, D_NodeID);
			
			Thread.sleep(1000);
			// Keo Node Nickname
			WebElement S_NodeNickname = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[1]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[6]/ul/li"));
			WebElement D_NodeNickname = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div[2]/app-component-configuration/app-map-editor/div/div[2]/div[1]/as-split/as-split-area[3]/div/div[2]/ul/li/ul/li[4]/ul/li[2]/ul/li[6]/ul/li"));
			DragElementMap(S_NodeNickname, D_NodeNickname);

		} catch (Exception e) {
			Log.info("Drag failled --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void DragAndDropDISK(String object, String data) {
		try {

			// Element which needs to drag.
			WebElement Disk = driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[2]/div/app-component-configuration/app-recipe/as-split/as-split-area/as-split/as-split-area[1]/app-workflow-toolbox/div/div[2]/div[1]/div[3]/div/div[2]/h4"));

			DragAndDrop(Disk, Des);

			Thread.sleep(1000);

			WebElement Diskpositon = driver.findElement(By.xpath(OR.getProperty(object.trim())));

			DragToPostion(Diskpositon, -50, -30);

		} catch (Exception e) {
			Log.info("Drag failled --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputRecipeName(String object, String data) {
		try {
			String n = RandomStringUtils.randomNumeric(6);

			String data2 = data + " " + n;
			WaitElement(object, data);

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data2);
			RecipeName = data2;
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void InputHTTPConnectionName(String object, String data) {
		try {
			String n = RandomStringUtils.randomNumeric(6);

			String data2 = data + " " + n;
			WaitElement(object, data);

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data2);
			HTTPConnectionName = data2;
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void InputHTTPConnectionName2(String object, String data) {
		try {
			
			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(HTTPConnectionName);
			
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void InputHTTPOperationName(String object, String data) {
		try {
			String n = RandomStringUtils.randomNumeric(6);

			String data2 = data + " " + n;
			WaitElement(object, data);

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data2);
			HTTPOPerationName = data2;
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void InputHTTPOperationName2(String object, String data) {
		try {
			
			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(HTTPOPerationName);
			
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}


	public static void InputMapName(String object, String data) {
		try {
			String n = RandomStringUtils.randomNumeric(6);

			String data2 = data + " " + n;
			WaitElement(object, data);

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data2);
			MapName = data2;
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void InputMapName2(String object, String data) {
		try {			
			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(MapName);
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}


	public static void InputXMLProfileName(String object, String data) {
		try {
			String n = RandomStringUtils.randomNumeric(6);

			String data2 = data + " " + n;
			WaitElement(object, data);

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data2);

			XMLProfileName = data2;
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputXMLProfileName2(String object, String data) {
		try {

			WaitElement(object, data);

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(XMLProfileName);

		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputJSONProfileName(String object, String data) {
		try {
			String n = RandomStringUtils.randomNumeric(6);

			String data2 = data + " " + n;
			WaitElement(object, data);

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data2);

			JSONProfileName = data2;
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void InputJSONProfileName2(String object, String data) {
		try {
			
			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(JSONProfileName);

		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputDiskConnectionName(String object, String data) {
		try {
			String n = RandomStringUtils.randomNumeric(6);

			String data2 = data + " " + n;
			WaitElement(object, data);

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data2);

			DiskConnectionName = data2;
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void InputDiskConnectionName2(String object, String data) {
		try {
			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(DiskConnectionName);
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void InputDiskOperationName(String object, String data) {
		try {
			String n = RandomStringUtils.randomNumeric(6);

			String data2 = data + " " + n;
			WaitElement(object, data);

			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(data2);

			DiskOPerationName = data2;
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	
	public static void InputDiskOperationName2(String object, String data) {
		try {			
			driver.findElement(By.xpath(OR.getProperty(object.trim()))).sendKeys(DiskOPerationName);
		} catch (Exception e) {
			Log.error("Khong the nhap --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void HoverAndClick(String object, String data) {
		try {
			action = new Actions(driver);
			WebElement hovericonclose = driver.findElement(By.xpath(OR.getProperty(object)));
			action.moveToElement(hovericonclose).perform();

			Thread.sleep(1000);
			driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/app-desktop/div/app-build/as-split/as-split-area[2]/div/div[1]/div[1]/ul/li[2]/mat-icon[2]"))
					.click();
		} catch (Exception e) {
			Log.error("Khong the hover --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}

	public static void CheckResultRecipeRun(String object, String data) {
		try {
			String fuctionnamecheck = "---CHECK RESULT RUN RECIPE---";
			Log.info(fuctionnamecheck);
			
			String RecipeName1 = "Run " + RecipeName + " recipe successfully";
			System.out.println("RecipeName1 la: " + RecipeName1);
			Log.info("RecipeName1 la: " + RecipeName1);
			
			String RecipeName2 = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			System.out.println("RecipeName2 la: " + RecipeName2);
			Log.info("RecipeName2 la: " + RecipeName2);
			
//			String RecipeName3 = driver.findElement(By.xpath(OR.getProperty(object))).getAttribute("aria-label");
//			System.out.println("RecipeName3 la: " + RecipeName3);
			ReadFileTXT(tenemail);
			if (RecipeName1.equals(RecipeName2)) {
				String msgsuccess = "Run Recipe success";
				System.out.println(msgsuccess);
				Log.info(msgsuccess);
				takeSnapShot(driver, "CaptureUA\\Result_Run_Recipe " + RecipeName + "_"
						+ obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureUA\\Result_Run_Recipe " + RecipeName + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
						tenemail,fuctionnamecheck,msgsuccess);

			} else {
				String msgfailled = "Run Recipe failled";
				System.out.println(msgfailled);
				Log.info(msgfailled);
				takeSnapShot(driver, "CaptureUA\\Result_Run_Recipe " + RecipeName + "_"
						+ obDateFormat.format(obDate.getTime()) + ".png");
				SendMail(("CaptureUA\\Result_Run_Recipe " + RecipeName + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
						tenemail, fuctionnamecheck, msgfailled);
			}
		} catch (Exception e) {
			Log.info("Check failled --- " + e.getMessage());
			main_run_gui.bResult = false;
		}
	}
	

	
	
	
	
	
	
	
}
