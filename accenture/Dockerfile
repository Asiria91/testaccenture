# Utiliza la imagen oficial de Apache Tomcat (versión específica)
FROM tomcat:9.0-jdk17
# Copia el archivo .war al directorio de despliegue de Tomcat
COPY target/*.war /usr/local/tomcat/webapps/app.war
# Exponer el puerto en el que Tomcat escucha (por defecto 8080)
EXPOSE 8080
# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]