package web.form.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import web.form.base.BasePage;
import web.form.base.BaseTest;


public class PlayrightBe extends BasePage{

	WebDriver driver;
	
	BaseTest baseTest= new BaseTest();
	
	By nlLink = By.xpath("//span[text()='NL']");
	By langList = By.xpath("//ul[@class='wpml-ls-sub-menu']/li//a");
	By portalLink = By.xpath("//a[@class='portal-link toggle-portal']");
	
	By loginBtn = By.xpath("//a[text()='Log in']");
	By userName = By.xpath("//div[@class='UserCtn']//input[@name='wt93$wtMainContent$wtUserNameInput']");
	By password = By.xpath("//div[@class='PassCnt']//input[@name='wt93$wtMainContent$wtPasswordInput']");
	By signInBtn = By.xpath("//a[text()='SIGN IN']");
	
	By perfomrsLink = By.xpath("//div[@class='SideMenuItemList']//div[text()='Performers']");
	By addPerfBtn = By.name("CA_Portal_Lib_wt46$block$wtMainContent$wt105");
	By newMembershipRadioBtn = By.id("CA_Portal_Lib_wt6_block_wtMainContent_wt17_WebPatterns_wt1525_block_wtCell1");
	
	
	By lastName = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wt852$block$wtColumn1$wtPersonalDetail_LastName");
	By firstName = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wt852$block$wtColumn2$wtPersonalDetail_FirstName4");
	By email = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$wtAffiliationForm_Email");
	By dob = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wt689$block$wtColumn1$wtPersonalDetail_BirthDate2");
	By COB = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wt689$block$wtColumn2$wtAffiliationForm_BirthCountry");
	By genderMale = By.id("CA_Portal_Lib_wt6_block_wtMainContent_wt17_WebPatterns_wt689_block_wtColumn3_wt1699");
	By genderFemale = By.id("CA_Portal_Lib_wt6_block_wtMainContent_wt17_WebPatterns_wt689_block_wtColumn3_wt334");
	By nationality = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wtPNcountry$block$wtColumn1$wtAffiliationForm_Performer_Nacionality");
	By COR = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wt228$block$wtColumn1$wtAffiliationForm_PerformerCountry");
	By address = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wt228$block$wtColumn2$wtAddres_Address");
	By postalCode = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wt605$block$wtColumn1$wtAddres_PostalCode");
	By city = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wt605$block$wtColumn2$wtAddres_City");
	By pseudonyms = By.name("CA_Portal_Lib_wt6$block$wtMainContent$wt17$WebPatterns_wt946$block$wtColumn1$wtPersonalDetail_Pseudonyms");
	By musicalPerf = By.id("CA_Portal_Lib_wt6_block_wtMainContent_wt17_wtFiduciaryAssignementTerritorialTable_MU_ctl04_wt1457");
	By audiovisPerf = By.id("CA_Portal_Lib_wt6_block_wtMainContent_wt17_wtFiduciaryAssignementTerritorialTable_AV_ctl04_wt1682");
	
	
	
	
	public PlayrightBe(WebDriver driver) {
		this.driver = driver;
		
		
	}
	
	
	public void launchURL(String email, String firstName, String lastName, String aliasName, String Bands, String dob,
			String placeOfBirth, String COB, String nationality, String address, String CSZC, String instruments, String fullName,
			String postalCode, String city, String COR, String TaxID, String todaysDate, String passportNo, String gender) {
	
		
		driver.findElement(nlLink).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> langs = driver.findElements(langList);
		System.out.println(langs.size());
		for (WebElement ele : langs) {
			String langName = ele.getText();
			//System.out.println(langName);
			if(langName.equals("EN")) {
				ele.click();
				break;
			}
		}
		
		
		driver.findElement(portalLink).click();
		driver.findElement(loginBtn).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wHandles = new ArrayList<String>(windowHandles);
		//System.out.println(windowHandles.size());

		String pWH = wHandles.get(0);
		String cWH = wHandles.get(wHandles.size()-1);
			
		driver.switchTo().window(cWH);
		driver.findElement(userName).sendKeys("chris@ridentroyalties.com");
		driver.findElement(password).sendKeys("Lucythedog16!");
		driver.findElement(signInBtn).click();
		
		driver.findElement(perfomrsLink).click();
		driver.findElement(addPerfBtn).click();
		driver.findElement(newMembershipRadioBtn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(this.lastName).sendKeys(lastName);
		//elementUtil.waitForElementToBeVisible(this.firstName, 30);
		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.dob).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		driver.findElement(this.dob).sendKeys(dob);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(this.COB).click();
		driver.findElement(this.COB).sendKeys(COB);
		//By ctryOfBirth = By.xpath("//a[@id='os-internal-ui-active-menuitem']/ui-autocomplete-item");
		//driver.findElement(ctryOfBirth).click();
		driver.findElement(this.nationality).sendKeys(nationality);
		//By strong = By.xpath("//a[@id='os-internal-ui-active-menuitem']//strong");
		//driver.findElement(strong).click();
		driver.findElement(this.COR).sendKeys(COR);
		//By strongCOR = By.xpath("(//a[@class='os-internal-ui-corner-all needsclick']//strong)[2]");
		//driver.findElement(strongCOR).click();
		driver.findElement(this.address).sendKeys(address);
		driver.findElement(this.postalCode).sendKeys(postalCode);
		driver.findElement(this.city).sendKeys(city);
		driver.findElement(this.pseudonyms).sendKeys(aliasName);
		driver.findElement(this.musicalPerf).click();
		driver.findElement(this.audiovisPerf).click();
		
	}
	
}
