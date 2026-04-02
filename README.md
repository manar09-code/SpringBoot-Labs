# Spring Boot Labs

A comprehensive collection of Spring Boot laboratory exercises covering fundamentals to advanced concepts in Java-based web application development.

## Repository Structure

```
SpringBoot-Labs/
├── Lab1/              # Hello World & Spring Boot Fundamentals
│   └── hello-world/   # Basic Spring Boot project
├── Lab2/              # Web Applications & Thymeleaf
│   ├── Lab basic/
│   └── Lab advanced/
├── Lab3/              # Data Access & Database Integration
│   ├── Lab basic/
│   └── Lab advanced/
├── Lab4/              # REST APIs & Advanced Concepts
│   ├── Lab basic/
│   └── Lab advanced/
├── Lab5/              # Advanced Topics
│   └── Lab basic/
└── README.md
```

## Technologies Used

- **Java 8+** (82.9%)
- **Spring Boot**: Modern Java framework
- **Maven**: Build and dependency management
- **Thymeleaf**: Server-side Java template engine (16%)
- **Spring Data JPA**: Data access layer
- **Spring MVC**: Web framework
- **MySQL/H2**: Database options

---

## Prerequisites

### Required Software

1. **Java Development Kit (JDK)**
   - JDK 8 or higher
   - Verify installation: `java -version`

2. **Maven**
   - Version 3.6.0 or higher
   - Verify installation: `mvn -version`

3. **IDE** (Optional but recommended)
   - IntelliJ IDEA
   - Eclipse IDE
   - VS Code with Java extensions
   - Spring Tool Suite (STS)

4. **Database** (for data access labs)
   - MySQL 5.7+
   - Or use H2 (in-memory database, included)

---

## General Setup Instructions

### 1. Prerequisites Verification

```bash
# Check Java version (should be 8 or higher)
java -version

# Check Maven version
mvn -version

# If not installed, download from:
# Java: https://www.oracle.com/java/technologies/downloads/
# Maven: https://maven.apache.org/download.cgi
```

### 2. Clone the Repository

```bash
git clone https://github.com/manar09-code/SpringBoot-Labs.git
cd SpringBoot-Labs
```

---

## Lab-by-Lab Execution Guide

---

### **Lab 1: Hello World & Spring Boot Fundamentals**

**Objective**: Learn Spring Boot basics and create your first Spring Boot application.

**Location**: `Lab1/hello-world/`

**Project Structure**:
```
hello-world/
├── hello-world/          # Maven project
│   ├── src/
│   ├── pom.xml           # Maven configuration
│   └── .idea/
└── .idea/
```

**Setup & Execution**:

```bash
# Navigate to Lab1
cd Lab1/hello-world

# Navigate to the Maven project
cd hello-world

# Check pom.xml file to see dependencies
cat pom.xml

# Build the project (downloads dependencies)
mvn clean install

# Run the application
mvn spring-boot:run

# Alternative: Run the generated JAR file
java -jar target/hello-world-1.0.0.jar
```

**Access the Application**:
- Application Server: `http://localhost:8080`
- Check console for startup messages

**Key Concepts**:
- Spring Boot application structure
- pom.xml and dependency management
- Auto-configuration
- Embedded Tomcat server

**Expected Output**:
```
Started HelloWorldApplication in X.XXX seconds (JVM running for X.XXX)
```

---

### **Lab 2: Web Applications & Thymeleaf**

**Objective**: Build web applications using Spring MVC and Thymeleaf templating.

**Location**: `Lab2/` (with Lab basic and Lab advanced subdirectories)

#### **Lab 2 - Basic**

**Location**: `Lab2/Lab basic/spring-thymeleaf-lab/`

**Project Contents**:
```
spring-thymeleaf-lab/
├── src/
│   ├── main/
│   │   ├── java/          # Java source files
│   │   └── resources/
│   │       ├── templates/ # Thymeleaf HTML templates
│   │       └── static/    # CSS, JS, images
│   └── test/
├── pom.xml
└── .idea/
```

