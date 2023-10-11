#Positive Scenario:

Scenario: Compose and Send Email Successfully
  Given the user is logged into Gmail
  When the user clicks on the "Compose" button
  And fills in the recipient email address
  And sets the subject to "Incubyte"
  And sets the email body to "Automation QA test for Incubyte"
  And clicks on the "Send" button
  Then the email should be sent successfully
  And a confirmation message should be displayed
  
#Negative Scenario:

Scenario: Send Email Without Recipient Address
  Given the user is logged into Gmail
  When the user clicks on the "Compose" button
  And leaves the recipient field empty
  And sets the subject to "Incubyte"
  And sets the email body to "Automation QA test for Incubyte"
  And clicks on the "Send" button
  Then an error message should be displayed
  And the email should not be sent

Scenario: Send Email Without Subject
  Given the user is logged into Gmail
  When the user clicks on the "Compose" button
  And fills in the recipient email address
  And leaves the subject field empty
  And sets the email body to "Automation QA test for Incubyte"
  And clicks on the "Send" button
  Then an error message should be displayed
  And the email should not be sent
  
  