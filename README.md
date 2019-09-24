# WS-Proyect-Confianza REST API

Autenticación para probar en postman

Basic bWV0cm9jdWFkcmFkby1jbGllbnQ6TTM3cjBDdTREcjREMA==

curl -X POST \
  http://localhost:8280/oauth/token \
  -H 'authorization: Basic bWV0cm9jdWFkcmFkby1jbGllbnQ6TTM3cjBDdTREcjREMA==' \
  -F grant_type=password \
  -F username=confianza \
  -F password=admin1234 \
  -F client_id=confianza-client
  
  
  
Despliegue en servidores de pruebas o productivos
  

  
Se deben modificar los archivos para el ambiente requerido:

*desplegarci.sh
*desplegarProducction.sh
*desplegarstaging.sh 

en la ruta del proyecto etce-email-marketing/

Modificar la variable:
JAVA_HOME=/usr/java/jdk1.8.0_191-i586

En este batch se define el perfil a desplegar:
v_profile="ci" = desplegarci.sh
v_profile="staging" = desplegarstaging.sh
v_profile="produccion" = desplegarProducction.sh


Modificar lo siguiente para descargar de git o comentario si no se requiere

git reset --hard feature/integration_metrocuadrado
git pull



Si se requiere cambiar el puerto se hace en :
etce-email-marketing/mailingceet-rest/src/main/resources/application.properties

Modificar en applicatios.properties el puerto de la aplicación:
server.port:8280

Guardar los cambios.

Dar permisos de ejecución a los archivos sh de los perfiles del aplicativo:

*desplegarci.sh
*desplegarProducction.sh
*desplegarstaging.sh 

Ejecutar el archivo del perfil que se requiere
./esplegarci.sh
./desplegarProducction.sh
./desplegarstaging.sh 

Una vez se ejecuta este crea un servicio en el servidor 
/etc/init.d/mailingci


Este posteriormente se puede utilizar como 
/etc/init.d/mailingci stop
/etc/init.d/mailingci start
/etc/init.d/mailingci restart

O ejecutar de nuevo los archivos:
./esplegarci.sh
./desplegarProducction.sh
./desplegarstaging.sh 
 quien regenera el servicio y la aplicación.
  
  
 
