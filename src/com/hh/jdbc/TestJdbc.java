package com.hh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";

		try {
			System.out.println("Conectando a la base de datos: " + jdbcUrl);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Conexion exitosa!!");

			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
