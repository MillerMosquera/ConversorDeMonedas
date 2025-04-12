
# 💱 Conversor de monedas - Integración con la API de Java

Este proyecto es una **aplicación de consola en Java** que permite realizar conversiones entre diferentes monedas utilizando una API de tasas de cambio en tiempo real. Integra buenas prácticas de programación orientada a objetos, manejo de JSON con Gson, modularización de servicios y persistencia básica en archivos `.json`.

---

## 📌 Características

- Conversión en tiempo real de divisas utilizando la [ExchangeRate API](https://www.exchangerate-api.com/).
- Interfaz de línea de comandos interactiva.
- Conversión entre:
  - Dólar ⇄ Peso Colombiano
  - Dólar ⇄ Real Brasileño
  - Dólar ⇄ Peso Argentino
- Uso de GSON para deserialización y serialización de datos JSON.
- Guardado de resultados en archivos locales `.json`.
- Diseño modular (Modelo, Servicio, DTO).
- Gestión de claves API con variables de entorno (`.env`).

---

## 🧠 Estructura del Proyecto

```
├── modelo
│   ├── conversion.java
│   └── conversionDTO.java
│
├── service
│   ├── conexionApi.java
│   ├── convertirGson.java
│   └── serviceConversion.java
│
├── .env
├── Main.java
└── conversion_moneda.json
```

---

## 🛠️ Requisitos

- Java 17 o superior
- [Gson](https://github.com/google/gson)
- [dotenv-java](https://github.com/cdimascio/dotenv-java)
- Clave válida de ExchangeRate API

---

## ⚙️ Instalación

1. Clona el repositorio:

```bash
git clone [https://github.com/MillerMosquera/ConversorDeMonedas]
cd ConversorDeMonedas
```

2. Crea un archivo `.env` en el directorio raíz con tu clave API:

```
APIKEY=tu_clave_api
```

3. Compila y ejecuta:

```bash
javac Main.java
java Main
```

> También puedes compilar todos los archivos Java con:
> ```bash
> javac */*.java Main.java
> ```

---

## 🎮 Uso

Al ejecutar la aplicación, se mostrará un menú con opciones para convertir entre monedas. El usuario debe ingresar la opción deseada y luego proporcionar la cantidad a convertir. El resultado se muestra en pantalla y se guarda en un archivo `conversion_moneda.json`.

---

## 📦 Dependencias

- [`dotenv-java`](https://github.com/cdimascio/dotenv-java)
- [`Gson`](https://github.com/google/gson)
- API: [ExchangeRate-API](https://www.exchangerate-api.com/)

---

## 🧪 Ejemplo de Conversión

```bash
 Bienvenido al conversor de moneda

 1. Dolar => Peso colombiano
 2. Peso colombiano => Dolar
 ...
 Ingrese la cantidad a convertir: 100

 Moneda='USD',
 Conversion='COP',
 cantidad=100.0,
 resultado=394768.0
```

---

## 📁 Archivos Generados

- `conversion_moneda.json`: Contiene el resultado de la última conversión efectuada.

---

## 🚀 Posibles mejoras

- Añadir interfaz gráfica (JavaFX o Swing).
- Permitir selección dinámica de cualquier par de monedas.
- Agregar historial completo de conversiones.
- Tests automatizados con JUnit.


