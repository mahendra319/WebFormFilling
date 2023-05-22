package web.form.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import web.form.base.BasePage;
import web.form.testdata.TestDataExternal;
import web.form.utils.Utils;

public class EJI extends BasePage{
	
	
	WebDriver driver;
	
	
	
	By lastName = By.id("csaladnev");
	By firstName = By.id("keresztnev");
	By stageName = By.id("muvesznev");
	By placeOfBirth = By.id("szuletesi_hely");
	By dob = By.id("szuletesi_datum");
	//By taxId = By.id("adoazonosito");
	By postalCode = By.id("allando_irsz");
	By city = By.id("allando_varos");
	By CSZC = By.id("allando_utcahazszam");
	By companyNanme = By.id("cegnev");
	By compRegAdd = By.id("ceg_szekhely");
	By compCEO = By.id("ceg_kepviselo");
	By compTaxID = By.id("ceg_adoszam");
	By compBankName = By.id("ceg_bank_nev");
	By compBankAdd = By.id("ceg_bank_cim");
	By compSWIFTcode = By.id("ceg_swift");
	By compIBAN = By.id("ceg_bankszamlaszam");
	
	
	
	public EJI(WebDriver driver) {
		this.driver = driver;
		
	}
	

	public void ejiLaunch(String email, String firstName, String lastName, String aliasName, String Bands, String dob,
			String placeOfBirth, String COB, String nationality, String address, String CSZC, String instruments, String fullName,
			String postalCode, String city, String COR, String taxId, String todaysDate, String passportNo, String gender) {

		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		
		
		
		
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.stageName).sendKeys(aliasName);
		driver.findElement(this.placeOfBirth).sendKeys(placeOfBirth);
		//driver.findElement(this.dob).sendKeys(dob);
		driver.findElement(this.dob).click();
		String [] DOB = dob.split("/");
		//System.out.println(DOB.length);
		
		String month = Utils.getMonthNameFromNumber(Integer.parseInt(DOB[1]));
		
		By months = By.className("ui-datepicker-month");
		WebElement monthsDropdown = driver.findElement(months);
		Select selectM = new Select(monthsDropdown);
		//selectM.selectByValue(month);
		List<WebElement> monthOptions = selectM.getOptions();
		for (WebElement ele : monthOptions) {
			String text = ele.getText();
			//System.out.println(text);
			if(text.equals(month)) {
				ele.click();
				break;
				
			}
		}
		
		By years = By.className("ui-datepicker-year");
		WebElement year = driver.findElement(years);
		Select selectY = new Select(year);
		selectY.selectByValue(DOB[2]);
		
		
		if(DOB[0].charAt(0)=='0') {
			DOB[0]=DOB[0].substring(1);
			By date = By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='"+DOB[0]+"']");
			driver.findElement(date).click();
		}else {
			By date = By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='"+DOB[0]+"']");
			driver.findElement(date).click();
		}
		
		
		//driver.findElement(this.taxId).sendKeys(taxId);
				
		WebElement countryDropDown = driver.findElement(By.id("allando_orszag"));
		Select select = new Select(countryDropDown);
		List<WebElement> options = select.getOptions();
		for (WebElement element : options) {
			String countryName = element.getText();
			//System.out.println(countryName);
			if(countryName.equals(COR.toUpperCase())) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				element.click();
				break;
			}
		}
		
		driver.findElement(this.postalCode).sendKeys(postalCode);
		driver.findElement(this.city).sendKeys(city);
		driver.findElement(this.CSZC).sendKeys(address);
		
		//driver.findElement(this.companyNanme).sendKeys("Rident Royalties");
		driver.findElement(this.companyNanme).sendKeys(TestDataExternal.compName_EJI);
		
		//driver.findElement(this.compRegAdd).sendKeys("309 Craigmont Dr., Austin, TX 78745, USA");
		driver.findElement(this.compRegAdd).sendKeys(TestDataExternal.compRegAddress_EJI);
		
		//driver.findElement(this.compCEO).sendKeys("Chris Kennedy");
		driver.findElement(this.compCEO).sendKeys(TestDataExternal.compCEO_EJI);
		
		//driver.findElement(this.compTaxID).sendKeys("81-4839770");
		driver.findElement(this.compTaxID).sendKeys(TestDataExternal.compTaxID_EJI);
		
		//driver.findElement(this.compBankName).sendKeys("First Citizens");
		driver.findElement(this.compBankName).sendKeys(TestDataExternal.compBankName_EJI);
		
		//driver.findElement(this.compBankAdd).sendKeys("4101 Marathon Blvd First Floor, Austin, TX 78756");
		driver.findElement(this.compBankAdd).sendKeys(TestDataExternal.compBankAddress_EJI);
		
		//driver.findElement(this.compSWIFTcode).sendKeys("FCBTUS33");
		driver.findElement(this.compSWIFTcode).sendKeys(TestDataExternal.compSWIFTCode_EJI);
		
		//driver.findElement(this.compIBAN).sendKeys("000009161124080");
		driver.findElement(this.compIBAN).sendKeys(TestDataExternal.compIBAN_EJI);
		
		
		
	}
	


}
