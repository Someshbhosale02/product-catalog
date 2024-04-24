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
    mvn spring-boot:run
    ```

6. The application should now be running on `http://localhost:8080`.

## API Endpoints

### Product Endpoints

- **GET /api/products**: Retrieve all products.
- **GET /api/products/{id}**: Retrieve a product by ID.
- **POST /api/products**: Create a new product.
- **PUT /api/products/{id}**: Update an existing product.
- **DELETE /api/products/{id}**
- **GET /api/products/search**: Search products with filters for name, category, and attributes.

### Category Endpoints

- **GET /api/categories**: Retrieve all categories.
- **GET /api/categories/{id}**: Retrieve a category by ID.
- **POST /api/categories**: Create a new category.
- **PUT /api/categories/{id}**: Update an existing category.
- **DELETE /api/categories/{id}**: Delete a category by ID.

### Attribute Endpoints

- **GET /api/attributes**: Retrieve all attributes.
- **GET /api/attributes/{id}**: Retrieve an attribute by ID.
- **POST /api/attributes**: Create a new attribute.
- **PUT /api/attributes/{id}**: Update an existing attribute.
- **DELETE /api/attributes/{id}**: Delete an attribute by ID.

### Rating Endpoint

- **POST /api/products/{id}/rate**: Rate a product. Body should contain `userId`, `rating`, and optional `comment`.

## Documentation

Additional documentation, including data models and API usage examples, can be found in the `docs` directory.

- Data Model Diagram: [Link to Diagram](docs/data_model_diagram.png)
- Sample JSON of Product Entity:

```json
{
  "id": "1",
  "name": "Product 1",
  "description": "Description of Product 1",
  "price": 19.99,
  "categories": ["Category A", "Category B"],
  "attributes": [
    {"size": "Medium"},
    {"color": "Red"},
    {"brand": "Brand X"}
  ],
  "availability": {
    "inStock": true,
    "quantity": 100
  },
  "ratings": [
    {"userId": "user1", "rating": 4, "comment": "Great product!"},
    {"userId": "user2", "rating": 5}
  ]
}
## Advanced Features

- Pagination and sorting implemented in product list retrieval endpoint.

## Evaluation Criteria

- **Data Model Complexity Handling**: Ability to implement and manipulate the nested data structure.
- **Code Quality**: Adherence to Java best practices and clear, maintainable code.
- **Effective Documentation**: Clarity and thoroughness of the setup and API usage documentation.
- **Database Skills**: Proper use of MongoDB features or SQL schema design to handle the entity structure.


## Contributing

Contributions are welcome! Please feel free to submit issues or pull requests.
