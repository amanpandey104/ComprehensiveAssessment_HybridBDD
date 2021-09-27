package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignInFacebookObject {
	public WebDriver driver = null;
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	By icon = By.xpath("//span[@class='header-icon-link user-profile-icon']");
	By signin = By.xpath("//a[@class='signup-link authentication_popup']");
	By fbConnect = By.id("facebook_login");
	By email = By.id("email");
	By password = By.id("pass");
	By submit = By.id("loginbutton");
	public SignInFacebookObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public Actions getIcon() {
		WebElement iconNav = driver.findElement(icon);
		Actions s = new Actions(driver);
		return s.moveToElement(iconNav);
	}
	public WebElement getFbConnect() {
		return driver.findElement(fbConnect);
	}
	public WebElement getSigninButton() {
		return driver.findElement(signin);
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
