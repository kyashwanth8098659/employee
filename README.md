# employeeREADME FILE CONTENT :



DATABASE CONFIGURATION:
MYSQL:


spring.application.name=EmployeeProject

spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


**********************************************************
REST API CALL:

POST :  http://localhost:8080/employees/v1/register



postman :  

Basic auth:      

username:user
password:pass123



request body:

{
  "employee_id": 123,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumbers": ["1234567890", "0987654321"],
  "doj": "2024-05-16",
  "salary": 50000
}


ResponseBody:


{
  "employee_id": 123,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumbers": ["1234567890", "0987654321"],
  "doj": "2024-05-16",
  "salary": 50000
}

if already user exists in table :  

 message:  Employee ID already exists



Get request:
url: http://localhost:8080/employees/v1/tax_deduct/123
{
  "employee_id": "123",
  "firstName": "John",
  "lastName": "Doe",
  "yearlySalary": 600000,
  "taxAmount": 5000,
  "cessAmount":0
}



Get request:
url: http://localhost:8080/employees/v1/tax_deduct/127


Basic auth:      

username:user
password:pass123



response :Employee not found




