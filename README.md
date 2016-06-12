# Palindrome
A Restful API to resolve the pallindrome challenge

### Frameworks and Technologies ###
* Java v 1.8
* Dropwizard
* Hibernate validator
* Maven v 3.3

### How to use ###

* Go to palindrome.api folder (cd palindrome.api/ )
* Compile the application typing: _mvn clean install_
* After that you can run the application. Type: _java -jar target/palindrome.api-1.jar server palindrome-configuration.yml_
* Using a REST client application, such as Postman, perfom the following GET operations:
  * [http://localhost:9000/palindrome/v1/range?min=1&max=1000000](http://localhost:9000/palindrome/v1/range?min=1&max=1000000)  
  The previous version, works well if the maximum value is less than or equal to 1 million
  * [http://localhost:9000/palindrome/v2/range?min=1&max=1000000](http://localhost:9000/palindrome/v2/range?min=1&max=1000000)  
  The newest version, It is suggested if the maximum value is greater than 1 million, because it gets the result in parallel manner.
* They both returns a JSON with the structure:
~~~~
{
  "palindromeStrings": {
    "decimal_number": "binary_number",
    ..
  },
  "iterations": iterations_needed_to_get_palindromes_in_the_range,
  "bigOComplexity": "An explanation about the complexity to calculate palindromes in the range"
}
~~~~
