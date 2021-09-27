package eus.uni.dam;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author blazquez.asier
 */
public class Model {

	private static Connection connect() throws SQLException {
		// SQLite connection string

		Connection conn = null;

		try {

			//conn = DriverManager.getConnection("jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma", "openpg","openpgpwd");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_asier_blaz", "openpg","openpgpwd");
			System.out.println(conn.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static String imprimirProductos() {
		String sql = "SELECT * FROM public.product_product";
		String s = "";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				
				s= s+ rs.getInt("id")+"\n";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return s;
	}
	
	
	public static ArrayList<Produktua> produktuaToArray(){
		ArrayList<Produktua> produktuak = new ArrayList<Produktua>();
		String sql = "SELECT * FROM public.product_template";
		String s = "";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
			Produktua p1= new Produktua(rs.getInt("id"),rs.getString("name"),rs.getString("description"));
						produktuak.add(p1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return produktuak;
	}


}