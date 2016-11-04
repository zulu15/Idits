# RestIdits
### Instrucciones para ejecutarlo:

  - Descargar el proyecto o clonarlo (git clone https://github.com/zulu15/RestIdits.git RestIdits)
  - Importarlo en NetBeans o Eclipse (Preferentemente eclipse: File > Import > Existing Projects Into Workspace > Browse > Accept )
  - Configurar la base de datos
  

#### Configurar la base de datos:

Para configurar la base de datos basta con crear una base de datos vacia en MYSQL con el nombre `idits_hibernate` e ir al archivo `/RestIdits/src/hibernate.cfg.xml` y modificar los datos de acceso a la base de datos: `usuario`, `contraseña` y nombre de la base de datos (si se modifico).

#### URLS:


`localhost:8080/idits/rest/usuario` (Metodo GET) devuelve un listado con objetos de tipo "usuario" en formato JSON
`localhost:8080/idits/rest/usuario/add` (Metodo POST) Inserta una persona recibida como parametro en formato JSON

`localhost:8080/idits/rest/curso` (Metodo GET) devuelve un listado con objetos de tipo "curso" en formato JSON
`localhost:8080/idits/rest/curso/add/{cursoId}/{usuarioDni}` (Metodo POST) Genera una inscripcion a un curso a partir de su id y del dni de la persona
