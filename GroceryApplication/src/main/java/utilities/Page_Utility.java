package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page_Utility {//pageutility is a page helper class
	public void selectDragDropWithValue(WebElement element, String value) {

		Select object=new Select(element);

		object.selectByValue(value);

		}
	public void selectDragDropWithIndex(WebElement element, int value) {

		Select object=new Select(element);

		object.selectByIndex(value);

		}
	public void selectDragDropWithVisibileText(WebElement element, String value) {

		Select object=new Select(element);

		object.selectByVisibleText(value);

		}
	//click
	public void clickUsingJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) element;
        js.executeScript("arguments[0].click();", element);
    }
	//scroll
	public void scrollUsingJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) element;
        js.executeScript("window.scrollBy(0,350)","");
        
	}
	//Right Click
	 public void verifyRightclick(WebElement element, WebDriver driver) {
	        Actions a = new Actions(driver);
	        a.contextClick(element).build().perform();
	    }
	 //HouseHover
	 public void verifyHousehover(WebDriver driver, WebElement element) {
	        Actions a = new Actions(driver);
	        a.moveToElement(element).build().perform();
	    }

	    // Double click
	    public void verifydoubleclick(WebDriver driver, WebElement element) {
	        Actions a = new Actions(driver);
	        a.doubleClick(element).build().perform();
	    }

	    // Drag and drop
	    public void verifyDraganddrop(WebDriver driver, WebElement dragdr, WebElement dropbox) {
	       
	        Actions act = new Actions(driver);
	        act.dragAndDrop(dragdr, dropbox).build().perform();
	    }

	   

	
	

}
