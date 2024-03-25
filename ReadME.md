# EtherealTrek

EtherealTrek es un proyecto realizado para la maratón de codificación de TODOCODE, desarrollado por el Equipo 10.

## Acerca de

Este repositorio se enfoca en el back-end del proyecto, utilizando una variedad de tecnologías para su desarrollo.

### Lenguajes / Frameworks utilizados / Tecnologías:
- Java (JDK MIXTO, Entre JDK 11 y JDK 17)
- Spring Boot 
- Spring Cloud (Eureka)
- Spring Security
  (Versiones de Spring rondan entre Mixto, Versión 3.1 y Versión 2.4)
- Gateway (CORS)
- OAUTH 2
- MYSQL 8.0
- Postman (Colecciones en cada uno de los servicios)
- Swagger
- JWT
- Servidor de configuración centralizado
- LoadBalancer (Balanceo de cargas para microservicios)
- Docker

## Objetivo
La aplicación pretende que a través de empleados, cada uno con diferente rol y puesto, tenga potestad de crear/eliminar/modificar el "Crear, Leer, Actualizar y Borrar" (CRUD) de diferentes entidades como son cliente, paquete, venta, archivos y registros.

- Cliente: Usado para simbolizar una persona que quiera adquirir algún bien o servicio con nosotros.
- Archivos: Galería de imágenes para representación gráfica.
- Servicios: Define el tipo de servicio que se le brindará al cliente y posee datos como destino, precio, fecha, descripción...
- Paquetes: El conjunto de 2 o más servicios ya creados y posee atributos como nombre, descripción, un Array de Lista de servicios y finalmente el precio, el cual es calculado como la suma del precio de los servicios seleccionados - 10% debido a haberlo comprado del modo Paquete.
- Ventas: Entidad usada para representar una transacción con un cliente, posee atributos como cliente comprador, empleado vendedor, paquete o servicio a vender, fecha de la venta, y el precio depende del método de pago que use el cliente, cada método de pago tiene una comisión distinta. 
- Registro: Entidad usada para representar transacciones y alimentar el Big Data de nuestro negocio aportando más información para la creación de estadísticas y reportes financieros.

## Explicación Técnica
El ambiente de microservicios creado para este proyecto se basa en un servidor de registro en donde cada microservicio se reporta con este para otorgarle información individual y ponerse a disposición de cualquier otro microservicio registrado para su intercomunicación.

Para su consumo se hace a través de una puerta de enlace la cual se encarga de darle o implementar seguridad en cada ruta dinámica y autobalancear las cargas de peticiones para cada microservicio individualmente. Esta puerta de enlace implementa la seguridad a través de un token encriptado (JSON Web Token) que valide a través de los datos provenientes del Token si la solicitud está abierta al usuario con base en su rol. El token primeramente valida el usuario y contraseña de la aplicación cliente para posteriormente validar los datos del usuario y su rol y finalmente nuestra firma de acceso encriptado. 

También existe una forma alternativa de logeo fuera de las credenciales del usuario. Esta sería a través de un Refresh Token el cual tiene una fecha de expiración un tanto mayor a la del Token Original y permitiría que al enviarlo le retornará Tokens renovados (evitando que el usuario tenga que estarse logeando habitualmente).

Por otro lado, se implementó un manejo de errores a través de la dependencia Resilience4J la cual a través de la metodología cortocircuito (Circuit Breaker) aplicado a cada End Point nos ayuda a prevenir errores en cascada entre microservicios.

## Creadores

Los creadores de este proyecto y sus respectivos perfiles de GitHub son:

- [Francisco Carrizo](https://github.com/FrancarriYT)
- [Irving Meza](https://github.com/IrvingMeza95)
- [José Zambrano](https://github.com/21Zam03)

## Repositorios Específicos

Adjuntamos el link directo de cada repositorio, allí pueden verse sus commits, cambios y ReadMEs específicos, permitiendo mejor lectura:

- **[Eureka Server](https://github.com/IrvingMeza95/ethereal-trek-eureka-server)**: Servidor de registro para nuestros microservicios.
- **[Gateway](https://github.com/IrvingMeza95/ethereal-trek-gateqayServer)**: Puerta de enlace a todos los servicios y encargado de otorgar seguridad.
- **[Servicio OAUTH](https://github.com/IrvingMeza95/ethereal-trek-servicioOauth)**: Servicio encargado de autenticar credenciales tanto como de servicio-cliente como del usuario mismo para la generación de un Token de acceso.
- **[Servicio paquete-Servicio](https://github.com/IrvingMeza95/ethereal-trek-gestionPaqSer)**: Servicio encargado de gestionar la creación de Servicios y Paquetes y de su comercialización (ventas y reportes).
- **[Servicio Empleado-Cliente](https://github.com/IrvingMeza95/ethereal-trek-gestionPaqSer)**: Servicio encargado de gestionar la información de Empleados y Clientes.
- **[ConfigServer](https://github.com/IrvingMeza95/ethereal-trek-configServer)**: Servicio encargado de proporcionar las propiedades a cada microservicio extrayéndolas de un archivo de configuración centralizado en un repositorio en la nube.

# Frontend

Para acceder al repositorio del Front-end, visita: [EtherealTrek-Frontend](https://github.com/FrancarriYT/EtherealTrekHackacode2024-Frontend)
