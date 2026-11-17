# 🐾 DogApp

**Aplicación móvil para la gestión y administración de citas veterinarias.**

DogApp es una aplicación móvil nativa para Android orientada a facilitar el registro, consulta, edición y eliminación de citas veterinarias. Su propósito es centralizar la información de las mascotas y sus propietarios mediante una interfaz sencilla e intuitiva.

## 📌 Información del proyecto

- **Nombre:** DogApp
- **Tipo de proyecto:** Aplicación móvil nativa Android
- **Área:** Gestión de citas veterinarias
- **Metodología de desarrollo:** Trabajo colaborativo por historias de usuario SCRUM
- **Estado:** En desarrollo

## 🎯 Objetivo

Desarrollar una aplicación móvil que permita administrar citas veterinarias, facilitando el registro de mascotas, la consulta de sus datos y la actualización de la información asociada a cada cita.

## ⚙️ Funcionalidades principales

| Historia de usuario | Funcionalidad |
|---|---|
| HU 1.0 | Inicio de sesión mediante autenticación biométrica. |
| HU 2.0 | Visualización y administración de citas registradas. |
| HU 3.0 | Registro de nuevas citas veterinarias. |
| HU 4.0 | Consulta del detalle de una cita. |
| HU 5.0 | Edición de la información de una cita. |

## 🛠️ Tecnologías y herramientas

- **Android Studio:** Entorno de desarrollo.
- **Kotlin:** Lenguaje de programación.
- **XML:** Diseño de interfaces.
- **MVVM:** Patrón de arquitectura.
- **Repository Pattern:** Organización del acceso a los datos.
- **Room / SQLite:** Persistencia de información local.
- **Retrofit:** Consumo de servicios REST.
- **Dog CEO API:** Consulta de razas e imágenes de perros.
- **Lottie:** Animaciones.
- **Navigation Component:** Navegación entre pantallas.
- **Git y GitHub:** Control de versiones y trabajo colaborativo.
- **Jira:** Gestión y seguimiento de actividades.

## 🏗️ Arquitectura

El proyecto utiliza el patrón **MVVM (Model-View-ViewModel)** junto con el patrón **Repository**, buscando separar las responsabilidades de la interfaz, la lógica de presentación y el acceso a los datos.

La aplicación contempla los siguientes componentes:

- **View:** Fragments y layouts XML.
- **ViewModel:** Gestión del estado y lógica de presentación.
- **Model:** Entidades y modelos de datos.
- **Repository:** Centralización del acceso a los datos.
- **Room:** Almacenamiento local de las citas.
- **Retrofit:** Comunicación con la API externa.

## 👥 Equipo de trabajo

| Integrante | Rol |
|---|---|
| Shannel Bejarano | Project Manager / QA |
| Jorge Ramos| UX/UI / Desarrollo de interfaces |
| Sebastian Alonso | Desarrollo Android / Base de datos |
| Camilo Hurtado | Desarrollo Android / Integraciones |

## 📂 Documentación del proyecto

En este espacio se centralizará la documentación académica y técnica de DogApp.

**Documento principal del proyecto:**

👉 [Consultar documentación de DogApp](https://docs.google.com/document/d/1YXqE5odZ6duSelMpy7Tk9AC1Mr9ztPAr2b3ZenaDpVE/edit?usp=sharing)


## 🔗 Recursos del proyecto

- **Repositorio GitHub:** [DogApp](https://github.com/Nel10/DogApp)
- **Tablero Jira:** [Seguimiento del proyecto](https://miniproyecto1.atlassian.net/?continue=https%3A%2F%2Fminiproyecto1.atlassian.net%2Fwelcome%2Fsoftware%3FprojectId%3D10132&atlOrigin=eyJpIjoiMGM3ZjVmNzk1MmJhNGIzYWIxZDg3NzdiZDNmY2RhZDIiLCJwIjoiamlyYS1zb2Z0d2FyZSJ9)
- **Documentación:** [Documento principal](https://docs.google.com/document/d/1YXqE5odZ6duSelMpy7Tk9AC1Mr9ztPAr2b3ZenaDpVE/edit?usp=sharing)

## 🌿 Control de versiones y estrategia de ramas

El proyecto utilizará Git y GitHub para gestionar el control de versiones y facilitar el trabajo colaborativo entre los integrantes.

Se manejarán dos ramas principales:

| Rama | Propósito |
|---|---|
| `develop` | Rama principal de desarrollo e integración de las funcionalidades del proyecto. |
| `master` | Rama estable que contendrá la versión final o las versiones verificadas de la aplicación. |

### Ramas de trabajo por historia de usuario

Para organizar el desarrollo, cada integrante deberá crear una rama temporal a partir de `develop`, utilizando una nomenclatura que permita identificar la historia de usuario en la que está trabajando.

La estructura será:

`feature/HU-XX-descripcion`

Ejemplos:

- `feature/HU-01-login`
- `feature/HU-02-home`
- `feature/HU-03-nueva-cita`
- `feature/HU-04-detalle`
- `feature/HU-05-editar`

Si se necesita corregir un error, se podrá utilizar:

`fix/HU-XX-descripcion`

### Flujo de trabajo

1. Actualizar la rama `develop` antes de comenzar una actividad.
2. Crear una rama de trabajo a partir de `develop`, identificando la historia de usuario correspondiente.
3. Realizar los cambios y registrar commits descriptivos.
4. Subir la rama de trabajo al repositorio remoto.
5. Crear un Pull Request para integrar los cambios en `develop`.
6. Revisar y validar los cambios antes de aprobar la integración.
7. Una vez que las funcionalidades estén integradas y verificadas, realizar un Pull Request de `develop` hacia `master`.

### Convención de commits

Los mensajes de los commits deberán identificar la historia de usuario y el cambio realizado.

Ejemplos:

- `HU-01: Implementar autenticación biométrica`
- `HU-02: Crear listado de citas`
- `HU-03: Implementar registro de citas`
- `HU-04: Implementar detalle de citas`
- `HU-05: Implementar edición de citas`

**Objetivo:** mantener una estructura organizada que permita identificar qué historia de usuario se está desarrollando, quién realiza los cambios y cómo se integran las funcionalidades al proyecto.

## 🚀 Instalación y ejecución

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/Nel10/DogApp.git
   ```

2. Abrir el proyecto desde Android Studio.
3. Esperar la sincronización de Gradle.
4. Conectar un dispositivo Android o iniciar un emulador.
5. Ejecutar la aplicación desde Android Studio.

## 📌 Estado del proyecto

DogApp se encuentra en fase de desarrollo. Las funcionalidades se implementarán progresivamente de acuerdo con las historias de usuario y las actividades registradas en Jira.

---

**DogApp – Gestión de citas veterinarias 🐶**
