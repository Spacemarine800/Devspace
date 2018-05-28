# Tweet Feed

## Objective
   Simulate a twitter feed. Program will receive two ASCII files. The first file contains a list of users and their
   followers. The second file contains tweets. Given the users, followers and tweets, display a simulated twitter feed for each user to the
   console.

## Assumptions
- There will more than the given users, hence solution needs to be generic.
- One to many relationship for the user to followers.
- The data can be read from a file or database.
- Usernames are unique. 
- Data is always well-formed. 
- A user will not follow another user more than once. 
- Users will not follow themselves. 

## Instructions to Run
- Download Zip of given source code of TweeterProcessor
- Unzip to your directory of choice
- In your IDE of choice, I will use Eclipse, import the project into your workspace
- Right click TweeterProcessor project -> Run As -> Java Application
- You will be prompted to select a class, Select FeedReader that is located under tweetprocessor.main
- View Console for required output
 
## Testing
- JunitLoadTweets tests the service method to load tweets onto users, from the given inputs.
- JunitLoadUsers tests the reading of users from the given file.
- LoadUserServiceTest demonstrates how service layer can be used for testing without Junit.
 
## Notes about the Program design
- Designed around a service layer pattern, each service method that invokes a single command class that execute one specific              function.
- This allows the reuse of the services and testing each function.
- The command layer allows it to be modified to read from a database if needed or an external source.
- The program is driven by a properties file named tweeter.properties, this contains paths to the actual file inputs for user and tweets.
- The additional properties control the following:
   - FORMAT -> File format
   - SOURCE_VERSION -> Numerical value that controls different input sources
   - DEBUG -> Settting this to true will allow the program to output the data read in from each file to the console to verify.

- By default the SOURCE_VERSION is set to blank, so the program will process the given files user.txt and tweets.txt.

- To test if the program can handle more users and tweets, I created the following additional files under tweetprocessor.datainput, named user2.txt and tweet2.txt. This is where the property SOURCE_VERSION is used, if it is set to 2, the program will read those source files and process accordingly.
 
 
 
 
