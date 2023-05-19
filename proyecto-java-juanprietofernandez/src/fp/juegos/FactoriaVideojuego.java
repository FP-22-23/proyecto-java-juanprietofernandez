package fp.juegos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import fpUtiles.Checkers;

public class FactoriaVideojuego {
	public static Videojuegos leerVideojuego(String nomfich) {
		Videojuegos res=null;
		try {
			Stream<Videojuego> sv =
			Files.lines(Paths.get(nomfich))
				.skip(1)
				.map(FactoriaVideojuego::parsearVideojuego);
			res = new Videojuegos(sv);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + nomfich);
			e.printStackTrace();
		}
		return res;
	}
	
	private static Videojuego parsearVideojuego(String linea) {
		String[] trozos=linea.split(";");
		Checkers.check("La línea debe contener 9 trozos", trozos.length == 9);	
		Integer rank=Integer.valueOf(trozos[0].trim());
		String name=trozos[1].trim();
		String publisher=trozos[2].trim();
		String platform=trozos[3].trim();
		LocalDate year= LocalDate.parse(trozos[4].trim(), DateTimeFormatter.ofPattern("yyyy"));
		genero genre=genero.valueOf(trozos[5].trim().toUpperCase());
		Float na_sales=Float.valueOf(trozos[6].trim().toUpperCase());
		Float eu_sales=Float.valueOf(trozos[7].trim().toUpperCase());
		Float jp_sales=Float.valueOf(trozos[7].trim().toUpperCase());
		Float other_sales=Float.valueOf(trozos[8].trim().toUpperCase());
		Float global_sales=Float.valueOf(trozos[9].trim().toUpperCase());
		
		return new Videojuego(rank, name, publisher, platform, year, genre, na_sales, 
				eu_sales, jp_sales, other_sales, global_sales, null);
	}
}

