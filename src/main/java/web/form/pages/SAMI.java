package web.form.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import web.form.base.BasePage;

public class SAMI extends BasePage{
	
	
	
	WebDriver driver;
	
	
	
	By close = By.xpath("//button[@class='a-modal-close a-icon icon-cross']");
	By lang = By.xpath("//a[@class='a-topbar-nav__langswitch']");
	By login = By.xpath("//header[@class='m-topbar-nav ']//a[text()='Log in to MySAMI']");
	
	By userTab = By.id("user-tab");
	By userName = By.id("Username");
	By password = By.id("Password");
	By loginBtn = By.xpath("//form[@id='userPasswordForm']//button[text()='Log in']");
	
	By menu = By.id("js-sitemenutoggle");
	By mySamiTab = By.xpath("//a[text()='MySAMI']");
	By newPerformer = By.xpath("//a[text()='New performer application']");
	
	By firstName = By.name("firstname");
	By lastName = By.name("lastname");
	By dob = By.name("dateofbirth");
	By street = By.name("street");
	By postalCode = By.name("zip");
	By city = By.name("city");
	By country = By.name("country");
	By countryDropdown = By.xpath("//span[@id='select2-country-58-container']");
	By countryList = By.xpath("//ul[@id='select2-country-58-results']/li");
	By nationalityDropD = By.name("nationality");
	By nationalityDropdown = By.xpath("//span[@id='select2-nationality-zr-container']");
	By nationalityList = By.xpath("//ul[@id='select2-nationality-zr-results']/li");
	By email = By.name("email");
	By taxResidenceDropdown = By.xpath("//span[text()='Select country']");
	By taxResidenceList = By.xpath("//ul[@id='select2-tax_domicile-iu-results']/li");
	By taxResidence = By.name("tax_domicile");
	By tin = By.name("tin");
	By sexDropdown = By.className("select2-hidden-accessible");
	
	public SAMI(WebDriver driver) {
		
		this.driver = driver;
		
	}

	public void samiLaunch(String email, String firstName, String lastName, String aliasName, String Bands, String dob,
			String placeOfBirth, String COB, String nationality, String address, String CSZC, String instruments, String fullName,
			String postalCode, String city, String COR, String taxId, String todaysDate, String passportNo, String gender) {

		
		//driver.get("https://minasidor.sami.se/recordinglists/new");
		driver.findElement(close).click();
		String language = driver.findElement(lang).getText();
		System.out.println(language);
		if( language.equals("English")) {
			
			driver.findElement(lang).click();
		}
		
		driver.findElement(login).click();
		
		driver.findElement(userTab).click();
		driver.findElement(userName).sendKeys("Rident");
		driver.findElement(password).sendKeys("Lucythedog16!");
		

		driver.findElement(loginBtn).click();
		driver.findElement(menu).click();
		driver.findElement(mySamiTab).click();
		driver.findElement(newPerformer).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.street).sendKeys(address);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		//System.out.println(dob);
		try {
			date =formatter.parse(dob);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter1.format(date);
		//System.out.println(dateString);
		driver.findElement(this.dob).sendKeys(dateString);
		WebElement genderEle = driver.findElement(this.sexDropdown);
		Select selectG = new Select(genderEle);
		List<WebElement>genderOptions = selectG.getOptions();
		for (WebElement ele : genderOptions) {
			String genderType = ele.getText();
			//System.out.println(genderType);
			if(genderType.equals(gender)) {
				ele.click();
				break;
			}
		}
		driver.findElement(this.postalCode).sendKeys(postalCode);
		driver.findElement(this.city).sendKeys(city);
		

		WebElement cntryEle=driver.findElement(this.country);
		Select select = new Select(cntryEle);
		List<WebElement> cList = select.getOptions();
		for (WebElement ele : cList) {
			String text = ele.getText();
			//System.out.println(text);
			if(text.equals(COR)) {
				ele.click();
				break;
			}
		}
		
		
		WebElement nationEle = driver.findElement(this.nationalityDropD);
		Select selectN = new Select(nationEle);
		List<WebElement> optionsNationality = selectN.getOptions();
		for (WebElement ele : optionsNationality) {
			String text = ele.getText();
			//System.out.println(text);
			if(text.equals(nationality)) {
				ele.click();
				break;
			}
		}
		

		
		driver.findElement(this.email).sendKeys(email);
		
		
		WebElement taxEle = driver.findElement(this.taxResidence);
		Select selectTax = new Select(taxEle);
		List<WebElement> optionsTax = selectTax.getOptions();
		for (WebElement ele : optionsTax) {
			String text = ele.getText();
			//System.out.println(text);
			if(text.equals(COR)) {
				ele.click();
				break;
			}
		}
		driver.findElement(this.tin).sendKeys(taxId);
	}

}
