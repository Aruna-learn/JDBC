package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Opencart {

	public static void main(String[] args) throws Exception {
		
		//data
		String cust_firstname="Arunaa";
		String cust_lastname="Reddyy";
		String cust_email="apoololl@gmail.com";
		String cust_password="Ammu@460";
		
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/opencart/opencart-4.0.2.3/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys(cust_firstname);
		driver.findElement(By.id("input-lastname")).sendKeys(cust_lastname);
		driver.findElement(By.id("input-email")).sendKeys(cust_email);
		driver.findElement(By.id("input-password")).sendKeys(cust_password);
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		//WebElement revealed=driver.findElement(By.name("agree"));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("agree")))).click();
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		try {
		String confirm=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		
		if(confirm.equals("Your Account Has Been Created!")) {
			System.out.println("Registartion success");
		}
		else
			System.out.println("Registartion not successful");
		
		}
		catch(Exception e)
		{
			System.out.println("some problem in UI");
		}
		
		
		//database validation
		//create connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/opencart", "root","");
		
		//create statement
		Statement stmt=con.createStatement();
		
		//create query
		String query="Select * from oc_customers";
		
		//execute statement/query and store in the result set
		ResultSet rs=stmt.executeQuery(query);
		
		
		boolean status=false;
		while(rs.next()) {
			String fname=rs.getString(cust_firstname);
			String lname=rs.getString(cust_lastname);
			String email=rs.getString(cust_email);
			String passw=rs.getString(cust_password);
			
			if(cust_firstname.equals(fname)&&cust_lastname.equals(lname)
					&&cust_email.equals(email)&& cust_password.equals(passw)) {
				System.out.println("Record found test passed");
				status=true;
				break;
			}
			
			
			
			
		}
		
		if(status==false) {
			System.out.println("record not found");
		}
		
		
		
		//close the connection
		con.close();
		
		
		
		
		
		

	}

}
