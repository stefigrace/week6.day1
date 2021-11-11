package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {	

	
	@When("Click on {string} link")
	public void click_link(String text) {
		driver.findElement(By.linkText(text)).click();
	}

	@Given("Enter Company Name as {string}")
	public void enter_company_name_as(String compName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
	}

	@Given("Enter First Name as {string}")
	public void enter_first_name_as(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}

	@Given("Enter Last Name as {string}")
	public void enter_last_name_as(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}

	@Given("Enter Phone Number as {string}")
	public void enter_phone_number_as(String phoneNo) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNo);
	}

	@When("Click Submit Button")
	public void click_submit_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Title page should contains with {string}")
	public void title_page_shoul_contains_with(String expectedTitle) {
		String actTitle = driver.getTitle();
		if (actTitle.contains(expectedTitle)) {
			System.out.println("Title Matching");
			Assert.assertTrue(true);
		} else {
			System.out.println("Title Not Matching");
			Assert.assertTrue(false);
		}
	}

	
}