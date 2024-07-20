# TestChoucair

# Proyecto de Automatización de Pruebas

Este proyecto contiene las pruebas automatizadas para la aplicación usando 
Serenity BDD y Screenplay Pattern.

## Introducción

Este proyecto utiliza Selenium, Serenity BDD y el patrón 
Screenplay para automatizar las pruebas de la aplicación web. 
Proporciona un conjunto de pruebasautomatizadas para asegurar 
la calidad del software.

## Pre-requisitos

Asegúrate de tener instalados los siguientes software antes de 
ejecutar las pruebas:

- [Java JDK 8 o superior](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/install/)
- [Git](https://git-scm.com/downloads)

## Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/Sergiorr22/TestChoucair.git
    cd tu-repositorio
    ```

2. Compila el proyecto:

    ```bash
    gradle clean build
    ```

## Ejecución de Pruebas

Para ejecutar las pruebas, ir a la siguiente ruta y 
ejecutar el runner con el tag @candidates

```bash
    java/com/co/testchoucair/runners/Runner.java
 ```

## Evidencias pruebas

Para validar las evidencias tomadas en el proceso
de prueba validar la ruta

```bash
TestChoucair/target/site/serenity/index.html
 ```