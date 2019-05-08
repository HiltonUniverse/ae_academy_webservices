# API Milestone 2

Start a new RAML project in Atom and execute the following tasks:

Copy your schemas to the schemas folder of the raml project and the examples to the examples folder

Create a RAML definition with the following possibilities:
* Get a list of accounts
* Create a new account
* Get a specific account
* Delete an account

Think about everything we have seen:
* Correct HTTP verbs
* Correct Status codes
* Proper URI design (Take the first Request ID example we have seen to base yourself on)


### Tips & tricks

* (Setup project in Atom together)

* Please search in RAML 100 & RAML 200 tutorials to find out how to do certain things. The setup of the project already gives you most of the required info with the helloworld example 

* Import the schemas you have just made in the following way (best practice):

```
#%RAML 0.8
title: Account
version: v1
baseUri: http://api.ae.be/
schemas:
  - accounts: !include schemas/account.schema.json
  - account: !include schemas/accounts.schema.json
```


