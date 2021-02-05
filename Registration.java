package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {
	private static final String USERNAME_XPATH="//*[@id=\"email\"]";
	public static final String URL="http://demo.guru99.com/test/newtours/register.php";
	
	public static void inputUsername(WebDriver driver,String username) {			// metoda koja upisuje podatke u username
		driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(username);
		
	}
	
	public static void inpputConfirmPassword(WebDriver driver, String password) {			//metoda koja upisuje podatke u password
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	public static void inpputPassword(WebDriver driver, String password2) {			//metoda koja upisuje podatke u password
		driver.findElement(By.name("confirmPassword")).sendKeys(password2);
	}
	
	public static void submit (WebDriver driver) {										//metoda koja klikce na submit
		driver.findElement(By.name("submit")).click();
	}
	
	
}
