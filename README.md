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

## 🌿 Control de versiones

Se utilizarán ramas para organizar el desarrollo de las historias de usuario:

- `main`: versión estable del proyecto.
- `develop`: integración de funcionalidades.
- `feature/HU-1-login`
- `feature/HU-2-home`
- `feature/HU-3-nueva-cita`
- `feature/HU-4-detalle`
- `feature/HU-5-editar`

Los cambios se integrarán mediante Pull Requests para facilitar la revisión del código y mantener organizada la colaboración.

## 🚀 Instalación y ejecución

1. Clonar el repositorio:

   ```bash
   git clone [URL_DEL_REPOSITORIO](https://github.com/Nel10/DogApp.git)
   ```

2. Abrir el proyecto desde Android Studio.
3. Esperar la sincronización de Gradle.
4. Conectar un dispositivo Android o iniciar un emulador.
5. Ejecutar la aplicación desde Android Studio.

## 📌 Estado del proyecto

DogApp se encuentra en fase de desarrollo. Las funcionalidades se implementarán progresivamente de acuerdo con las historias de usuario y las actividades registradas en Jira.

---

**DogApp – Gestión de citas veterinarias 🐶**
