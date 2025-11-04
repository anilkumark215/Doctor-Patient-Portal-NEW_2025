// package com.hms.db;

// import java.sql.Connection;
// import java.sql.DriverManager;

// public class DBConnection {

// 	private static Connection conn;
	
// 	public static Connection getConn() {
		
// 		try {
			
// 			//step:1 for connection - load the driver class 
// 			Class.forName("com.mysql.cj.jdbc.Driver");
			
// 			//step:2- create a connection
// 			// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","admin");

// 			conn = DriverManager.getConnection(
//             "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12805847",
//             "sql12805847",
//             "ZYRYhvSFHt"
//              );

			
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 			// TODO: handle exception
// 		}
		
// 		return conn;
// 	}
// }

// 



package com.hms.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                // Load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Read environment variables (Render dashboard)
                String url = System.getenv("DB_URL");
                String username = System.getenv("DB_USERNAME");
                String password = System.getenv("DB_PASSWORD");

                // Connect
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("✅ Database connected successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Database connection failed!");
        }
        return conn;
    }
}
