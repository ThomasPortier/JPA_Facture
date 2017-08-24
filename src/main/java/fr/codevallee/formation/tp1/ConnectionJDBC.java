package fr.codevallee.formation.tp1;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class ConnectionJDBC {
	private Connection conn;

	public ConnectionJDBC() {
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_tp", "root", "6390");
			// MySQL: "jdbc:mysql://hostname:port/databaseName", "username",
			// "password"

			// Step 2: Allocate a 'Statement' object in the Connection
			// Statement stmt = conn.createStatement();) {
			// Step 3: Execute a SQL SELECT query, the query result
			// is returned in a 'ResultSet' object.
			// String strSelect = "select ID_Plat, nom, tarif from Plat";
			// System.out.println("The SQL query is: " + strSelect); // Echo For
			// // debugging
			// System.out.println();
			//
			// ResultSet rset = stmt.executeQuery(strSelect);
			//
			// // Step 4: Process the ResultSet by scrolling the cursor forward
			// via
			// // next().
			// // For each row, retrieve the contents of the cells with
			// // getXxx(columnName).
			// System.out.println("The records selected are:");
			// int rowCount = 0;
			// while (rset.next()) { // Move the cursor to the next row, return
			// // false if no more row
			// int ID_Plat = rset.getInt("ID_Plat");
			// String nom = rset.getString("nom");
			// int tarif = rset.getInt("tarif");
			// System.out.println(ID_Plat + ", " + nom + ", " + tarif);
			// ++rowCount;
			// }
			// System.out.println("Total number of records = " + rowCount);
			//
		}

		catch (SQLException ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
	}

	public Connection getConn() {
		return conn;
	}

}
