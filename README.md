# Rentacar

Esta es una aplicación que proporciona una REST API para administrar vehiculos y sus servicios de una empresa de alquiler de autos.

##Estructura del proyecto:
```
src
├───main
│   ├───java
│   │   └───com
│   │       └───myhotel
│   │           └───rentacar
│   │               ├───domain
│   │               │   ├───model
│   │               │   ├───repository
│   │               │   └───usecase
│   │               │       ├───dto
│   │               │       ├───enums
│   │               │       ├───impl
│   │               │       └───mapper
│   │               └───infraestructure
│   │                   ├───handler
│   │                   └───rest
│   └───resources
│       ├───static
│       └───templates
└───test
    └───java
        └───com
            └───myhotel
                └───rentacar
                    ├───controller
                    └───service
```
## Stack Tecnológico

* Java 11 JDK.
* [Apache Maven](https://maven.apache.org/) 3.8.x en adelante.
* [Spring boot](https://spring.io/projects/spring-boot) - Framework de java
* [Hibernate](https://hibernate.org/) - ORM. Mapear tablas a clases de Java
* [Junit](https://junit.org/junit5/docs/current/user-guide/) - Tests y Test de integración.
* [Lombok](https://projectlombok.org/) - Anotaciones para reducir codigo (setters, getters,etc)
* [MapStruc](https://mapstruct.org/) - Mapeo entre DTOs y Entities
* [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/) - Utilides auxiliares
* [MySQL](https://www.mysql.com/) - Base de datos


## Prerequisitos

###MySQL Server 8.x
Download: https://dev.mysql.com/downloads/mysql/

####Dump: 
**https://drive.google.com/file/d/18qqpHcaFmg9dmZTGjRBTqtZ7gxyBWG0P/view?usp=sharing**

###Java 11 JDK
Oracle jdk: https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html

Verificar instalación:

      $ java -version
      java version "11.0.12" 2021-07-20 LTS
      Java(TM) SE Runtime Environment 18.9 (build 11.0.12+8-LTS-237)
      Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.12+8-LTS-237, mixed mode)

      $ javac -version
      javac 11.0.12


### Apache Maven
Maven 3.8.4+
Download: https://archive.apache.org/dist/maven/maven-3/3.8.4/binaries/

Instalación: https://www.baeldung.com/install-maven-on-windows-linux-mac

Verificar instalación:

      $ mvn -v
      Maven home: C:\apache-maven-3.8.4
      Java version: 11.0.12, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.0.12
      Default locale: es_AR, platform encoding: Cp1252
      OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"



### Postman
Download: https://www.postman.com/downloads/

Instalación: https://learning.postman.com/docs/getting-started/installation-and-updates/

## Install
Clonar el repositorio: https://github.com/lucasrobert/Rentacar.git

## Build
Mediante linea de comando hacemos un build del proyecto maven.
 
    $ mvn clean install -DskipTests

Si no tenemos maven instalado podemos utilizar maven "incorporado" en el proyecto.

    $ ./mvnw clean install -DskipTests

## Run the app

Ir a la clase com.myhotel.rentacar.RentacarApplication, hacer click con el botón derecho y seleccionar "Run RentacarApplication.main().."

## Run the tests

**_SOLO SE CREARON ALGUNOS TEST A MODO DE EJEMPLO_**

Mediante linea de comando hacemos un build del proyecto maven.

    $ mvn clean install

O se pueden ejecutar directamente ejecutando

Mediante linea de comando hacemos un build del proyecto maven.

    $ mvn test

# Endpoints

## 1. AUTOMOVIL

### “POST /v1/automoviles”
Crear automóvil

- **URL**: http://localhost:8080/v1/automoviles
    
- **BODY**
```
{
    "tipoId": 3,
    "cantPuertas": 5,
    "cantPasajeros": 5,
    "capacidadBaul": 350,
    "marca": "Chevrolet",
    "modelo": "Cruze",
    "patente": "AB-123-AB",
    "anio": 2019,
    "kilometraje": "35000",
    "cilindrada": "1.4"
}
```

- **Descripción campos y formatos**:


| Campo            | Tipo de campo   | Descripción                                              |
|------------------|-----------------|----------------------------------------------------------|
| tipoId           | Numérico        | Tipo de automovil, id externo a la tabla automovil_tipo. |
| cantPuertas      | Numérico        | Cantidad de puertas del automóvil.                       |
| cantPasajeros    | Numérico        | Cantidad de pasajeron que puede llevar el automóvil      |
| capacidadBaul    | Numérico        | Capacidad del baul en litros del automóvil               |
| marca            | Texto           | Marca del automóvil                                      |
| modelo           | Texto           | Modelo del automóvil                                     |
| patente          | Texto           | Número de patente del automóvil                          |
| anio             | Numérico        | Año de fabricación del automóvil                         |
| kilometraje      | Numérico        | Kilometraje actual del automóvil                         |
| cilindrada       | Texto           | Cilindrada del motor del automóvil                       |


- **Códigos de respuesta esperados**:

| Código             | Descripción                                                                           |
|--------------------|---------------------------------------------------------------------------------------|
| 201 Created        | La solicitud ha tenido éxito y devuelve un json con un ID del automóvil.              |
| 400 Bad Request    | Error en la llamada, algunos de los campos contiene un error.                         |
| 500 Internal Error | Error interno de la aplicacion. |

### Ejemplos
- **201 Created**
```
{
    "_data": {
        "object": "Automovil",
        "id": 15
    },
    "_errors": [],
    "_status": "CREATED"
}
```

- **400 Bad Request**
```
{
    "_errors": [
        {
            "description": "Column 'TIPO_ID' cannot be null"
        }
    ],
    "_status": "BAD_REQUEST"
}
```


### “GET /v1/automoviles/{id}”
Obtenger automóvil no borrado por ID

- **URL**: http://localhost:8080/v1/automoviles/{id}

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:

```
N/A
```

- **Códigos de respuesta esperados**:

| Código          | Descripción                                                                  |
|-----------------|------------------------------------------------------------------------------|
| 200 Ok          | La solicitud ha tenido éxito y devuelve un json con los detos del automóvil. |
| 404 Not Found   | No se encontró ningún automóvil con el id especificado.                      |

### Ejemplos
- **200 OK**
```
{
    "_data": {
        "id": 14,
        "marca": "Chevrolet",
        "modelo": "Cruze",
        "patente": "AB-123-AB",
        "anio": 2019,
        "kilometraje": 35000,
        "cilindrada": "1.4",
        "tipo": {
            "nombre": "Coupé"
        },
        "cantPuertas": 5,
        "cantPasajeros": 5,
        "capacidadBaul": 350
    },
    "_errors": [],
    "_status": "OK"
}
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de automóvil: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```


### “PUT /v1/automoviles/{id}”
Actualizar un automóvil

- **URL**: http://localhost:8080/v1/automoviles/{id}

- **BODY**
```
{
    "id": 15,   
    "tipoId": 4,
    "cantPuertas": 5,
    "cantPasajeros": 5,
    "capacidadBaul": 155,
    "marca": "Chevrolet",
    "modelo": "Onix",
    "patente": "AB-591-AB",
    "anio": 2020,
    "kilometraje": "12500",
    "cilindrada": "1.0"
}
```

- **Descripción campos y formatos**:


| Campo         | Tipo de campo   | Descripción                                              |
|---------------|-----------------|----------------------------------------------------------|
| id            | Numérico        | ID del automóvil a actualizar.                           |
| tipoId        | Numérico        | Tipo de automovil, id externo a la tabla automovil_tipo. |
| cantPuertas   | Numérico        | Cantidad de puertas del automóvil.                       |
| cantPasajeros | Numérico        | Cantidad de pasajeron que puede llevar el automóvil      |
| capacidadBaul | Numérico        | Capacidad del baul en litros del automóvil               |
| marca         | Texto           | Marca del automóvil                                      |
| modelo        | Texto           | Modelo del automóvil                                     |
| patente       | Texto           | Número de patente del automóvil                          |
| anio          | Numérico        | Año de fabricación del automóvil                         |
| kilometraje   | Numérico        | Kilometraje actual del automóvil                         |
| cilindrada    | Texto           | Cilindrada del motor del automóvil                       |


- **Códigos de respuesta esperados**:

| Código             | Descripción                                                                        |
|--------------------|------------------------------------------------------------------------------------|
| 204 No Content     | La solicitud ha tenido éxito y se ha actualizado el automóvil (No devuelve info.). |
| 400 Bad Request    | Error en la llamada, algunos de los campos contiene un error.                      |
| 500 Internal Error | Error interno de la aplicacion.                                                    |
| 404 Not Found   | No se encontró ningún automóvil con el id especificado.                      |

### Ejemplos
- **204 No Content**
```
```

- **400 Bad Request**
```
{
    "_errors": [
        {
            "description": "Los IDs no coinciden: 15<>14"
        }
    ],
    "_status": "BAD_REQUEST"
}
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de automóvil: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```

### “GET /v1/automoviles”
Obtenger automóviles no borrados con opción de paginación y ordenamiento

- **URL**: http://localhost:8080/v1/automoviles

- **PARAMS**

| Parámetro | Ejemplo               | Descripción                                    |
|-----------|-----------------------|------------------------------------------------|
| size      | size=5                | Cantidad de registros que devuelve por página. |
| page      | page=0                | Número de pagina que se solicita.              |
| sort      | sort=kilometraje,desc | Campo por el que se desea ordenar.             |

Ejemplo URL completa http://localhost:8080/v1/automoviles?size=5&page=0&sort=kilometraje,desc

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:

```
N/A
```

- **Códigos de respuesta esperados**:

| Código          | Descripción                                                                                                                |
|-----------------|----------------------------------------------------------------------------------------------------------------------------|
| 200 Ok          | La solicitud ha tenido éxito y devuelve un json con un listado de automóviles o vacio en caso de que no existan registros. |

### Ejemplos
- **200 OK**
```
{
    "_data": [
        {
            "id": 6,
            "marca": "Ford",
            "modelo": "Focus",
            "patente": "ABC-123",
            "anio": 2015,
            "kilometraje": 85500,
            "cilindrada": "1.4",
            "tipo": {
                "nombre": "Sedán"
            },
            "cantPuertas": 4,
            "cantPasajeros": 5,
            "capacidadBaul": 300
        },
        {
            "id": 14,
            "marca": "Chevrolet",
            "modelo": "Cruze",
            "patente": "AB-123-AB",
            "anio": 2019,
            "kilometraje": 35000,
            "cilindrada": "1.4",
            "tipo": {
                "nombre": "Coupé"
            },
            "cantPuertas": 5,
            "cantPasajeros": 5,
            "capacidadBaul": 350
        },
        {
            "id": 15,
            "marca": "Chevrolet",
            "modelo": "Onix",
            "patente": "AB-591-AB",
            "anio": 2020,
            "kilometraje": 12500,
            "cilindrada": "1.0",
            "tipo": {
                "nombre": "SUV"
            },
            "cantPuertas": 5,
            "cantPasajeros": 5,
            "capacidadBaul": 155
        }
    ],
    "_errors": [],
    "_status": "OK"
}
```

### “DELETE /v1/automoviles/{id}”
Borrar un automóvil (Borrado lógico)

- **URL**: http://localhost:8080/v1/automoviles/{id}

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:
```
N/A
```

- **Códigos de respuesta esperados**:

| Código         | Descripción                                                                 |
|----------------|-----------------------------------------------------------------------------|
| 204 No Content | La solicitud ha tenido éxito y se borrado el automóvil (No devuelve info.). |
| 404 Not Found  | No se encontró ningún automóvil con el id especificado.                      |

### Ejemplos
- **204 No Content**
```
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de automóvil: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```

## 2. Camión

### “POST /v1/camiones”
Crear camión

- **URL**: http://localhost:8080/v1/camiones

- **BODY**
```
{
	"tipoId": 1,
    "capacidadCarga": 1500,
    "cantEjes": 2
    "marca": "Ford",
	"modelo": "F350",
	"patente": "ZTU-568",
	"anio": 2004,
	"kilometraje": 260000,
	"cilindrada": "4.4",
}
```

- **Descripción campos y formatos**:


| Campo            | Tipo de campo   | Descripción                                           |
|------------------|-----------------|-------------------------------------------------------|
| tipoId           | Numérico        | Tipo de camión, id externo a la tabla camion_tipo.    |
| capacidadCarga   | Numérico        | Capacidad de carga en litros del camión.              |
| cantEjes         | Numérico        | Cantidad de ejes que posee el camión                  |
| marca            | Texto           | Marca del camión                                      |
| modelo           | Texto           | Modelo del camión                                     |
| patente          | Texto           | Número de patente del camión                          |
| anio             | Numérico        | Año de fabricación del camión                         |
| kilometraje      | Numérico        | Kilometraje actual del camión                         |
| cilindrada       | Texto           | Cilindrada del motor del camión                       |


- **Códigos de respuesta esperados**:

| Código             | Descripción                                                                           |
|--------------------|---------------------------------------------------------------------------------------|
| 201 Created        | La solicitud ha tenido éxito y devuelve un json con un ID del camión.              |
| 400 Bad Request    | Error en la llamada, algunos de los campos contiene un error.                         |
| 500 Internal Error | Error interno de la aplicacion. |

### Ejemplos
- **201 Created**
```
{
    "_data": {
        "object": "Camion",
        "id": 15
    },
    "_errors": [],
    "_status": "CREATED"
}
```

- **400 Bad Request**
```
{
    "_errors": [
        {
            "description": "Column 'TIPO_ID' cannot be null"
        }
    ],
    "_status": "BAD_REQUEST"
}
```


### “GET /v1/camiones/{id}”
Obtenger camión no borrado por ID

- **URL**: http://localhost:8080/v1/camiones/{id}

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:

```
N/A
```

- **Códigos de respuesta esperados**:

| Código          | Descripción                                                                  |
|-----------------|------------------------------------------------------------------------------|
| 200 Ok          | La solicitud ha tenido éxito y devuelve un json con los detos del camión. |
| 404 Not Found   | No se encontró ningún camión con el id especificado.                      |

### Ejemplos
- **200 OK**
```
{
    "_data": {
        "id": 7,
        "marca": "Ford",
        "modelo": "F350",
        "patente": "ZTU-568",
        "anio": 2004,
        "kilometraje": 260000,
        "cilindrada": "4.4",
        "tipo": {
            "nombre": "Sedán"
        },
        "capacidadCarga": 1500,
        "cantEjes": 2
    },
    "_errors": [],
    "_status": "OK"
}
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de camión: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```


### “PUT /v1/camiones/{id}”
Actualizar un camión

- **URL**: http://localhost:8080/v1/camiones/{id}

- **BODY**
```
```
```
{
    "id": 7,
    "tipoId": 1,
    "capacidadCarga": 1500,
    "cantEjes": 2
    "marca": "Ford",
    "modelo": "F350",
    "patente": "ZTU-568",
    "anio": 2004,
    "kilometraje": 260000,
    "cilindrada": "4.4",
}
```

- **Descripción campos y formatos**:


| Campo            | Tipo de campo   | Descripción                                           |
|------------------|-----------------|-------------------------------------------------------|
| tipoId           | Numérico        | Tipo de camión, id externo a la tabla camion_tipo.    |
| capacidadCarga   | Numérico        | Capacidad de carga en litros del camión.              |
| cantEjes         | Numérico        | Cantidad de ejes que posee el camión                  |
| marca            | Texto           | Marca del camión                                      |
| modelo           | Texto           | Modelo del camión                                     |
| patente          | Texto           | Número de patente del camión                          |
| anio             | Numérico        | Año de fabricación del camión                         |
| kilometraje      | Numérico        | Kilometraje actual del camión                         |
| cilindrada       | Texto           | Cilindrada del motor del camión                       |


- **Códigos de respuesta esperados**:

| Código             | Descripción                                                                        |
|--------------------|------------------------------------------------------------------------------------|
| 204 No Content     | La solicitud ha tenido éxito y se ha actualizado el camión (No devuelve info.). |
| 400 Bad Request    | Error en la llamada, algunos de los campos contiene un error.                      |
| 500 Internal Error | Error interno de la aplicacion.                                                    |
| 404 Not Found   | No se encontró ningún camión con el id especificado.                      |

### Ejemplos
- **204 No Content**
```
```

- **400 Bad Request**
```
{
    "_errors": [
            {
                "description": "Los IDs no coinciden: 7<>6"
            }
    ],
    "_status": "BAD_REQUEST"
}
```

- **404 Not Found**
```
{
    "_errors": [
            {
                "description": "No se encontraron datos para el id de camión: 1"
            }
    ],
    "_status": "NOT_FOUND"
}
```

### “GET /v1/camiones”
Obtenger camiónes no borrados con opción de paginación y ordenamiento

- **URL**: http://localhost:8080/v1/camiones

- **PARAMS**

| Parámetro | Ejemplo               | Descripción                                    |
|-----------|-----------------------|------------------------------------------------|
| size      | size=5                | Cantidad de registros que devuelve por página. |
| page      | page=0                | Número de pagina que se solicita.              |
| sort      | sort=kilometraje,desc | Campo por el que se desea ordenar.             |

Ejemplo URL completa http://localhost:8080/v1/camiones?size=5&page=0&sort=kilometraje,desc

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:

```
N/A
```

- **Códigos de respuesta esperados**:

| Código          | Descripción                                                                                                                |
|-----------------|----------------------------------------------------------------------------------------------------------------------------|
| 200 Ok          | La solicitud ha tenido éxito y devuelve un json con un listado de camiónes o vacio en caso de que no existan registros. |

### Ejemplos
- **200 OK**
```
{
    "_data": [
        {
            "id": 8,
            "marca": "Volvo",
            "modelo": "NL10",
            "patente": "UVP-864",
            "anio": 2005,
            "kilometraje": 460000,
            "cilindrada": "3.2",
            "tipo": {
                "nombre": "Hatchback"
            },
            "capacidadCarga": 2600,
            "cantEjes": 2
        },
        {
            "id": 7,
            "marca": "Ford",
            "modelo": "F350",
            "patente": "ZTU-568",
            "anio": 2004,
            "kilometraje": 260000,
            "cilindrada": "4.4",
            "tipo": {
                "nombre": "Sedán"
            },
            "capacidadCarga": 1500,
            "cantEjes": 2
        }
    ],
    "_errors": [],
    "_status": "OK"
}
```

### “DELETE /v1/camiones/{id}”
Borrar un camión (Borrado lógico)

- **URL**: http://localhost:8080/v1/camiones/{id}

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:
```
N/A
```

- **Códigos de respuesta esperados**:

| Código         | Descripción                                                                 |
|----------------|-----------------------------------------------------------------------------|
| 204 No Content | La solicitud ha tenido éxito y se borrado el camión (No devuelve info.). |
| 404 Not Found  | No se encontró ningún camión con el id especificado.                      |

### Ejemplos
- **204 No Content**
```
```

- **404 Not Found**
```
{
       "_errors": [
            {  
                "description": "No se encontraron datos para el id de camión: 1"
            }
        ],
        "_status": "NOT_FOUND"
}
```

## 3. Taller

### “POST /v1/talleres”
Crear taller

- **URL**: http://localhost:8080/v1/talleres

- **BODY**
```
{
    "nombre": "BHASSA S.A.",
    "direccion": "AV. Spinetto 1409",
    "cuit": "30-65319095-2"
}
```

- **Descripción campos y formatos**:


| Campo            | Tipo de campo   | Descripción                                           |
|------------------|-----------------|-------------------------------------------------------|
| nombre           | Texto        	 | Nombre del taller.                                    |
| direccion        | Texto           | Dirección del taller.                                 |
| cuit             | Texto           | Cuit del taller                                       |


- **Códigos de respuesta esperados**:

| Código             | Descripción                                                                           |
|--------------------|---------------------------------------------------------------------------------------|
| 201 Created        | La solicitud ha tenido éxito y devuelve un json con un ID del taller.              |
| 400 Bad Request    | Error en la llamada, algunos de los campos contiene un error.                         |
| 500 Internal Error | Error interno de la aplicacion. |

### Ejemplos
- **201 Created**
```
{
    "_data": {
        "object": "Taller",
        "id": 10
    },
    "_errors": [],
    "_status": "CREATED"
}
```

- **400 Bad Request**
```
{
    "_errors": [
        {
            "description": "Column 'NOMBRE' cannot be null"
        }
    ],
    "_status": "BAD_REQUEST"
}
```


### “GET /v1/talleres/{id}”
Obtenger taller no borrado por ID

- **URL**: http://localhost:8080/v1/talleres/{id}

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:

```
N/A
```

- **Códigos de respuesta esperados**:

| Código          | Descripción                                                                  |
|-----------------|------------------------------------------------------------------------------|
| 200 Ok          | La solicitud ha tenido éxito y devuelve un json con los detos del taller. |
| 404 Not Found   | No se encontró ningún taller con el id especificado.                      |

### Ejemplos
- **200 OK**
```
{
    "_data": {
        "id": 1,
        "nombre": "BHASSA S.A.",
        "direccion": "AV. Spinetto 1409",
        "cuit": "30-65319095-2"
    },
    "_errors": [],
    "_status": "OK"
}
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de taller: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```


### “PUT /v1/talleres/{id}”
Actualizar un taller

- **URL**: http://localhost:8080/v1/talleres/{id}

- **BODY**
```
{
    "id":1,
    "nombre": "BHASSA S.A.",
    "direccion": "AV. Spinetto 1409",
    "cuit": "30-65319095-2"
}
```

- **Descripción campos y formatos**:


| Campo            | Tipo de campo   | Descripción                                           |
|------------------|-----------------|-------------------------------------------------------|
| nombre           | Texto        	 | Nombre del taller.                                    |
| direccion        | Texto           | Dirección del taller.                                 |
| cuit             | Texto           | Cuit del taller                                       |


- **Códigos de respuesta esperados**:

| Código             | Descripción                                                                        |
|--------------------|------------------------------------------------------------------------------------|
| 204 No Content     | La solicitud ha tenido éxito y se ha actualizado el taller (No devuelve info.). |
| 400 Bad Request    | Error en la llamada, algunos de los campos contiene un error.                      |
| 500 Internal Error | Error interno de la aplicacion.                                                    |
| 404 Not Found   | No se encontró ningún taller con el id especificado.                      |

### Ejemplos
- **204 No Content**
```
```

- **400 Bad Request**
```
{
    "_errors": [
        {
            "description": "Los IDs no coinciden: 7<>6"
        }
    ],
    "_status": "BAD_REQUEST"
}
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de taller: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```

### “GET /v1/talleres”
Obtenger talleres no borrados con opción de paginación y ordenamiento

- **URL**: http://localhost:8080/v1/talleres

- **PARAMS**

| Parámetro | Ejemplo               | Descripción                                    |
|-----------|-----------------------|------------------------------------------------|
| size      | size=5                | Cantidad de registros que devuelve por página. |
| page      | page=0                | Número de pagina que se solicita.              |
| sort      | sort=codigo,desc      | Campo por el que se desea ordenar.             |

Ejemplo URL completa http://localhost:8080/v1/talleres?size=5&page=0&sort=codigo,desc

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:

```
N/A
```

- **Códigos de respuesta esperados**:

| Código          | Descripción                                                                                                                |
|-----------------|----------------------------------------------------------------------------------------------------------------------------|
| 200 Ok          | La solicitud ha tenido éxito y devuelve un json con un listado de talleres o vacio en caso de que no existan registros. |

### Ejemplos
- **200 OK**
```
{
    "_data": [
        {
            "id": 1,
            "nombre": "BHASSA S.A.",
            "direccion": "AV. Spinetto 1409",
            "cuit": "30-65319095-2"
        }
    ],
    "_errors": [],
    "_status": "OK"
}
```

### “DELETE /v1/talleres/{id}”
Borrar un taller (Borrado lógico)

- **URL**: http://localhost:8080/v1/talleres/{id}

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:
```
N/A
```

- **Códigos de respuesta esperados**:

| Código         | Descripción                                                                 |
|----------------|-----------------------------------------------------------------------------|
| 204 No Content | La solicitud ha tenido éxito y se borrado el taller (No devuelve info.). |
| 404 Not Found  | No se encontró ningún taller con el id especificado.                      |

### Ejemplos
- **204 No Content**
```
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de taller: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```

## 5. Servicio

### “POST /v1/servicios”
Crear servicio

- **URL**: http://localhost:8080/v1/servicios

- **BODY**
```
{
    "fechaRecepcion": null,
    "fechaEntrega": "2022-03-02T15:21:00",
    "descripcion": "Servicio 10000km",
    "comentario": null,
    "vehiculoId": 6,
    "tallerId": 1,
    "kilometraje": 10365,
    "precio": 12365
}
```

- **Descripción campos y formatos**:


| Campo            | Tipo de campo   | Descripción                                                   |
|------------------|-----------------|---------------------------------------------------------------|
| fechaRecepcion   | Fecha        	 | Fecha en la que se recibe el vehiculo nuevamente.             |
| fechaEntrega     | Fecha        	 | Fecha en la que se entrega el vehiculo al taller.             |
| descripcion      | Texto           | Descripción del servicio.                                     |
| comentario       | Texto           | Comentario sobre el servicio.                                 |
| vehiculoId       | Numérico        | ID del vehículo al que pertenece el servicio                  |
| tallerId         | Numérico        | ID del taller en el que se realiza el servicio                |
| kilometraje      | Numérico        | Kilometros del vehículo al momento de realizar el servicio    |
| precio           | Numérico        | Precio del servicio realizado                                 |

- **Códigos de respuesta esperados**:

| Código             | Descripción                                                                           |
|--------------------|---------------------------------------------------------------------------------------|
| 201 Created        | La solicitud ha tenido éxito y devuelve un json con un ID del servicio.              |
| 400 Bad Request    | Error en la llamada, algunos de los campos contiene un error.                         |
| 500 Internal Error | Error interno de la aplicacion. |

### Ejemplos
- **201 Created**
```
{
    "_data": {
        "object": "Servicio",
        "id": 10
    },
    "_errors": [],
    "_status": "CREATED"
}
```

- **400 Bad Request**
```
{
    "_errors": [
        {
            "description": "Column 'TALLER_ID' cannot be null"
        }
    ],
    "_status": "BAD_REQUEST"
}
```


### “GET /v1/servicios/{id}”
Obtenger servicio no borrado por ID

- **URL**: http://localhost:8080/v1/servicios/{id}

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:

```
N/A
```

- **Códigos de respuesta esperados**:

| Código          | Descripción                                                                  |
|-----------------|------------------------------------------------------------------------------|
| 200 Ok          | La solicitud ha tenido éxito y devuelve un json con los detos del servicio. |
| 404 Not Found   | No se encontró ningún servicio con el id especificado.                      |

### Ejemplos
- **200 OK**
```
{
    "_data": {
        "id": 1,
        "fechaEntrega": "2022-03-02T03:00:00.000+00:00",
        "descripcion": "Servicio 10000km",
        "vehiculo": {
            "id": 6,
            "marca": "Ford",
            "modelo": "Focus",
            "patente": "ABC-123",
            "anio": 2015,
            "kilometraje": 85500,
            "cilindrada": "1.4"
        },
        "taller": {
            "id": 1,
            "nombre": "BHASSA S.A.",
            "direccion": "AV. Spinetto 1409",
            "cuit": "30-65319095-2"
        },
        "kilometraje": 10365,
        "precio": 12365.00
    },
    "_errors": [],
    "_status": "OK"
}
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de servicio: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```


### “PUT /v1/servicios/{id}”
Actualizar un servicio

- **URL**: http://localhost:8080/v1/servicios/{id}

- **BODY**
```
{
    "id":1,
    "fechaRecepcion": null,
    "fechaEntrega": "2022-03-02T15:21:00",
    "descripcion": "Servicio 10000km",
    "comentario": null,
    "vehiculoId": 6,
    "tallerId": 1,
    "kilometraje": 10365,
    "precio": 12365
}
```

- **Descripción campos y formatos**:


| Campo            | Tipo de campo   | Descripción                                                   |
|------------------|-----------------|---------------------------------------------------------------|
| fechaRecepcion   | Fecha        	 | Fecha en la que se recibe el vehiculo nuevamente.             |
| fechaEntrega     | Fecha        	 | Fecha en la que se entrega el vehiculo al taller.             |
| descripcion      | Texto           | Descripción del servicio.                                     |
| comentario       | Texto           | Comentario sobre el servicio.                                 |
| vehiculoId       | Numérico        | ID del vehículo al que pertenece el servicio                  |
| tallerId         | Numérico        | ID del taller en el que se realiza el servicio                |
| kilometraje      | Numérico        | Kilometros del vehículo al momento de realizar el servicio    |
| precio           | Numérico        | Precio del servicio realizado                                 |


- **Códigos de respuesta esperados**:

| Código             | Descripción                                                                        |
|--------------------|------------------------------------------------------------------------------------|
| 204 No Content     | La solicitud ha tenido éxito y se ha actualizado el servicio (No devuelve info.). |
| 400 Bad Request    | Error en la llamada, algunos de los campos contiene un error.                      |
| 500 Internal Error | Error interno de la aplicacion.                                                    |
| 404 Not Found   | No se encontró ningún servicio con el id especificado.                      |

### Ejemplos
- **204 No Content**
```
```

- **400 Bad Request**
```
{
    "_errors": [
        {
            "description": "Los IDs no coinciden: 7<>6"
        }
    ],
    "_status": "BAD_REQUEST"
}
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de servicio: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```

### “GET /v1/servicios”
Obtenger servicios no borrados con opción de paginación y ordenamiento

- **URL**: http://localhost:8080/v1/servicios

- **PARAMS**

| Parámetro   | Ejemplo                                 | Descripción                                             |
|-------------|-----------------------------------------|---------------------------------------------------------|
| vehiculoId  | vehiculoId=6                            | ID del vhiculo del que se quieren ver los servicios.    |
| fechasDesde | fechaDesde=2022-03-02T00:00:00          | Fecha a partir de la cual se registraron los servicios. |
| fechaHasta  | fechaDesde=2022-03-03T00:00:00          | Fecha a hasta la cual se registraron los servicios.     |
| size        | size=5                                  | Cantidad de registros que devuelve por página.          |
| page        | page=0                                  | Número de pagina que se solicita.                       |
| sort        | sort=fechaRecepcion,desc                | Campo por el que se desea ordenar.                      |

Ejemplo URL completa http://localhost:8080/v1/servicios?vehiculoId=6&fechaDesde=2022-03-02T00:00:00&fechaHasta=2022-03-03T00:00:00&size=5&page=0&sort=fechaRecepcion,desc

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:

```
N/A
```

- **Códigos de respuesta esperados**:

| Código          | Descripción                                                                                                                |
|-----------------|----------------------------------------------------------------------------------------------------------------------------|
| 200 Ok          | La solicitud ha tenido éxito y devuelve un json con un listado de servicios o vacio en caso de que no existan registros. |

### Ejemplos
- **200 OK**
```
{
    "_data": [
        {
            "id": 6,
            "fechaRecepcion": "2022-03-02T03:00:00.000+00:00",
            "descripcion": "Servicio 10000km",
            "vehiculo": {
                "id": 6,
                "marca": "Ford",
                "modelo": "Focus",
                "patente": "ABC-123",
                "anio": 2015,
                "kilometraje": 85500,
                "cilindrada": "1.4"
            },
            "repuestos": [
                {
                    "id": 1,
                    "codigo": "0001",
                    "descripcion": "ACEITE PREMIUM 5W30",
                    "precio": 690.80
                }
            ],
            "trabajos": [
                {
                    "id": 1,
                    "codigo": "0001",
                    "descripcion": "REEMPLAZO ACEITE MOTOR",
                    "precio": 700.00
                }
            ]
        }
    ],
    "_errors": [],
    "_status": "OK"
}
```

### “DELETE /v1/servicios/{id}”
Borrar un servicio (Borrado lógico)

- **URL**: http://localhost:8080/v1/servicios/{id}

- **BODY**
```
N/A
```

- **Descripción campos y formatos**:
```
N/A
```

- **Códigos de respuesta esperados**:

| Código         | Descripción                                                                 |
|----------------|-----------------------------------------------------------------------------|
| 204 No Content | La solicitud ha tenido éxito y se borrado el servicio (No devuelve info.). |
| 404 Not Found  | No se encontró ningún servicio con el id especificado.                      |

### Ejemplos
- **204 No Content**
```
```

- **404 Not Found**
```
{
    "_errors": [
        {
            "description": "No se encontraron datos para el id de servicio: 1"
        }
    ],
    "_status": "NOT_FOUND"
}
```

# Postman con ejemplos
https://www.getpostman.com/collections/3fe09d79a11de262b17d

## Autor

* **Lucas Robert** - https://github.com/lucasrobert