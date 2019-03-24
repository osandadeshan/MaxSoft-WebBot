# Search Specification

<pre>
Project Name    : MaxSoft WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 14/03/2019
Time            : 20:59
Description     : This is an executable specification file which covers the login scenarios.
</pre>



## Search Question Scenario By Inputing Text Directly To The Text Box In Locators File

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text                            |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|---------------------------------------|
   |Set search text as|yes                                      |HomePage          |search_bar          |                               |                              |                                       |no                                       |                       |                                |How to automate Android 6.0 date picker|

* Click Element
   |Step Name           |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |--------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Tap on Search button|yes                                      |HomePage          |btn_search          |                               |                              |                                       |

* Validate Element's Visibility On The Page
   |Step Name                             |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |--------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Ask question button should be visible |yes                                      |HomePage          |btn_ask_question    |                               |                              |                                       |y          |

* Replace Element Locator Placeholder And Save To Data Store
   |Step Name                                       |Sheet Name|Element Name      |Placeholder Text|Replacement Text                                        |Data Store Type|Data Store Variable Name|
   |------------------------------------------------|----------|------------------|----------------|--------------------------------------------------------|---------------|------------------------|
   |Get search result locator and save to data store|HomePage  |test_search_result|searchText      |How to automate Android 6.0 Date picker to set any date?|scenario       |question_search_result  |

* Wait Until Element Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Search result should be visible|yes                                      |HomePage          |lbl_seach_result    |                               |                              |                                       |

* Wait Until Element Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Search result should be visible|no                                       |                  |                    |XPath                          |scenario                      |question_search_result                 |

* Validate Element's Visibility On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Search result should be visible|no                                       |                  |                    |XPath                          |scenario                      |question_search_result                 |y          |

* Validate Element's Visibility On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Search result should be visible|yes                                      |HomePage          |lbl_seach_result    |                               |                              |                                       |y          |



## Search Question Scenario By Inputing Text From Data Store To The Text Box In Locators File

* Click Element
   |Step Name           |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name        |If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |--------------------|-----------------------------------------|------------------|----------------------------|-------------------------------|------------------------------|---------------------------------------|
   |Tap on Search button|yes                                      |HomePage          |nav_bar_stackoverflow_menu  |                               |                              |                                       |

* Save Test Data From Excel To Data Stores
   |Sheet Name |Key Name|Data Store Type|Data Store Variable Name|
   |-----------|--------|---------------|------------------------|
   |SearchData |question|scenario       |questionVal             |

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text          |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|---------------------|
   |Set search text as|yes                                      |HomePage          |search_bar          |                               |                              |                                       |yes                                      |scenario               |questionVal                     |                     |

* Click Element
   |Step Name           |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |--------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Tap on Search button|yes                                      |HomePage          |btn_search          |                               |                              |                                       |

* Validate Element's Visibility On The Page
   |Step Name                             |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |--------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Ask question button should be visible |yes                                      |HomePage          |btn_ask_question    |                               |                              |                                       |y          |

* Replace Element Locator Placeholder And Save To Data Store
   |Step Name                                       |Sheet Name|Element Name      |Placeholder Text|Replacement Text                                        |Data Store Type|Data Store Variable Name|
   |------------------------------------------------|----------|------------------|----------------|--------------------------------------------------------|---------------|------------------------|
   |Get search result locator and save to data store|HomePage  |test_search_result|searchText      |How to automate Android 6.0 Date picker to set any date?|scenario       |question_search_result  |

* Wait Until Element Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Search result should be visible|no                                       |                  |                    |XPath                          |scenario                      |question_search_result                 |

* Validate Element's Visibility On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Search result should be visible|no                                       |                  |                    |XPath                          |scenario                      |question_search_result                 |y          |



## Search Question Scenario By Inputing Text Directly To The Text Box In Data Store

* Click Element
   |Step Name           |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name        |If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |--------------------|-----------------------------------------|------------------|----------------------------|-------------------------------|------------------------------|---------------------------------------|
   |Tap on Search button|yes                                      |HomePage          |nav_bar_stackoverflow_menu  |                               |                              |                                       |

