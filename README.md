# spring-drools-rule-engine

#### 1. Setup the Spring boot project
#### 2. Add controller endpoint and services
#### 3. Configure Drools engine
#### 4. Drool Rules Unit Test


### Allow Request
```
POST /api/company/save HTTP/1.1
Host: localhost:8081
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: a49561f3-e985-468b-a006-a205694400be

{
	"name": "JadeBalde Corp.",
	"noOfEmployees": 10000,
	"yearlyTurnOver": 2000000000.00,
	"yearOfRegistration": "2015-02-25",
	"category": "IT",
	"govtRegistrationCode": "IND28701IT"
}
```
### Response:
```
{
    "allow": "ALLOW",
    "message": "Allow Company Save"
}
```
