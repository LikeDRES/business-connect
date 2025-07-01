# ----------------------------
# Etapa 1: build (compilación)
# ----------------------------

# Imagen base con JDK 21 para compilar la aplicación
FROM eclipse-temurin:21-jdk AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos necesarios para descargar dependencias
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Descarga las dependencias en caché para acelerar builds futuros
RUN ./mvnw dependency:go-offline

# Copia el código fuente (luego de cachear dependencias)
COPY src src

# Compila la aplicación y genera el .jar sin ejecutar los tests
RUN ./mvnw clean package -DskipTests


# -------------------------------
# Etapa 2: imagen final (runtime)
# -------------------------------

# Imagen limpia con solo el JDK para ejecutar la app
FROM eclipse-temurin:21-jdk

# Define el directorio de ejecución
WORKDIR /root

# Copia el JAR compilado desde la etapa anterior y lo renombra
COPY --from=build /app/target/business-connect-0.0.1-SNAPSHOT.jar business-service.jar

# Comando que se ejecutará al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "business-service.jar"]