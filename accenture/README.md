# testaccenture

Este proyecto es una prueba tecnica.

---

## **Requisitos previos**

Asegúrate de que los siguientes requisitos estén instalados en tu máquina:

- **Java 17** o superior.
- **Apache Maven** (si no estás usando el wrapper `mvnw`).
- **Docker** (opcional, para ejecutar en contenedores).

---

## **Instrucciones para ejecutar**

### **1. Ejecución local**

#### **Paso 1: Clonar el repositorio**
Clona este repositorio en tu máquina local:

```bash
git clone <URL_DEL_REPOSITORIO>
cd my-franchise-project
```

#### **Paso 2: Compilar el proyecto**
Usa Maven o el wrapper de Maven (`mvnw`) para compilar y empaquetar la aplicación:

```bash
./mvnw clean package -DskipTests
```

Esto generará un archivo `.war` en el directorio `target/`.

#### **Paso 3: Ejecutar la aplicación**
Ejecuta la aplicación con el siguiente comando:

```bash
java -jar target/my-franchise-app.war
```

La aplicación estará disponible en [http://localhost:8080](http://localhost:8080).

---

### **2. Ejecución con Docker**

#### **Paso 1: Construir la imagen Docker**
Asegúrate de que Docker esté instalado y en ejecución. Luego, construye la imagen Docker:

```bash
docker build -t my-franchise-app .
```

#### **Paso 2: Ejecutar el contenedor**
Ejecuta el contenedor de la aplicación mapeando el puerto 8080:

```bash
docker run -p 8080:8080 my-franchise-app
```

La aplicación estará disponible en [http://localhost:8080](http://localhost:8080).

---

## **Endpoints disponibles**

La API ofrece los siguientes endpoints:

1. **Agregar una nueva franquicia**:  
   `POST /franquicias`

2. **Agregar una sucursal a una franquicia**:  
   `POST /franquicias/{id}/sucursales`

3. **Agregar un producto a una sucursal**:  
   `POST /sucursales/{id}/productos`

4. **Eliminar un producto de una sucursal**:  
   `DELETE /productos/{id}`

5. **Modificar el stock de un producto**:  
   `PUT /productos/{id}`

6. **Obtener el producto con mayor stock en una sucursal**:  
   `GET /sucursales/{id}/mayor-stock`

---

---

© 2025 testaccenture

