package com.adactin.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static WebDriver driver;
	public static Select select;
	public static Actions a;
	public static Alert alert;
	public static WebElement element;
	public static String value;

	// Browser Methods********************************
	public static WebDriver browserlaunch() {
		
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		return driver;
	}

	public static void selectBrowser(String browsername) {
		if (browsername == "chrome") {
			
			driver = new ChromeDriver();
		} else if (browsername == "gecko") {
			
			driver = new FirefoxDriver();
		} 
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	// WebDriver Methods********************************

	public static void windowmaximize() {
		driver.manage().window().maximize();
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static void switchToLastOpenedWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList(windowHandles); // Set to List Conversion
		driver.switchTo().window(windowHandlesList.get(windowHandlesList.size() - 1));
	}

	public static void switchToWindowByIndex(int windowIndex) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList(windowHandles); // Set to List Conversion
		driver.switchTo().window(windowHandlesList.get(windowIndex));
	}

	// findElement and findElements********************************
	public static WebElement findElementByXpath(String xPath) {
		try {

			return driver.findElement(By.xpath(xPath));
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
		return element;
	}

	public static WebElement findElementById(String id) {
		try {
			return driver.findElement(By.id(id));
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
		return element;
	}

	public static WebElement findElementByName(String name) {
		try {

			return driver.findElement(By.name(name));
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
		return element;
	}

	public static WebElement findElementByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}

	public static WebElement findElementByClassName(String className) {
		return driver.findElement(By.className(className));
	}

	public static WebElement findElementByCssSelector(String cssValue) {
		return driver.findElement(By.cssSelector(cssValue));
	}

	public static WebElement findElementByLinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

	public static WebElement findElementByPartialLinkText(String partialLinkText) {
		return driver.findElement(By.partialLinkText(partialLinkText));
	}

	public static List<WebElement> findElementsByXpath(String xPath) {
		return driver.findElements(By.xpath(xPath));
	}

	public static List<WebElement> findElementsById(String id) {
		return driver.findElements(By.id(id));
	}

	public static List<WebElement> findElementsByName(String name) {
		return driver.findElements(By.name(name));
	}

	public static List<WebElement> findElementsByTagName(String tagName) {
		return driver.findElements(By.tagName(tagName));
	}

	public static List<WebElement> findElementsByClassName(String className) {
		return driver.findElements(By.className(className));
	}

	public static List<WebElement> findElementsByCssSelector(String cssValue) {
		return driver.findElements(By.cssSelector(cssValue));
	}

	public static List<WebElement> findElementsByLinkText(String linkText) {
		return driver.findElements(By.linkText(linkText));
	}

	public static List<WebElement> findElementsByPartialLinkText(String partialLinkText) {
		return driver.findElements(By.partialLinkText(partialLinkText));
	}

	// Wait Methods********************************
	public static void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void explicitWait(Duration secs) {
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	// WebElement Methods********************************
	public static void sendKeys(WebElement element, String sendData) {

		element.sendKeys(sendData);
	}

	public static void submit(WebElement element) {
		element.submit();
	}

	public static String getText(String text) {
		return text;
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String getCssValue(WebElement element, String propertyName) {
		return element.getCssValue(propertyName);
	}

	public static Point getLocation(WebElement element) {
		return element.getLocation();
	}

	public static Rectangle getRect(WebElement element) {
		return element.getRect();
	}

	public static Dimension getSize(WebElement element) {
		return element.getSize();
	}

	public static String getName(WebElement element) {
		return element.getTagName();
	}

	public static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public static boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public static boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	// Screenshot Method********************************
	public static void takeScreenshot(String fileLocation) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(fileLocation);
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			System.out.println("Caught IO Exception");
			e.printStackTrace();
		}

	}

	// Select Class Methods********************************
	public static Select dropdown(WebElement value) {
		Select select = new Select(value);
		return select;

	}

	

	public static void selectByvalue(WebElement element, String value) {
	    Select select = new Select(element);
	    select.selectByValue(value);
	}
	
	
	public static void selectByvisibletext(WebElement element, String value) {
		Select select = new Select(element);
	    select.selectByValue(value);
	}

	public static void selectByIndex(int index) {
		select.selectByIndex(index);
	}

	public static void getoptions() {
		select.getAllSelectedOptions();
	}

	public static void getAllSelectedOptionns() {
		select.getAllSelectedOptions();
	}

	public static void getFirstSelectedOption() {
		select.getFirstSelectedOption();
	}

	public static void isMultiple() {
		select.isMultiple();
	}

	public static void deSelectedByValue() {
		select.deselectByValue(null);
	}

	// Actions Class Methods********************************
	public static Actions mouseActions(WebDriver driver) {
		Actions a = new Actions(driver);
		return a;
	}

	public static void rightClick(WebElement element) {
		a.contextClick(element).build().perform();
	}

	public static void doubleClick(WebElement element) {
		a.doubleClick(element).build().perform();
	}

	public static void build() {
		a.build();
	}

	public static void dragAndDrop(WebElement element, WebElement element1) {
		a.dragAndDrop(element, element1);
	}

	public static void movetoElement(WebElement element) {
		a.moveToElement(element);
	}

	public static void keyboardEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	// Alert Methods ********************************
	public static Alert alert() {
		driver.switchTo().alert();
		return alert;
	}

	public static void acceptAlert() {
		alert.accept();
	}

	public static void dismissAlert() {
		alert.dismiss();
	}

	// Frame Methods********************************
	public static void frameHandleByindex(int index) {
		driver.switchTo().frame(index);
	}

	public static void frameHandleByvalue(String value) {
		driver.switchTo().frame(value);
	}

	public static void frameHandleByElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void defaultFrameHandling() {
		driver.switchTo().defaultContent();
	}

	/*
	 * public static void clearText() { clearText.clear();
	 * 
	 * }
	 */

	public static String getText1(String str) {

		return str;
	}

	public static void quitBrowswer() {
		driver.quit();
	}

	public static void closeBrowswer() {
		driver.close();
	}

	public static String getCurrentUrl() {
		String a = driver.getCurrentUrl();
		return a;

	}

	public static String getPageSource() {
		String ba = driver.getPageSource();
		return ba;

	}
	
	public static void checkindate(WebElement date,String value)
	{
		date.sendKeys("dd-MM-yyyy");
		//return date;
		
	}

	public static void clearText(WebElement element) {
		element.clear();
		
	}
	public static String readProp(String key)
	{
		String value="";
		try {
			FileReader read= new FileReader("C:\\Users\\haris\\eclipse-workspace\\AdactinHotelUsingExcel\\src\\test\\resources\\TestData_Adactin\\credentials.properties");
			Properties prop = new Properties();
			prop.load(read);			
			value=prop.getProperty(key);			
		} 	
		catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return value;
	}

	public static String excel_read_Resuse()
	{
		String value="";
		//file locate
		try {
			File f = new File("C:\\Users\\haris\\eclipse-workspace\\AdactinHotelUsingExcel\\src\\test\\resources\\TestData_Adactin\\Data_test\\Adactin_Excel_Testdata.xlsx");
		//file read
		FileInputStream fis = new FileInputStream(f);
		//workbook Access
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheet = wb.getSheet(value);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		int cellType = cell.getCellType();
		if(cellType==1) {
			value = cell.getStringCellValue();
			System.out.println(value);
			
		}
		else if(cellType==0){
			if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sm = new SimpleDateFormat("dd/mm/yy");
			value = sm.format(dateCellValue);
			System.out.println(value);
		}
		
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
			System.out.println(value);
		}
	}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	

	
	public static String getAttribute(WebElement orderNum_element) {

		return orderNum_element.getAttribute("value");

	}

	public static void navigateTo(String Url) {
		driver.navigate().to(Url);
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

}



