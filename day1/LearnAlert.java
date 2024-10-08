package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert
{

		
	public static void main(String[] args)
	{
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.leafground.com/alert.xhtml");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	//Simple Alert
	
	driver.findElement(By.xpath("//span[text()='Show']")).click();
	
	//To handle the Alert
	Alert alert = driver.switchTo().alert();
	String simpleAlertText=alert.getText();
	System.out.println("Simple ALert:" +simpleAlertText);
	alert.accept();
	
	//Confirmation  Alert

	driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
	String confirmAlert=alert.getText();
	System.out.println("Confirmation Alert:"+confirmAlert);
	//alert.accept();
	
	alert.dismiss();
	
	//Prompt Alert
	driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
	String promptAlertText=alert.getText();
	System.out.println("Prompt Alert: " +promptAlertText);
	alert.sendKeys("Saras");
	alert.dismiss();
	
	// Sweet Alert to Delete
	
	driver.findElement(By.xpath("//span[text()='Delete']")).click();
	driver.findElement(By.name("j_idt88:j_idt108")).click();
	
	//sweet alert show button
	
	driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
	driver.findElement(By.xpath("//span[text()='Dismiss']")).click();

	
	
}
}
