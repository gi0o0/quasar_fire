# Mercado Libre - Operación Fuego de Quasar

## Arquitectura de Software

A continuaciòn se exponen diferentes vistas de la arquitectura de software

### Vista de Paquetes

En la vista de paquetes se definen los paquetes que tendrá el componente software. Cada Paquete es una capa de software en nuestro componente y agrupa un conjunto de clases o interfaces con responsabilidades comunes, los paquetes son:

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


 