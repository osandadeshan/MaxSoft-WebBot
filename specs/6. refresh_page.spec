# Refresh Page Specification

<pre>
Project Name    : MaxSoft-WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 12/05/2019
Time            : 11:23
Description     : This is an executable specification file
</pre>


Tags: refresh_page



* Login To The Application Using Username By Referring The Key "osandaEmail" and Password By Referring The Key "osandaPassword". Then Validate The Account Name By Referring The Key "osandaProfileName" In The Test Data Excel File.



## Refresh page until an element is visible

* Refresh Until Element Is Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Maximum Retries|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|---------------|
   |Profile name should be visible |no                                       |                  |                    |XPath                          |scenario                      |currentProfileNameLocator              |4              |



## Refresh page until an element is not visible

* Refresh Until Element Is Not Visible On The Page
   |Step Name                           |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Maximum Retries|
   |------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|---------------|
   |Email textbox should not be visible |yes                                      |LoginPage         |txt_email           |                               |                              |                                       |4              |



_____________________________

* Logout From The Application