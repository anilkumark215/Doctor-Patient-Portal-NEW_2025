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

package com.hms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {

    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                // Load db.properties from resources folder
                Properties props = new Properties();
                InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");

                if (input == null) {
                    throw new RuntimeException("⚠️ db.properties file not found in resources folder!");
                }

                props.load(input);

                String url = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");

                // Load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish connection
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("✅ Database connected successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
