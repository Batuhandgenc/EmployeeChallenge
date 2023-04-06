# EmployeeChallenge
An application created for a case given to me.

# Gereksinimler

-PostgreSQL

For Ubuntu:
```
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo apt-get update
sudo apt-get -y install postgresql
```
For Windows:
```
https://www.postgresql.org/download/windows/
```

# Installation
Install Git on your computer,
Clone the project repository
```
git clone https://github.com/Batuhandgenc/EmployeeChallenge
```
Wait for Gradle to build.
Once the process is complete, go to batuhan/src/main/java/com.batuhan.
Right-click on BatuhanApplication and select Run.
After the application starts,
go to the address
```
http://localhost:8080/actuator/health
```
If you receive the response
```
{"status":"UP"}
```
then the project is up and running.

# Usage
Here, I will explain the codes of the platform that manages Companies and Employees via Swagger.

For Employee,

```
id,firstname,lastname,age,salary,creationDate ve company fields are available.

```

For Company,

```
id,name,description ve creationDate fields are available.
```

A new company can be created with the **/save** endpoint by sending a POST request:
```
POST http://localhost:8080/save
Content-Type: application/json

{
    "name": "ACME Inc.",
    "description": "A company that makes everything"
}
```

The information of a company can be updated with the **/update** endpoint:

```
PUT http://localhost:8080/update
Content-Type: application/json

{
    "id": 1,
    "name": "ACME Corporation",
    "description": "A company that makes everything and more"
}
```
A company can be deleted with the **/delete/{id}** endpoint:
```
DELETE http://localhost:8080/delete/1
```
A new employee can be added to a company with the **/addNewEmployee/{companyId}** endpoint:
```
POST http://localhost:8080/addNewEmployee/1
Content-Type: application/json

{
    "firstName": "John",
    "lastName": "Doe",
    "age": 30,
    "salary": 50000.0
}
```
**/listAllEmployees/{id}** endpoint is used to list all employees of a specific company. You can send a GET request to the endpoint to get the list of employees. The {id} parameter specifies the identity of the company whose employees will be listed. For example, the "/listAllEmployees/1" endpoint lists all employees of the company with an id of 1.

**/addNewEmployee/{companyId}** endpoint is used to add a new employee to a specific company. You can send a POST request to the endpoint with the details of the new employee. The {companyId} parameter specifies the identity of the company where the employee should be added. For example, the "/addNewEmployee/1" endpoint adds a new employee to the company with an id of 1.

**/update** endpoint is used to update the details of an employee. You can send a PUT request to the endpoint with the updated details of the employee.

**/delete/{id}** endpoint is used to delete a specific employee. You send the ID of the employee to be deleted with a DELETE request to the endpoint. The {id} parameter specifies the ID of the employee to be deleted. For example, the "/delete/1" endpoint deletes the employee with an ID of 1.

# Additional Information
For those who would like to contribute, I kindly request them to access the GitHub repository and pass the tests before submitting a pull request.