* Save the values inside data stores
   |Data Store Type|Data Store Variable Name|Value To Be Stored  |
   |---------------|------------------------|--------------------|
   |scenario       |searchQuestionTextBox   |//input[@name='q']  |

* Read the values from data stores
   |Data Store Type|Data Store Variable Name|
   |---------------|------------------------|
   |scenario       |searchQuestionTextBox   |

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text                            |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|---------------------------------------|
   |Set search text as|no                                       |                  |                    |XPath                          |scenario                      |searchQuestionTextBox                  |no                                       |                       |                                |How to automate Android 6.0 date picker|

* Click Element
   |Step Name           |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |--------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Tap on Search button|yes                                      |HomePage          |btn_search          |                               |                              |                                       |

* Validate Element's Visibility On The Page
   |Step Name                             |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |--------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Ask question button should be visible |yes                                      |HomePage          |btn_ask_question    |                               |                              |                                       |y          |

* Wait Until Element Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Search result should be visible|yes                                      |HomePage          |lbl_seach_result    |                               |                              |                                       |

* Validate Element's Visibility On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Search result should be visible|yes                                      |HomePage          |lbl_seach_result    |                               |                              |                                       |y          |



## Search Question Scenario By Inputing Text Saved In Data Store To The Text Box In Data Store

* Click Element
   |Step Name           |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name        |If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |--------------------|-----------------------------------------|------------------|----------------------------|-------------------------------|------------------------------|---------------------------------------|
   |Tap on Search button|yes                                      |HomePage          |nav_bar_stackoverflow_menu  |                               |                              |                                       |

* Save the values inside data stores
   |Data Store Type|Data Store Variable Name|Value To Be Stored  |
   |---------------|------------------------|--------------------|
   |scenario       |searchQuestionTextBox   |//input[@name='q']  |

* Read the values from data stores
   |Data Store Type|Data Store Variable Name|
   |---------------|------------------------|
   |scenario       |searchQuestionTextBox   |

* Save the values inside data stores
   |Data Store Type|Data Store Variable Name|Value To Be Stored                       |
   |---------------|------------------------|-----------------------------------------|
   |scenario       |searchVal               |How to automate Android 6.0 date picker  |

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text   |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|--------------|
   |Set search text as|no                                       |                  |                    |XPath                          |scenario                      |searchQuestionTextBox                  |yes                                      |scenario               |searchVal                       |              |

* Click Element
   |Step Name           |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |--------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Tap on Search button|yes                                      |HomePage          |btn_search          |                               |                              |                                       |

* Validate Element's Visibility On The Page
   |Step Name                             |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |--------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Ask question button should be visible |yes                                      |HomePage          |btn_ask_question    |                               |                              |                                       |y          |

* Replace Element Locator Placeholder And Save To Data Store
   |Step Name                                       |Sheet Name|Element Name      |Placeholder Text|Replacement Text                                        |Data Store Type|Data Store Variable Name|
   |------------------------------------------------|----------|------------------|----------------|--------------------------------------------------------|---------------|------------------------|
   |Get search result locator and save to data store|HomePage  |test_search_result|searchText      |How to automate Android 6.0 Date picker to set any date?|scenario       |question_search_result  |

* Wait Until Element Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Search result should be visible|no                                       |                  |                    |XPath                          |scenario                      |question_search_result                 |

* Validate Element's Visibility On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Search result should be visible|yes                                      |HomePage          |lbl_seach_result    |                               |                              |                                       |y          |



## Search User Scenario

* Click Element
   |Step Name             |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |----------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Tap on Users Menu Item|yes                                      |HomePage          |nav_bar_users_menu  |                               |                              |                                       |

* Validate Element's Visibility On The Page
   |Step Name                             |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Is Visible?|
   |--------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------|
   |Ask question button should be visible |yes                                      |HomePage          |btn_ask_question    |                               |                              |                                       |n          |

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text      |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|-----------------|
   |Set search text as|yes                                      |UsersPage         |txt_box_user_search |                               |                              |                                       |no                                       |                       |                                |Osanda Deshan    |

* Wait Until Element Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Search result should be visible|yes                                      |UsersPage         |lbl_seach_result    |                               |                              |                                       |
