# Tabs Operations Specification

<pre>
Project Name    : MaxSoft-WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 6/11/2019
Time            : 12:09 PM
Description     : This is an executable specification file
</pre>


Tags: tabs



* Open URL In New Browser Tab
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



## Tabs operations using tab indexes

* Switch To The Browser Tab By Browser Tab Index "1"
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Focused, Tab index = 1)
3. File upload page (Tab index = 2)
4. Github page (Tab index = 3)

* Verify Google Page Title

* Close The Current Browser Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. File upload page (Focused, Tab index = 1)
3. Github page (Tab index = 2)

* Verify My Store Page Title

* Switch To The Browser Tab By Browser Tab Index "2"
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. File upload page (Tab index = 1)
3. Github page (Focused, Tab index = 2)

* Verify GitHub Page Title

* Close The Current Browser Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. File upload page (Focused, Tab index = 1)

* Verify File Upload Demo Page Title

* Close The Current Browser Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. File upload page (Focused, Tab index = 1)



## Tabs operations using tab titles

* Switch To The Google Tab And Verify Page Title
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Focused, Tab index = 1)
3. File upload page (Tab index = 2)
4. Github page (Tab index = 3)

* Switch To The File Upload Demo Tab And Verify Page Title
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Tab index = 1)
3. File upload page (Focused, Tab index = 2)
4. Github page (Tab index = 3)

* Close The Current Browser Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Google page (Focused, Tab index = 1)
3. Github page (Tab index = 2)

* Verify Google Page Title

* Close The Current Browser Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Focused, Tab index = 0)
2. Github page (Tab index = 1)

* Verify My Store Page Title

* Switch To The GitHub Tab And Verify Page Title
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Tab index = 0)
2. Github page (Focused, Tab index = 1)

* Close The Current Browser Tab
After this step executed, the following tabs will be on the browser,
1. Automation practice page (Focused, Tab index = 0)

* Verify My Store Page Title



_________________________________

* Open My Store In Current Browser Tab

* Switch To The Parent Browser Tab And Verify Page Title