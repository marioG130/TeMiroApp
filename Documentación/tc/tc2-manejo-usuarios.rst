
2) Manejo de Usuarios
~~~~~~~~~~~~~~~~~~~~~

A continuación se describen *Casos de Prueba* (Test Cases) referidas al login para que el usuario ingrese a la aplicación. 

+ *TC2.1:*

  + **Objetivo**: Iniciar sesión a TeMiroApp sin datos de entrada.
  + **Prioridad**: 1
  + **Trazabilidad**: Ingresar a TeMiroApp, presionar Iniciar sesión.
  + **Precondiciones**: aplicación en producción.
  + **Entradas**: Nombre de Usuario y contraseña sin valores.
  + **Resultados Esperados**: Visualizar un mensaje que detalle que los campos deben tener valor.

* *TC2.2:* 

  + **Objetivo**: Iniciar sesión a TeMiroApp solo con nombre de usuario.
  + **Prioridad**: 2
  + **Trazabilidad**: Ingresar a TeMiroApp, presionar Iniciar sesión, ingresar sólo nombre de usuario y precionar botón Iniciar Sesión..
  + **Precondiciones**: aplicación en producción.
  + **Entradas**: Nombre de Usuario con valor y contraseña sin valor.
  + **Resultados Esperados**: Visualizar un mensaje que detalle que el campo contraseña debe tener valor.

* *TC2.3:* 

  + **Objetivo**: Iniciar sesión a TeMiroApp solo con contraseña.
  + **Prioridad**: 3
  + **Trazabilidad**: Ingresar a TeMiroApp, presionar Iniciar sesión, ingresar sólo contraseña y precionar botón Iniciar Sesión..
  + **Precondiciones**: aplicación en producción.
  + **Entradas**: Nombre de Usuario sin valor y contraseña con valor.
  + **Resultados Esperados**: Visualizar un mensaje que detalle que el campo nombre de usuario debe tener valor.

* *TC2.4:* 

  + **Objetivo**: Iniciar sesión a TeMiroApp con nombre de usuario y contraseña no validos.
  + **Prioridad**: 4
  + **Trazabilidad**: Ingresar a TeMiroApp, presionar Iniciar sesión, ingresar nombre de usuario y contraseña aleatorios, precionar botón Iniciar Sesión.
  + **Precondiciones**: aplicación en producción.
  + **Entradas**: Nombre de Usuario y contraseña con valores no válidos.
  + **Resultados Esperados**: Visualizar un mensaje que detalle que los datos ingresados no corresponden a un usuario registrado.

* *TC2.5:* 

  + **Objetivo**: Iniciar sesión a TeMiroApp con nombre de usuario y contraseña validos.
  + **Prioridad**: 5
  + **Trazabilidad**: Ingresar a TeMiroApp, presionar Iniciar sesión, ingresar nombre de usuario y contraseña válidos, precionar botón Iniciar Sesión.
  + **Precondiciones**: aplicación en producción.
  + **Entradas**: Nombre de Usuario y contraseña con valores válidos.
  + **Resultados Esperados**: Visualizar la pantalla de Inicio.