package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objs.Home;
import objs.Registration;

public class RegistrationTest {
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\NewChromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void testRegBtn() {
		driver.navigate().to(Home.URL);
		Home.clickRegBtn(driver);
		String actual = driver.getCurrentUrl();
		String expected= Registration.URL;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testRegForm() {
		File f = new File("Tijana.xlsx"); // Ucitavanje fajla
		try {
			InputStream inp = new FileInputStream(f); // Citanje iz fajla
			XSSFWorkbook wb = new XSSFWorkbook(inp); // Pretvaranje fajla u odgovarajuci format
			Sheet sheet = wb.getSheetAt(0); // Dohvata sheet
			Row row = sheet.getRow(0); // Dohvata red
			
			wb.close();
		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}
		driver.navigate().to(Registration.URL); //ako prvi padne drugi ode na istu stranu
		Registration.inputUsername(driver, "djordje");
		Registration.inpputPassword(driver, "1234");
		Registration.inpputConfirmPassword(driver, "1234");
		Registration.submit(driver);
		
		String actual=driver.getCurrentUrl();
		String expected="http://demo.guru99.com/test/newtours/register_sucess.php";
		Assert.assertEquals(actual, expected);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
