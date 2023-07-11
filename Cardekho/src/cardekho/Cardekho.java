package cardekho;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.server.HttpChannelState.Action;

public class Cardekho {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option=new ChromeOptions();
		Thread.sleep(1000);
		option.addArguments("--disable-notifications");
		Thread.sleep(1000);
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cardekho.com/");
		WebElement usedcar = driver.findElement(By.xpath("//span[contains(text(),'USED CAR')]"));
		Thread.sleep(1000);
		Actions a=new Actions(driver);
		a.moveToElement(usedcar).perform();
		WebElement e = driver.findElement(By.xpath("//span[text()='Cars In Your City ']"));
		Actions a2=new Actions(driver);
		a.moveToElement(e).perform();
		driver.findElement(By.xpath("//a[@title='Used Cars In Bangalore']//span")).click();
		List<WebElement> check = driver.findElements(By.xpath("//div[@class='outBox fuelby']//label[@class='checkLabel']"));
		for(int i=0;i<check.size();i++)
		{
			check.get(i).click();
		}
		
		//thank you

	}

}
