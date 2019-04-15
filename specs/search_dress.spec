# Search Dress Specification

<pre>
Project Name    : MaxSoft-WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 13/04/2019
Time            : 13:02
Description     : This is an executable specification file
</pre>


    
## Search T-Shirt

* Login To The Application Using Username By Referring The Key "osandaEmail" and Password By Referring The Key "osandaPassword". Then Validate The Account Name By Referring The Key "osandaProfileName" In The Test Data Excel File.

* Save Test Data From Excel To Data Stores
   |Sheet Name|Key Name         |Data Store Type|Data Store Variable Name|
   |----------|-----------------|---------------|------------------------|
   |SearchData|tShirtDress      |scenario       |searchVal               |

* Input Text
   |Step Name         |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|Does Input Text Retrieve From Data Store?|If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Text          |
   |------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|-----------------------------------------|-----------------------|--------------------------------|---------------------|
   |Set search text as|yes                                      |HomePage          |txt_search_bar      |                               |                              |                                       |yes                                      |scenario               |searchVal                       |                     |

* Press Key
   |Step Name             |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|ASCII Key Code|
   |----------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|--------------|
   |Press Enter           |yes                                      |HomePage          |txt_search_bar      |                               |                              |                                       |\ue007        |

* Replace Element Locator Placeholder And Save To Data Store
   |Step Name                |Sheet Name|Element Name      |Placeholder Text|Is Replacement Text Retrieve From Data Store |If Yes, Data Store Type|If Yes, Data Store Variable Name|If No, Replacement Text |Data Store Type To Save Final Locator|Data Store Variable Name To Save Final Locator|
   |-------------------------|----------|------------------|----------------|---------------------------------------------|-----------------------|--------------------------------|------------------------|-------------------------------------|----------------------------------------------|
   |Get search result locator|HomePage  |lbl_search_result |searchText      |yes                                          |scenario               |searchVal                       |                        |scenario                             |searchResultLocator                           |

* Wait Until Element Is Visible On The Page
   |Step Name                      |Does Element Retrieve From Locators File?|If Yes, Sheet Name|If Yes, Element Name|If No, Element Locator Strategy|If No, Element Data Store Type|If No, Element Data Store Variable Name|
   |-------------------------------|-----------------------------------------|------------------|--------------------|-------------------------------|------------------------------|---------------------------------------|
   |Search result should be visible|no                                       |                  |                    |XPath                          |scenario                      |searchResultLocator                    |

* Logout From The Application