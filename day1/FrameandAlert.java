package week4.day1;

import java.time.Duration;// First find the frames and click on try it, move to alert popup message
//then accept by saying ok and move webpage again to enter the parent frame and type the message of the action performed. 

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameandAlert {

	
	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//frames
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//Alert
Alert alert=driver.switchTo().alert();
String confirmAlertText=alert.getText();
System.out.println("Confirmation Alert Message: "+confirmAlertText);
alert.accept();

driver.switchTo().defaultContent();
driver.switchTo().frame("iframeResult");
String clickedText=driver.findElement(By.id("demo")).getText();
System.out.println("Result is: "+clickedText);

	}
}
