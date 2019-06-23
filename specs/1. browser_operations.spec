# Browser Operations Specification

<pre>
Project Name    : MaxSoft-WebBot
Developer       : Osanda Deshan
Version         : 1.0.0
Date            : 6/16/2019
Time            : 7:12 PM
Description     : This is an executable specification file
</pre>


Tags: browser



* Open New Browser Window

* Maximize Browser Window



## Open browser and navigates to eBay

* Open eBay In Current Browser Tab

* Switch To The Parent Browser Tab And Verify Page Title



## Open browser and navigates to google url saved in property file and again swiching to the my store(parent) window

* Open Google In Current Browser Tab

* Switch To The Parent Browser Tab And Verify Page Title

* Switch To The Browser Tab By Browser Tab Index "1"

* Verify Google Page Title



## Open browser and navigates to an url saved in property file and do some actions

* Open My Store In Current Browser Tab

* Login To The Application Using Username By Referring The Key "osandaEmail" and Password By Referring The Key "osandaPassword". Then Validate The Account Name By Referring The Key "osandaProfileName" In The Test Data Excel File.

* Logout From The Application



## Open browser and navigates to an url saved in property file and open new tabs and do actions

* Open My Store In Current Browser Tab

* Open URL In New Browser Tab
   |Step Name                 |Is URL Retrieve From Data Store?|If Yes, URL Data Store Type|If Yes, URL Data Store Variable Name|If No, URL                            |
   |--------------------------|--------------------------------|---------------------------|------------------------------------|--------------------------------------|
   |Open google.com           |no                              |                           |                                    |https://www.google.com/               |
   |Open file upload demo site|no                              |                           |                                    |http://demo.guru99.com/test/upload/   |
   |Open github.com           |no                              |                           |                                    |https://github.com/                   |
After this step executed, the following windows and tabs will be on the browser,
1. Automation practice page (Window No = 1, Tab/Window index = 0)
2. Automation practice page (Window No = 2, Tab/Window index = 1)
3. Google page (Window No = 2, Tab/Window index = 2)
4. File upload page (Window No = 2, Tab/Window index = 3)
5. Github page (Focused, Window No = 2, Tab/Window index = 4)

* Verify GitHub Page Title

* Switch To The Browser Tab By Browser Tab Index "2"
After this step executed, the following windows and tabs will be on the browser,
1. Automation practice page (Window No = 1, Tab/Window index = 0)
2. Automation practice page (Window No = 2, Tab/Window index = 1)
3. Google page (Focused, Window No = 2, Tab/Window index = 2)
4. File upload page (Window No = 2, Tab/Window index = 3)
5. Github page (Window No = 2, Tab/Window index = 4)

* Verify Google Page Title

* Switch To The File Upload Demo Tab And Verify Page Title
After this step executed, the following windows and tabs will be on the browser,
1. Automation practice page (Window No = 1, Tab/Window index = 0)
2. Automation practice page (Window No = 2, Tab/Window index = 1)
3. Google page (Window No = 2, Tab/Window index = 2)
4. File upload page (Focused, Window No = 2, Tab/Window index = 3)
5. Github page (Window No = 2, Tab/Window index = 4)

* Close The Current Browser Tab
After this step executed, the following windows and tabs will be on the browser,
1. Automation practice page (Window No = 1, Tab/Window index = 0)
2. Automation practice page (Window No = 2, Tab/Window index = 1)
3. Google page (Focused, Window No = 2, Tab/Window index = 2)
4. Github page (Window No = 2, Tab/Window index = 3)

* Verify Google Page Title

* Switch To The GitHub Tab And Verify Page Title
After this step executed, the following windows and tabs will be on the browser,
1. Automation practice page (Window No = 1, Tab/Window index = 0)
2. Automation practice page (Window No = 2, Tab/Window index = 1)
3. Google page (Window No = 2, Tab/Window index = 2)
4. Github page (Focused, Window No = 2, Tab/Window index = 3)

* Close The Current Browser Tab
After this step executed, the following windows and tabs will be on the browser,
1. Automation practice page (Window No = 1, Tab/Window index = 0)
2. Automation practice page (Window No = 2, Tab/Window index = 1)
3. Google page (Focused, Window No = 2, Tab/Window index = 2)

* Verify Google Page Title

* Close The Current Browser Tab
After this step executed, the following windows and tabs will be on the browser,
1. Automation practice page (Window No = 1, Tab/Window index = 0)
2. Automation practice page (Focused, Window No = 2, Tab/Window index = 1)

* Verify My Store Page Title

* Switch To The Parent Browser Tab And Verify Page Title
After this step executed, the following windows and tabs will be on the browser,
1. Automation practice page (Focused, Window No = 1, Tab/Window index = 0)
2. Automation practice page (Window No = 2, Tab/Window index = 1)



___________________________________________________________

* Close All Other Tabs And Switch To The Parent Browser Tab