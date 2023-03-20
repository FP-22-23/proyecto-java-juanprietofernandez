package fp.juegos;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fpUtiles.Checkers;

public class Videojuego {
	private Integer rank;
	private String name, publisher, platform;
	private LocalDate year;
	private genero genre;
	private Float na_sales, eu_sales, jp_sales, other_sales, global_sales;
	private List<Float> sales;
	
	//constructor de lista
	public Videojuego() {
		this.sales = new ArrayList<Float>();
	}
	public Videojuego(List<Float> sales) {
		this.sales = sales;
	}
	public List<Float> getJugadores(){
		return new ArrayList<Float>(this.sales);
	}
	public void anadirJugador( Float na_sales, Float eu_sales, Float jp_sales, Float other_sales, Float global_sales) {
		this.sales = List.of(na_sales, eu_sales, jp_sales, other_sales, global_sales);
	}
	
	public Videojuego(Integer rank, String name, String publisher, String platform, LocalDate year,
	genero genre, Float na_sales, Float eu_sales, Float jp_sales, Float other_sales, Float global_sales,
	List<Float> sales) {
		
		this.rank = rank;
		this.name = name;
		this.publisher = publisher;
		this.platform = platform;
		this.year = year;
		this.genre = genre;
		this.na_sales = na_sales;
		this.eu_sales = eu_sales;
		this.jp_sales = jp_sales;
		this.other_sales = other_sales;
		this.global_sales = global_sales;
	}
	//check
	
	public Videojuego(Integer rank, Float na_sales, Float eu_sales, Float jp_sales, Float other_sales, Float global_sales) {
		Checkers.check("las ventas de una region no pueden ser mayores que las golbales",
				na_sales <= global_sales && eu_sales <= global_sales && jp_sales <= global_sales && other_sales<= global_sales);
		Checkers.check("No hay puesto 0 en el ranking " + rank, rank > 0);
	}
		
	 // @return El identificador del genero del videojuego, si devuelve null el genero no se
	 //  corresponde a ninguno de los que he especificado en la funcion
	public String getMejoresGeneros() {
		String res = null;
		if (genre.equals(genero.ROLE_PLAYING)) {
			res = "RPG";
		} else if (genre.equals(genero.FIGHTING)) {
			res = "Lucha";
		}
		 else if (genre.equals(genero.PLATFORM)) {
				res = "Plataforma";
			}
		return res;
	}
	// return unn string con el nombre, desarrolladora, consola y genero del viedojuego
	public String toString() {
		return "Juego [nombre=" + name + ", desarrolladora=" + publisher + ", consola=" +
		platform + ", genero= " + genre + "]";
		 }
	
	// return La diferencia de ventas entre EEUU y japon
	public String getDiferenciaJaponEEUU() {
		float dif;
		String res = null;
		dif = (na_sales - jp_sales);
		if (dif < 0) {
			res = "japon tiene mas ventas que EEUU";
		} 
		else if (dif > 0){
			res = "EEUU tiene mas ventas que japon";
			}
		return res;
		
	}
	// return el porcentaje de ventas de japon
		public Float getPorcentajeJapon() {
			return(jp_sales*100.0f/global_sales);
		}
		
		
		/**
		 * Las partidas se ordenan por posicion en el ranking, ventas globales y año
		 */
		public int compareTo(Videojuego p) {
			int r;
			r = getRank().compareTo(p.getRank());
			if (r == 0) {
				r = getGlobal_sales().compareTo(p.getGlobal_sales());
				if (r == 0) {
					r = getYear().compareTo(p.getYear());
				}
			}
			return r;
		}
	
	
	 public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public LocalDate getYear() {
		return year;
	}
	public void setYear(LocalDate year) {
		this.year = year;
	}
	public genero getGenre() {
		return genre;
	}
	public void setGenre(genero genre) {
		this.genre = genre;
	}
	public Float getNa_sales() {
		return na_sales;
	}
	public void setNa_sales(Float na_sales) {
		this.na_sales = na_sales;
	}
	public Float getEu_sales() {
		return eu_sales;
	}
	public void setEu_sales(Float eu_sales) {
		this.eu_sales = eu_sales;
	}
	public Float getJp_sales() {
		return jp_sales;
	}
	public void setJp_sales(Float jp_sales) {
		this.jp_sales = jp_sales;
	}
	public Float getOther_sales() {
		return other_sales;
	}
	public void setOther_sales(Float other_sales) {
		this.other_sales = other_sales;
	}
	public Float getGlobal_sales() {
		return global_sales;
	}
	public void setGlobal_sales(Float global_sales) {
		this.global_sales = global_sales;
	}
	public List<Float> getSales() {
		return sales;
	}
	public void setSales(List<Float> sales) {
		this.sales = sales;
	}
		
	
	 
	
	
	
	
}