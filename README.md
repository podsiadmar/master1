# README #

### What is this repository for? ###

* Base repository with Test Automation framework for backend testing.
* Version 1.0.0

### How do I get set up? ###

* Configuration
  * What is needed:
    - Java 1.8
    - Maven - https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/
    - Allure CLI - https://docs.qameta.io/allure/#_get_started (For windows https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/)
    - Sourcetree or any other GIT client - https://www.sourcetreeapp.com/
    - Intellij Community - https://www.jetbrains.com/idea/download/#section=windows
  * Configuration
    - Add Java path to Windows environment variables.
    - Add Maven path to folder with maven to Windows environment variables.
    - Add Allure CLI path to folder to Windows environment variables.
    - Using CMD check java version using <code>java -version</code>
    - Using CMD check java home using <code>echo JAVA_HOME</code>
    - Using CMD check maven version using <code>mvn -version</code>
    - Using CMD check allure version using <code>allure --version</code>
  * Plugins (File > Settings > Plugins)
    - Cucumber for Java
    - Gherkin
    - Lombok (should be bundled)
  * Intellij config
    - File > Settings > Annotation Processors > Enable annotation processing (Select checkbox)

* How to run tests
  * Use run configuration API All to execute all test from Suite or API @dev to execute single tests. 
    Using @dev requires tag to be added before scenario. For different suites different run configuration need to be created.
  * run from maven command <code>mvn -Denv.URL="https://api.publicapis.org" -Ddataproviderthreadcount=1 test</code>

### Contribution guidelines ###

* Writing tests - WIP
* Code review - WIP
* Other guidelines - WIP

### Allure reporting ###

1. Go to Intellij Terminal *(can be found on the bottom or View>Tool Windows>Terminal)*
2. Move to **target** folder *<code>cd target</code>*
3. Use command <code>allure generate --clean</code> it will generate allure-report folder.
4. Use command <code>allure serve</code> it will start web server with Allure report.
5. In terminal server can be stopped with key shortcut **CTRL + C**

### Who do I talk to? ###

* Author: Paweł Borkowski