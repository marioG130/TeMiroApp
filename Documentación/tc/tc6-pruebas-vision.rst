
6) Pruebas de Visión
~~~~~~~~~~~~~~~~~~~~

A continuación se describen *Casos de Prueba* (Test Cases) referidas a la pruebas de visión que un usuario podrá realizar en la aplicación móbil. Las mismas se refieren a tres funcionalidades diferentes que presentará la app, por un lado la posibilidad de determinar y medir si una persona es *daltónica*, por otro lado la de medir la agudeza visual (capacidad de hacer foco y ver objetos pequeños), y finalmente la posibilidad de medir la distancia pupilar. Algunas de estas funcionalidades estarán disponibles para el público en general, mientras que otras lo estarán solamente para los clientes registrados de la ótica.

+ *TC6.1:*

  + **Objetivo**: Verificar el test básico de daltonismo
  + **Prioridad**: 1
  + **Trazabilidad**: Ingresar a la app como visitante y seleccionar el botón para este test
  + **Precondiciones**: La persona tiene visión normal de todos los colores
  + **Entradas**: Seleccionar el btón que da comienzo al test
  + **Resultados Esperados**: La persona pasa el test con todos los resultados parciales correctos. Se informa a la persona que tiene una visión normal de los colores.

* *TC6.2:* 

  + **Objetivo**: Verificar el test básico de daltonismo
  + **Prioridad**: 2
  + **Trazabilidad**: Ingresar a la app como visitante y seleccionar el botón para este test
  + **Precondiciones**: La persona NO tiene visión normal de todos los colores (o simula no tenerla)
  + **Entradas**: Seleccionar el btón que da comienzo al test
  + **Resultados Esperados**: La persona NO pasa el test, debido a que en alguna de las pantallas no ha reconocido el número aleatorio generado (o ha simulado no reconocerlo). Se informa a la persona que tiene cierto grado de daltonismo.
