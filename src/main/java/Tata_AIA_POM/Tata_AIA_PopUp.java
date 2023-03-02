package Tata_AIA_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tata_AIA_PopUp {
	
	@FindBy (xpath="//b[text()='Your details have been successfully submitted. A representative from Tata AIA Life Insurance will call you soon.']") private WebElement SuccessMsgText;
	@FindBy (xpath="//div[@class='popup-title-wrap popup-new-title-wrap']/h2[text()='Success']") private WebElement Succcesstext;
	
	
	public Tata_AIA_PopUp(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public String getSuccessMsgText() {
		
		String msgText= SuccessMsgText.getText();
		return msgText;
	}
	
public String Succcesstext() {
		
	String success=Succcesstext.getText();
	return success;

	}

}