**Setup & Execution**:

```bash
# Navigate to Lab 2 Basic
cd Lab2/Lab\ basic/spring-thymeleaf-lab

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

# Or build and run JAR
mvn clean package
java -jar target/spring-thymeleaf-lab-*.jar
```

**Access the Application**:
- Web Application: `http://localhost:8080`
- Home Page: `http://localhost:8080/`
- Check browser console for any errors

**Features**:
- Spring MVC controllers
- Thymeleaf template engine
- HTML form processing
- Model-View pattern

**Common Endpoints** (may vary based on implementation):
- `/` - Home page
- `/list` - List items
- `/add` - Add new item form
- `/form` - Form submission

---

#### **Lab 2 - Advanced**

**Location**: `Lab2/Lab advanced/`

**Setup & Execution**:

```bash
# Navigate to Lab 2 Advanced
cd Lab2/Lab\ advanced

# Follow similar steps as Lab 2 Basic
mvn clean install
mvn spring-boot:run
```

**Advanced Features** (varies by implementation):
- Form validation
- Database integration
- Session handling
- Error pages
- Security basics

---

### **Lab 3: Data Access & Database Integration**

**Objective**: Learn Spring Data JPA and database operations.

**Location**: `Lab3/` (with Lab basic and Lab advanced subdirectories)

#### **Lab 3 - Basic**

**Location**: `Lab3/Lab basic/`

**Setup & Execution**:

```bash
# Navigate to Lab 3 Basic
cd Lab3/Lab\ basic

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

**Database Configuration**:

The application uses H2 in-memory database by default. To access H2 console:
- H2 Console: `http://localhost:8080/h2-console`
- Default URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

**Or configure MySQL**:

Edit `application.properties` or `application.yml`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springboot_lab
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

**Features**:
- Spring Data JPA repositories
- Entity relationships
- CRUD operations
- JPA queries

---

#### **Lab 3 - Advanced**

**Location**: `Lab3/Lab advanced/`

**Setup & Execution**:

```bash
# Navigate to Lab 3 Advanced
cd Lab3/Lab\ advanced

mvn clean install
mvn spring-boot:run
```

**Advanced Features**:
- Complex queries
- Relationships (One-to-Many, Many-to-Many)
- Pagination and sorting
- Custom queries using @Query
- Transaction management

---

### **Lab 4: REST APIs & Advanced Concepts**

**Objective**: Build RESTful web services with Spring Boot.

**Location**: `Lab4/` (with Lab basic and Lab advanced subdirectories)

#### **Lab 4 - Basic**

**Location**: `Lab4/Lab basic/`

**Setup & Execution**:

```bash
# Navigate to Lab 4 Basic
cd Lab4/Lab\ basic

mvn clean install
mvn spring-boot:run
```

**Access the API**:
- Base URL: `http://localhost:8080/api`
- Swagger UI (if enabled): `http://localhost:8080/swagger-ui.html`

**Test Endpoints using curl**:

```bash
# GET request
curl http://localhost:8080/api/items

# POST request
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Item Name","description":"Item Description"}'

# GET specific item
curl http://localhost:8080/api/items/1

# PUT request
curl -X PUT http://localhost:8080/api/items/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Updated Name"}'

# DELETE request
curl -X DELETE http://localhost:8080/api/items/1
```

**Or use Postman**:
1. Download and install Postman
2. Create new requests for each endpoint
3. Set method (GET, POST, PUT, DELETE)
4. Add body for POST/PUT requests

**Features**:
- @RestController and @RequestMapping
- HTTP methods handling
- Request/response JSON
- HTTP status codes
- Path variables and query parameters

---

#### **Lab 4 - Advanced**

**Location**: `Lab4/Lab advanced/`

**Setup & Execution**:

