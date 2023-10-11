package gmailComposeTestStepDef;

public class StepDef {
	
	WebDriver driver;

    @Given("the user is logged into Gmail")
    public void theUserIsLoggedIntoGmail() {
        
        driver = new ChromeDriver();
        driver.get("https://mail.google.com");
        // Implement login 
        WebElement emailInput = driver.findElement(By.id("identifierId"));
        emailInput.sendKeys("your_username@gmail.com");
        driver.findElement(By.id("identifierNext")).click();

        // Wait for the password input field to load
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("your_password");
        driver.findElement(By.id("passwordNext")).click();
    }
    
    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        driver.findElement(By.xpath("//div[text()='" + buttonName + "']")).click();
    }

    @And("fills in the recipient email address")
    public void fillsInRecipientEmailAddress() {
        WebElement toInput = driver.findElement(By.name("to"));
        toInput.sendKeys("recipient_email@example.com");
    }

    @And("sets the subject to {string}")
    public void setsTheSubjectTo(String subject) {
        WebElement subjectInput = driver.findElement(By.name("subjectbox"));
        subjectInput.sendKeys(subject);
    }

    @And("sets the email body to {string}")
    public void setsTheEmailBodyTo(String body) {
        WebElement bodyInput = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        bodyInput.sendKeys(body);
    }

    @And("clicks on the {string} button")
    public void clicksOnTheButton(String buttonName) {
        driver.findElement(By.xpath("//div[text()='" + buttonName + "']")).click();
    }

    @Then("the email should be sent successfully")
    public void theEmailShouldBeSentSuccessfully() {
        // You can add verification logic here to ensure the email is sent successfully
        // For example, you can check for a confirmation message
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Message sent.']"));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }

    @And("a confirmation message should be displayed")
    public void aConfirmationMessageShouldBeDisplayed() {
        // You can add verification logic here to check for a confirmation message
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Message sent.']"));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        // You can add verification logic here to check for an error message
        WebElement errorMessage = driver.findElement(By.xpath("//div[text()='Error: Recipient address is required.']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @And("the email should not be sent")
    public void theEmailShouldNotBeSent() {
        // You can add verification logic here to check that the email was not sent
        // For example, you can verify that the email is not in the "Sent" folder
        WebElement sentFolder = driver.findElement(By.xpath("//a[text()='Sent']"));
        Assert.assertFalse(sentFolder.isDisplayed());
    }
	

}
