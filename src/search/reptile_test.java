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
import java.io.File;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.glass.events.KeyEvent;

import search.WebEventListener;
import search.outil.OpSqliteDB;

public class reptile_test {
	
//	public static String browserString = "D:\\360 浏览器\\360se6\\Application\\360se.exe";
	public static String browserString;
	private ChromeOptions option ;
	public WebDriver br;
	public String urlString;
	public EventFiringWebDriver e_driver;
	public Actions action;
	public Robot r;
	
	reptile_test(String urlString) {
		final File file = new File ("resource/file/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		this.urlString = urlString;
		System.out.println(this.urlString);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		
		browserString = commonUtil.browserString;
		System.out.println(commonUtil.browserString);
		option.setBinary(browserString);
		br =  new ChromeDriver(option);
		try {
			startBrowser(br); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String C2EDate (String CDate) {
		String n = "";
		String y = "";
		String r = "";
		int flag = 0;
		for (int i=0;i<CDate.length();i++) {
			if (CDate.substring(i, i+1).equals("年")) {
				n = CDate.substring(0,i);
				flag = i+1;
			}
			if (CDate.substring(i, i+1).equals("月")) {
				y = CDate.substring(flag,i);
				flag = i+1;
			}
			if (CDate.substring(i, i+1).equals("日")) {
				r = CDate.substring(flag,i);
				return n+"-"+y+"-"+r;
			}
		}
		return n+"-"+y+"-"+r;
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
	
//	 通过名字 填写选项框
	 public void fillComboxBox (WebDriver driver,String targetID, String targeChoice) {
		 WebElement targetCombox= driver.findElement(By.id(targetID));
		 action.click(targetCombox).perform();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement content = driver.findElement(By.xpath("//div[text()='"+targeChoice+"']")); 
		 String StrJs = "var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true,false);arguments[0].dispatchEvent(evObj);arguments[0].click();";
		 System.out.println(StrJs);
		 js.executeScript(StrJs,content);
		 content = driver.findElement(By.xpath("//div[text()='"+targeChoice+"']")); 
		 System.out.println(content.getAttribute("outerHTML"));
		 StrJs = "var evObj = document.createEvent('HTMLEvents');evObj.initEvent('select',true,false);arguments[0].dispatchEvent(evObj);";
		 System.out.println(StrJs);
		 js.executeScript(StrJs,content);
	 }
//	 通过名字和排序 填写 选项框
	 public void fillComboxBoxSelectedWithSameValue (WebDriver driver,String targetID, String targeChoice, int order) {
		 WebElement targetCombox= driver.findElement(By.id(targetID));
		 action.click(targetCombox).perform();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 List<WebElement> contents = driver.findElements(By.xpath("//div[text()='"+targeChoice+"']")); 
		 WebElement content = contents.get(order);
		 String StrJs = "var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true,false);arguments[0].dispatchEvent(evObj);arguments[0].click();";
		 System.out.println(StrJs);
		 js.executeScript(StrJs,content);
		 contents = driver.findElements(By.xpath("//div[text()='"+targeChoice+"']"));
		 System.out.println(contents.size());
		 content = contents.get(order);
		 System.out.println(content.getAttribute("outerHTML"));
		 StrJs = "var evObj = document.createEvent('HTMLEvents');evObj.initEvent('select',true,false);arguments[0].dispatchEvent(evObj);";
		 System.out.println(StrJs);
		 js.executeScript(StrJs,content);
	 }
//	 填写 日期
	 public void fillDate (WebDriver driver,String targetID, String Date) {
		 WebElement zcdjri= driver.findElement(By.id(targetID));  
		 JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
		 removeAttribute.executeScript("var setDate=document.getElementById(\""+targetID+"\").removeAttribute('readonly');");
		 zcdjri.sendKeys(Date);
//		  双击激活JS
		 action.click(zcdjri).perform();
		 action.click(zcdjri).perform();
		 
	 }
	 public void fillTestProvince (WebDriver driver,String targetID, String StringContent) {
		 WebElement clpp= driver.findElement(By.id(targetID));  
		 clpp.click();
		 clpp.clear();
		 clpp.sendKeys(StringContent);
		 WebDriverWait w=new WebDriverWait(driver,60);
		 w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()='"+StringContent+"']")));
		 clpp.click();
	 }
//	 填写 文本框
	 public void fillTextInput (WebDriver driver,String targetID, String StringContent) {
		 WebElement clpp= driver.findElement(By.id(targetID));  
		 clpp.click();
		 clpp.clear();
		 clpp.click();
		 clpp.sendKeys(StringContent);
	 }
	 
//	 public void SanDo (reptile_test reptile) {
//
//		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input5", "注册登记检验");
//		 reptile.fillTestProvince(reptile.br, "_easyui_textbox_input6", "鲁");
//		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input2", "DR3344");
//		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input7", "小型汽车");
//		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input3", "131186");
//		 reptile.br.findElement(By.id("clearBtn")).click();
//	 }
	 
	 public void ifAutoComplete (reptile_test reptile) throws InterruptedException {

		 reptile.br.switchTo().frame("addWaitWinIframe");
		 reptile.br.switchTo().frame("addWaitWinIframe");
		 Thread.sleep(2000);
//		 WebElement selector = reptile.br.findElement(By.cssSelector("body > div.panel.window.panel-htop.messager-window > div.dialog-button.messager-button > a"));
//		 selector.click();
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input89", (String)commonUtil.resultMap.get("${vin}"));
		 
		 reptile.fillComboxBoxSelectedWithSameValue(reptile.br, "_easyui_textbox_input67", "蓝",0);
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input68", (String)commonUtil.resultMap.get("${owner}"));
//		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input64", "客车");
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input87", (String)commonUtil.resultMap.get("${SYXZ}"));
		 
		 
		 String rq  = (String)commonUtil.resultMap.get("${CCDJRQ}");rq = C2EDate(rq);
		 reptile.fillDate(reptile.br, "_easyui_textbox_input63", rq);
		 rq  = (String)commonUtil.resultMap.get("${CLCCRQ}");rq = C2EDate(rq);
		 reptile.fillDate(reptile.br, "_easyui_textbox_input62", rq);
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input65",(String)commonUtil.resultMap.get("${brand}") );
		 if (((String)commonUtil.resultMap.get("${GCJK}")).equals("A")) {
			 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input28", "国产" );		
		 }
		 else if (((String)commonUtil.resultMap.get("${GCJK}")).equals("B")) {
			 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input28", "进口" );		
		 }	 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input91", (String)commonUtil.resultMap.get("${crosght}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input90", (String)commonUtil.resultMap.get("${ZBZL}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input75", (String)commonUtil.resultMap.get("${hdzzl}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input74", (String)commonUtil.resultMap.get("${ZKRS}"));
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input66", (String)commonUtil.resultMap.get("${XH}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input73", (String)commonUtil.resultMap.get("${engineModel}"));
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input85", (String)commonUtil.resultMap.get("${fuelType}"));
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input30", "无");
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input8", (String)commonUtil.resultMap.get("${FDJH}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input92", (String)commonUtil.resultMap.get("${factoryName}"));
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input61", (String)commonUtil.resultMap.get("${transimissionType}"));
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input84", "前驱");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input34",  (String)commonUtil.resultMap.get("${fuelSupplyMethod}"));
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input77", (String)commonUtil.resultMap.get("${airSupethod}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input79", "4");
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input71", (String)commonUtil.resultMap.get("${power}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input72", (String)commonUtil.resultMap.get("${ratepeed}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input82", (String)commonUtil.resultMap.get("${PL}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input78", "0");
		 
//		 三元催化
		 reptile.fillComboxBoxSelectedWithSameValue(reptile.br, "_easyui_textbox_input83", "三元催化",0);
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input10", "0");
		 reptile.fillComboxBoxSelectedWithSameValue(reptile.br, "_easyui_textbox_input37", "三元催化",1);
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input11", "0");
		 
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input38", "否");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input59", "否");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input70", "-");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input13", "-");
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input88", "长治市");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input81", (String)commonUtil.resultMap.get("${address}"));
		 String zbzl = (String)commonUtil.resultMap.get("${ZBZL}");
		 String zs = (String)commonUtil.resultMap.get("${ZS}");
		 double zbzl_double = Double.parseDouble(zbzl);
		 double zs_double = Double.parseDouble(zs);
		 String dczs = String.valueOf(Math.round(zbzl_double/zs_double));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input53", dczs);
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input42", "身份证");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input15", (String)commonUtil.resultMap.get("${sfzmhm}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input80", (String)commonUtil.resultMap.get("${tel}"));
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input69", (String)commonUtil.resultMap.get("${postcode}"));
		 
		 
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input19", "1");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input102", "-");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input103", "-");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input104", "-");
		 
		 
		 
		 
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input23", (String)commonUtil.resultMap.get("${factoryName}"));
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input43", "有");
		 String dang = "";
		 String gang = "";
		 if (((String)commonUtil.resultMap.get("${platType}")).equals("大型汽车")) {
			 dang = "10";
			 gang = "6";
		 }
		 else if (((String)commonUtil.resultMap.get("${platType}")).equals("小型汽车")) {
			 dang = "5";
			 gang = "4";
		 }
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input54", dang);
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input55", gang);
		 commonUtil.log.printInfo("自动打印成功请检查！");
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
		 Thread.sleep(30000);
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
		 WebDriverWait w=new WebDriverWait(driver,60);
		 w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()='黑']")));
