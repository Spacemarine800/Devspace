Tweet Feed

Objective
   Simulate a twitter feed. Program will receive two ASCII files. The first file contains a list of users and their
   followers. The second file contains tweets. Given the users, followers and tweets, display a simulated twitter feed for each user to the
   console.

Assumptions
- There will more than the given users, hence solution needs to be generic.
- One to many relationship for the user to followers.
- The data can be read from a file or database.
- Usernames are unique. 
- Data is always well-formed. 
- A user will not follow anther user more than once. 
- Users will not follow themselves. 

Instructions to Run
- Download Zip of given source code of TweeterProcessor
- Unzip to your directory of choice
- In your IDE of choice, I will use Eclipse, import the project into your workspace
- Right click TweeterProcessor project -> Run As -> Java Application
- View Console for required output
 
Notes about the Program design
- Designed around a service layer pattern, each service method that invokes a single command class that execute one specific              function.
- This allows the reuse of the services and testing each function.
- The command layer allows it to be modified to read from a database if needed or an external source.
- The program is driven by a properties file named tweeter.properties, this contains paths to the actual file inputs for user and tweets.
- The additional properties control the following:
   - FORMAT -> File format
   - SOURCE_VERSION -> Numerical value that controls different input sources
   - DEBUG -> Settting this to true will allow the program to output the data read in from each file to the console to verify.
 
 
