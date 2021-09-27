import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---------Prueba----------");
	
	System.out.println(Model.imprimirProductos());
	System.out.println("fin");
	}
	
	
	
	public void toFile() {
		String filename = "FileOuta.csv";
		PrintWriter outputStream = null;

		try {
			ClassPathResource fileResource = new ClassPathResource(filename);
			outputStream = new PrintWriter(new FileWriter(fileResource.getFile()));

			String l;
			for (Pelicula p : peliculas) {
				outputStream.println(p.getId() + "," + p.getTitulo() + "," + p.getAnyo());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (outputStream != null) {
				outputStream.close();
				System.out.println("Datuak gorde dira " + filename +" fitxategian.");
			}
		}
	}

}
