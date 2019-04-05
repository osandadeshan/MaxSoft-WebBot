# MaxSoft WebBot
<br />

## Introduction
The main reason for developing this framework is to provide an easy way for Technical QA, Developer or Non-technical QA to perform Web testing in an easy manner.

### Technologies/Frameworks used
- Java
- Gauge Framework
- Selenium
- Bonigarcia WebDriver Manager
- Junit
- Apache POI
- Apache Maven

### Supported Platforms
- Windows
- Linux
- Mac OS

### Supported Languages
- Java

### Advantages
- Generation of an executable document.
- Human readable tests, business language and Mark-down syntax.
- Tests can be designed even by a non- technical person.
- Generate a HTML report with test details for every test execution.
- Parallel execution.
- Live execution report.
- Automated emails for test execution summary with graphical representations.
<br />

## Pre Requisites
1. Java
2. Maven
<br />

## How to Install Gauge Core

**On Windows**
1. Install Chocolatey by executing the following command. \
` @"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString(‘https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"`

2. Install Gauge by executing the following command. \
`choco install gauge`

**On MacOS**
1. Update Homebrew. \
`brew update`

2. Install Gauge using Homebrew. \
`brew install gauge`

**On Linux**
1. First, add Gauge’s GPG key with this command. \
`sudo apt-key adv --keyserver hkp://pool.sks-keyservers.net --recv-keys 023EDB0B`

2. Then add Gauge to the repository list using this command. \
`echo deb https://dl.bintray.com/gauge/gauge-deb nightly main | sudo tee -a /etc/apt/sources.list`

3. Finally, install Gauge using these commands. \
`sudo apt-get update` \
`sudo apt-get install gauge`
<br />

## How to Install Gauge Plugins
1. Open Command Prompt and execute following commands. \
`gauge install java` \
`gauge install html-report` \
`gauge install json-report` \
`gauge install xml-report` \
`gauge install spectacle` \
`gauge install flash`

2. You can check the installation using the following command. \
`gauge -v`

	If the installation is success, it will output like this:

```markdown
    Gauge version: <version number>
    Plugins
    -------
    flash (<version number>)
    html-report (<version number>)
    java (<version number>)
    json-report (<version number>)
    spectacle (<version number>)
    xml-report (<version number>)
```
<br />

## WebBot Development
[Trello Board](https://trello.com/b/Aj0f2Gow/maxsoft-webbot)

<br />

## License
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/License_icon-mit-2.svg/2000px-License_icon-mit-2.svg.png" alt="MIT License" width="100" height="100"/> [MaxSoft WebBot]() is released under [MIT License](https://opensource.org/licenses/MIT)

<br />

## Copyright
Copyright 2019 MaxSoft.
