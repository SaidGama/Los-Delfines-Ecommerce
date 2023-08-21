FROM amazoncorretto:11

WORKDIR /SpringApp

EXPOSE 8080

# Copiamos el archivo JAR desde el sistema de archivos local al directorio actual del contenedor
COPY build/libs/LosDelfinesEcommerce-1.0.jar .

# Indicamos el comando para ejecutar la aplicación Spring Boot desde el archivo JAR
CMD ["java", "-jar", "LosDelfinesEcommerce-1.0.jar"]