package fp.juego.test;


import java.time.LocalDate;
import java.util.List;


import fp.juegos.Videojuego;
import fp.juegos.genero;

public class Videojuego_test {
	
	
	
	public static void mostrarVideojuego(Videojuego v) {
		System.out.println(v);
		System.out.println("getPorcentajeJapon: "+v.getPorcentajeJapon());
		System.out.println("compareTo: "+v.compareTo(v));
		System.out.println("getDiferenciaJaponEEUU: "+v.getDiferenciaJaponEEUU());
		System.out.println("toString: "+v.toString());
		System.out.println("getMejoresGeneros: "+v.getMejoresGeneros());
	}
	public static void testConstructor1(Integer rank, String name, String publisher, String platform, LocalDate year,
			genero genre, Float na_sales, Float eu_sales, Float jp_sales, Float other_sales, Float global_sales,
			List<Float> sales) {
		
		try {
			Videojuego p = new Videojuego(rank, name, publisher, platform, year,
					genre, na_sales, eu_sales,jp_sales,other_sales, global_sales,
					sales);	
			mostrarVideojuego(p);
		} catch(IllegalArgumentException e) {
			System.out.println("Excepci�n capturada:\n   " + e);	
		} catch (Exception e) {
			System.out.println("Excepci�n inesperada:\n   " + e);
		}
	}
}
