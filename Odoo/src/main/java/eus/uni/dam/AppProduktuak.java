package eus.uni.dam;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AppProduktuak {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);


		ProduktuaDao produktuaDao = appContext.getBean(ProduktuaDaoJbdc.class);
		System.out.println("Ditugun Produktuak:");
		for(Produktua prod:produktuaDao.getProduktuak()) {
			System.out.println(prod);
	    }	
		
		/*Pelicula peliBerria = new Pelicula(11,"Gallipolli","1979",null);
		peliDao.insert(peliBerria);
		
		System.out.println("BUKATZERAKOAN:");
		for(Pro peli:peliDao.getPeliculas()) {
			System.out.println(peli);
	    }*/
		
		//postdestroy
		((AnnotationConfigApplicationContext) appContext).close();

	}

}
