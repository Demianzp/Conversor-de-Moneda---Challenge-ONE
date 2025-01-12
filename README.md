# Conversor-de-Moneda---Challenge-ONE
# 🪙 Conversor de Monedas - Java

Este es un programa de conversión de monedas escrito en Java que permite convertir entre **Peso Argentino (ARS)**, **Dólar Estadounidense (USD)** y **Real Brasileño (BRL)**. El programa utiliza una API externa para obtener las tasas de cambio actualizadas y realizar las conversiones de manera precisa.

## 🚀 Descripción

El **Conversor de Monedas** permite a los usuarios ingresar una cantidad en una moneda y convertirla a otra de las tres opciones disponibles. El programa obtiene las tasas de cambio en tiempo real desde la API de [ExchangeRate-API](https://www.exchangerate-api.com/) y ofrece una interfaz de consola simple para facilitar la interacción.

## 📦 Funcionalidades

- ✅ Convertir entre **ARS**, **USD**, y **BRL**.
- ✅ Visualizar las tasas de cambio actualizadas.
- ✅ Menú interactivo en consola para elegir las monedas de origen y destino.
- ✅ Opción de salir del programa en cualquier momento.
- ✅ Validación de entradas del usuario (monedas válidas y cantidades).
- ✅ Cálculos precisos basados en las tasas de cambio actuales.

## 💻 Requisitos

- Java 11 o superior.
- Conexión a internet para acceder a la API de tasas de cambio.

## ⚙️ Instalación y Uso
### 1. Clona el repositorio

-Cuando ejecutes el programa, se te presentará un menú en la consola donde podrás elegir las monedas de origen y destino. El programa realizará la conversión utilizando las tasas de cambio más recientes y te mostrará el resultado.

## 📝 Notas

- El programa está utilizando la API pública de **ExchangeRate-API** para obtener las tasas de cambio. Si deseas utilizarla en producción, asegúrate de tener una clave de API válida.
- El código está diseñado para permitir futuras mejoras, como la inclusión de más monedas o la personalización de la interfaz.

## 🛠️ Estructura del Proyecto

- `Main.java`: Clase principal que contiene el método `main` y gestiona la ejecución del programa.
- `ConversorMoneda.java`: Lógica principal de conversión de monedas, incluyendo la comunicación con la API.
- `Moneda.java`: Define el registro `Moneda` para almacenar información sobre cada moneda.

## 🔧 Tecnologías Usadas

- **Java 11+**
- **API de ExchangeRate-API** (para tasas de cambio)
- **Gson** (para analizar JSON)

## 🌐 API Utilizada

- **ExchangeRate-API**: Esta API proporciona tasas de cambio de divisas en tiempo real. Se utiliza para obtener las tasas de conversión entre **ARS**, **USD**, y **BRL**. La API requiere una clave de API que puedes obtener al registrarte en [ExchangeRate-API](https://www.exchangerate-api.com/).
