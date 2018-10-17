----------------------
Problem Statement
----------------------

The system will be Initialised with an input file in CSV format containing a list of transaction records.

Once initialised, the system should report the total number of transactions and the average transaction value for a specific merchant in a specific date range.

Another requirement is that, if a transaction has a reversing transaction, then it should not be included in the computed statistics, even if the reversing transaction is outside of the requested date range.

----------------------
Assumptions
----------------------

For the sake of simplicity,  Transaction records are assumed to be listed in correct time order.
The input file is well formed and is not missing data.
Java version is Java 8 or above.
dd/MM/yyyy HH:mm:ss is the format of Date time provided.

----------------------
How to compile and run
----------------------

Download a copy from the Github repository.
Open the terminal/command prompt and change directory to the Project Directory 
for e.g. if your project is downloads into Downloads the following 
will be the path of the Project Directory for a mac
cd /Users/homemac(User name)/Downloads/Hoolah(project name)

Compile the project with: javac -d bin/ -cp src src/com/view/face/TransactionAnalyser.java
Run the project with : java -cp bin com/view/face/TransactionAnalyser

You will be prompted from the following. Sample inputs are provided

Path of csv file: 

/Users/homemac/Downloads/tran.csv 

from Date: 
20/08/2018 12:00:00

to Date: 
20/08/2018 13:00:00

Merchant: 
Kwik-E-Mart


 
