# WWE_LoginTestAuto
The solution for WWE QA Task.

What is [WWE_LoginTestAuto]?
- The [WWE_LoginTestAuto] is a pure JAVA TECH STACK based test automation framework.
- Based on Maven, WebDriver, Junit, Spring, ExtentReports and also we could use it by Jenkins-CI.


What do we have here? :)
- We have failure retry : [Utils.RetryTest] implements [org.junit.rules.TestRule]

@Rule
public RetryTest retry = new RetryTest(3, chromeDriver, logger, capture);

Above annotation means : All Junit test fail in the Class will be retried for 3 times,
if there is 1 time the test pass, the assert will be passed. If the test fails for 3 times,
The [Utils.ScreenShotTaker] will take a screenshot and throw the assert failure.


- We have the failure screenshot : [Utils.ScreenShotTaker]
It will take a screenshot when one JUnit test fails for retry times.(It only take 1 shot after the test try out all times it been set)
This screenshot function has been wrapped into the [Utils.RetryTest]


- We have the test report : [Utils.ReportsUtils]
This is a decent test report generator, for more info, you can find on : http://extentreports.relevantcodes.com/,
The local generate path is : [resources.conf.testParams.properties.ExtentReportsPath] you can change it by yourself.


- We have system level info logs : [Utils.LogUtilFunctions], [Utils.Log4jFileAppender], [resources.conf.log4j.properties].
All logs will be stored at : WWE_LoginTestAuto\WebDriverLogs,
You can change them by edit the [resources.testParams.properties.TestCase_CreateNewPage_QuickCreate_On_Chrome_LayOut]


- We have the Spring IOC : [TestParams.BaseTest], [TestParams.ProjectParams], [resources.conf.testParams.properties], [resources.spring].

Why we use the spring to control the test params ? Because of the elastic design.
If the scaffold will be implemented as an online test application in the future,
then, when we want to change any param to fit the test,
we only need to change it on [resources.conf:testParams.properties] and restart the online instance,
the param's value will changed and we don't need to compile the whole solution and packaging it again before release it online.


- We have the PageFactory : loosely-coupled design


- We also have the Jenkins-CI, which means we could use the Jenkins to trigger the test on the distributed clients.


- One last thing : You'll not find any [try...catch] block in the test case java file.
Because the [try...catch] already wrapped into the [Utils.RetryTest].

*****************************************************************************************************************************************

Below is my test environment:

- Selenium Drivers : http://www.seleniumhq.org/download/


- My Drivers -> [IEDriverServer_Win32_2.48.0], [chromedriver_win32_2.20], [firefox_43.0.1].
If you use the IE11 for the test, there is a defect after the WebDriver boot the browser,
Please Check the web for details : http://www.michael-whelan.net/selenium-webdriver-and-ie11/


- My Maven conf settings.xml -> D:\Maven\apache-maven-3.3.3\conf\settings.xml

		<mirror>
      		<id>Nexus</id>
      		<name>Nexus Public Mirror</name>
      		<url>http://repo2.maven.org/maven2</url>
      		<mirrorOf>*</mirrorOf>
     	</mirror>

     	<mirror>
      		<id>Nexus1</id>
      		<name>Nexus1 Public Mirror</name>
      		<url>http://mirror.reverse.net/pub/apache</url>
      		<mirrorOf>*</mirrorOf>
     	</mirror>


- JDK version : 1.8.0_25


- I use the IntelliJ IDEA 15.0.2 for all development.


- My local report generate path is : C:\Users\Marcus_Chang\Desktop\WWE-BPM-TestReports,
you can change it on [resource.conf:testParams.properties].


- My local screenshot generate path is : C:\Users\Marcus_Chang\Desktop\WWE-BPM-Screenshots,
you can change it on [resource.conf:testParams.properties].



*****************************************************************************************************************************************


Below is my test cases for the [sign in] feature of the outlook.com :

- Test Case 1 : Input [Username = null] + [Password = null] Then [Press Submit Btn];
EP : [id=usernameError] + [id=passwordError] Popup and requires user to input the valid [Username] + [Password].

