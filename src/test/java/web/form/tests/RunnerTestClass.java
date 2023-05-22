package web.form.tests;

import org.testng.TestNG;

public class RunnerTestClass {

	static TestNG testNg;
	public static void main(String[] args) {

		testNg = new TestNG();
		testNg.setTestClasses(new Class[] {WebFormFillingTest.class});
		testNg.run();
	}

}
