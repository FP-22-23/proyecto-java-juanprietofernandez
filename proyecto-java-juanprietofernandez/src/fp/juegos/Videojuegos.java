package fp.juegos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.TreeMap
import fpUtiles.Checkers;

public class Videojuegos {
	private List<Videojuego> videojuegos;
	
	
	//Constructores
	public Videojuegos() {
		this.videojuegos = new LinkedList<Videojuego>();
	}
	
	public Videojuegos(Stream<Videojuego> videojuegos) {
		this.videojuegos = videojuegos.collect(Collectors.toList());
	}
	

	// Métodos

	public void añadirVideojuego(Videojuego videojuego) {
		this.videojuegos.add(videojuego);
	}
	
	// Contador de juegos por consola
    public Integer calcularNumeroVideojuegosConsola(String platform) {
        Long res=  videojuegos.stream()
                          .filter(videojuego -> videojuego.getPlatform().equals(platform))
                          .count();
        return res.intValue();
    }

	
	// Búsqueda de máximas ventas en japon
	public Videojuego obtenerVideojuegoMasVentasJP() {
		return videojuegos.stream()
				    .max(Comparator.comparing(Videojuego::getJp_sales))
				    .get();
	}
	
	
	// Cálculo de conjunto de valores de (nombre) la columna (desarrolladora)
	public Set<String> calcularNombrePorDesarrolladora(String publisher){
		return videojuegos.stream()
                .filter(videojuego -> videojuego.getPublisher().equals(publisher))
                .map(videojuego -> videojuego.getName())
                .collect(Collectors.toSet());

	}
	
	// Filtrado por posicion en el ranking
	public Collection<Videojuego> obtenerVideojuegoPosicionRank(Integer minimoRango, Integer maximoRango){
		Checkers.check("El límite inferior debe ser menor o igual que el superior", minimoRango<=maximoRango);
		return videojuegos.stream()
				    .filter(videojuego -> minimoRango <= videojuego.getRank() 
				    && maximoRango>=videojuego.getRank())
				    .collect(Collectors.toSet());
	}
		
