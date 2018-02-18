# intuit-exercise

This is a maven project. Building this project will produce an executable jar.Just download and build the project using the following cmd. 

mvn clean package

To run the project run the following cmd. By default the application will be started on port 8080

java -jar ./target/marketplace-0.0.1-SNAPSHOT.jar


This API has 4 operations.

POST /marketplace/createproject This will create a project.

request 
```json
{
	"projectDescription" : "testing project",
	"maxBudget" : "400",
	"deadineForBids" : "2018-02-18T13:34:22-05:00",
	"sellerId" : "ID1",
	"sellerName" : "ABC tech"
}
```
response
```json
{
    "projectId": 2
}
```


GET /marketplace/project/{id} This will fetch the project by id.

response


```json
{
    "projectDescription": "testing project",
    "maxBudget": 400,
    "projectStatus": "CLOSED",
    "lowestBid": 100
}
```

GET /marketplace/showprojects  This operation will fetch all the open projects.

response

```json

[
    {
        "projectDescription": "testing project",
        "maxBudget": 400,
        "projectStatus": "OPEN",
        "deadineForBids": "2018-02-18T18:34:22Z"
    },
    {
        "projectDescription": "testing project",
        "maxBudget": 400,
        "projectStatus": "OPEN",
        "deadineForBids": "2018-02-18T18:34:22Z"
    }
]
```

POST /marketplace/placebid This operation will place a bid for an open project.

request

```json

{
	"bidderId" : "100",
	"bidderName" : "sid sharma",
	"bidAmount" : "399",
	"projectId" : "1"
}

```


response 
```json
{
    "bidId": 1,
    "bidCreateTime": "2018-02-18T06:06:00Z"
}
```

————

Questionnaire

Time the exercise took: 6 hours

Exercise Difficulty: Moderate

How do you feel about the exercise: 5

Coding as an exercise step in process : 9

What do you change in exercise: No comments