```bash
# Navigate to Lab 4 Advanced
cd Lab4/Lab\ advanced

mvn clean install
mvn spring-boot:run
```

**Advanced REST Features**:
- Exception handling with @ControllerAdvice
- Request validation
- Pagination and filtering
- Content negotiation
- HATEOAS (Hypermedia As The Engine Of Application State)
- API versioning

---

### **Lab 5: Advanced Topics**

**Objective**: Explore advanced Spring Boot features and best practices.

**Location**: `Lab5/Lab basic/`

**Setup & Execution**:

```bash
# Navigate to Lab 5
cd Lab5/Lab\ basic

mvn clean install
mvn spring-boot:run
```

**Topics Covered** (may vary):
- Security (Spring Security)
- Caching
- Scheduling
- Async operations
- Monitoring and actuators
- Configuration management
- Logging best practices

**Access Actuator Endpoints** (if enabled):
```bash
# Health check
curl http://localhost:8080/actuator/health

# Metrics
curl http://localhost:8080/actuator/metrics
```

---

## Common Maven Commands

```bash
# Clean build (removes target folder)
mvn clean

# Compile project
mvn compile

# Run tests
mvn test

# Build JAR package
mvn package

# Install to local repository
mvn install

# Clean and build JAR
mvn clean package

# Run with spring-boot-maven-plugin
mvn spring-boot:run

# Skip tests during build
mvn clean package -DskipTests

# View dependency tree
mvn dependency:tree

# Check for dependency updates
mvn versions:display-dependency-updates
```

---

## Troubleshooting

### 1. Port Already in Use

```bash
# Change port in application.properties
echo "server.port=8081" >> src/main/resources/application.properties

# Or run with different port
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

### 2. Maven Dependencies Not Downloading

```bash
# Clear Maven cache and re-download
rm -rf ~/.m2/repository
mvn clean install
```

### 3. Java Version Mismatch

```bash
# Check current Java version
java -version

# Set Java version in pom.xml
# Add to <properties> section:
# <java.version>11</java.version>
# <maven.compiler.source>11</maven.compiler.source>
# <maven.compiler.target>11</maven.compiler.target>
```

### 4. Application Won't Start

```bash
# Check for error messages in console
# Verify all dependencies are installed
mvn clean install

# Run with debug logging
mvn spring-boot:run -Dspring-boot.run.arguments="--debug"
```

### 5. Database Connection Issues

```bash
# Verify MySQL is running
mysql -u root -p

# Check database configuration in application.properties
# Ensure database exists and credentials are correct
```

---

## Testing Applications

### Unit Testing

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=TestClassName

# Run with coverage
mvn test jacoco:report
```

### Integration Testing

```bash
# Run integration tests
mvn verify

# Run with specific profile
mvn test -P integration
```

---

## Project-Specific Notes

### H2 Database

If using H2 in-memory database:
- Data is reset on application restart
- Perfect for development and testing
- Console at `http://localhost:8080/h2-console`

### MySQL Setup

```bash
# Create database
mysql -u root -p
CREATE DATABASE springboot_lab;
USE springboot_lab;
```

### Application Properties Examples

**H2 Database (in-memory)**:
```properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

**MySQL**:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springboot_lab?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

---

## Best Practices

✅ Always use virtual environments/isolation
✅ Keep dependencies updated
✅ Use configuration files for different environments
✅ Write unit tests for your code
✅ Use Spring profiles for dev/test/prod
✅ Follow REST API naming conventions
✅ Use proper HTTP status codes
✅ Document your APIs

---

## Useful Resources

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf Documentation](https://www.thymeleaf.org/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [HTTP Status Codes Reference](https://httpwg.org/specs/rfc7231.html#status.codes)
- [Java Tutorials](https://docs.oracle.com/javase/tutorial/)

---

## License

This project is open source and available for educational purposes.

## Author

**manar09-code**

---

**Last Updated**: 2026-04-02 19:16:40