package com.fran.BaseDeDatos1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbutils.DbUtils;
public class AddDeporte {

	public static void main(String[] args){
		
		 Connection con = null;
		 Statement st = null;
		 ResultSet rs = null;
		
		 try {
			 Class.forName("org.postgresql.Driver");
			 String url = "jdbc:postgresql://localhost:5432/DEPORTES";
			 String usuario = "postgres";
			 String password = "1234";
			 con = DriverManager.getConnection(url, usuario, password);
			 st = con.createStatement();
			 String sentenciaSQL = "INSERT INTO deportes VALUES((SELECT MAX(cod)+1 from deportes), 'Petanka')";
			 int cantidad = st.executeUpdate(sentenciaSQL);
			 System.out.println("Datos insertados: " + cantidad);
		 }
		 catch (ClassNotFoundException ce) {
			 System.out.println("PostgreSQL no accesible");
		 }
		 catch (SQLException se) {
			 System.out.println("Fallo en la Select");
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 finally {
			 DbUtils.closeQuietly(rs);
			 DbUtils.closeQuietly(st);
			 DbUtils.closeQuietly(con);
		 }
	 }
} 
