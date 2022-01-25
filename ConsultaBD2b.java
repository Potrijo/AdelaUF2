package com.fran.BaseDeDatos1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaBD2b {
	 public static void main(String[] args) {
		 try {
		 Class.forName("org.postgresql.Driver");
		 String url = "jdbc:postgresql://localhost:5432/datos1";
		 String usuario = "postgres";
		 String password = "1234";
		 Connection con = DriverManager.getConnection(
		 url, usuario, password);
		 Statement statement = con.createStatement();
		 String sentenciaSQL = "CREATE TABLE personas2 ( "+
		 "codigo VARCHAR(4) PRIMARY KEY, "+
		 "nombre VARCHAR(50), "+
		 "email VARCHAR(40) "+
		 ");";
		 statement.executeUpdate(sentenciaSQL);
		 con.close();
		 }
		 catch (ClassNotFoundException ce) { ce.printStackTrace(); }
		 catch (SQLException se) { se.printStackTrace(); }
		 System.out.println("Terminado!");
	 } 
}

