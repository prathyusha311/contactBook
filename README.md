# contactBook
assigment 



1. Basic auth credentials:

	user: tom
	passwrd: 123
	
	
2. using h2 db, properties are configured in application.properties

---------

POST Request: http://localhost:9091/add  

			{
				"mobileNumber" : "7762924463",
				"emailId" : "ram@gmail.com",
				"name" : "ram"
			}
			
or

curl request:


curl -X POST \
  http://localhost:9091/add \
  -H 'authorization: Basic dG9tOjEyMw==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: b56f0536-10a1-3e58-4093-2739c99ceb72' \
  -d '{
	"mobileNumber" : "7762924463",
	"emailId" : "pratyu@gmail.com",
	"name" : "pratyu"
}'


Response:

			{
				"status": 200,
				"message": "SUCCESS"
			}
		
---------

DELETE Request: http://localhost:9091/delete?mobileNumber=7763     or

curl request:

curl -X DELETE \
  'http://localhost:9091/delete?mobileNumber=7762924463' \
  -H 'authorization: Basic dG9tOjEyMw==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: a93e8773-9af1-8df7-4ca6-293e367e5e74'
  

Response:

			{
				"status": 200,
				"message": "SUCCESS"
			}	
		
		
---------


PUT Request: http://localhost:9091/edit

			{
				"mobileNumber" : "7762924463",
				"emailId" : "ram@gmail.com",
				"name" : "ram123"
			}
			
			
or

curl request:

curl -X PUT \
  'http://localhost:9091/edit?type=emailId' \
  -H 'authorization: Basic dG9tOjEyMw==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: e8d5e46c-8395-aeee-6d2b-c152efa05a96' \
  -d '{
	"mobileNumber" : "7762924463",
	"emailId" : "likhi@g",
	"name" : "pratyu"
}'

			
Response:

			{
				"status": 200,
				"message": "SUCCESS"
			}
		

---------

GET Request: http://localhost:9091/listByEmailId?emailId=likidig

or

curl request:

curl -X GET \
  'http://localhost:9091/listByEmailId?emailId=likidig' \
  -H 'authorization: Basic dG9tOjEyMw==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 8993e7a1-6ded-0c80-9384-ffe5becd6bbe'

Response:
			{
				"mobileNumber": "7544",
				"emailId": "likidig",
				"name": "liki"
			}

			
---------

GET Request: http://localhost:9091/listByName?name=liki&page=1&size=2

or

curl -X GET \
  'http://localhost:9091/list?name=liki&page=3&size=2' \
  -H 'authorization: Basic dG9tOjEyMw==' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 66b2ea08-9fa7-c537-d8f8-9f80b206f9c7'

Response:

{
    "content": [
        {
            "mobileNumber": "77454",
            "emailId": "likid@diig",
            "name": "liki"
        },
        {
            "mobileNumber": "774544",
            "emailId": "likid@didig",
            "name": "liki"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 2,
        "pageSize": 2,
        "pageNumber": 1,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 5,
    "totalPages": 3,
    "size": 2,
    "number": 1,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 2,
    "first": false,
    "empty": false
}	
		

---------



HTTP Status 401 - Full authentication is required to access this resource

601 - MobileNumber already exists
602 - Given email is linked with another mobile
603 - email already exists
604 - something went wrong
605 - contact not found
