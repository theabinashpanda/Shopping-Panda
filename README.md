# Shopping-Panda

A web application that allows users to list, view, update, and delete products with a search feature. Built using React for the frontend and Spring Boot for the backend.

## Table of Contents

- [UML Design](#uml-design)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Running the Backend](#running-the-backend)
- [Test and Coverage Reports](#test-and-coverage-reports)
- [Screenshots](#screenshots)
- [Additional Knowledge](#additional-knowledge)

## UML Design

The following diagram represents the architecture and flow of the Shopping-Panda application:

![image](https://github.com/user-attachments/assets/eca06b33-f5be-4a5f-ab77-85494944fb0b)

## Features

- **Product Management**: List, view, update, and delete products.
- **Search Functionality**: Easily search for products by name or category.

## Technology Stack

- **Frontend**:
  - React
  - CSS
  
- **Backend**:
  - Spring Boot
  - Java

- **Database**:
  - MySQL

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/theabinashpanda/Shopping-Panda.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd Shopping-Panda
   ```

3. **Set up the backend**:
   - Navigate to the backend directory (if applicable).
   - Follow the instructions to set up the Spring Boot application.

4. **Set up the frontend**:
   - Navigate to the frontend directory.
   - Install dependencies:
     ```bash
     npm install
     ```

5. **Run the application**:
   - **Note**: Before running the backend, ensure that MySQL is running.
   - Start the backend server:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Start the frontend development server:
     ```bash
     npm run dev
     ```

## Usage

- Access the application via `http://localhost:5173` for the frontend.
- Use the provided UI to manage products.

## API Endpoints

- **GET /api/products**: Retrieve all products.
- **GET /api/products/:id**: Retrieve a single product by ID.
- **POST /api/products**: Create a new product.
- **PUT /api/products/:id**: Update an existing product.
- **DELETE /api/products/:id**: Delete a product.

## Running the Backend

### Using IntelliJ IDEA

1. **Open the Project**:
   - Launch IntelliJ IDEA and open the project by selecting the `pom.xml` file located in the backend directory.

2. **Import Dependencies**:
   - IntelliJ will automatically import the Maven dependencies. If not, right-click on the `pom.xml` file and select `Maven` > `Reimport`.

3. **Run the Application**:
   - Locate the main application class (usually annotated with `@SpringBootApplication`).
   - Right-click on the class and select `Run 'YourApplicationName'`.
   - The application will start, and you can view the console for any logs.

### Using Other IDEs

- For Eclipse or other IDEs, ensure that you have the necessary plugins for Maven and Spring Boot installed. Follow similar steps to import the project and run the application.

## Test and Coverage Reports

### Running Tests

- To run tests, execute the following command in the backend directory:
  ```bash
  ./mvnw test
  ```

### Generating Coverage Reports

- To generate coverage reports, you can use the following command:
  ```bash
  ./mvnw test jacoco:report
  ```
- The coverage reports will be generated in the `target/site/jacoco` directory. Open the `index.html` file in a web browser to view the coverage details.

## Screenshots

Below are some screenshots showcasing the Shopping-Panda application:

1. **Home Page**:
  <img width="1680" alt="Screenshot 2025-01-23 at 3 01 28 AM" src="https://github.com/user-attachments/assets/04c8a393-e992-4c64-b02e-ee9cac59e73d" />

2. **Product List**:
   ![Product List](screenshots/product-list.png)

3. **Product Details**:
    <img width="1680" alt="image" src="https://github.com/user-attachments/assets/a8b0ebb4-b6a4-47ab-b9ea-e77889ece807" />

4. **Add/Edit Product Form**:
   <img width="1680" alt="image" src="https://github.com/user-attachments/assets/5751e161-484d-4c53-ae4f-ad60b84d33c6" />
   <img width="1679" alt="image" src="https://github.com/user-attachments/assets/5924ca1b-cd82-423f-9388-9b13f408a596" />


5. **Search Functionality**:
   
    <img width="370" alt="image" src="https://github.com/user-attachments/assets/4a6d8a96-9517-455e-a0f6-9d2ab5cb7ebe" />

## Additional Knowledge

### Initializing a Spring Boot Project from start.spring.io

To create a new Spring Boot project from **start.spring.io**, follow these steps:

#### 1. **Open start.spring.io**
   - Navigate to [start.spring.io](https://start.spring.io) in your web browser.
     <img width="1678" alt="image" src="https://github.com/user-attachments/assets/53580132-d1fa-40b7-b193-16f7b9ad07fd" />


#### 2. **Project Configuration**
   - Choose the project type:
     - **Maven** (default) or **Gradle**.
   - Choose the language:
     - **Java** (default), **Kotlin**, or **Groovy**.
   - Set the **Spring Boot version** (use the latest stable release).

#### 3. **Add Project Metadata**
   - Fill in the following fields:
     - **Group**: This typically represents your organization's domain name in reverse (e.g., `com.example`).
     - **Artifact**: This is the name of your project (e.g., `shopping-panda`).
     - **Name**: The display name of your application (defaults to the artifact name).
     - **Description**: A brief description of the project (e.g., `A simple shopping management application`).
     - **Package Name**: Automatically generated based on the group and artifact (you can customize it if needed).

#### 4. **Dependencies**
   - Click on **Add Dependencies** and select the necessary dependencies for your project. For example:
     - **Spring Web**: For building REST APIs.
     - **Spring Data JPA**: For database interactions.
     - **MySQL Driver**: To connect to a MySQL database.
     - **Spring Boot DevTools**: For hot-reloading during development.
     - **Lombok**: To reduce boilerplate code.

#### 5. **Generate the Project**
   - Once you've configured the project, click the **Generate** button.
   - A `.zip` file containing the project will be downloaded.

#### 6. **Extract the Project**
   - Extract the downloaded `.zip` file to your desired location.

#### 7. **Open the Project in an IDE**
   - Open the extracted project folder in your preferred IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).
   - If you are using IntelliJ IDEA:
     - Open the project by selecting the `pom.xml` file.
     - Ensure Maven dependencies are imported (IntelliJ usually does this automatically).

#### 8. **Run the Application**
   - Locate the main application class (annotated with `@SpringBootApplication`).
   - Run the class to start the application:
     - In IntelliJ IDEA: Right-click the file and select **Run 'YourApplicationName'**.
     - Alternatively, use the terminal:
       ```bash
       ./mvnw spring-boot:run
       ```

#### 9. **Verify the Application**
   - Once the application starts, verify it by accessing `http://localhost:8080` in your browser or testing an API endpoint using tools like Postman.

