# Java Pre-Check Assignment

## Personal Details
- Name: *Samuel Olumide Oluwole*
- Matriculation Number: **7215275**

### Tasks

Develop Class Participant, which contains information about participants in the competitions. It should contain following attributes: name and surname, age, type of sport, list of awards.
Create all necessary setters and getters.
In the testing program create array of participants. Select participants depending from the type of sport, number of national and international awards.

### Project Description
- Project was developed with [JavaFx](https://openjfx.io/) to handle the User Interface of the Project
- Database: **[Postgresql](https://www.postgresql.org/)** 
- Update: Project now implemented using ArrayList to avoid postgresql setup problem in test PC. 
- Minimum JDK version - JDK 18

### Functionality
- Create Class Participant
- List Participant
- Filter Participants by Sports Type and Awards

### App Image
![Application Image](https://res.cloudinary.com/olumidesamuel/image/upload/v1694793525/Screenshot_2023-09-15_at_17.55.42_h9enzo.png "Class Participants")

### Github Link
https://github.com/LuminousIT/Precheck_ClassParticipantTest

### Setup Instructions

- Unzip file or git clone project into personal computer
- From eclipse, File -> Open Project from File System
- Select file from Local PC and import.

#### Add JavaFX to Eclipse
- Add JavaFX to Eclipse. [Click here for instructions with images](https://pragmaticways.com/how-to-add-javafx-to-eclipse-the-easy-way/) or follow the steps below:



  - [Download JavaFX](https://gluonhq.com/products/javafx/) 
  - Unzip the file
  - Open up Eclipse and go to Preferences
		You should be able to get to Preferences from Eclipse > Preferences or Window > Preferences
  - Go to Java > Build Path > User Libraries
  - Now click New…
  - Name it JavaFX and click Ok
  - With JavaFX highlighted, click Add External JARs…
  - Select all the .jar files from the /lib/ folder of the unzipped JavaFX folder we saved earlier.
  - Click Open and your new User Library should look something like this:
  	![image](https://res.cloudinary.com/olumidesamuel/image/upload/v1695992350/Screen-Shot-2021-12-09-at-6.51.55-PM_lfobs6.png)
  - Click Apply and Close to save your new User Library
  
  
  
  - Go back to Preferences in Eclipse
  - Go to Java > Installed JREs
  - Select your default JRE and click Duplicate
  - Copy this line if you’re on Windows
     --module-path "\path\to\javafx-sdk-17\lib" --add-modules javafx.controls,javafx.fxml
  - Copy this line if you’re on Mac or Linux
     --module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls,javafx.fxml
     **Replace the /path/to/javafx-sdk-17/lib with the path to where you placed your unzipped JavaFX folder from before.**
  - Paste that line in the Default VM arguments: field
  - Rename the JRE name: field to something memorable, such as javafx-jre-15
  - Click Add External JARs…
  - Select all the .jar files from the /lib/ folder of the unzipped JavaFX folder we saved earlier and then click Open
  - Your JRE Definition window should now look something like this
  ![jre](https://res.cloudinary.com/olumidesamuel/image/upload/v1695992350/Screen-Shot-2021-12-30-at-11.56.23-AM_mukup8.png)
  - Click Finish
  
#### Run
- Run project

#### Debug
If error ```Unbound class path container - JRE system library``,
 - Right click project, select Properties
 - Go to “Java Build Path” – “Libraries”
 - Select JRE System Library that went wrong; then click on “remove”
 - Click on “Add Library”; choose “JRE System Library”
 - Select “Workspace Default JRE”; 
 - Click on “Apply and Close”
 
If Error ```Error occurred during initialization of boot layer```
```java.lang.module.FindException: Error reading module: /Users/samueloluwole/Downloads/ClassParticipantsTest/target/classes. Caused by: java.lang.module.InvalidModuleDescriptorException: Unsupported major.minor version 62.0```,
 - This means JDK is less than 18.
 - Download JDK >= 18 from [JavaDoc](https://www.oracle.com/java/technologies/downloads)
 - Install
 - Restart Eclipse
 - Right Click on Project in Eclipse
 - Go to Properties -> Java build path -> Libraries Tab
 - Select existing idk, click remove
 - Then click Add library
 - Select JRE system library, then next
 - Select alternate JRE, choose newly installed jre version
 - Finish
 - Click apply and close
 - Run project
 

  
  