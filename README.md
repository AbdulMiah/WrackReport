# Flood Wrack Data

A crowd-sourced project to collate reports of flood wracking and damage.

# Instructions to download and run a local copy of the project

To get started, go to the Gitlab project repository by clicking on the link below (or copy and paste into browser of choice):
-	https://git.cardiff.ac.uk/c2035950/wrack-report-fork

Once on the page, press the blue “Clone” button, and click “Clone with HTTPS” to copy the address. After you choose a location to store the project, right click in the desired folder and select “Git Bash Here”. Enter “git clone” then paste the link. Should look something like this:
-	git clone https://git.cardiff.ac.uk/c2035950/wrack-report-fork.git
This should clone the repository so you can get a local copy of it. 

When the clone is complete, open SQL Workbench and open the SQL creation and population scripts. These scripts can be found if you navigate to src / main / resources from the directory. File name for the creation script is “schema-wrack-report.sql” and the population script is named “data-wrack-report.sql”.

When you have run both scripts, go back to the directory, and open the Command Prompt from that location. You can do this by clicking in the address bar at the top of the folder and type “cmd” and press “Enter”. 
Enter the following command in the Command Prompt:
-	.\gradlew (this enables the gradle environment)

Since we are using the JASYPT java library to encrypting our usernames and passwords for our database in the application.properties file, we will have to pass the environment variables to the gradle tasks in the command line. To do this, we simply enter:
-	.\gradlew -PJASYPT_ENCRYPTOR_PASSWORD=T34M-3 build 

After the project has been built successfully, the jar file should be generated. To execute the jar file, enter the following commands: 
-	cd build/libs 

Jar file is stored in this location. Once again, to run the jar file we will have to include the environment variable in the command, so enter this:
-	java -DJASYPT_ENCRYPTOR_PASSWORD=T34M-3 -jar WrackReport-0.0.1-SNAPSHOT.jar

This command will run the project and you can access the site by opening the browser of your choice and entering (or copy and paste) the following in the URL:
-	https://localhost:8443/ 
