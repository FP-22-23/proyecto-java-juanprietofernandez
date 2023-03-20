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