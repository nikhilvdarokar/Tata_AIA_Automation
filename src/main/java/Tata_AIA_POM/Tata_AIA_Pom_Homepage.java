package Tata_AIA_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Tata_AIA_Pom_Homepage {
	
	public WebDriver dirver;
	public Select s;
	
	@FindBy(xpath="//input[@class='form-control']") private WebElement name;
	@FindBy(xpath="//input[@class='form-control number-input']") private WebElement MobNo;
	@FindBy(xpath="//select[@name='cars']") private WebElement plan_dropdown;
	@FindBy(xpath="//button[text()='Get a call back']") private WebElement getCallButton;
	@FindBy(xpath="//p[@class='ta-error-msg err-class error-txt d-none d-block']") private WebElement ErroMsgForMob;
	@FindBy(xpath="//p[@class=\"ta-error-msg err-class error-txt d-none d-block\"]") private WebElement ErroMsgForEmptyName;
	@FindBy(xpath="//div[@class='selectCtr form-group fvc']//p[@class=\"ta-error-msg err-class error-txt d-none\"]") private WebElement ErrorMsgForDropDown;
	
	public Tata_AIA_Pom_Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String enterName(String Fullname) {
		name.sendKeys(Fullname);
		return Fullname;
	}
	
	
	public String enterMobNo(String Mob1) {
		MobNo.sendKeys(Mob1);
		return Mob1;
	}
	
	public void selectplan_dropdown(String plan) {
		
	 s = new Select(plan_dropdown);
	 
	 s.selectByValue(plan);
		
	}
	
	public void clickgetCallButton() {
		getCallButton.click();
	}
	
	public String getTextErroMsgForMob() {
		String ErrorMob = ErroMsgForMob.getText();
		return ErrorMob;
	}

	
	
}
