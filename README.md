# Simple CRUD - Quarkus Project

![Quarkus Logo](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2F1.bp.blogspot.com%2F-gqE2ne-nwS0%2FX68qhcbatLI%2FAAAAAAAABCk%2F8V1-YWJrOqU0XqL52jJjVNya5xzT_PPLgCLcBGAsYHQ%2Fs16000%2Fquarkus.jpg&f=1&nofb=1)

This project uses Quarkus, the Supersonic Subatomic Java Framework.

- [Simple CRUD - Quarkus Project](#simple-crud---quarkus-project)
  * [Table of Contents](#table-of-contents)
    * [Extensions](#extensions)
    * [Running the application in dev mode](#running-the-application-in-dev-mode)
    * [Access to Swagger UI](#access-to-swagger-ui)
    * [Packaging and running the application](#packaging-and-running-the-application)
    * [Creating a native executable](#creating-a-native-executable)

## Extensions
To add extensions used in this project

``` shell script
.\mvnw quarkus:add-extensions -Dextensions="hibernate-or
m-panache" 
```
``` shell script
.\mvnw quarkus:add-extensions -Dextensions="quarkus-jdbc
-postgres"
```
``` shell script
.\mvnw quarkus:add-extensions -Dextensions="quarkus-resteasy-jackson"
```


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.


## Access to Swagger UI

http://localhost:8080/swagger-ui.html

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory. Be aware that it’s not an _über-jar_ as
the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-1.0-SNAPSHOT-runner`

