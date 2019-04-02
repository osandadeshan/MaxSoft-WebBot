# Login Specification

<pre>
Project Name    : MaxSoft-WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 29/03/2019
Time            : 15:45
Description     : This is an executable specification file
</pre>


    
## Valid user login to the application and profile name verification using test data excel file data

* Login To The Application Using Username and Password In Test Data Excel File "LoginData" "osandaEmail" "osandaPassword" "profileName"



## Valid user login to the application and profile name verification using test data excel file

* Click Element
   |Step Name              |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-----------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Click on Sign in link  |yes                                      |HomePage          |nav_bar_signin_link |                               |                              |                                       |

* Validate Element's Visibility On The Page
   |Step Name                               |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |----------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Email address textbox should be visible |yes                                      |LoginPage         |txt_email           |                               |                              |                                       |y          |
   |Password textbox should be visible      |yes                                      |LoginPage         |txt_password        |                               |                              |                                       |y          |
   |Submit button should be visible         |yes                                      |LoginPage         |btn_submit          |                               |                              |                                       |y          |

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text          |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|---------------------|
   |Set email as      |yes                                      |LoginPage         |txt_email           |                               |                              |                                       |no                                       |                       |                                |osanda@mailinator.com|
   |Set password as   |yes                                      |LoginPage         |txt_password        |                               |                              |                                       |no                                       |                       |                                |1qaz2wsx@            |

* Click Element
   |Step Name              |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-----------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Click on Submit button |yes                                      |LoginPage         |btn_submit          |                               |                              |                                       |

* Save Test Data From Excel To Data Stores
   |Sheet Name|Key Name   |Data Store Type|Data Store Variable Name|
   |----------|-----------|---------------|------------------------|
   |LoginData |profileName|scenario       |profileNameVal          |

* Replace Element Locator Placeholder And Save To Data Store
   |Step Name                |Sheet Name|Element Name      |Placeholder Text|Is Replacement Text Retrieve From Data Store |If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Replacement Text |Data Store Type To Save Final Locator|Data Store Variable Name To Save Final Locator|
   |-------------------------|----------|------------------|----------------|---------------------------------------------|-----------------------|--------------------------------|------------------------|-------------------------------------|----------------------------------------------|
   |Get profile name locator |HomePage  |lbl_profile_name  |profileName     |yes                                          |scenario               |profileNameVal                  |                        |scenario                             |currentProfileNameVal                         |

* Wait Until Element Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Profile name should be visible |no                                       |                  |                    |XPath                          |scenario                      |currentProfileNameVal                  |

* Click Element
   |Step Name              |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-----------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Click on Sign out link |yes                                      |HomePage          |nav_bar_signout_link|                               |                              |                                       |



## Valid user login to the application and profile name verification using hard coded text

* Click Element
   |Step Name              |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-----------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Click on Sign in link  |yes                                      |HomePage          |nav_bar_signin_link |                               |                              |                                       |

* Validate Element's Visibility On The Page
   |Step Name                               |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |----------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Email address textbox should be visible |yes                                      |LoginPage         |txt_email           |                               |                              |                                       |y          |
   |Password textbox should be visible      |yes                                      |LoginPage         |txt_password        |                               |                              |                                       |y          |
   |Submit button should be visible         |yes                                      |LoginPage         |btn_submit          |                               |                              |                                       |y          |

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text          |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|---------------------|
   |Set email as      |yes                                      |LoginPage         |txt_email           |                               |                              |                                       |no                                       |                       |                                |osanda@mailinator.com|
   |Set password as   |yes                                      |LoginPage         |txt_password        |                               |                              |                                       |no                                       |                       |                                |1qaz2wsx@            |

* Click Element
   |Step Name              |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-----------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Click on Submit button |yes                                      |LoginPage         |btn_submit          |                               |                              |                                       |

* Save Test Data From Excel To Data Stores
   |Sheet Name|Key Name   |Data Store Type|Data Store Variable Name|
   |----------|-----------|---------------|------------------------|
   |LoginData |profileName|scenario       |profileNameVal          |

* Replace Element Locator Placeholder And Save To Data Store
   |Step Name                |Sheet Name|Element Name      |Placeholder Text|Is Replacement Text Retrieve From Data Store |If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Replacement Text |Data Store Type To Save Final Locator|Data Store Variable Name To Save Final Locator|
   |-------------------------|----------|------------------|----------------|---------------------------------------------|-----------------------|--------------------------------|------------------------|-------------------------------------|----------------------------------------------|
   |Get profile name locator |HomePage  |lbl_profile_name  |profileName     |no                                           |                       |                                |Osanda Nimalarathna     |scenario                             |currentProfileNameVal                         |

* Wait Until Element Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Profile name should be visible |no                                       |                  |                    |XPath                          |scenario                      |currentProfileNameVal                  |

* Click Element
   |Step Name              |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-----------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Click on Sign out link |yes                                      |HomePage          |nav_bar_signout_link|                               |                              |                                       |

