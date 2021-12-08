import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationDriver {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qaclickacademy.com/practice.php ");
		exerciseOne(driver);
		exerciseTwo(driver);
		exerciseThree(driver);
		exerciseFour(driver);
		exerciseFourPointOne(driver);
		exerciseFourPointTwo(driver);
		exerciseFive(driver);
		exerciseSix(driver);
		exerciseSeven(driver);
		exerciseEight(driver);
		exerciseNine(driver);
	}

	public static void exerciseOne(WebDriver driver) {
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		driver.findElement(By.xpath("//input[@value='radio3']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());
	}

	public static void exerciseTwo(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("United States");
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//ul/li[@class='ui-menu-item']"));
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase("United States Minor Outlying Islands")) {
				element.click();
				break;
			}
		}
		if(driver.findElement(By.id("autocomplete")).getAttribute("value").equalsIgnoreCase("United States Minor Outlying Islands")) {
			System.out.println("valid selection");
		}
	}

	public static void exerciseThree(WebDriver driver) {
		WebElement element = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(element);
		dropdown.selectByIndex(1);
		String opt1 = dropdown.getFirstSelectedOption().getText();
		if (opt1.equals("Option1")) {
			System.out.println("verified");
		}
		dropdown.selectByIndex(2);
		String opt2 = dropdown.getFirstSelectedOption().getText();
		if (opt2.equals("Option2")) {
			System.out.println("verified");
		}
		dropdown.selectByIndex(3);
		String opt3 = dropdown.getFirstSelectedOption().getText();
		if (opt3.equals("Option3")) {
			System.out.println("verified");
		}
	}

	public static void exerciseFour(WebDriver driver) {
		driver.findElement(By.id("checkBoxOption1")).click();
		boolean checkbox1 = driver.findElement(By.id("checkBoxOption1")).isSelected();
		if (checkbox1 == true) {
			System.out.println("checkbox 1 is checked");
		}

		driver.findElement(By.id("checkBoxOption1")).click();
		boolean un_check1 = driver.findElement(By.id("checkBoxOption1")).isSelected();
		if (un_check1 == false) {
			System.out.println("checkbox 1 unchecked");
		}
		driver.findElement(By.id("checkBoxOption2")).click();
		boolean checkbox2 = driver.findElement(By.id("checkBoxOption2")).isSelected();
		if (checkbox2 == true) {
			System.out.println("checkbox 2 is checked");
		}
		driver.findElement(By.id("checkBoxOption2")).click();
		boolean un_check2 = driver.findElement(By.id("checkBoxOption2")).isSelected();
		if (un_check2 == false) {
			System.out.println("checkbox 2 unchecked");
		}
		driver.findElement(By.id("checkBoxOption3")).click();
		boolean checkbox3 = driver.findElement(By.id("checkBoxOption3")).isSelected();
		if (checkbox3 == true) {
			System.out.println("checkbox 3 is checked");
		}
		driver.findElement(By.id("checkBoxOption3")).click();
		boolean un_check3 = driver.findElement(By.id("checkBoxOption3")).isSelected();
		if (un_check3 == false) {
			System.out.println("checkbox 3 unchecked");
		}
	}

	public static void exerciseFourPointOne(WebDriver driver) {
		List<WebElement> opt = driver.findElements(By.cssSelector("input[type='checkbox']"));
		for (int i = 0; i < opt.size(); i++) {
			opt.get(i).click();
		}
		for (int i = 0; i < opt.size(); i++) {
			boolean ee = opt.get(i).isSelected();
			if (ee == true) {
				System.out.println("checkbox " + (i + 1) + " is selected");
			}
		}
		for (int i = 0; i < opt.size(); i++) {
			opt.get(i).click();
		}
	}

	public static void exerciseFourPointTwo(WebDriver driver) {
		List<WebElement> opt = driver.findElements(By.cssSelector("input[type='checkbox']"));
		for (int i = 0; i < opt.size(); i++) {
			opt.get(i).click();
		}
		for (int i = 0; i < opt.size(); i++) {
			boolean ee = opt.get(i).isSelected();
			if (ee == true) {
				System.out.println("checkbox " + (i + 1) + " is selected");
			}
		}
		for (int i = 0; i < opt.size(); i++) {
			opt.get(i).click();
		}
		for (int i = 0; i < opt.size(); i++) {
			boolean ee = opt.get(i).isSelected();
			if (ee == false) {
				System.out.println("checkbox " + (i + 1) + " is not selected");
			}
		}
	}

	public static void exerciseFive(WebDriver driver) {
		driver.findElement(By.id("openwindow")).click();
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String PID = it.next();
		String CID = it.next();
		driver.switchTo().window(CID);
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(
				"QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy")) {
			System.out.println("verified! welcome to new page");
		}
		driver.close();
		driver.switchTo().window(PID);
		String parenttitle = driver.getTitle();
		if (parenttitle.equalsIgnoreCase("Practice Page")) {
			System.out.println("Back to parent page");
		}
	}

	public static void exerciseSix(WebDriver driver) {
		driver.findElement(By.id("opentab")).click();
		Set<String> Handles = driver.getWindowHandles();
		Iterator<String> It = Handles.iterator();
		String PID = It.next();
		String CID = It.next();
		driver.switchTo().window(CID);
		String Child = driver.getTitle();
		if (Child.equalsIgnoreCase("Rahul Shetty Academy")) {
			System.out.println("Welcome to new tab");
		}
		driver.close();
		driver.switchTo().window(PID);
		String Parent = driver.getTitle();
		if (Parent.equalsIgnoreCase("Practice Page")) {
			System.out.println("Back to parent page");
		}
	}
	public static void exerciseSeven(WebDriver driver) {
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("sandeep");
		driver.findElement(By.id("alertbtn")).click();
		String text=driver.switchTo().alert().getText();
		if(text.contains("sandeep")) {
			System.out.println("Name is displayed!!!");
		}
		driver.switchTo().alert().accept();
	}
	public static void exerciseEight(WebDriver driver) {
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scroll(0,650)");
		WebElement table=driver.findElement(By.id("product"));
		List<WebElement> fRow=table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th"));
		System.out.println(fRow.get(0).getText());
		System.out.println(fRow.get(1).getText());
		System.out.println(fRow.get(2).getText());
		List<WebElement> sRow=table.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"));
		System.out.println(sRow.get(0).getText());
		System.out.println(sRow.get(1).getText());
		System.out.println(sRow.get(2).getText());
		List<WebElement> tRow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(tRow.get(0).getText());
		System.out.println(tRow.get(1).getText());
		System.out.println(tRow.get(2).getText());
		List<WebElement> foRow=table.findElements(By.tagName("tr")).get(3).findElements(By.tagName("td"));
		System.out.println(foRow.get(0).getText());
		System.out.println(foRow.get(1).getText());
		System.out.println(foRow.get(2).getText());
		List<WebElement> fiRow=table.findElements(By.tagName("tr")).get(4).findElements(By.tagName("td"));
		System.out.println(fiRow.get(0).getText());
		System.out.println(fiRow.get(1).getText());
		System.out.println(fiRow.get(2).getText());
		List<WebElement> siRow=table.findElements(By.tagName("tr")).get(5).findElements(By.tagName("td"));
		System.out.println(siRow.get(0).getText());
		System.out.println(siRow.get(1).getText());
		System.out.println(siRow.get(2).getText());
		List<WebElement> seRow=table.findElements(By.tagName("tr")).get(6).findElements(By.tagName("td"));
		System.out.println(seRow.get(0).getText());
		System.out.println(seRow.get(1).getText());
		System.out.println(seRow.get(2).getText());
		List<WebElement> eRow=table.findElements(By.tagName("tr")).get(9).findElements(By.tagName("td"));
		System.out.println(eRow.get(0).getText());
		System.out.println(eRow.get(1).getText());
		System.out.println(eRow.get(2).getText());
		List<WebElement> nRow=table.findElements(By.tagName("tr")).get(10).findElements(By.tagName("td"));
		System.out.println(nRow.get(0).getText());
		System.out.println(nRow.get(1).getText());
		System.out.println(nRow.get(2).getText());

	}
	public static void exerciseNine(WebDriver driver) {
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scroll(0,1100)");
		WebElement Hover=driver.findElement(By.id("mousehover"));
		Actions a=new Actions(driver);
		a.moveToElement(Hover).build().perform();
		WebElement item=driver.findElement(By.xpath("//a[contains(text(),'Top')]"));
		a.moveToElement(item).click().build().perform();	
	}
}
