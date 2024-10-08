package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	
	public static void main(String[] args) throws Exception {
		
	ChromeDriver driver= new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.linkText("Merge Contacts")).click();
	driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
	System.out.println(driver.getWindowHandles());
	Set<String> windowHandles=driver.getWindowHandles();
	System.out.println(driver.getTitle());
//	Convert Set into the List
	
List<String> window=new ArrayList<String>(windowHandles);
driver.switchTo().window(window.get(1));
System.out.println(driver.getTitle());
driver.findElement(By.linkText("DemoCustomer")).click();
driver.switchTo().window(window.get(0));
System.out.println(driver.getTitle());
driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
Set<String> windowHandles2=driver.getWindowHandles();
window.addAll(windowHandles2);
System.out.println(driver.getWindowHandles());
driver.switchTo().window(window.get(1));
System.out.println(driver.getTitle());
driver.findElement(By.linkText("Saraswathi")).click();
driver.switchTo().window(window.get(0));
System.out.println(driver.getTitle());
driver.findElement(By.linkText("Merge")).click();
//Now as pop up has raised to confirm the merge contact to be sure, we need to click ok 
// To do that, we should move from main window to alert by switch it to alert() and saving it in Alert class.
Alert alert=driver.switchTo().alert();
String confirmAlertText=alert.getText();
System.out.println("Confirmation Text is: "+confirmAlertText);
alert.accept();
	}
	
}
