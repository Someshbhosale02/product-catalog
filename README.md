# Product Catalogue API

This project provides RESTful API endpoints for managing a product catalogue system. The system is designed to handle products with complex, nested data structures, utilizing MongoDB for storage due to its ability to store nested documents efficiently.

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven
- MongoDB installed and running locally or accessible remotely

### Installation Steps

1. Clone the repository:

    ```bash
    git clone https://github.com/Someshbhosale02/product-catalog.git
    ```

2. Navigate to the project directory:

    ```bash
    cd product-catalog
    ```

3. Update `application.properties` file with your MongoDB connection details:

    ```properties
    spring.data.mongodb.host=<mongodb-host>
    spring.data.mongodb.port=<mongodb-port>
    spring.data.mongodb.database=<mongodb-database-name>
    ```

4. Build the project using Maven:

    ```bash
    mvn clean install
    ```

5. Run the application:

    ```bash
    java -jar target/product-catalogue-api.jar
    ```

6. The application should now be running on `http://localhost:8080`.

## API Endpoints

### Product Endpoints

- **GET /api/products**: Retrieve all products.
- **GET /api/products/{id}**: Retrieve a product by ID.
- **POST /api/products**: Create a new product.
- **PUT /api/products/{id}**: Update an existing product.
- **DELETE /api/products/{id}
