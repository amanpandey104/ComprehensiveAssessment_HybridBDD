package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrackOrderObject {
	public WebDriver driver = null;
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	By track = By.xpath("//a[@href='/orders']");
	By orderNumber = By.xpath("//input[@placeholder='Order Number']");
	By phoneNumber = By.xpath("//input[@placeholder='Phone Number']");
	By submitButton = By.xpath("//button[@type='submit']");
	
	public TrackOrderObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public WebElement getTrack() {
		return driver.findElement(track);
	}
	public WebElement getOrderNumber() {
		return driver.findElement(orderNumber);
	}
	public WebElement getPhoneNumber() {
		return driver.findElement(phoneNumber);
	}
	public WebElement getSubmitButton() {
		return driver.findElement(submitButton);
	}
	public Object excelData() throws IOException {
		String fileName = ".\\ExcelSheets\\TrackOrder.xlsx";
		String sheetName = "Sheet1";
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		String[][] array = new String[rowCount+1][2];
		for (int i = 0; i < rowCount+1; i++) {
	        Row row = sheet.getRow(i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            array[i][j] = String.valueOf(row.getCell(j).getNumericCellValue());
	        }
	    }
		workbook.close();
		return array;
	}
}
