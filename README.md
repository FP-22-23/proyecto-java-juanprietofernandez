# proyecto-java-juanprietofernandez
proyecto-java-juanprietofernandez created by GitHub Classroom
Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)

Autor/a: Juan Prieto Fernandez



Estructura de las carpetas del proyecto
•/src: Directorio con el código fuente.
    •fp.juegos: Paquete que contiene los tipos del proyecto.
    •fp.juego.test: Paquete que contiene las clases de test del proyecto.
    •fp.utiles: Paquete que contiene las clases de utilidad. 
•/data: Contiene el dataset del proyecto.
    ◦videogameglobalsales.csv: Archivo csv que contiene datos de diferentes partidas de ajedrez.

Estructura del dataset

El dataset original videogameglobalsales Dataset se puede obtener de la URL https://www.kaggle.com/datasets/prashant111/video-games-global-sales-in-volume. Originalmente tiene 16 columnas y cada fila contiene datos sobre una partida de ajedrez jugada en la plataforma lichess.com. El dataset usado en este proyecto tiene 11 columna. A continuación se describen las 11 columnas del dataset:
-rank: integer que representa la posicion en el ranking de ventas del juego  
-name: string en el que aparece el nombre del juego 
-platform: string en el que aparece el nombre de la consola del juego 
-year: date en el que aparace el año de lanzamiento del juego
-genre: propiedad enumerada sobre el genero del juego
-publisher: string en el que aparece el nombre de la desarrolladora del juego 
-na_sales: float que representa las ventas en EEUU
-eu_sales: float que representa las ventas en Europa
-jp_sales: float que representa las ventas en Japon
-other_sales: float que representa las ventas en otros paises
-global_sales: float que representa las ventas mundiales
Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:
-public Videojuego(Integer rank, String name, String publisher, String platform, LocalDate year,
	genero genre, Float na_sales, Float eu_sales, Float jp_sales, Float other_sales, Float global_sales,
	List<Float> sales): la parte de los this.
-List<Float> sales: lista con todas las ventas [el constructor de la lista empieza con public Videojuego()]
-Videojuego(Integer rank, Float na_sales, Float eu_sales, Float jp_sales, Float other_sales, Float global_sales): los checkers
-String getMejoresGeneros: return El identificador del genero del videojuego, si devuelve null el genero no se corresponde a ninguno de los que he especificado en la funcion
-String getMejoresGeneros():return El identificador del genero del videojuego, si devuelve null el genero no se corresponde a ninguno de los que he especificado en la funcion
-String toString(): return unn string con el nombre, desarrolladora, consola y genero del viedojuego
-String getDiferenciaJaponEEUU(): return La diferencia de ventas entre EEUU y japon
-Float getPorcentajeJapon():return el porcentaje de ventas de japon
-int compareTo(Videojuego p): return las partidas se ordenan por posicion en el ranking, ventas globales y año
  
  FactoriaVideojuego  una factoría, con sus métodos correspondientes:
    -Método que recibe como parámetro una cadena con el formato de las líneas del fichero CSV, y devuelve un objeto del tipo a partir de esa cadena.
    -Método que recibe como parámetro una cadena que contiene el nombre y ruta del fichero CSV, y devuelve una lista de objetos del tipo.
  
  Funciones que se encuentran en Videojuegos:
  
  -public Integer calcularNumeroVideojuegosConsola(String platform): Contador de juegos por consola
  -public Videojuego obtenerVideojuegoMasVentasJP(): Búsqueda de máximas ventas en japon
  -public Set<String> calcularNombrePorDesarrolladora(String publisher): Cálculo de conjunto de valores de (nombre) la columna (desarrolladora)
  -public Collection<Videojuego> obtenerVideojuegoPosicionRank(Integer minimoRango, Integer maximoRango): Filtrado por posicion en el ranking
  -public Map<String, Set<String>> calcularJuegosPorDesarrolladora():Agrupación de juegos por desarrolladora
  -public Double getPromedioVentasJaponPorGeneroMedias(genero genre): media de ventas en japn por genero
  -public SortedSet<Videojuego> getNJuegosMasAntiguos(LocalDate anyo, Integer n): método de agrupación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores una colección
  -public Map<String, Double> getPorcentajesVentasEuropaJuego(String nombre, Integer ventaseu):Un método de acumulación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores el conteo o la suma de los objetos del tipo base almacenados en el contenedor que tienen como valor esa propiedad.
  -public Boolean existeCompañiaGenero(String compañia): métodos que trabajan sobre el dataset usando stream que comprueba que existe una propiedad
  -public Double mdeiaRankingEnPlataformas(Set<String> consolas): métodos que trabajan sobre el dataset usando stream que usa la media
  -public SortedSet<String> getPlataformasCompañia(String compañia): métodos que trabajan sobre el dataset usando stream que realiza unaselección con filtrado
  -public Videojuego getCompañiaMasVentaGenero(String compañia): métodos que trabajan sobre el dataset usando stream que realiza un máximo con filtrado.
  -public Stream<Object> getRangoTotalEmpresa(String empresa):  métodos que trabajan sobre el dataset usando stream que realiza una seleccion con filtrado y ordenacion
  -public Map<String, Set<String>> getNombrePorCompañia(): Uno de los métodos (4) o (5) implementados en la entrega 2, pero con streams: Un método de agrupación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores una colección (List, Set, SortedSet) de objetos del tipo base.
  -public Map<String, Integer> getNumeroVideojuegosGeneroCompañia(): n método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.
  -public SortedSet<Videojuego> getNVideojuegosMenosVentasJapon(Integer anyo, Integer n): Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor.
  -public SortedMap<String, Object> getTopNGeneroPorAnyo(Integer m): Un método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, y los valores sean listas con los n mejores o peores elementos que comparten el valor de ese atributo (o función sobre el atributo).
  -public Map<LocalDate, List<String>> getNprimeraJUegosFecha(Integer n): Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map.
  
  
  
  
  
  
  
  
  
  
