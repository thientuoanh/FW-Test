package config;

import static executionEngine.main_run_gui.OR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import executionEngine.main_run_gui;
import utility.Log;

public class ActionKeywords_DiWMS extends ActionKeywords {
	
	
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
	
	
	static String emailminerva = null;
	static String phoneminerva = null;
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

					takeSnapShot(driver,
							"CaptureAfterOrder\\InformationOrder" + "_" + obDateFormat.format(obDate.getTime()) + ".png");
					ReadFileTXT(tenemail);
//					SendMail(("CaptureAfterOrder\\InformationOrder" + "_" + obDateFormat.format(obDate.getTime()) + ".png"),
//							tenemail);

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


}
