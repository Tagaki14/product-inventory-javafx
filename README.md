# Product Inventory Management

A desktop application for managing product inventory, built with **JavaFX** and **Java**. This application allows users to register products, organize them by category, search for products, and view detailed product information through a simple and intuitive interface.

## Features

- **Add Products** — Register new products with their name, category, and price.
- **Automatic Product Code** — Generate unique product codes automatically.
- **Product Categories** — Organize products into Food and Beverage categories.
- **Product List** — Display registered products in a structured table.
- **Search Products** — Find products by name.
- **Product Details** — View detailed information about a selected product.
- **Input Validation** — Prevent empty product names and invalid prices.

## Technologies Used

- Java 17+
- JavaFX 21
- Maven
- FXML
- CSS

## Getting Started

### Prerequisites

Make sure you have installed:

- Java Development Kit (JDK) 17 or later
- Apache Maven

### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/Tagaki14/product-inventory-javafx.git
   ```

2. Navigate to the project directory:

   ```bash
   cd product-inventory-javafx
   ```

3. Run the application:

   ```bash
   mvn clean javafx:run
   ```

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── kelas/
│   │       ├── MainApp.java
│   │       ├── Navigator.java
│   │       ├── controller/
│   │       │   ├── FormController.java
│   │       │   ├── DaftarController.java
│   │       │   └── DetailController.java
│   │       ├── data/
│   │       │   └── DataProduk.java
│   │       └── model/
│   │           └── Produk.java
│   └── resources/
│       └── kelas/
│           ├── form.fxml
│           ├── daftar.fxml
│           ├── detail.fxml
│           └── styles/
│               └── app.css
└── pom.xml
```

## Data Storage

This application currently uses in-memory storage. Product records are maintained while the application is running and are not permanently saved to a database.

## Application Scope

This project focuses on basic product inventory recording, including product registration, categorization, searching, and viewing product details.

---

**Developed as a JavaFX practical project.**
