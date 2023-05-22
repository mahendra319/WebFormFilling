package web.form.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	
	private static Workbook book;
	private static Sheet sheet;
	private static String TEST_DATA_SHEET_PATH = ".\\src\\main\\java\\web\\form\\testdata\\WebFormFiller.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		
		Object [][] data = null;
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
						
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			System.out.println("Row Count is: "+rowCount);
			System.out.println("Column Count is: "+colCount);
			
			for(int i=0; i<rowCount; i++) {
				for(int j=0;j<colCount; j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	
	
	
}
