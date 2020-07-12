package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Minerva {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://qa-minerva:minerva@par.minerva.vn");

		WebDriverWait wait = new WebDriverWait(driver, 120, 1000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/h4[2]/a")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/h4[2]/a")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/a")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/a")).click();

		// Nhap thong tin
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/h3")));
		driver.findElement(By.id("email")).sendKeys("thientuoanh@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("full_name")).sendKeys("Phan Tu Oanh");
		Thread.sleep(1000);
		driver.findElement(By.id("phone")).sendKeys("0974105249");
		Thread.sleep(1000);
		driver.findElement(By.id("address")).sendKeys("address");
		Thread.sleep(1000);
		driver.findElement(By.id("note")).sendKeys("note");
		Thread.sleep(1000);

		// Click Submit
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/button")).click();

		Thread.sleep(3000);

		String email = "thientuoanh@gmail.com";
		String phone = "0974105249";

		String email2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/dl/dd[1]")).getText();
		String phone2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/dl/dd[3]")).getText();

		if (email.equals(email2) && phone.equals(phone2)) {
			System.out.println("Submit thanh cong");
		} else {
			System.out.println("Submit that bai");
		}

	}

}
