# Patient Management System (PMS)


## Database (through Navicat)
Use "**patient.sql**" file to create the database, called patients; create the table, called Patients, and insert the initial patient infomation through **Navicat** or other database management tool. (Recommend **Navicat**). Lastly, set the initial user name and password below. 
```
user = "root"
password = "111"
```
Or you might need to modify the user and password in the **Datebase.java** file, then download the **JDBC** library and set up in the IDE. Lastly, run "**LoginInterface.java**". (*NOT RECOMMEND*)


## Execute
Open "**PMS_jar**" folder, click "**PMS.jar**" file, the *Print* operation will export the "**Patient-Name.txt**" file in the folder. The main method to run the system is in the "**LoginInterface.java**" file. You need to check the "**user.txt**" to get the user name.
Or you can use Command Lind open "**PMS**" folder, compiling *.java* file. (should set the library **JDBC** before). Then run "**LoginInterface.java**".
```
javac *.java
java LoginInterface.java
```


## Check original code
Open "**PMS**" folder, containing all the *.java* file. 
If you want to run in the IDE, you should make sure your project library contains the [JDBC](https://downloads.mysql.com/archives/c-j/). The main method to run the system is in the "**LoginInterface.java**" file.


## Note that!!!
**Make sure set up the database (patients) before running, including initial user and password as mentioned before **PMS.jar**
