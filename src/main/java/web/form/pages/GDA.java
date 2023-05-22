package web.form.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import web.form.base.BasePage;

public class GDA extends BasePage{

	
	WebDriver driver;
	
	
	By user = By.name("wt194$wtPageContent$wt107$wtContent$wtUserNameInput");
	By password = By.name("wt194$wtPageContent$wt107$wtContent$wtPasswordInput");
	By loginBtn = By.xpath("//a[text()='Login']");
	
	By artistLink = By.xpath("//a[@id='CA_Portal_wt18_block_wtTopMenu_CA_Portal_wt4_block_wt71']");
	By addArtist = By.xpath("//a[text()='Add Artist']");
	By newMember = By.xpath("//td[text()='New Member']//preceding-sibling::td//input[@id='CA_Portal_wt14_block_wtPageContent_CA_Portal_wt9_block_wtContent_wt4_wt457']");
	
	By fullName= By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtPersonalDetail_LastName");
	By pseudonym = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtPersonalDetail_Pseudonyms");
	By dob = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtPersonalDetail_BirthDate");
	By nationality = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtAffiliationForm_Performer_Nacionality");
	By taxId = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtAffiliationForm_FiscalNumber");
	By email = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtAffiliationForm_Email");
	By mobilePhNo = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtAffiliationForm_Mobile");
	By address = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtAddres_Address");
	By postalCode = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtAddress_PostalCode");
	By city = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtAddress_City");
	By COR = By.name("CA_Portal_wt14$block$wtPageContent$CA_Portal_wt9$block$wtContent$wt4$wtAffiliationForm_PerformerCountry");
	By strong = By.xpath("//strong[text()='United Kingdom']");
	By limitedMember = By.id("CA_Portal_wt14_block_wtPageContent_CA_Portal_wt9_block_wtContent_wt4_wt151");
	By portugalAndFollowinCntry = By.id("CA_Portal_wt14_block_wtPageContent_CA_Portal_wt9_block_wtContent_wt4_wt1034");
	
	public GDA(WebDriver driver) {
		this.driver = driver;
		
	}

	public void gdaLaunch(String email, String firstName, String lastName, String aliasName, String Bands, String dob,
			String placeOfBirth, String COB, String nationality, String address, String CSZC, String instruments, String fullName,
			String postalCode, String city, String COR, String taxId, String todaysDate, String passportNo, String gender) {
		

		driver.findElement(user).sendKeys("chris@ridentroyalties.com");
		driver.findElement(password).sendKeys("Lucythedog16!");
		driver.findElement(loginBtn).click();
		
		driver.findElement(artistLink).click();
		driver.findElement(addArtist).click();
		driver.findElement(newMember).click();
		
		driver.findElement(this.fullName).sendKeys(fullName);
		driver.findElement(this.pseudonym).sendKeys(aliasName);
		driver.findElement(this.dob).sendKeys(dob);
		driver.findElement(this.nationality).clear();
		driver.findElement(this.nationality).sendKeys(nationality);
		driver.findElement(this.taxId).sendKeys(taxId);
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(this.mobilePhNo).sendKeys("301-717-0503");
		driver.findElement(this.address).sendKeys(address);
		driver.findElement(this.postalCode).sendKeys(postalCode);
		driver.findElement(this.city).sendKeys(city);
		driver.findElement(this.COR).clear();
		driver.findElement(this.COR).sendKeys(COR);
		By strong = By.xpath("//strong[text()='"+COR+"']");
		driver.findElement(strong).click();
		driver.findElement(this.limitedMember).click();
		//driver.findElement(this.portugalAndFollowinCntry).click();
		
	}
}
