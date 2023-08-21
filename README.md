# LosDelfinesEcommerce
![Sitio Web](/captura.png "Captura del sitio web")

Este proyecto ha sido desarrollado para una purificadora ubicada en Yucatán, México.

La aplicacion esta funcionando en la nube y puedes acceder con la url: 
-http://losdelfines.us-east-1.elasticbeanstalk.com/


El proyecto utiliza dos contenedores Docker para su ejecución.

Si deseas ejecutar la aplicación localmente, sigue estos pasos:
1. Descarga e instala Docker en tu computadora.
2. Descarga o clona el proyecto desde el repositorio.
3. Abre el archivo .env y modifica las variables que se indican en el archivo.
4. Abre una terminal en la carpeta principal del proyecto.
5. Ejecuta el siguiente comando: docker-compose up -d.
6. Una vez que el comando anterior se haya ejecutado en la terminal, verás que se han creado exitosamente dos contenedores Docker. Finaliza el proceso con el comando: docker-compose restart.
7. Espera a que los contenedores de la aplicación se reinicien y, posteriormente, accede a la aplicación web a través de tu navegador web ingresando la siguiente dirección: localhost:8080.
