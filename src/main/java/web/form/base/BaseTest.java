package web.form.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	
	public BasePage basePage;
	public WebDriver driver;
	public String playRightBe;
	public String sENA;
	public String sAMI;
	public String pPL;
	public String gDA;
	public String eJI;
	
	@BeforeTest
	public void setUp() {
		
		basePage = new BasePage();
		driver = basePage.initialize_WebDriver();
		eJI = basePage.windowHandleEJI;
		gDA = basePage.windowHandleGDA;
		pPL = basePage.windowHandlePPL;
		sAMI = basePage.windowHandleSAMI;
		sENA = basePage.windowHandleSENA;
		playRightBe=basePage.palyrightBeWH;
//		System.out.println(eJI);
//		System.out.println(gDA);
//		System.out.println(pPL);
//		System.out.println(sAMI);
//		System.out.println(sENA);
//		System.out.println(playRightBe);
	}
	
	
	
}
