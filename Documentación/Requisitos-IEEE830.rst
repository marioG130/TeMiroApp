
**Especificación de Requisitos de Software**
############################################

(según el estándar de la norma IEEE 830)
++++++++++++++++++++++++++++++++++++++++


Proyecto: TeMiroApp (2023)
--------------------------


.. contents::


--------------


.. _1-introducción:

1) Introducción
===============

Este documento es una Especificación de Requisitos Software (ERS) para
al aplicación móbil del negocio de la Óptica Temiro. Esta especificación
se ha estructurado basándose en las directrices dadas por el estándar
IEEE "Práctica Recomendada para Especificaciones de Requisitos Software"
ANSI/IEEE 830, 1998.



.. _11-proposito:

1.1 Propósito
^^^^^^^^^^^^^

El presente documento tiene como propósito definir las especificaciones
funcionales y no funcionales para el desarrollo de la aplicación móbil
del negocio de la Óptica Temiro, orientado bridar un servicio extra a
sus clientes y al público en general.




.. _12-alcance:

1.2 Alcance
^^^^^^^^^^^

La aplicación móbil ...


.. _13-definiciones-y-abreviaturas:

1.3 Definiciones y abreviaturas
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

A continuación se establecen los detalles de ciertos conceptos usados a en el presente documento.

+----------------------------+--------------------------------------------+
| Nombre                     | Descripción                                |
+============================+============================================+
| **Usuario**                | Toda persona que ha descargado e instalado |
|                            | la aplicación móbil                        |
+----------------------------+--------------------------------------------+
| **Usuario Registrado**     | Usuarios que han realizado el proceso      |
|                            | de registro en la app                      |
+----------------------------+--------------------------------------------+
| **ERS**                    | Especificación de Requisitos del           |
|                            | Software                                   |
+----------------------------+--------------------------------------------+
| **RF**                     | Requerimiento Funcional                    |
+----------------------------+--------------------------------------------+
| **RNF**                    | Requerimiento No Funcional                 |
+----------------------------+--------------------------------------------+




.. _14-referencias:

1.4 Referencias
^^^^^^^^^^^^^^^

Referencias a documentos y enlaces externos.

======================== ==========
Título del Documento     Referencia
======================== ==========
Standard IEEE 830 - 1998 IEEE
======================== ==========

1.5 Resumen
^^^^^^^^^^^

La aplicación móbil ...



.. _2-descripción-general-1:

2) Descripción General
======================

.. _21-perspectiva-del-producto:

2.1 Perspectiva del Producto
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

La aplicación móbil ...




.. _22-funciones-del-producto:

2.2 Funciones del Producto
^^^^^^^^^^^^^^^^^^^^^^^^^^

La aplicación móbil ...





.. _23-características-de-los-usuarios:

2.3 Características de los usuarios
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Se describen a continuación las características de los usuarios:

=============== =====================================
Tipo de usuario Visitante/s
=============== =====================================
Formación       Manejo básico de aplicaciones móbiles
Actividades
=============== =====================================


=============== ===========
Tipo de usuario Visitante/s
=============== ===========
Formación
Actividades
=============== ===========

--



.. _24-restricciones:

2.4 Restricciones
^^^^^^^^^^^^^^^^^

-  Interfaz para ser usada con dispositivos móbiles Android.
-  Lenguajes y tecnologías en uso: Android con lenguaje de programación
   Java.




.. _3-requisitos-específicos-1:

3) Requisitos específicos
=========================


.. _31-requisitos-func:

3.1 Requisitos Funcionales
^^^^^^^^^^^^^^^^^^^^^^^^^^

Los requisitos funcionales se clasifican en siete grupos, de forma de agrupar los mismos para facilitar el análisis y desarrollo de la aplicación móbil. Estos grupos servirán como *Epicas* en la metodología de desarrollo ágil seguida por el equipo de desarrollo.

.. include:: req/rf1-paginas-principales.rst

.. include:: req/rf2-manejo-usuarios.rst

A continuación se detallan los requisitos funcionales del manejo de usuario: 

  * El sistema permitirá que un usuario inicie sesión con su nombre de usuario y contraseña"
  * El sistema permitirá el registro de un nuevo usuario ingresando email, nombre usuario y contraseña y aceptando los términos y condiciones.
  * El campo nombre acepta caracteres alfabéticos únicamente.
  * El sistema permitirá cambiar los datos del usuario incluyendo, nombre de usuario, contraseña, email.
  * El sistema almacenará los datos de todos los usuarios en una base de datos.
  * El sistema almacenara todas las transacciones realizadas por el usuario en la base de datos.
  *El sistema controlará el acceso y lo permitirá solamente a usuarios autorizados. Los usuarios deben ingresar al sistema con un nombre de usuario y contraseña.

.. include:: req/rf3-productos-servicios.rst

.. include:: req/rf4-pedidos-tienda.rst

.. include:: req/rf5-turnero-servicios.rst

.. include:: req/rf6-pruebas-vision.rst

.. include:: req/rf7-ejercicios-vision.rst




.. _32-requisitos-no-func:

3.2 Requisitos No Funcionales
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. include:: req/rnofuncionales.rst

.. include:: req/rf2-manejo-usuarios.rst

 * El sistema no deberá tardar más de 5 minutos en iniciar sesión.

