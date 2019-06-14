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
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Tab index = 1)
3. File upload page (Tab index = 2)
4. Github page (Focused, Tab index = 3)

* Switch To The Tab By Tab Index "1"
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Focused, Tab index = 1)
3. File upload page (Tab index = 2)
4. Github page (Tab index = 3)

* Current Page Title Is
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                       |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |Google                                  |

* Close The Current Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. File upload page (Focused, Tab index = 1)
3. Github page (Tab index = 2)

* Current Page Title Contains
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title            |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|-----------------------------|
   |Validate current page title|no                                     |                                  |                                           |My Store                     |

* Switch To The Tab By Tab Index "2"
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. File upload page (Tab index = 1)
3. Github page (Focused, Tab index = 2)

* Current Page Title Is
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                                         |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |The world’s leading software development platform · GitHub|

* Close The Current Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. File upload page (Focused, Tab index = 1)

* Current Page Title Is
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                       |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |File Upload Demo                        |

* Close The Current Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. File upload page (Focused, Tab index = 1)



## Tabs operations using tab titles

* Open URL In New Tab
   |Step Name                 |Is URL Retrieve From Data Store?|If Yes, URL Data Store Type|If Yes, URL Data Store Variable Name|If No, URL                            |
   |--------------------------|--------------------------------|---------------------------|------------------------------------|--------------------------------------|
   |Open google.com           |no                              |                           |                                    |https://www.google.com/               |
   |Open file upload demo site|no                              |                           |                                    |http://demo.guru99.com/test/upload/   |
   |Open github.com           |no                              |                           |                                    |https://github.com/                   |
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Tab index = 1)
3. File upload page (Tab index = 2)
4. Github page (Focused, Tab index = 3)

* Switch To The Tab By Tab Title
   |Step Name                 |Is Tab Title Retrieve From Data Store?|If Yes, Tab Title Data Store Type|If Yes, Tab Title Data Store Variable Name|If No, Tab Title                      |
   |--------------------------|--------------------------------------|---------------------------------|------------------------------------------|--------------------------------------|
   |Switch to google.com      |no                                    |                                 |                                          |Google                                |
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Focused, Tab index = 1)
3. File upload page (Tab index = 2)
4. Github page (Tab index = 3)

* Current Page Title Is
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                       |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |Google                                  |

* Switch To The Tab By Tab Title
   |Step Name                       |Is Tab Title Retrieve From Data Store?|If Yes, Tab Title Data Store Type|If Yes, Tab Title Data Store Variable Name|If No, Tab Title                      |
   |--------------------------------|--------------------------------------|---------------------------------|------------------------------------------|--------------------------------------|
   |Switch to file upload demo site |no                                    |                                 |                                          |File Upload Demo                      |
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Tab index = 1)
3. File upload page (Focused, Tab index = 2)
4. Github page (Tab index = 3)

* Current Page Title Is
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                       |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |File Upload Demo                        |

* Close The Current Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Focused, Tab index = 1)
3. Github page (Tab index = 2)

* Current Page Title Is
   |Step Name                 |Is Tab Title Retrieve From Data Store?|If Yes, Tab Title Data Store Type|If Yes, Tab Title Data Store Variable Name|If No, Tab Title                      |
   |--------------------------|--------------------------------------|---------------------------------|------------------------------------------|--------------------------------------|
   |Switch to google.com      |no                                    |                                 |                                          |Google                                |

* Close The Current Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Focused, Tab index = 0)
2. Github page (Tab index = 1)

* Current Page Title Contains
   |Step Name                        |Is Tab Title Retrieve From Data Store?|If Yes, Tab Title Data Store Type|If Yes, Tab Title Data Store Variable Name|If No, Tab Title                      |
   |---------------------------------|--------------------------------------|---------------------------------|------------------------------------------|--------------------------------------|
   |Switch to automationpractice.com |no                                    |                                 |                                          |My Store                              |

* Switch To The Tab By Tab Title
   |Step Name                       |Is Tab Title Retrieve From Data Store?|If Yes, Tab Title Data Store Type|If Yes, Tab Title Data Store Variable Name|If No, Tab Title                                          |
   |--------------------------------|--------------------------------------|---------------------------------|------------------------------------------|----------------------------------------------------------|
   |Switch to github.com            |no                                    |                                 |                                          |The world’s leading software development platform · GitHub|
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Github page (Focused, Tab index = 1)

* Current Page Title Is
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                                         |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |The world’s leading software development platform · GitHub|

* Close The Current Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Focused, Tab index = 0)

* Current Page Title Contains
   |Step Name                        |Is Tab Title Retrieve From Data Store?|If Yes, Tab Title Data Store Type|If Yes, Tab Title Data Store Variable Name|If No, Tab Title                      |
   |---------------------------------|--------------------------------------|---------------------------------|------------------------------------------|--------------------------------------|
   |Switch to automationpractice.com |no                                    |                                 |                                          |My Store                              |



_________________________
* Open URL In Current Tab
   |Step Name                  |Is URL Retrieve From Data Store?|If Yes, URL Data Store Type|If Yes, URL Data Store Variable Name|If No, URL                              |
   |---------------------------|--------------------------------|---------------------------|------------------------------------|----------------------------------------|
   |Open automationpractice.com|no                              |                           |                                    |http://automationpractice.com/index.php |

* Current Page Title Contains
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                       |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |My Store                                |

* Switch To The Parent Tab

* Current Page Title Contains
   |Step Name                  |Is Page Title Retrieve From Data Store?|If Yes, Page Title Data Store Type|If Yes, Page Title Data Store Variable Name|If No, Page Title                       |
   |---------------------------|---------------------------------------|----------------------------------|-------------------------------------------|----------------------------------------|
   |Validate current page title|no                                     |                                  |                                           |My Store                                |