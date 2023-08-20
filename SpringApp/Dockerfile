FROM amazoncorretto:11

WORKDIR /SpringApp

EXPOSE 8080

# Copiamos el archivo JAR desde tu sistema de archivos local al directorio actual del contenedor
COPY build/libs/LosDelfinesBackend-0.0.1-SNAPSHOT.jar .

# Indicamos el comando para ejecutar la aplicación Spring Boot desde el archivo JAR
CMD ["java", "-jar", "LosDelfinesBackend-0.0.1-SNAPSHOT.jar"]
