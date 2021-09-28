package eus.uni.dam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository
public class ProduktuaDaoJbdc implements ProduktuaDao {
	
	public List<Produktua> produktuak= new ArrayList<>();
	
	
	
	public ProduktuaDaoJbdc() {
	}

	
	public Collection<Produktua> getProduktuak() {
		return produktuak;
	};

	/** Datu-basetik datuak berreskuratu eta memoriako zerrendan kargatu. 
	 *  
	 */
	
	@PostConstruct
	public void init() {
		this.produktuaToArray(produktuak);
	}
	
	
	
	public Collection<Produktua> findAll() {
		return produktuak;
	}

	/** DBan INSERT bat egin, eta dena ondo balego, memorian be egin insert-a.
	 * 
	 * @param pelicula
	 */
	public void insert(Produktua produktua) {
		// DBan insert-a
		produktuak.add(produktua);
	};

	/** DBan UPDATE bat egin, eta dena ondo balego, memorian be...
	 *  
	 * @param pelicula
	 */
	public void edit(Produktua produktua) {
		//TO-DO
	};
	
	/**
	 * DBan DELETE bat egin, eta dena ondo balego, memorian be 
	 * @param id
	 */	
	public void delete(long id) {
		//TO-DO
	};

	/** Momentuoro, aldaketak, bai memorian, bai dban bertan egin izan ditugu,
	 *  beraz, ez da beharrezkoa orain zerrendako datuak dban berriz gordetzea. 
	 *  (DB-an beste norbaitek, beste aplikazio batetik 
	 *  eginiko aldaketez ez gara enteratzen. Kontuz)   
	 * 
	 */
	@PreDestroy
	public void destroy() {
		
	}
	
	
	//connect
	private Connection connect() throws SQLException {
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


	//insertar productos al arrayList
	
	public void produktuaToArray(List<Produktua> produktuak){
		String sql = "SELECT * FROM public.product_template";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
			Produktua p1= new Produktua(rs.getInt("id"),rs.getString("name"),rs.getString("description"));
			produktuak.add(p1);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}


}
