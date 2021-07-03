# Mercado Libre - Operación Fuego de Quasar

## Arquitectura de Software

A continuaciòn se exponen diferentes vistas de la arquitectura de software

### Vista de Paquetes

En la vista de paquetes se definen los paquetes que tendrá el componente software. Cada Paquete es una capa de software en nuestro componente y agrupa un conjunto de clases o interfaces con responsabilidades comunes, los paquetes son:

![Screenshot](https://github.com/gi0o0/quasar_fire/blob/master/doc/architecture-PackageView.png?raw=true)

* co.com.mercadolibre: Todas las clases encargadas de ejecutar el proyecto
* co.com.mercadolibre.config: todas las clases que realizan la configuración del proyecto.
* co.com.mercadolibre.controller: Todos las clases que reciben peticiones HTTP a los end-point defindos.
* co.com.mercadolibre.dao: Todas las clases encargadas de acceder a los datos.
* co.com.mercadolibre.dto: Todas las clases que representan el negocio.
* co.com.mercadolibre.entidades: Todas las clases que representan el acceso a datos.
* co.com.mercadolibre.exceptions: Todas las excepciones para el manejo de errores controlados.
* co.com.mercadolibre.mapper: Todas las interfaces con las colleciones de los metodos abstractos para la transformacion de objetos.
* co.com.mercadolibre.mapper.impl: Todas las clases con lógica de transformacion de objetos.
* co.com.mercadolibre.service: Todas las interfaces con las colleciones de los metodos abstractos para obtener la posicion y decifrar el mensaje.
* co.com.mercadolibre.service.impl: Todas las clases con lógica de negocio para Localizar nave y construir mensaje.
* co.com.mercadolibre.util: funciones transversales.

La comunicación entre paquetes es unidireccional y solo con la capa siguiente inferior.

### Vista de clases

El diagrama de clases expone las clases necesarias para representar el negocio, los servicios con lógica y reglas de negocio y Controladores para atender la petición HTTP a los end-points.

![Screenshot](https://github.com/gi0o0/quasar_fire/blob/master/doc/architecture-ClassView.png?raw=true)


Se utilizara Java y el framework Spring Boot para construir el componente Software,

### Vista funcional

![Screenshot](https://github.com/gi0o0/quasar_fire/blob/master/doc/architecture-FunctionView.png?raw=true)

El despliegue del componente software es en AWS usando servicio el servicio ECS.

Existen varias ventajas por las cuales elegi usar Amazon ECS :

Ejecutar contenedores sin servidores: A través de AWS Fargate, que es ofrecido por Amazon ECS, es posible implementar y administrar los contenedores sin que sea necesario aprovisionar o administrar servidores. Fargate le da la libertad para enfocarse en crear y ejecutar aplicaciones.

Incluir todo en contenedores:  Es posible crear fácilmente todo tipo de aplicaciones en contenedores y además también se pueden migrar Apps de Linux o Windows, provenientes de entornos on-premise, a la nube y ejecutarlas como aplicaciones en contenedores Amazon ECS.

Seguridad: Ofrece un alto nivel de aislamiento que permite crear aplicaciones seguras y confiables,  debido a que Amazon ECS tiene su propia Amazon VPC en la que lanza sus contenedores, permitiendo así usar grupos de seguridad de red VPC y ACL.

Desempeño a escala: Es basado en tecnología que ha sido desarrollada a partir de una sólida trayectoria en la ejecución de servicios.

Posibilidad de uso con otros servicios de AWS: Amazon ECS se integra con los diferentes servicios de AWS, como Amazon VPC, AWS IAM, Amazon ECR, AWS Batch, Amazon CloudFormation, entre otros.


### Vista de Despliegue

![Screenshot](https://github.com/gi0o0/quasar_fire/blob/master/doc/img/architecture-DeployView.png?raw=true)


## REQUERIMIENTOS
- Java 8
- Maven
- Docker
- AWS cuenta (Opcional)

## Instalaciòn

Clone este repositorio con el siguiente comando:

```bash
git clone https://github.com/gi0o0/quasar_fire.git


Puede instalar una Base de datos Local MySql utilizando las siquientes instrucciones. https://dev.mysql.com/doc/refman/8.0/en/linux-installation-yum-repo.html o puede crearla en AWS con el servicio RDS
siguiendo el siguiente manual. 

![Screenshot](https://github.com/gi0o0/quasar_fire/blob/master/doc/img/AWS_RDS.docx?raw=true)

Una vez instalada o creada en el servicio de AWS conectarse por medio de un cliente de su preferencia y ejecutar los script.

![Screenshot](https://github.com/gi0o0/quasar_fire/blob/master/src/main/resources/sql-scripts/schema.sql?raw=true)
![Screenshot](https://github.com/gi0o0/quasar_fire/blob/master/src/main/resources/sql-scripts/data.sql?raw=true)

Tener en cuenta que se deben reemplazar las variables nombradas a continuacion se deben sustituir en el archivo https://github.com/gi0o0/quasar_fire/blob/master/src/main/resources/application.properties: 

${URL} = Corresponde a la URL de la Base de datos Ejemplo: jdbc:mysql://serviciosnubeqas.c5eqgve9novs.us-east-1.rds.amazonaws.com:3306/AccesoDB?zeroDateTimeBehavior=convertToNull&serverTimezone=America/Bogota&useSSL=false
${USERNAME} = Corresponde al usuario de la base de datos
${PASSWORD} = Corresponde a la contraseña de la base de datos.


Puede ejecutar este proyecto en local usando maven:

mvn install prd

java -jar quasar_fire-1.jar

o puede comenzar el servicio con ECS.


## Ejecuciòn 

Las siguientes son las URLs relacionadas con el servicio publicado:


  Servicio topsecret:  http://3.83.247.249:8080/v01/quasar/topsecret
  
  Servicio topsecret_split:  http://3.83.247.249:8080/v01/quasar/topsecret_split

  Swagger:  http://3.83.247.249:8080/v01/quasar/swagger-ui.html
  
  Health: http://3.83.247.249:8080/v01/quasar/health
 