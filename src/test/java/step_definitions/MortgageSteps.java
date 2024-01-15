package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;
import utilities.ReadConfigFiles;


public class MortgageSteps {
    private static final Logger LOGGER=LogManager.getLogger(LoginSteps.class);
    WebDriver driver=Hooks.driver;

    @Given("^user is in mortgage calculator home page$")
    public void user_is_in_mortgage_calculator_home_page() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageAppUrl"));
        LOGGER.info("Landed on the Mortgage Calculator Home Page");
    }

    @And("^user navigate to Real Apr page$")
    public void user_navigate_to_real_apr_page() {
        new Home(driver)
                .mouseHoverToRate()
                .navigateToRealApr();
        LOGGER.info("Navigated to Real APR Page ");
    }

    @When("^user clicks on calculate button upon entering the data of \"(.+?)\",\"(.+?)\",and \"(.+?)\"$")
    public void user_clicks_on_calculate_button_upon_entering_the_data_of_and(String homePrice, String downPayment, String interestRate) {
        new RealApr(driver)
                .typeHomePrice(homePrice)
                .clickDownPaymentInDollar()
                .typeDownPayment(downPayment)
                .typeInterestRate(interestRate)
                .clickOnCalculateRateButton();
        LOGGER.info("User clicks on Calculate button upon entering the data");
    }


        @Then("^the real apr rate is \"(.+?)\"$")
        public void theRealAprRateIs(String expectedAprRate) throws Exception {
            new RealApr(driver)
                    .validateRealAprRate(expectedAprRate);
            LOGGER.info("Real APR rate is validated");
        }

    }

