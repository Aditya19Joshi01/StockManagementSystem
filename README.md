# Stock Management System

## Problem Statement
The aim of the Stock Management System is to develop a robust and efficient platform for managing stock-related operations within a business organization. The system will streamline the process of tracking stock levels, managing users, handling orders, and generating reports for better decision-making.

## Synopsis
The Stock Management System is a product management tool that allows you to track your goods and services comprehensively. It maintains a complete record of all the orders you place, including details such as invoice number, date of purchase, product price, brand, category, payment history, and due payments. With this online application, you can easily and efficiently manage your purchases and view their statuses at a glance.

The system uses JSP, Spring Boot, and MySQL for database management, following the MVC architecture. The Admin (Supplier) is the main user who manages every activity, including adding brands, products, payment methods, and delivery statuses. It is designed for use by retailers, small shopkeepers, grocery store owners, and customers to maintain a complete record of their orders.

## Key Features
- **Inventory Tracking:** Track the quantity of each item in the inventory, including product name, quantity available, and unit price.
- **Order Processing:** Supports functionalities for placing orders, updating order status, tracking order history, and canceling orders to ensure timely delivery of products.
- **Reporting:** Displays stock levels, sales, and order history to provide valuable insights for decision-making and strategic planning.
- **User Management:** Allows administrators to manage user accounts (including customers, suppliers, etc.), roles, and permissions.
- **Payment:** Supports payment processing, enabling users to pay using their card details while purchasing a product.

## Benefits
- **Efficient Stock Management:** Streamlines stock management processes, reducing the risk of stockouts or overstocking.
- **Enhanced Order Processing:** Automated order processing reduces manual errors and improves the efficiency of order fulfillment processes.
- **Data-Driven Decision Making:** Comprehensive reporting capabilities provide valuable insights for data-driven decision-making and strategic planning.

## Use of MVC Architecture Pattern
### Model
- **BaseDTO:** Base class for all DTO (Data Transfer Object) classes, defining common properties like id.
- **CategoryDTO, OrderDTO, PaymentDTO, ProductDTO, UserDTO:** Domain model classes representing different entities in the application, containing fields corresponding to the attributes of each entity.

### View
- **BaseForm, CategoryForm, OrderForm, PaymentForm, ProductForm, UserForm:** Form objects used in the presentation layer, containing fields corresponding to the input fields in the user interface and transferring data between the view and controller.

### Controller
- **CategoryService, OrderService, PaymentService, ProductService, UserService:** Service classes responsible for handling business logic and acting as an intermediary between the model and view layers. They contain methods for performing CRUD (Create, Read, Update, Delete) operations on the model objects and interact with the corresponding DAO (Data Access Object) interfaces for database operations.

## Flow
- **Client Interaction:** The client interacts with the view layer by submitting requests or input data through forms.
- **Controller Processing:** The controller receives the requests from the view and invokes the appropriate service methods to perform business logic.
- **Service Layer:** The service layer interacts with the model layer (DTOs and DAOs) to fetch or manipulate data as required.
- **Model Manipulation:** Data is fetched, processed, or modified in the model layer based on the business logic.
- **Response Generation:** The controller receives the processed data from the service layer and generates an appropriate response, which is then sent back to the client.

## Design Principles: SOLID
- **Single Responsibility Principle (SRP):** Each class has a specific responsibility, such as providing services (Service classes), handling exceptions, and managing form data.
- **Open/Closed Principle (OCP):** The code does not demonstrate the Open/Closed Principle.
- **Liskov Substitution Principle (LSP):** The code does not demonstrate the Liskov Substitution Principle.
- **Interface Segregation Principle (ISP):** The DAO interfaces (CategoryDAO, OrderDAO, etc.) follow the Interface Segregation Principle by providing specific methods tailored to the needs of their clients (e.g., findById, findByEmail, etc.).
- **Dependency Inversion Principle (DIP):** Dependency Inversion is not demonstrated in the code.

### General Responsibility Assignment Software Patterns (GRASP)
- **Controller Pattern:** The CategoryService, OrderService, PaymentService, ProductService, and UserService classes manage specific aspects of the application's business logic.
- **Creator Pattern:** The BaseForm and its subclasses (CategoryForm, OrderForm, etc.) encapsulate the creation logic for form objects.

## Design Patterns
1. **Factory Method Pattern:** The BaseFactory class acts as a factory class that creates instances of ControllerForm, ProductForm, and OrderForm whenever required.
2. **Builder Pattern:** Used for building complex objects with optional parameters, such as constructing DTO objects with varying attributes in the Form classes. The populate() methods in the Form classes serve as builders for DTO objects.
3. **Facade Pattern:** The service classes provide a single interface to implement all the respective operations on categories, orders, products, etc.
4. **Interpreter Pattern:** The DataValidator class defines a way to interpret and evaluate language grammar or expressions, used to check if inputs are valid (e.g., phone number, email address for registration, card details).

## GitHub Link to Source Code
[Stock Management System Source Code](https://github.com/Aditya19Joshi01/StockManagementSystem)
