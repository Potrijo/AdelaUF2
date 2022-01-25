package com.fran.BaseDeDatos1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaBD3 {
	
 public static void main(String[] args) throws ClassNotFoundException,
	 SQLException {
	 Class.forName("org.postgresql.Driver");
	 String url = "jdbc:postgresql://localhost:5432/datos1";
	 String usuario = "postgres";
	 String password = "1234";
	 Connection con = DriverManager.getConnection(url, usuario, password);
	 Statement statement = con.createStatement();
	 String sentenciaSQL = "INSERT INTO personas VALUES "+
	 "('Persona Tres','pers3@correo.com'), "+
	 "('Persona Cuatro','pers4@correo.com'),"
	 + "('Persona Cinco','pers5@correo.com')";
	 int cantidad = statement.executeUpdate(sentenciaSQL);
	 System.out.println("Datos insertados: " + cantidad);
	 con.close();
 }
 
} 

