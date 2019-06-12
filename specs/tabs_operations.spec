# Tabs Operations Specification

<pre>
Project Name    : MaxSoft-WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 6/11/2019
Time            : 12:09 PM
Description     : This is an executable specification file
</pre>



## Tabs operations using tab indexes

* Open URL In New Tab
   |Step Name                 |Is URL Retrieve From Data Store?|If Yes, URL Data Store Type|If Yes, URL Data Store Variable Name|If No, URL                            |
   |--------------------------|--------------------------------|---------------------------|------------------------------------|--------------------------------------|
   |Open google.com           |no                              |                           |                                    |https://www.google.com/               |
   |Open file upload demo site|no                              |                           |                                    |http://demo.guru99.com/test/upload/   |
   |Open github.com           |no                              |                           |                                    |https://github.com/                   |

* Switch To The Tab By Tab Title
   |Step Name                 |Is Tab Title Retrieve From Data Store?|If Yes, Tab Title Data Store Type|If Yes, Tab Title Data Store Variable Name|If No, Tab Title                      |
   |--------------------------|--------------------------------------|---------------------------------|------------------------------------------|--------------------------------------|
   |Switch to google.com      |no                                    |                                 |                                          |Google                                |

* Current Page Title Is
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                       |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |Google                                  |

* Sleep "5" Seconds

* Switch To The Tab By Tab Title
   |Step Name                       |Is Tab Title Retrieve From Data Store?|If Yes, Tab Title Data Store Type|If Yes, Tab Title Data Store Variable Name|If No, Tab Title                      |
   |--------------------------------|--------------------------------------|---------------------------------|------------------------------------------|--------------------------------------|
   |Switch to file upload demo site |no                                    |                                 |                                          |File Upload Demo                      |

* Current Page Title Is
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                       |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |File Upload Demo                        |

* Sleep "5" Seconds



_________________________
* Open URL In Current Tab
   |Step Name                  |Is URL Retrieve From Data Store?|If Yes, URL Data Store Type|If Yes, URL Data Store Variable Name|If No, URL                              |
   |---------------------------|--------------------------------|---------------------------|------------------------------------|----------------------------------------|
   |Open automationpractice.com|no                              |                           |                                    |http://automationpractice.com/index.php |

* Current Page Title Is
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                       |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |My Store                                |