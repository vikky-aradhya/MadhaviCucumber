package genericFunction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Property {

	Properties properties;

	public Property(String mapFile) {

		try {

			FileInputStream in = new FileInputStream(mapFile);
			properties = new Properties();
			properties.load(in);
			in.close();
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public By getLocator(String logicalElementName) throws Exception {

		String locator = properties.getProperty(logicalElementName);

		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];

		if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if (locatorType.toLowerCase().equals("classname"))
			return By.className(locatorValue);
		else if (locatorType.toLowerCase().equals("linktext"))
			return By.linkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if (locatorType.toLowerCase().equals("css"))
			return By.cssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("tagname"))
			return By.tagName(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);

		else
			throw new Exception("Locator type '" + locatorType + "'not defined");

	}

}
