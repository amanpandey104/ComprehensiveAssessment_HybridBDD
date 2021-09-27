package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInGoogleObject {
	public WebDriver driver = null;
	By gConnect = By.id("google_login");
	By email = By.id("identifierId");
	By password = By.xpath("//input[@name='password']");
	By submit = By.xpath("//button[@type='button']");
	public SignInGoogleObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getGConnect() {
		return driver.findElement(gConnect);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getSubmitButton() {
		return driver.findElement(submit);
	}
	public Object excelData() throws IOException {
		String fileName = ".\\ExcelSheets\\LoginSignUp.xlsx";
		String sheetName = "Sheet1";
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		String[][] array = new String[rowCount+1][2];
		for (int i = 0; i < rowCount+1; i++) {
	        Row row = sheet.getRow(i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            array[i][j] = row.getCell(j).getStringCellValue();
	        }
	    }
		workbook.close();
		return array;
	}
}
