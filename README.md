# spring-drools-rule-engine

#### 1. Setup the Spring boot project
#### 2. Add controller endpoint and services
#### 3. Configure Drools engine
#### 4. Drool Rules Unit Test

Step by step tutorial is coming soon in my medium blog......

### https://medium.com/@kousikpaul


#### Deny Request: Employee number should be more than equal to 10
```
{
	"name": "JadeBalde Corp.",
	"noOfEmployees": 2,
	"yearlyTurnOver": 2000000000.00,
	"yearOfRegistration": "2015-02-25",
	"category": "IT",
	"govtRegistrationCode": "IND28701IT"
}
```
#### Response:
```
{
    "allow": "DENY",
    "message": "Employee number should be more than equal to 10"
}
```

--------


#### Deny Request: Yearly turnover should be more than $1000.00
```
{
	"name": "JadeBalde Corp.",
	"noOfEmployees": 10000,
	"yearlyTurnOver": 200.00,
	"yearOfRegistration": "2015-02-25",
	"category": "IT",
	"govtRegistrationCode": "IND28701IT"
}
```
#### Response:
```
{
    "allow": "DENY",
    "message": "Yearly turnover should be more than $1000.00"
}
```

--------


#### Deny Request: Year of Registration can not be future date
```
{
	"name": "JadeBalde Corp.",
	"noOfEmployees": 10000,
	"yearlyTurnOver": 2000000000.00,
	"yearOfRegistration": "2019-02-25",
	"category": "IT",
	"govtRegistrationCode": "IND28701IT"
}
```
#### Response:
```
{
    "allow": "DENY",
    "message": "Year of Registration can not be future date"
}
```

-------


#### Deny Request: Category should be IT
```
{
	"name": "JadeBalde Corp.",
	"noOfEmployees": 10000,
	"yearlyTurnOver": 2000000000.00,
	"yearOfRegistration": "2015-02-25",
	"category": "MANUFACTURING",
	"govtRegistrationCode": "IND28701IT"
}
```
#### Response:
```
{
    "allow": "DENY",
    "message": "As of now only IT category will allow"
}
```

--------


#### Allow Request
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
#### Response:
```
{
    "allow": "ALLOW",
    "message": "Allow Company Save"
}
```
