package Test_Tata_AIA_Classes;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Tata_AIA_Base_Class.Tata_AIA_Base_Class;
import Tata_AIA_POM.Tata_AIA_Pom_Homepage;
import Tata_AIA_POM.Tata_AIA_PopUp;
import Tata_AIA_Utility_Classes.Tata_DDF;

public class Test_Tata_AIA_With_Valid_Name_And_Mob_No extends Tata_AIA_Base_Class {
	
	public Tata_AIA_Pom_Homepage TIAPM;
	public Tata_AIA_Base_Class TAIABase;
	public Tata_AIA_PopUp TAIAPouUp;
	
	@BeforeClass
	//This method is help us to open Tata AIA Application
	public void open_Tata_Aia() {
		
		initializeBrowser();
		TAIABase = new Tata_AIA_Base_Class();
		TIAPM = new Tata_AIA_Pom_Homepage(driver);
		TAIAPouUp=new Tata_AIA_PopUp(driver);
	}
	
	@BeforeMethod
	//This method is help us to enter Name Mobile Number and click on Get a Call button
	public void User_Actions() throws IOException, Throwable {
		//Below 3 lines code is used to scroll down
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,5000);");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Below code is used to fetch Fullname from excel
		String Fullname =Tata_DDF.getTestData(0, 0);
		TIAPM.enterName(Fullname);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//Below code is used to fetch Mob Nuber from excel
		double Mob=Tata_DDF.getMobNumbers(1, 0);
		String Mob1 = String.valueOf(Mob);
		TIAPM.enterMobNo(Mob1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//Below code is used to fetch Plan from excel
		String plan=Tata_DDF.getTestData(2, 0);
        TIAPM.selectplan_dropdown(plan);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		TIAPM.clickgetCallButton();
		Thread.sleep(5);
	}
	
	
	@Test
	
	public void Verify_create_user_With_Valid_Credentials() throws Throwable, Throwable {
		//Below code is used to success from excel
		String expcted_successtext = Tata_DDF.getTestData(7, 0);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actual_successtext=TAIAPouUp.Succcesstext();
		
		//Below code is used to fetch successMsg from excel
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String expected_successMsg = Tata_DDF.getTestData(8, 0);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actual_successMsg=TAIAPouUp.getSuccessMsgText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//Below code is used to verify user getting success popup or not

		SoftAssert sat = new SoftAssert();
		sat.assertEquals(expcted_successtext, actual_successtext);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Below code is used to verify user getting success message or not
		sat.assertEquals(expected_successMsg, actual_successMsg);
		Thread.sleep(5);
	}
	
	@AfterMethod
	
	public void extentReport() {
		//Below code is used to generate extent report
		test=extent.createTest("Verify_create_user_With_Valid_Credentials");
		Assert.assertTrue(1>0);
		
		//This is used to send email but it's not working bcoz of gmail.smpt server issues
		//Email_Utility_Class.emailsend();
	}
	
	@AfterClass
	
	public void CloseBrowser() throws InterruptedException {
		//below code is used to quit the browser
		driver.quit();
	}

}
