Hi!

1 - This is a simple project that uses some functionality of spring framework.

2 - There is five packages in this projects, as it be:
- main pakage (br.com.interview): has the main class of the app. Starts the servlet when app will respond.
- config: where is defined the configuration of the app. This project doesn't use xml configuration and almost entire configuration was did through java annotations
	- RestConfig: configures the web part of the application.
	- ORMConfig: configures the orm part of the application.
- entities: has the JPA entities of the application
- json: has the json objects of the app, the requests and responses objects.
- repository: has the Data repositories of the app. The Repositories uses the JpaRepository interface that has a default implementation. If some customization is needed, then is necessary to implement this interface and extends the SimpleJpaRepository.
- rest.controller: has the web api part of the app. Exposes the endpoint "rest" with the REST Verbs as follows:

using the curl tool:
curl -H "Content-Type: application/json" -X POST -d '{"name":"marllon","description":"candidate"}' http://localhost:8080/interview-restapi-project/rest
curl -H "Content-Type: application/json" -X GET http://localhost:8080/interview-restapi-project/rest/{id}
curl -H "Content-Type: application/json" -X PUT -d '{"name":"marllon","description":"employee"}' http://localhost:8080/interview-restapi-project/rest/1
curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/interview-restapi-project/rest/1

using other rest client:

creates a new user
endpoint: http://localhost:8080/interview-restapi-project/rest
method: POST 
sample data: {"name":"marllon","description":"candidate"}

returns a list of all users in the database
endpoint: http://localhost:8080/interview-restapi-project/rest/
method: GET
sample data: none

returns the specific user defined by {id} variable
endpoint: http://localhost:8080/interview-restapi-project/rest/{id}
method: GET
sample data: none

update some user defined by {id} variable with the content of sample data
if the user was not found then raises an error
endpoint: http://localhost:8080/interview-restapi-project/rest/{id}
method: PUT 
sample data: {"name":"marllon","description":"employee"}
 
delete the user defined by variable {id}
endpoint: http://localhost:8080/interview-restapi-project/rest/{id}
method: DELETE
sample data: none 

3 - to puyt this application running follow this steps:
3.1 - compile this application with maven like: mvn clean install
There is no need to inform any profile because is was not configured.
3.2 - install this application in your java web server or application server.

4 - this application uses hsql database but it is embbeded in the application. No further configuration is needed.
 