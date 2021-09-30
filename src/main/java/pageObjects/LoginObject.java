package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObject {
	public WebDriver driver = null;
	By login = By.xpath("//*[@id=\'header\']/div[1]/div/section[3]/ul/li[2]/span/ul/li[1]/a");
	By email = By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/input");
	By password = By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/div/div/input");
	By submit = By.xpath("//*[@id=\"ul_site_login\"]");
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	By icon = By.cssSelector("#header > div.header__topBar > div > section.header__topBar_sectionRight > ul > li.header__topBarIconList_profile-icon > span > svg > path");
	public LoginObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public WebElement getIcon() {
		return driver.findElement(icon);
	}
	public WebElement getLoginButton() {
		return driver.findElement(login);
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
