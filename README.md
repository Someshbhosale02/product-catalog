# Product Catalogue REST API Documentation

This document provides information on how to use the REST API for the Product Catalogue system.

## Table of Contents

1. [Introduction](#introduction)
2. [Endpoints](#endpoints)
3. [Request and Response Formats](#request-and-response-formats)
4. [Setup and Database](#setup-and-database)
5. [Advanced Features](#advanced-features)
6. [Testing](#testing)
7. [Examples](#examples)

## <a name="introduction"></a>Introduction

The Product Catalogue REST API allows users to manage products, search for products with various filters, and rate products.

## <a name="endpoints"></a>Endpoints

The following endpoints are available:

- **GET /products**: Retrieve a list of products.
- **POST /products**: Add a new product.
- **GET /products/{id}**: Retrieve a specific product by ID.
- **PUT /products/{id}**: Update a specific product by ID.
- **DELETE /products/{id}**: Delete a specific product by ID.
- **GET /products/search**: Search for products with filters.
- **POST /products/{id}/rate**: Rate a product.

## <a name="request-and-response-formats"></a>Request and Response Formats

### Product Entity

```json
{
  "id": "string",
  "name": "string",
  "description": "string",
  "price": "number",
  "categories": ["string"],
  "attributes": [{"key": "string", "value": "string"}],
  "availability": {
    "inStock": "boolean",
    "quantity": "integer"
  },
  "ratings": [{"userId": "string", "rating": "number", "comment": "string"}]
}
