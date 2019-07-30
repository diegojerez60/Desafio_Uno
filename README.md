Solucion Desafío 1: Periodos perdidos - nivel 3

Este proyecto expone un API REST que entrega la siguiente información:

id: identificador fechaCreacion: Fecha de inicio de la secuencia fechaFin: Fecha de fin de la secuencia fechas: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin” 
fechasFaltantes: Lista de fechas que no están contempladas por el rango de fechas

Ejemplo.

{
    "id": 1,
    "fechaCreacion": "2001-06-01",
    "fechaFin": "2016-11-01",
    "fechas": [
        "2001-06-01",
        "2001-08-01"],
	"fechasFaltantes": [
       "2001-07-01",
       "2001-09-01"]
}

Nota: El formato de las fechas es yyyy-MM-dd El servicio entrega 1 periodos, el periodo contiene una fecha inicial una fecha final, una lista fechas y una lista fechas faltantes.

Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado. Ingresar al directorio springboot-servicio-desafio-1 ejecutar el siguiente comando maven

mvn package 
Luego de compilar el proyecto ingresar al directorio target ejecutar el siguiente comando java

java -jar springboot-servicio-desafio-1-1.0.jar 
Nota: Debe estar disponible el puerto 8091 en el PC donde se ejecute esta API


Visualizar Documentación y consumir la API
La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://127.0.0.1:8091/swagger-ui.html

Modificacion de ruta del servicio Generador Datos Desafio

Si deseas modificar la ruta ip:puerto del servicio Generador Datos Desafio, debes modificar el valor de la variable dir.service en el application.properties de este proyecto
por defecto busca la informacion en http://localhost:8080/periodos/api