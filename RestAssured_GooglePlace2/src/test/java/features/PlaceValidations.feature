Feature: Validating place API's 
@AddPlaceAPI
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI 
	#Given Add place Payload
	Given Add place Payload with "<name>" "<language>" "<address>" 
	When User calls "AddPlaceAPI" with "POST" http request 
	Then the API call got success with status code 200 
	And "status" in responsebody is "OK"
	And  "scope" in responsebody is "APP"
	And verify place_id created maps to "<name>" using "GetPlaceAPI"
Examples:
|name|language|address|
|selvam|Tamil|Chennai|
|mavles|French|Sholinganallur|

@DeletePlaceAPI
Scenario: verify if delete functionlity is working
	Given Deleteplace Payload
	When User calls "DeletePlaceAPI" with "DELETE" http request 
	Then the API call got success with status code 200 
	And "status" in responsebody is "OK"
	
