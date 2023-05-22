package web.form.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import web.form.base.BasePage;
import web.form.utils.Utils;

public class SENA extends BasePage{
	
	WebDriver driver;
		
	By senaNumber = By.id("SenaNumber");
	By password = By.id("Password");
	By loginBtn = By.id("login");
	
	//By lang1 = By.tagName("");
	By lang = By.xpath("//a[text()=' Log out ']//preceding-sibling::a");
	By flag = By.xpath("//img[@class='flag']");
	
	By register = By.id("btnAddRightholder");
	By signUp = By.id("registerMU");
	By prefName = By.id("PreferredName");
	By firstName = By.id("Firstname");
	By initials = By.id("Initials");
	By lastName = By.id("Surname");
	By placeOfBirth = By.id("PlaceOfBirth");
	By dob = By.xpath("//input[@class='required date hasDatepicker']");
	By nationalityDropdown = By.id("NationalityCode");
	
	
	
	
	
	public SENA(WebDriver driver) {
		this.driver = driver;
		
	}
	

	public void senaLaunch(String email, String firstName, String lastName, String aliasName, String Bands, String dob,
			String placeOfBirth, String COB, String nationality, String address, String CSZC, String instruments, String fullName,
			String postalCode, String city, String COR, String taxId, String todaysDate, String passportNo, String gender) {
		

		driver.findElement(senaNumber).sendKeys("400525");
		driver.findElement(password).sendKeys("Lucythedog16!");
		driver.findElement(loginBtn).click();
		
		String titleName = driver.findElement(flag).getAttribute("title");
		if(titleName.equals("Nederlands")) {
			driver.findElement(lang).click();
			//driver.findElement(flag).click();
		}
		
		driver.findElement(register).click();
		driver.findElement(signUp).click();
		
		driver.findElement(prefName).sendKeys(firstName);
		driver.findElement(this.firstName).sendKeys(firstName);
		String initials = lastName.substring(0, 1);
		driver.findElement(this.initials).clear();
		driver.findElement(this.initials).sendKeys(initials);
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.placeOfBirth).sendKeys(placeOfBirth);
		//driver.findElement(this.dob).sendKeys(dob);
		
		driver.findElement(this.dob).click();
		String [] DOB = dob.split("/");
		System.out.println(DOB.length);
		
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
		
		
		
//		By date = By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='"+DOB[0]+"']");
//		driver.findElement(date).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		
		char genderType = gender.charAt(0);
		System.out.println(genderType);
		By gType = By.xpath("//form[@id='frm2']//label[text()='Gender *']/..//input[@value='"+genderType+"']");
		
		driver.findElement(gType).click();
		//driver.findElement(this.dob).click();
		WebElement nationalityList = driver.findElement(nationalityDropdown);
		
		Select select = new Select(nationalityList);
		List<WebElement> options = select.getOptions();
		for (WebElement element : options) {
			String text = element.getText();
			//System.out.println(text);
			if(text.equals(nationality)) {
				element.click();
				break;
			}
		}
		
	}

}
