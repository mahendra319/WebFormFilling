package web.form.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import web.form.base.BaseTest;
import web.form.pages.EJI;
import web.form.pages.GDA;
import web.form.pages.PPL;
import web.form.pages.PlayrightBe;
import web.form.pages.SAMI;
import web.form.pages.SENA;
import web.form.utils.ExcelUtil;

public class WebFormFillingTest extends BaseTest{

	PlayrightBe palyrightBe;
	EJI eji;
	SENA sena;
	GDA gda;
	SAMI sami;
	PPL ppl;
	
	@DataProvider()
	public Object[][] getFormData() {
		Object[][] data = ExcelUtil.getTestData("Sheet1");
		
		return data;
	}
	
	@Test(dataProvider = "getFormData",priority=1)
	public void palyrightFormFilling(String email, String firstName, String lastName, String aliasName, String bands, String dob,
			String placeOfBirth, String COB, String nationality, String address1, String CSZC, String instruments, String fullName,
			String zipCode, String city, String COR, String taxID, String todaysDate, String passportNo, String gender) {
		palyrightBe=new PlayrightBe(driver);
		driver.switchTo().window(playRightBe);
		palyrightBe.launchURL(email,firstName,lastName,aliasName,bands, dob, placeOfBirth, COB, nationality, address1, CSZC,
				instruments, fullName, zipCode, city, COR, taxID, todaysDate, passportNo, gender);
	}
	
	
	@Test(dataProvider="getFormData",priority=2)
	public void ejiFormFillingTest(String email, String firstName, String lastName, String aliasName, String bands, String dob,
			String placeOfBirth, String COB, String nationality, String address1, String CSZC, String instruments, String fullName,
			String zipCode, String city, String COR, String taxID, String todaysDate, String passportNo, String gender) {
		
		eji=new EJI(driver);
		driver.switchTo().window(eJI);
		eji.ejiLaunch(email, firstName, lastName, aliasName, bands, dob, placeOfBirth, COB, nationality, address1, CSZC, instruments, fullName, zipCode, city, COR, taxID, todaysDate, passportNo, gender);
	}
	
	@Test(dataProvider="getFormData",priority=3)
	public void senaFormmFillingTest(String email, String firstName, String lastName, String aliasName, String bands, String dob,
			String placeOfBirth, String COB, String nationality, String address1, String CSZC, String instruments, String fullName,
			String zipCode, String city, String COR, String taxID, String todaysDate, String passportNo, String gender) {
		
		
		sena = new SENA(driver);
		driver.switchTo().window(sENA);
		sena.senaLaunch(email, firstName, lastName, aliasName, bands, dob, placeOfBirth, COB, nationality, address1, 
				CSZC, instruments, fullName,  zipCode,city, COR, taxID, todaysDate, passportNo, gender);
	}
	
	
	@Test(dataProvider="getFormData",priority=4)
	public void gdaFormFillingTest(String email, String firstName, String lastName, String aliasName, String bands, String dob,
			String placeOfBirth, String COB, String nationality, String address1, String CSZC, String instruments, String fullName,
			String zipCode, String city, String COR, String taxID, String todaysDate, String passportNo, String gender) {
		
		gda = new GDA(driver);
		driver.switchTo().window(gDA);
		gda.gdaLaunch(email, firstName, lastName, aliasName, bands, dob, placeOfBirth, COB, nationality, address1, CSZC, instruments, fullName,
				zipCode, city, COR, taxID, todaysDate, passportNo, gender);
		
	}
	
	
	@Test(dataProvider = "getFormData",priority=5)
	public void samiFormFillingTest(String email, String firstName, String lastName, String aliasName, String bands, String dob,
			String placeOfBirth, String COB, String nationality, String address1, String CSZC, String instruments, String fullName,
			String zipCode, String city, String COR, String taxID, String todaysDate, String passportNo, String gender) {
		
		sami = new SAMI(driver);
		driver.switchTo().window(sAMI);
		sami.samiLaunch(email, firstName, lastName, aliasName, bands, dob, placeOfBirth, COB, nationality, address1, CSZC, instruments, fullName, zipCode, city, COR, taxID, todaysDate, passportNo, gender);
		
	}
	
	
	
	@Test(dataProvider = "getFormData",priority=6,enabled=true)
	public void pplFormFillingTest(String email, String firstName, String lastName, String aliasName, String bands, String dob,
			String placeOfBirth, String COB, String nationality, String address1, String CSZC, String instruments, String fullName,
			String zipCode, String city, String COR, String taxID, String todaysDate, String passportNo, String gender) {
		
		ppl = new PPL(driver);
		driver.switchTo().window(pPL);
		ppl.pplLaunch(email, firstName, lastName, aliasName, bands, dob, placeOfBirth, COB, nationality, address1, CSZC, instruments, fullName, zipCode, city, COR, taxID, todaysDate, passportNo, gender);
		
	}
	
	
	
	
	
	
	
	
	
	
}
