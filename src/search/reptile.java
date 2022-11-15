package search;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class reptile {
	
	public static String browserString = "D:\\360 浏览器\\360se6\\Application\\360se.exe";
	public WebDriver br;
	public String urlString;
	public EventFiringWebDriver e_driver;
	public Actions action;
	public Robot r;
	
	reptile(String urlString) {
		System.setProperty("webdriver.chrome.driver",".\\.\\resource\\file\\chromedriver.exe");
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
		e_driver = new EventFiringWebDriver(driver);
		WebEventListener eventListener = new WebEventListener();
        e_driver.register(eventListener);
		e_driver.get(urlString);
        action = new Actions(driver);
        r = new Robot();
        Thread.sleep(10000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        String jsOpenNewWindow = "window.open('"+"http://www.baidu.com"+"');";
        jsExecutor.executeScript(jsOpenNewWindow);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs.size());
        e_driver.switchTo().window(tabs.get(0));
        System.out.println("有标签页："+tabs.size()+"被检测到！");
	  }
	 
	 public void get_combox(WebDriver driver) throws InterruptedException {
	   ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
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
        
//      List<WebElement> frame = driver.findElements(By.tagName("iframe"));
//      for ()
//      for (int i=0;i< frame.size();i++) {
//      	System.out.println(frame.get(i).getAttribute("outerHTML"));
//      }
//      driver.switchTo().f
//      找到第一个ifram
//        for (int i=0;i<trlist.size();i++) {
//        	 List <WebElement>tdList= trlist.get(i).findElements(By.tagName("td"));
//        	 for 
//        }
       
//        frame = driver.findElements(By.tagName("iframe"));
//        for (int i=0;i< frame.size();i++) {
//        	System.out.println(frame.get(i).getAttribute("outerHTML"));
//        }
//        WebElement a = driver.findElement(By.tagName("form"));
//        System.out.println(a.getAttribute("outerHTML"));
//      WebElement c = driver.findElement(By.xpath(".."));
//    System.out.println(b.getAttribute("outerHTML"));
        
        
//      ------------------------------------------------------------------------  
//          WebElement b = driver.findElement(By.id("czxm"));
//
//         WebElement c = b.findElement(By.xpath("./..")); 
//         System.out.println(c.getAttribute("outerHTML"));
//        Actions action = new Actions(driver);
////        System.out.println(c.getAttribute("outerHTML"));
//        List<WebElement> children =c.findElements(By.xpath("./*"));//所有根节
////        
//        Robot r = new Robot();
//        WebElement d = children.get(2);
//        System.out.println(d.getAttribute("outerHTML"));
//        action.contextClick(children.get(1)).perform();
//////        action.contextClick(d).perform();
//        r.keyPress(KeyEvent.VK_ESCAPE);
//        Thread.sleep(1000);
//        System.out.println("睡眠结束");
//        d.sendKeys("1234");
        
//        -----------------------------------------------------------------------------
        
        
////        b.click();
//        List<WebElement> FF =d.findElements(By.xpath("./*"));
//        System.out.println("------------------------");
//        System.out.println(FF.get(1).getAttribute("outerHTML"));
////        action.contextClick(FF.get(1)).perform();
//        Thread.sleep(1000);
//        System.out.println("睡眠结束");
//        System.out.println(FF.get(0).getAttribute("outerHTML"));
//        action.contextClick(FF.get(0)).perform();
//        r.keyPress(KeyEvent.VK_ESCAPE);
//        FF.get(0).sendKeys("这是测试输入");
        
//        driver.switchTo().frame(frame);
//        frame = driver.findElement(By.id("addWaitWinIframe"));
//        driver.switchTo().frame(frame);
//        System.out.println(frame);
//        WebElement id1 = driver.findElement(By.id("_easyui_textbox_input89"));
//        System.out.println(id1.getAttribute("outerHTML"));
	  }
	
	 

	 public boolean sendKeyToInputUI(WebDriver driver,String id, String input) {
		 
		 driver.findElement(By.id(id)).sendKeys(input);  
		 return false;
	 }
	 
	 public void export_ecologie_data() throws Exception
	 {
		 System.out.print("我正在导出数据内容");
	 }
	 
	 public static void main(String[] args) throws Exception 
    { 
		 // 对浏览器驱动
//		 reptile reptile =new reptile("http://www.baidu.com");
		 String result = JOptionPane.showInputDialog("检测到新车牌号，请确认你要输入的综检车牌号：");
		 System.out.println(result);
//		 String a = "2018/02/26 00:00:00";
//		 String b[] = a.split(" ");
//		 String c[] = b[0].split("/");
//		 System.out.println(c[0]+ " 年 "+c[1]+ " 月 "+c[2]+ " 日 ");
    } 
}
	 

