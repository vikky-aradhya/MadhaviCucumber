package stepDefinitions;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;

public class DatePicker extends BasePage {

	@And("^user picks date and time$")
	public void dateTimePicker() throws Throwable {

		String dateTime = testdataMap.get("datetime");
		
		//accept cookies
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Accept Cookies')]")).click();

		// button to open calendar
		Thread.sleep(2000);
		WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
		selectDate.click();

		// button to move next in calendar
		WebElement nextLink = driver.findElement(By.xpath("//a[@aria-label='Next']"));

		// button to click in center of calendar header
		WebElement midLink = driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']"));

		// button to move previous month in calendar
		WebElement previousLink = driver.findElement(By.xpath("//a[@aria-label='Previous']"));

		// Split the date time to get only the date part
		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

		// get the year difference between current year and year to set in calander
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		midLink.click();

		if (yearDiff != 0) {
			// if you have to move next year
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					// System.out.println("Year Diff->" + i);
					nextLink.click();
				}
			}

			// if you have to move previous year
			else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					// System.out.println("Year Diff->" + i);
					previousLink.click();
				}
			}
		}

		Thread.sleep(1000);

		// Get all months from calendar to select correct one
		List<WebElement> list_AllMonthToBook = driver
				.findElements(By.xpath("//div[@class='k-calendar-view']/table/tbody/tr/td"));

		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();

		Thread.sleep(1000);

		// get all dates from calendar to select correct one
		List<WebElement> list_AllDateToBook = driver.findElements(
				By.xpath("//div[@class='k-calendar-view']/table/tbody/tr//td[not(contains(@class,'k-other-month'))]"));

		list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();

		/// FOR TIME
		WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));

		// click time picker button
		selectTime.click();

		// get list of times
		List<WebElement> allTime = driver.findElements(By.xpath("//ul[@id='datetimepicker_timeview']/li"));
		dateTime = dateTime.split(" ")[1] + " " + dateTime.split(" ")[2];

		// select correct time
		for (WebElement webElement : allTime) {
			if (webElement.getText().equalsIgnoreCase(dateTime)) {
				webElement.click();
				Thread.sleep(5000);
			}
		}

	}
}
