package com.example.aemacc13.cloudclock;

/**
 * Created by aemacc13 on 5/10/2017.
 */

import java.sql.*;

public class DBConnection {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    //  Database credentials
    static final String USER = "username";
    static final String PASS = "password";

    Connection conn = null;
    Statement stmt = null;



}
