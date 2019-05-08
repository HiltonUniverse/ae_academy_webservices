# API Milestone 1

![Image 1](../master/img/api_img_1.png "Image 1")

Create json schema and example json file for the following information model, both for 1 account and a list of accounts. We should end up with 4 files:
* account.schema.json
* accounts.schema.json
* account.example.json
* accounts.example.json


### Bonus points: 
* Make moneyAmount a separate definition inside the same schema file and refer to it.
* Define a strict pattern for the iban number


### Tips & tricks
**Samples**

```json
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "title": "...",
  "description": "...",
  "type": "object",
  "properties": {
    "<property 1>": {
      "description": "...",
      "type": "string"
    },
    "<property 2>": {
      "description": "...",
      "type": "string"
    }
  },
  "required": []
}
```


```json
{
  "type": "array",
  "items": {
    "type": "object",
    "properties": {
        "<property 1>": {
            "description": "...",
            "type": "string"
        }
    }
  }
}
```


**JSON Schema basics: Useful info**

Website to validate if json structure is correct: http://www.jsonlint.com

Website to validate if json schema is correct and if example complies to schema: http://www.jsonschemalint.com (Select draft-04 on the top right of the website before pasting your schema!)

Available types in json schema:
* string
* number
* array
* object
* boolean
* null

