# Calcular Salario

El programa calcula el pago que recibirá un empleado, los datos de entrada son obtenidos de un archivo fichero.txt con la información de los empleados, los días y las horas trabajadas.
Por ejemplo 

```
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
```

**Dependencias**

El proyecto trabaja con la dependencia.

Junit. Es un framework para realizar pruebas unitarias.




**Nota**: El proyecto se ejecuta en version java 1.8

**Ejecutar el proyecto en consola**

* Abrir un terminal o cmd.

* Ingresar a la ruta donde se guarda el proyecto por ejemplo : "/home/jlucero/git/Salario/EjercicioSalario"

* Ejecutar el comando para compilar el proyecto y bajar las dependencias.
```
	mvn clean install
```

* Ingresar a la carpeta target
```
	cd target
```
* Ejecutar el comando
```
	java -cp EjercicioSalario-1.jar com.ejercicio.salario.Principal
```
**Ejecutar el proyecto en Eclipse**

* Importar el proyecto.
	* File -> import -> Existing Maven Projects
	* Seleccionar el proyecto previamente descargado "/home/jlucero/git/Salario/EjercicioSalario"
	* Finish
* Limpiar el proyecto Run as -> Maven clean.
* Compilar el proyecto Run as -> Maven install.
* Abrir la clase Principal que se encuentra en el paquete com.ejercicio.salario.
* Ejecutar la clase.

**Entrada**

```
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
JAVIER=MO12:00-14:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
JENNY=TU10:00-12:00,WE12:00-15:00,SA13:00-18:00
PATRICIO=FR02:00-03:00,SA15:00-18:00,SU20:00-22:00
```

**Salida**

```
El monto a pagar RENE is: 215.0 USD
El monto a pagar ASTRID is: 85.0 USD
El monto a pagar JAVIER is: 215.0 USD
El monto a pagar JENNY is: 175.0 USD
El monto a pagar PATRICIO is: 135.0 USD
```


**Contenido**

El proyecto consta de dos paquetes:

com.ejercicio.salario
com.ejercicio.test

**Paquete salario**

Contiene cuatro clases:

* **Horario**. Clase horario para colocar el incio y fin con su respectivo salario.
* **Principal**. Clase principal para obtener el valor total ganado por el empleador.
* **Semana**. Enumeracion de los dias de la semana.
* **ServicioHorario**. Clase servicio para obtener todos los metodos utlizados para el calculo del salario.

**Paquete test**

Contiene tres clases:

* **PruebaHorario**. Clase que realiza la prueba de los horarios.
* **PruebaSemana**. Clase para realizar las pruebas de la enumeracion de la semana.
* **PruebaServicio**. Clase para realizar las pruebas de todos los servicios.
