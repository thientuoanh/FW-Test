package config;

import static executionEngine.main_run_gui.OR;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import executionEngine.main_run_gui;
import utility.Log;

public class ActionKeywords_SmartTurn extends ActionKeywords {
	
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
				takeSnapShot(driver,
						"CaptureError\\MaPhieuSO_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(("CaptureError\\MaPhieuSO_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//						tenemail);
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
				takeSnapShot(driver,
						"CaptureError\\StatusSOList_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(("CaptureError\\StatusSOList_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//						tenemail);
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
				takeSnapShot(driver,
						"CaptureError\\MaPhieuShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(("CaptureError\\MaPhieuShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//						"");
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
				takeSnapShot(driver, "CaptureError\\StatusShipmentList_Error" + "_"
						+ obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(("CaptureError\\StatusShipmentList_Error" + "_" + obDateFormat.format(obDate.getTime())
//						+ ".png"), tenemail);
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
//				SendMail(("CheckPartialShipment" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);
			} else {
				System.out.println("Checkbox Partial Shipment UNCHECK");
				Log.info("Checkbox Partial Shipment UNCHECK" + "\n");

				takeSnapShot(driver,
						"CaptureError\\UnCheckPartialShipment" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(
//						("CaptureError\\UnCheckPartialShipment" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//						tenemail);
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
				takeSnapShot(driver,
						"CaptureError\\StatusSODetail_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(("CaptureError\\StatusSODetail_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//						tenemail);
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
						takeSnapShot(driver,
								"CaptureError\\OrderQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//						SendMail(
//								("CaptureError\\OrderQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//								tenemail);
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
					takeSnapShot(driver,
							"CaptureError\\PreviouslyQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//					SendMail(("CaptureError\\PreviouslyQty_Error" + "_" + obDateFormat.format(obDate.getTime())
//							+ ".png"), tenemail);
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
						takeSnapShot(driver, "CaptureError\\PendingQty_Error" + "_"
								+ obDateFormat.format(obDate.getTime()) + ".png");
//						SendMail(("CaptureError\\PendingQty_Error" + "_" + obDateFormat.format(obDate.getTime())
//								+ ".png"), tenemail);
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
						takeSnapShot(driver, "CaptureError\\StatusItemSO_Error" + "_"
								+ obDateFormat.format(obDate.getTime()) + ".png");
//						SendMail(("CaptureError\\StatusItemSO_Error" + "_" + obDateFormat.format(obDate.getTime())
//								+ ".png"), tenemail);
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

						takeSnapShot(driver,
								"Display_MessageError" + "_" + obDateFormat.format(obDate.getTime()) + ".png");

					} else {
						System.out.println("Message error not display");
						Log.info("Message error not display" + "\n");
						takeSnapShot(driver, "CaptureError\\NotDisplay_MessageError" + "_"
								+ obDateFormat.format(obDate.getTime()) + ".png");
//						SendMail(("CaptureError\\NotDisplay_MessageError" + "_" + obDateFormat.format(obDate.getTime())
//								+ ".png"), tenemail);
						main_run_gui.bResult = false;
					}

				}
//				SendMail(("Display_MessageError" + "_" + obDateFormat.format(obDate.getTime()) + ".png"), tenemail);

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
				takeSnapShot(driver,
						"CaptureError\\TonKho2_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(("CaptureError\\TonKho2_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//						tenemail);
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
				takeSnapShot(driver, "CaptureError\\AvailableItemShipment_Error" + "_"
						+ obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(("CaptureError\\AvailableItemShipment_Error" + "_" + obDateFormat.format(obDate.getTime())
//						+ ".png"), tenemail);
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
				takeSnapShot(driver,
						"CaptureError\\StatusShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(("CaptureError\\StatusShipment_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//						tenemail);
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
				takeSnapShot(driver,
						"CaptureError\\TotalQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
//				SendMail(("CaptureError\\TotalQty_Error" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//						tenemail);
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
						takeSnapShot(driver, "CaptureError\\StatusItemShipment_Error" + "_"
								+ obDateFormat.format(obDate.getTime()) + ".png");
//						SendMail(("CaptureError\\StatusItemShipment_Error" + "_" + obDateFormat.format(obDate.getTime())
//								+ ".png"), tenemail);
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

}
