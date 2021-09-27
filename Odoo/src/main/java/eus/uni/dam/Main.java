package eus.uni.dam;
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

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---------Prueba----------");
		toFile(Model.produktuaToArray());
		
	}
	
	
	
public static void toFile(ArrayList<Produktua> produktuak) {
		String filename = "FileOuta.csv";
		PrintWriter outputStream = null;

		try {
			ClassPathResource fileResource = new ClassPathResource(filename);
			outputStream = new PrintWriter(new FileWriter(fileResource.getFile()));

			String l;
			for (Produktua p : produktuak) {
				outputStream.println(p.getId() + "," + p.getName() + "," + p.getDescription());
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
