package search;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.glass.events.KeyEvent;

import search.WebEventListener;

public class reptile_test {
	
	public static String browserString = "D:\\360 浏览器\\360se6\\Application\\360se.exe";
	private ChromeOptions option ;
	public WebDriver br;
	public String urlString;
	public EventFiringWebDriver e_driver;
	public Actions action;
	public Robot r;
	
	reptile_test(String urlString) {
		this.urlString = urlString;
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		option.setBinary(browserString);
		br =  new ChromeDriver(option);
		try {
			startBrowser(br); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 public void startBrowser(WebDriver driver) throws Exception
    {
		int waitTime = 20;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		e_driver = new EventFiringWebDriver(driver);
		WebEventListener eventListener = new WebEventListener();
        e_driver.register(eventListener);
		e_driver.get(urlString);
//		Dimension dimension = new Dimension(800, 600);
//		e_driver.manage().window().setSize(dimension);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs.size());
        e_driver.switchTo().window(tabs.get(0));
//        Thread.sleep(5000);
        System.out.println("有标签页："+tabs.size()+"被检测到！");
        action = new Actions(driver);
        r = new Robot();
//	    driver.quit();
	  }
	 
	 public void get_combox(WebDriver driver) throws InterruptedException {
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//       System.out.println(tabs.get(0).);
       System.out.println(tabs.size());
       System.out.println("有标签页："+tabs.size()+"被检测到！");

       driver.switchTo().frame("addWaitWinIframe");
       Thread.sleep(1000);
       driver.switchTo().frame("addWaitWinIframe");
       Thread.sleep(1000);
       WebElement table = driver.findElement(By.id("carInfoTable"));
       List <WebElement> trlist = table.findElements(By.tagName("tr"));
       List <WebElement>tdList= trlist.get(0).findElements(By.tagName("td"));
       WebElement input = tdList.get(7).findElement(By.id("_easyui_textbox_input67"));
       action.click(input).perform();
       System.out.println(input.getAttribute("outerHTML"));
       Thread.sleep(1000);
       WebElement select = driver.findElement(By.id("cpys"));
       System.out.println(select.getAttribute("outerHTML"));
//       action.click(select).perform();
       Thread.sleep(2000);
       new WebDriverWait(driver, 15).until(
               ExpectedConditions.elementToBeClickable(select));
       select.click();
//       driver.findElement(By.linkText("黑")).click();
       Select dropList = new Select(select);
       dropList.selectByValue("黑");

//       System.out.println(dropList.getFirstSelectedOption().getText());
//       dropList.selectByValue("黑");
//       System.out.println(dropList.getFirstSelectedOption().getText());
//       WebDriverWait(driver,10).until();
	 }
	 
	 
	 public void get(WebDriver driver) throws Exception
	 {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        System.out.println(tabs.get(0).);
        System.out.println(tabs.size());
        System.out.println("有标签页："+tabs.size()+"被检测到！");

        driver.switchTo().frame("addWaitWinIframe");
        Thread.sleep(1000);
        driver.switchTo().frame("addWaitWinIframe");
        Thread.sleep(1000);
        WebElement table = driver.findElement(By.id("carInfoTable"));
        List <WebElement> trlist = table.findElements(By.tagName("tr"));
        List <WebElement>tdList= trlist.get(1).findElements(By.tagName("td"));
        WebElement input = tdList.get(1).findElement(By.id("_easyui_textbox_input68"));
        System.out.println(input.getText());
        System.out.println(input.getTagName());
        System.out.println(input.getAttribute("outerHTML"));
        action.contextClick(input).perform();
        Thread.sleep(1000);
        System.out.println(input.getAttribute("outerHTML"));
        r.keyPress(KeyEvent.VK_ESCAPE);
        Thread.sleep(1000);
        input.click();
        input.sendKeys("123445");
       
	  }
	
//	 车身颜色 测试
	 public void get_1_JS (WebDriver driver) throws AWTException, InterruptedException {
		 
//		 通过JS 改变readonly 参数来改变 值
//		 WebElement we = driver.findElement(By.id("_easyui_textbox_input67"));  
//		 JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
//		 removeAttribute.executeScript("var setDate=document.getElementById(\"_easyui_textbox_input67\").removeAttribute('readonly');");
//		 we.clear();
//		 we.sendKeys("黑");
		 
//		 通过直接找到input 来直接改变值
//		 WebElement we = driver.findElement(By.xpath("//*[@id=\"carInfoTable\"]/tbody/tr[1]/td[8]/span/input[2]"));  
//		 we.sendKeys("黑");
		 
//		 通过模仿人的操作来选择， 通过直接点击DIV来进行操作 
//		 input 输入
		 driver.switchTo().frame("addWaitWinIframe");
		 Thread.sleep(1000);
		 driver.switchTo().frame("addWaitWinIframe");
		 Thread.sleep(1000);
		 r = new Robot();
		 action = new Actions(driver);
		 WebElement syxz= driver.findElement(By.id("_easyui_textbox_input67"));
		 action.click(syxz).perform();
//		 driver.findElement(By.xpath("//*[text()='退出']"));
//		 WebElement content = driver.findElement(By.linkText("黑"));
		 WebElement content = driver.findElement(By.xpath("//div[text()='黑']")); 
//		 action.moveToElement(content).perform();
		 content.click();
//		 action.click(content).perform();
		 
//		 日期输入
		 WebElement zcdjri= driver.findElement(By.id("_easyui_textbox_input63"));  
		 JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
		 removeAttribute.executeScript("var setDate=document.getElementById(\"_easyui_textbox_input63\").removeAttribute('readonly');");
		 zcdjri.sendKeys("1997-12-23");
//		  双击激活JS
		 action.click(zcdjri).perform();
		 action.click(zcdjri).perform();
//		 文本输入
		 WebElement clpp= driver.findElement(By.id("_easyui_textbox_input65"));  
		 clpp.click();
		 clpp.sendKeys("123445");
		 
		 
	 }
	 
	 public boolean sendKeyToInputUI(WebDriver driver,String id, String input) {
		 
		 
		 return false;
	 }
	 
	 public boolean sendKeyToInput(WebDriver driver) throws InterruptedException
	 {
         Thread.sleep(1000);
         WebElement a = driver.findElement(By.id("toStationText"));
         System.out.println("-------------------------");
         System.out.println(a.getAttribute("value"));
         JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
         //remove readonly attribute
//         removeAttribute.executeScript("var setDate=document.getElementById(\"date\").removeAttribute('readonly');");
//         //输入要输入日期
//         driver.findElement(By.id("date")).clear();
         a.sendKeys("上海");
//         driver.findElement(By.id("date")).sendKeys("2019-08-31");
         //点击查询
//         driver.findElement(By.id("searchBtn")).click();
         System.out.println("-------------------------");
//         a.sendKeys("2019-08-31");
         return true;
	 }
	public boolean sendKeyToComboxUI(WebDriver driver,String id, int index) {
		WebElement selector = driver.findElement(By.id(id));
//		System.out.println(selector.getAllSelectedOptions().toString());
		return false;
	}
//	 method.click(By.id("fwmmsrk1"));
//	 method.sendKeys(By.id("servicePassword"),"123456");
	 //通过爬虫导出数据
	 public void export_ecologie_data() throws Exception
	 {
		 System.out.print("我正在导出数据内容");
	 }
	 
	 public static void main(String[] args) throws Exception 
    { 
		 // 对浏览器驱动
		 reptile_test reptile =new reptile_test("http://172.32.250.11:8090/jc/yt/loginout/login.yt");
		 reptile.get_1_JS(reptile.e_driver);
    } 
}
	 

