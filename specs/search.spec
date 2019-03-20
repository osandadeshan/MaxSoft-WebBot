# Search Specification

<pre>
Project Name    : MaxSoft WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 14/03/2019
Time            : 20:59
Description     : This is an executable specification file which covers the login scenarios.
</pre>



## Search Question Scenario

* Input Text
   |Step Name         |Sheet Name|Element Name|Text                                     |
   |------------------|----------|------------|-----------------------------------------|
   |Set search text as|HomePage  |search_bar  |How to automate Android 6.0 date picker  |
* Validate Element's Visibility On The Page
   |Step Name                            |Sheet Name|Element Name    |Is Visible?|
   |-------------------------------------|----------|----------------|-----------|
   |Ask Question button should be visible|HomePage  |btn_ask_question|y          |
* Click Element
   |Step Name           |Sheet Name|Element Name|
   |--------------------|----------|------------|
   |Tap on Search button|HomePage  |btn_search  |
* Wait Until Element Visible On The Page
   |Step Name                            |Sheet Name|Element Name    |Is Visible?|
   |-------------------------------------|----------|----------------|-----------|
   |Search result should be visible      |HomePage  |lbl_seach_result|y          |



## Search User Scenario

* Click Element
   |Step Name              |Sheet Name|Element Name        |
   |-----------------------|----------|--------------------|
   |Tap on Users Menu Item |HomePage  |nav_bar_users_menu  |
* Validate Element's Visibility On The Page
   |Step Name                            |Sheet Name|Element Name    |Is Visible?|
   |-------------------------------------|----------|----------------|-----------|
   |Ask Question button should be visible|HomePage  |btn_ask_question|n          |
* Input Text
   |Step Name         |Sheet Name|Element Name         |Text         |
   |------------------|----------|---------------------|-------------|
   |Set search text as|UsersPage |txt_box_user_search  |Osanda Deshan|
* Wait Until Element Visible On The Page
   |Step Name                            |Sheet Name|Element Name    |Is Visible?|
   |-------------------------------------|----------|----------------|-----------|
   |Search result should be visible      |UsersPage |lbl_seach_result|y          |