//		 WebElement content = driver.findElement(By.xpath("//div[text()='黑']")); 
		 WebElement content = driver.findElement(By.id("_easyui_combobox_i22_4")); 
		
		 System.out.println(content.getAttribute("outerHTML"));
//		 action.moveToElement(content).perform();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
//		 js.executeScript(browserString, null)
//		 String StrJs = "var setChoice=document.evaluate(\"//div[text()='黑']\",document,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue;setChoice.click(); ";
		 
		 String StrJs = "var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true,false);arguments[0].dispatchEvent(evObj);arguments[0].click();";
		 js.executeScript(StrJs,content);
//		 action.moveToElement(content).perform();
//		 content = driver.findElement(By.xpath("//div[text()='黑']")); 
		 content = driver.findElement(By.id("_easyui_combobox_i22_4")); 
		 System.out.println(content.getAttribute("outerHTML"));
		 StrJs = "var evObj = document.createEvent('HTMLEvents');evObj.initEvent('select',true,false);arguments[0].dispatchEvent(evObj);";
		 js.executeScript(StrJs,content);
//		 content = driver.findElement(By.xpath("//div[text()='黑']")); 
//		 content.click();
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
		 clpp.clear();
		 clpp.sendKeys("123445");
		 clpp.click();
		 
		 
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
		 Thread.sleep(20000);
		 reptile.br.switchTo().frame("addWaitWinIframe");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input5", "注册登记检验");
		 reptile.fillTestProvince(reptile.br, "_easyui_textbox_input6", "鲁");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input2", "DR3344");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input7", "小型汽车");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input3", "131186");
		 reptile.br.findElement(By.id("clearBtn")).click();
		 Thread.sleep(5000);
