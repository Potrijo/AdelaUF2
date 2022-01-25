package com.fran.BaseDeDatos1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbutils.DbUtils;
public class EjemploDBUtils {

public static void main(String[] args){

 Connection con = null;
 Statement st = null;
 ResultSet rs = null;

 try {
	 Class.forName("org.postgresql.Driver");
	 String url = "jdbc:postgresql://localhost:5432/datos1";
	 String usuario = "postgres";
	 String password = "1234";
	 con = DriverManager.getConnection(url, usuario, password);
	 st = con.createStatement();
	 String sentenciaSQL = "SELECT * FROM personas ORDER BY nombre";
	 rs = st.executeQuery(sentenciaSQL);
	 System.out.println("Nombre" + "\t" + "E-mail");
	 System.out.println("-----------------------------------------");
 while (rs.next()) {
	 System.out.println(rs.getString(1) + "\t " + rs.getString(2));
 }
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
