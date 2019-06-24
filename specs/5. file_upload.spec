# File Upload Specification

<pre>
Project Name    : MaxSoft-WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 24/05/2019
Time            : 13:03
Description     : This is an executable specification file
</pre>


Tags: file_upload


    
## File Upload

* Open URL In New Browser Tab
   |Step Name                 |Is URL Retrieve From Data Store?|If Yes, URL Data Store Type|If Yes, URL Data Store Variable Name|If No, URL                            |
   |--------------------------|--------------------------------|---------------------------|------------------------------------|--------------------------------------|
   |Open google.com           |no                              |                           |                                    |https://www.google.com/               |
   |Open file upload demo site|no                              |                           |                                    |http://demo.guru99.com/test/upload/   |

* Switch To The Google Tab And Verify Page Title

* Close The Current Browser Tab

* Switch To The File Upload Demo Tab And Verify Page Title

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text                          |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|-------------------------------------|
   |Send file path    |yes                                      |UploadPage        |btn_test_upload     |                               |                              |                                       |                                         |                       |                                |C:\\ggate30_to_ingest_Mv2.epub       |

* Click Element
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Click on Terms checkbox        |yes                                      |UploadPage        |btn_terms           |                               |                              |                                       |

* Click Element
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Click on Submit File button    |yes                                      |UploadPage        |btn_upload_file     |                               |                              |                                       |

* Wait Until Element Is Visible On The Page
   |Step Name                              |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |---------------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Upload success label should be visible |yes                                      |UploadPage        |lbl_upload_success  |                               |                              |                                       |

* Close The Current Browser Tab



______________________________________

* Open My Store In Current Browser Tab