//		 WebDriverWait w=new WebDriverWait(reptile.br,60);
//		 w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("l-btn l-btn-small")));
		 reptile.br.switchTo().frame("addWaitWinIframe");
//		 WebElement selector = reptile.br.findElement(By.cssSelector("body > div.panel.window.panel-htop.messager-window > div.dialog-button.messager-button > a"));
//		 selector.click();
		 
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input89", "123456");
		 reptile.fillComboxBoxSelectedWithSameValue(reptile.br, "_easyui_textbox_input67", "黑",1);
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input68", "123456");
//		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input64", "客车");
		 
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input87", "非营运");
		 reptile.fillDate(reptile.br, "_easyui_textbox_input63", "2019-01-08");
		 reptile.fillDate(reptile.br, "_easyui_textbox_input62", "2019-01-08");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input65", "大车1");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input28", "国产");
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input91", "大车2");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input90", "大车3");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input75", "大车4");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input74", "大车5");
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input66", "大车6");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input73", "大车7");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input85", "汽油");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input30", "无");
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input8", "大车8");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input92", "大车9");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input61", "手动");
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input84", "前驱");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input34", "高压共轨");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input77", "涡轮增压");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input79", "9");
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input71", "93123123");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input72", "93123123");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input82", "93123123");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input78", "93123123");
		 
		 reptile.fillComboxBoxSelectedWithSameValue(reptile.br, "_easyui_textbox_input83", "三元催化",0);
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input10", "93123123");
		 reptile.fillComboxBoxSelectedWithSameValue(reptile.br, "_easyui_textbox_input37", "三元催化",1);
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input11", "93123123");
		 
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input38", "否");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input59", "否");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input70", "-");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input13", "-");
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input88", "长治市");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input81", "13456798");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input53", "20");
		 
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input42", "统一社会信用代码");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input15", "140481199712230413");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input80", "13456798");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input69", "047500");
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input19", "140481199712230413");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input102", "140481199712230413");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input103", "140481199712230413");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input104", "140481199712230413");
		 
		 
		 
		 
		 
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input23", "140481199712230413");
		 reptile.fillComboxBox(reptile.br, "_easyui_textbox_input43", "有");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input54", "140481199712230413");
		 reptile.fillTextInput(reptile.br, "_easyui_textbox_input55", "140481199712230413");
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
    } 
}
	 

