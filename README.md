# ChallengeFinalAPIS
## Prerrequisitos
- Máquina local con el sistema operativo Windows 11
- [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/download/) 2024.1.4
- [SDK 17](https://www.oracle.com/java/technologies/downloads/) Oracle OpenJDK 17.0.6
- [Maven](https://maven.apache.org/download.cgi) 3.9.8
- Plugins:
   - Cucumber for Java (versión 241.14494.158)
   - Gherkin (versión 241.17011.40)

**Nota:** Proceso de instalación de plugins en IntelliJ:
- `File -> Settings -> Plugins -> Buscar en Marketplace`

- Configurar las variables de entorno del sistema y de usuario:
   - Agregar nuevas variables de sistemas con su valor:
      - `JAVA_HOME`: ruta de instalación (ejemplo: `C:\Users\USUARIO\.jdks\azul-1.8.0_412`)
      - `M2_HOME`: ruta de instalación (ejemplo: `C:\Programas\apache-maven-3.9.8`)
   - Editar el `PATH` de las variables de sistema y añadir las siguientes variables:
      - `%JAVA_HOME%\bin`
      - `%M2_HOME%\bin`

## Proceso de instalación
- clonamos el repositorio
```bash
https://github.com/AngeloSFV2001/ChallengeFinalE2E.git
```
- Abrimos la carpeta en IntelliJ IDEA
- Utilizamos el siguiente comando para actualizar y agregar las dependencias de Maven:
```bash
mvn serenity:aggregate
mvn -U dependency:resolve
```
**Nota:** En caso de que no se actualice, realizar de forma manual con el botón refrescar en la barra lateral de Maven.
## Instrucciones para ejecutar los test

- Para ejecutar los test nos trasladamos a la clase `CucumberTestSuite.java` que se encuentra en `src/test/java/com/example/runners/CucumberTestSuite.java` .
- Al ejecutar la funcion `CucumberTestSuite` se ejecutara los test.
- Tambien, se puede utilizar las teclas `Mayús + F10` considerando que ya esta configurado como clase de ejecucion
  la función `CucumberTestSuite`
### Modificar parametros de las pruebas
- Se puede modificar el archivo JSON ubicado en `src/test/resources/templates/users.json` para poner los datos del cliente 
segun corresponda

## Visualizacion del reporte
- Para ver los reportes nos trasladamos al directorio `target/site/serenity/` y hacemos click derecho en el
  archivo `index.html`, luego, `Open in -> Browser` y elegimos nuestro navegador de preferencia.
  Ahi se podra ver el reporte más reciente de la ejecución