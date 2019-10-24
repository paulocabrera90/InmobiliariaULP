# InmobiliariaULP
Mejor que Williams

INSTRUCTIVO: El proyecto será una aplicación en Java / MySQL. Se debe crear las tablas de la base de datos, y las correspondientes clases. Utilice una clase para la conexión y confeccione la interfaz gráfica (GUI). El grupo deberá presentar el proyecto en 3 etapas.
1-	Armado de la base de datos completa, relaciones. Proyecto en Netbeans, y clase de conexión. ABM de una clase*. 
2-	Desarrollo de todas las clases principales del dominio (ABM), consultas SQL embebidas. Interfaces gráficas completas. 
3-	Implementación de los todos los métodos necesarios, listados, ABM de clases relacionadas y aplicación terminada.

Se deben presentar las clases con atributos y métodos necesarios(abstracción). Setters y Getters (encapsulamiento). Constructor.
Se evaluará el aporte de todos los miembros al proyecto, en la construcción de las clases. Se subirán los commit al repositorio (Git).
2.	LA INMOBILIARIA: 
El sistema trata de la informatización de la gestión de alquileres de propiedades inmuebles que realiza una agencia inmobiliaria.
RELACIONES
	En la inmobiliaria se alquilaninmueblespara un uso tal como departamentos, locales, depósitos, oficinas individuales, etc. 
	Lospropietarios de los inmuebles los ofrecen a la agencia para que ésta les busque inquilinos y hacer un contrato de alquilerpor un tiempo determinado. Claro está que el propietario está obligado a aceptar el Inquilino que proponga la agencia si cumple las condiciones estipuladas.
	Se sabe que un propietario es dueño de una o varios inmuebles. Cada Inmueble será propiedad de un único propietario.
	Un Inquilino puede llegar a participar de varios contratos de alquiler, pero cada inquilino es único responsable de su contrato.
	Asi mismo, cada contrato de alquiler tiene asociado a un solo inmueble. Aunque a lo largo del tiempo ese inmueble aparece varios otros contratos de alquiler no vigentes. 

Propietario entrega inmueble
	Cuando un propietario entrega un inmueble, la agencia le pide la dirección y altura, tipo, superficie, y precio base del inmueble.Se le asigna un código,la zona. Su estado es Disponible(0).
	Si el propietario no estaba ingresado desde antes, hay que agregarlo al sistema solicitando sudni, apellido y nombre, domicilio real, y sus datos de contacto. A partir de entonces el propietario espera a que la Inmobiliaria le avise telefónicamente del contrato con la otra parte.

Inquilino alquila inmueble
	Cuando el inquilino viene a alquilar un local se lo entrevista solicitando sus datos personales. ABM inquilino. CUIT, nombre completo, lugar de trabajo, nombre garante, dni del garante.
	Luego indica las características del inmueble (uso de local, zona, superficie mínima, y precio aproximado). La agencia lleva a cabo un método parabúsquedadeinmuebles “disponibles”, si encuentra algunos adecuados, se entrega una lista de inmuebles, si al nuevo inquilino le interesa algún inmueble se marcará el mismo como “no disponible”(1), y se crea elcontrato de alquiler. Si entre los locales que la agencia ofrece, no hay ninguno que quiera el inquilino, se informa en pantalla que no hay locales alquilables de esas características y no se efectúa contrato.
	Se deben registrar la fecha de inicio y fecha de finalización del presente contrato, el monto de alquiler en pesos y un vínculo entre la propiedad inmueble y el inquilino. Luego se avisa al propietario que venga a firmar. El estado del contrato será “vigente”(1).
	Cualquiera de las partes puede cancelar el contrato en cualquier momento si no estuviese conforme a las condiciones pactadas en el contrato. El estado del contrato será “no vigente”(0).
	Cuando se cumple el plazo del contrato se puede efectuar una Renovación del contrato de alquiler, en cuyo caso se deben actualizar las fechas de inicio y fin del contrato, nuevo monto, y el estado del contrato será “renovado”. 
	Se quieren obtener listados de propiedades que estén disponibles(0) y su dueño.
	Listar todas las propiedades que le correspondan a un propietario (parámetro).
	Listar todos los contratos de alquiler que se encuentren vigentes.
	Dado como parámetro un inmueble en particular, listar todos sus contratos y nombre del inquilino.