	// Agrupación de juegos por desarrolladora
	public Map<String, Set<String>> calcularJuegosPorDesarrolladora(){
		return videojuegos.stream()
			    .collect(Collectors.groupingBy(
			    		Videojuego::getPublisher, 
			        		  Collectors.mapping(Videojuego::getName, Collectors.toSet())));
	}
	

	
	/*
	 * Métodos de la clase Object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((videojuegos == null) ? 0 : videojuegos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuegos other = (Videojuegos) obj;
		if (videojuegos == null) {
			if (other.videojuegos != null)
				return false;
		} else if (!videojuegos.equals(other.videojuegos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Videojuegos [videojuegos=" + videojuegos + "]";
	}

	public static Stream<Videojuego> stream() {
		// TODO Auto-generated method stub
		return null;
	}
	//existe
	public Boolean hayCompañiaConMasNVentas(Integer n) {
		Predicate<Videojuego> filtro = 
				p-> p.getPublisher()!= null;
		Map<String, Long> mc = getGlobal_sales(filtro);
		Boolean res = false;
		//Tratamiento existe
		for (Long num: mc.values()) {
			if (num>n) {
				res = true;
				break;
			}
		}
		
		return res;
	}


	private Map<String, Long> getGlobal_sales(Predicate<Videojuego> filtro) {
		// TODO Auto-generated method stub
		return null;
	}


	//media
	
	public Double getPromedioVentasJaponPorGeneroMedias(genero genre) {
		Double res = 0.0;
		Double suma =0.0;
		Integer cont = 0;
		for (Videojuego p: videojuegos) {
			if (p.getGenre().equals(genre)) {
				suma+= p.getJp_sales() / p.getGlobal_sales();
				cont++;
			}
		if (cont>0) {
			res = suma/cont;
			}
		}
		return res;
	}
	
	//sorted set
	public SortedSet<Videojuego> getNJuegosMasAntiguos(LocalDate anyo, Integer n){
		@SuppressWarnings("unchecked")
		Comparator<Videojuego> c = Comparator.comparing(Videojuego::getYear)
										.thenComparingInt((ToIntFunction<? super Videojuego>) Comparator.naturalOrder());
		
		List<Videojuego> filtradas = new ArrayList<Videojuego>();
		for (Videojuego p: videojuegos) {
			if (p.getYear() == anyo) {
				filtradas.add(p);
			}
		}
		Collections.sort(filtradas, Comparator.comparing(Videojuego::getYear));
		SortedSet<Videojuego> ss = new TreeSet<Videojuego>(c);
		ss.addAll(filtradas.subList(0,n));
		return ss;
	}

	
	//map
	
	public Map<String, Double> getPorcentajesVentasEuropaJuego(String nombre, Integer ventaseu){
		Checkers.check("Partidas.getPorcentajesSiguienteMovimiento:numeroMovimientos debe ser mayor que 0", ventaseu>0);

		Map<String, Long> m = contarVentas(nombre, ventaseu);
		Long totalMovimientos = sumarLongs(m.values());
		Map<String, Double> res = new HashMap<String, Double>();
		for (Map.Entry<String, Long> entry: m.entrySet()) {
			res.put(entry.getKey(), 100.*entry.getValue()/totalMovimientos);
		}
		return  res;
	}
		
		private Long sumarLongs(Collection<Long> numeros) {
			Long res = 0L;
			for (Long n: numeros) {
				res+=n;
			}
			return res;
		}

	
		private Map<String, Long> contarVentas(String nombre, Integer ventaseu){
		
			Map<String, Long> res = new HashMap<String, Long>();
			for (Videojuego p: videojuegos) {
				if (p.getEu_sales() > ventaseu 
					   && p.getName().equals(nombre)) {
					String clave = p.getName();
					if (res.containsKey(clave)) {
						res.put(clave, res.get(clave));
					}else {
						res.put(clave, 1L);
					}
				}
			}
			return res;
		}

		
			//BLOQUE1

		//EXISTE

		public Boolean existeCompañiaGenero(String compañia) {
			return Videojuego.stream().filter(
					v->v.getGenre().equals(genero.PUZZLE))
					.anyMatch(v-> v.getPublisher().equals(compañia));
			
		}
		
		//media
		public Double mdeiaRankingEnPlataformas(Set<String> consolas) {
			return Videojuego.stream().filter(c -> c.getRank()!=null&& consolas.contains(c.getPlatform()))
					.mapToInt(Videojuego::getRank).average().getAsDouble();
			
		}

		
		//selección con filtrado
		
		public SortedSet<String> getPlataformasCompañia(String compañia){
			return Videojuego.stream().filter(v->v.getPublisher().equals(compañia)).map(Videojuego::getPlatform)
					.collect(Collectors.toCollection(TreeSet::new));
		}
		
		//máximo/mínimo con filtrado.
		
		@SuppressWarnings("unchecked")
		public Videojuego getCompañiaMasVentaGenero(String compañia) {
			return Videojuego.stream().filter(v->v.getGenre().equals(genero.SPORTS)
					&& v.getPublisher().equals(compañia))
					.min(Comparator.comparing(Videojuego::getGlobal_sales)
							.thenComparingInt((ToIntFunction<? super Videojuego>) Comparator.naturalOrder())).orElse(null);
		}
		
		//seleccion con filtrado y ordenacion
		public Stream<Object> getRangoTotalEmpresa(String empresa) {
			Predicate<Videojuego> pred = p->p.getPlatform().equals(empresa) ||
					   p.getPublisher().equals(empresa);
					
			return Videojuego.stream()
					.filter(pred)
					.map(p->p.getRank());
		}

		
		//Uno de los métodos (4) o (5) implementados en la entrega 2, pero con streams: Un método de agrupación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores una colección (List, Set, SortedSet) de objetos del tipo base.
		public Map<String, Set<String>> getNombrePorCompañia() {
			return Videojuego.stream().collect(Collectors.groupingBy(Videojuego::getPublisher, Collectors.mapping(
					Videojuego::getName, Collectors.toSet())));
		}
		
		//Un método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.
		public Map<String, Integer> getNumeroVideojuegosGeneroCompañia(){
			return Videojuego.stream().filter(v-> !v.getGenre().equals(genero.PUZZLE))
					.collect(Collectors.groupingBy(Videojuego::getPublisher,
							Collectors.collectingAndThen(Collectors.counting(), l->l.intValue())));
		}
		
		//Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor.
		public SortedSet<Videojuego> getNVideojuegosMenosVentasJapon(Integer anyo, Integer n){
			@SuppressWarnings("unchecked")
			Comparator<Videojuego> c = Comparator.comparing(Videojuego::getJp_sales).thenComparingInt((ToIntFunction<? super Videojuego>) Comparator.naturalOrder());
			
			return Videojuego.stream()
					.filter(p->p.getYear().getYear() == anyo)
					.sorted(Comparator.comparing(Videojuego::getGlobal_sales))
					.limit(n).collect(Collectors.toCollection(()->new TreeSet<Videojuego>(c)));
		}
		
		//Un método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, y los valores sean listas con los n mejores o peores elementos que comparten el valor de ese atributo (o función sobre el atributo).
		@SuppressWarnings("unchecked")
		public SortedMap<String, Object> getTopNGeneroPorAnyo(Integer m){
		return Videojuegos.stream().collect(Collectors.groupingBy(Videojuegos::getYear, 
				TreeMap::new, Collectors.collectingAndThen(Collectors.toList(), x->x.stream().sorted()
						.limit(m).toList())));
		
		private Float meani(List<Object> conj, Integer m) {
			return 5f;
		}
		private static void Integer(Collection<Videojuego> col) {
			@SuppressWarnings("unchecked")
			Comparator<Videojuego>cmp = Comparator.comparing(Videojuego::getRank)
					.thenComparingInt((ToIntFunction<? super Videojuego>) Comparator.naturalOrder()).reversed();
		}
		
		//Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map.
		
		public Map<LocalDate, List<String>> getNprimeraJUegosFecha(Integer n){
			return Videojuego.stream().collect(Collectors.groupingBy(Videojuego::getYear,
					Collectors.collectingAndThen(Collectors.toList(), l->fAUX(l,n))));
		}
		private static List<String> fAUX(List<Videojuego> l, Integer n) {
			return l.stream().sorted(Comparator.comparing(Videojuego::getRank))
					.limit(n).map(Videojuego::getName).collect(Collectors.toList());
		}

}



