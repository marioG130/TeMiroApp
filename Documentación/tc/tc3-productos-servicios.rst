
3) Catálogo de Productos y Servicios
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

A continuación se describen *Casos de Prueba* (Test Cases) referidas a los Productos y Servicios que un usuario podrá visualizar y utilizar en la aplicación móbil.

**Productos**
TC3-1:

Objetivo: Verificar la capacidad de navegar por el catálogo de productos.
Prioridad: 1
Trazabilidad: Ingresar a la aplicación como un usuario visitante y seleccionar el boton catalogo.
Precondiciones: El catálogo de productos está disponible y contiene al menos 5 productos.
Entradas: Navegar por el catálogo de productos desplazándose hacia arriba y hacia abajo.
Resultados Esperados: La aplicación permite una navegación fluida y sin problemas por el catálogo de productos. 
Los productos se cargan correctamente a medida que el usuario se desplaza, y se muestran con sus detalles básicos, incluyendo nombre, imagen y precio.
El desplazamiento es suave y no hay retrasos significativos en la carga de productos.

TC3-1:
Objetivo: Verificar la capacidad de ver detalles de un producto en el catálogo.
Prioridad: 2
Trazabilidad: Ingresar a la aplicación como un usuario visitante.
Precondiciones: El catálogo de productos está disponible y contiene al menos 5 productos.
Entradas: Seleccionar un producto del catálogo y hacer clic en el botón "Ver más" para obtener información detallada sobre el producto.
Resultados Esperados: La aplicación muestra los detalles completos del producto seleccionado, incluyendo su nombre, imagen, precio y una descripción detallada del mismo.
La descripción debe ser legible y completa.

**Servicios**
TC3-2

Objetivo: Verificar la navegación dentro de la categoría de servicios.
Prioridad: 1
Trazabilidad: Ingresar a la aplicación como un usuario visitante y seleccionar la opción "Servicios" desde la pantalla Catalogo/Servicios.
Precondiciones: La categoría de servicios contiene tres opciones: "Taller de Montaje", "Seguro de Rotura de Cristal" y "Consultas Oftalmológicas".
Entradas: Seleccionar una de las opciones de servicio, por ejemplo, "Taller de Montaje".
Resultados Esperados: La aplicación redirige al usuario a una pantalla que muestra una breve descripción del servicio seleccionado. En la parte inferior de la pantalla,
se encuentra un botón que permite acceder al formulario de consulta del servicio.

TC3-2:
Objetivo: Verificar la información detallada de un servicio.
Prioridad: 2
Trazabilidad: Ingresar a la aplicación como un usuario visitante, seleccionar la opción "Servicios" y luego elegir un servicio, por ejemplo, "Seguro de Rotura de Cristal".
Precondiciones: La categoría de servicios contiene tres opciones: "Taller de Montaje", "Seguro de Rotura de Cristal" y "Consultas Oftalmológicas".
Entradas: Seleccionar un servicio y luego hacer clic en el botón "Ver más" en la pantalla de descripción del servicio.
Resultados Esperados: La aplicación muestra información detallada sobre el servicio seleccionado, incluyendo una descripción más completa y posiblemente detalles adicionales
como costos y condiciones. La información es legible y completa.

TC3-2:
Objetivo: Verificar la capacidad de enviar una consulta desde un formulario de servicio.
Prioridad: 1
Trazabilidad: Ingresar a la aplicación como un usuario visitante, seleccionar la opción "Servicios", elegir un servicio y acceder a la pantalla del formulario de consulta.
Precondiciones: La categoría de servicios contiene tres opciones: "Taller de Montaje", "Seguro de Rotura de Cristal" y "Consultas Oftalmológicas".
Entradas: Completar y enviar el formulario de consulta del servicio seleccionado.
Resultados Esperados: La aplicación permite al usuario completar el formulario de consulta y enviarlo correctamente. El formulario incluye campos relevantes y la aplicación
muestra un mensaje de confirmación o agradece al usuario por su consulta una vez que se ha enviado el formulario.