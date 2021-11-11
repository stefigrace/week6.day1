package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLead extends BaseClass{
	@Given("Click {string} link")
	public void click_link(String text) {
		driver.findElement(By.linkText(text)).click();
	}
	@Given("Click Phone Tab")
	public void click_phone_tab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@Given("Give Phone Number as {string}")
	public void give_phone_number_as(String phoneNo) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNo);
	}

	@Given("Click Find Lead Button")
	public void click_find_lead_button() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Given("Click The First LeadId")
	public void click_the_first_lead_id() throws InterruptedException {
		Thread.sleep(2000);
		//wait.until(ExpectedConditions
				//.visibilityOfElementLocated(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@Given("Update Company Name as {string}")
	public void update_company_name_as(String compName) {
		WebElement eleUpdateCompany = driver.findElement(By.id("updateLeadForm_companyName"));
		eleUpdateCompany.clear();
		eleUpdateCompany.sendKeys(compName);
	}

	@When("Click Update Button")
	public void click_update_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Company Name Should be {string}")
	public void company_name_should_be(String expecCompName) {
		String getCompName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String updatedCompName = getCompName.replaceAll("\\d", "");
		String actCompName = updatedCompName.substring(0, updatedCompName.length() - 3);
		if (actCompName.equalsIgnoreCase(expecCompName)) {
			System.out.println("Company Name Matching");
		} else {
			System.out.println("Company Name Not Matching");
		}
		Assert.assertEquals(actCompName, expecCompName);
	}


}
