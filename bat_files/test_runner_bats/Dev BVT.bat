@echo off
echo Executing MaxSoft WebBot Dev Test Automation Suite.............

cd ..
cd ..

call mvn test-compile gauge:execute -DspecsDir="specs" -Denv="dev"
echo Exit Code = %ERRORLEVEL%
if not "%ERRORLEVEL%" == "0" exit /b

call mvn clean -DemailConfigEnv=dev install exec:java
echo Exit Code = %ERRORLEVEL%
if not "%ERRORLEVEL%" == "0" exit /b