<h2>jdbc connection</h2>
Java Database Connectivity (JDBC) is a Java API that manages connecting and executing queries with databases. It is a part of the Java Standard Edition platform, from Oracle Corporation. JDBC allows you to connect to a database, execute SQL queries, and retrieve results.

<h3>Key Components of JDBC</h3>
<h4>JDBC Drivers:</h4> JDBC drivers are required to establish communication with a database. There are four types of JDBC drivers:

Type 1: JDBC-ODBC Bridge Driver</br>
Type 2: Native-API Driver</br>
Type 3: Network Protocol Driver</br>
Type 4: Thin Driver</br>
<h4>JDBC API:</h4> Provides various classes and interfaces to connect to databases and execute SQL queries.

</h4>Core Interfaces and Classes</h4>
DriverManager: Manages a list of database drivers.</br>
Connection: Represents a connection with a specific database.</br>
Statement: Used for executing a static SQL statement and returning the results it produces.</br>
PreparedStatement: A SQL statement that is precompiled and stored in a PreparedStatement object, which can then be used to execute this statement multiple times.</br>
ResultSet: Represents the result set of a query.</br>
Steps to Establish a JDBC Connection
