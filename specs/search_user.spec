# Search User Specification

<pre>
Project Name    : MaxSoft WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 14/03/2019
Time            : 20:59
Description     : This is an executable specification file which covers the login scenarios.
</pre>



## Search User Scenario

* Click Element
   |Step Name             |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |----------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Tap on Users Menu Item|yes                                      |HomePage          |nav_bar_users_menu  |                               |                              |                                       |

* Validate Element's Visibility On The Page
   |Step Name                                 |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |------------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Ask question button should not be visible |yes                                      |HomePage          |btn_ask_question    |                               |                              |                                       |n          |

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text      |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|-----------------|
   |Set search text as|yes                                      |UsersPage         |txt_box_user_search |                               |                              |                                       |no                                       |                       |                                |Osanda Deshan    |

* Wait Until Element Is Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Search result should be visible|yes                                      |UsersPage         |lbl_seach_result    |                               |                              |                                       |