- Test Case 2 : Input [Username = Vaild Value] + [Password = null] Then [Press Submit Btn];
EP : [id=passwordError] Popup and requires user to input the valid [Password].

- Test Case 3 : Input [Username = null] + [Password = Valid Value] Then [Press Submit Btn];
EP : [id=usernameError] Popup and requires user to input the valid [Username].

- Test Case 4 : Input [Username = space * (required input length)] + [Password = space * (required input length)] Then [Press Submit Btn];
EP : [id=usernameError] Popup and requires user to input the valid [Username].

- Test Case 5 : Input [Username = space * 1 + Valid Value + space * 1] + [Password = Valid Value] Then [Press Submit Btn];
EP : [id=usernameError] Popup and requires user to input the valid [Username].

- Test Case 6 : Input [Username = Valid Value] + [Password = space * 1 + Valid Value + space * 1] Then [Press Submit Btn];
EP : [id=passwordError] Popup and requires user to input the valid [Password].

- Test Case 7 : Input [Username = admin/Admin/ADMIN] + [Password = admin/Admin/ADMIN] Then [Press Submit Btn];
EP : [id=usernameError] + [id=passwordError] Popup and requires user to input the valid [Username] + [Password].

- Test Case 8 : Input [Username = Long String] + [Password = Valid Value] Then [Press Submit Btn];
EP : [id=usernameError] Popup and requires user to input the valid [Username].

- Test Case 9 : Input [Username = Valid Value] + [Password = Long String] Then [Press Submit Btn];
EP : [id=passwordError] Popup and requires user to input the valid [Password].

- Test Case 10 : Input [Username = multibyte character] + [Password = Valid Value] Then [Press Submit Btn];
EP : [id=usernameError] Popup and requires user to input the valid [Username].

- Test Case 11 : Input [Username = Valid Value] + [Password = multibyte character] Then [Press Submit Btn];
EP : [id=passwordError] Popup and requires user to input the valid [Password].

- Test Case 12 : Input [Username = Valid Value with Special Symbol( not include : space|(|)|[|]|.|-|#|*|/)] + [Password = Valid Value] Then [Press Submit Btn];
EP : [id=usernameError] Popup and requires user to input the valid [Username].

- Test Case 13 : Input [Username = Valid Value(like phone number) + Special Symbol(space|(|)|[|]|.|-|#|*|/)] + [Password = Valid Value] Then [Press Submit Btn];
EP : Login Success.

- Test Case 14 : Input [Username = JS code for XSS] + [Password = JS code for XSS] Then [Press Submit Btn];
EP : [id=usernameError] + [id=passwordError] Popup and requires user to input the valid [Username] + [Password].

- Test Case 15 : Input [Username = SQL for Injection] + [Password = SQL for Injection] Then [Press Submit Btn];
EP : [id=usernameError] + [id=passwordError] Popup and requires user to input the valid [Username] + [Password].

- Test Case 16 : Use the valid Username & Password to login the test account on multiple host with different ip address;
EP : Security Alert Message should Popup on all hosts.

- Test Case 17 : Use the valid Username & Password to login the test account on multiple browsers by the same ip address;
EP : Login Success.

- Test Case 18 : Use the valid Username & Password to login the test account on Outlook.com;
Then logout the test account and try to press the [backward] & [forward] buttons on the browser;
EP : User can't login the test account again.

- Test Case 19 : Use the valid Username & Password to login the test account on Outlook.com;
Then delete the Cookies for the Outlook.com and continue operate on the mailbox;
EP : After the Cookies have been deleted, when the user operate anything on the mailbox, there will be a refresh action to logout the user.

- Test Case 20 : Use Jmeter/Gatling/LoadRunner/BlazeMeter to generate the valid login stress to test the load performance of Outlook.com;
EP : It's should be fine as the Microsoft has the CDN and Cloud to elastic the service.


One last thing !
The test case scripts under : \WWE_LoginTestAuto\src\test\java\com\outlook\test\BPM
Are only coded for one valid login case and one invalid login case,
Because of the code amount and time I have.














