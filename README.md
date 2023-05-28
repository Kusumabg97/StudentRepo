# Student Info Application 

Demo Link: 

### APIs 


/**  This saveDetails will save the student data to database*/
public Student saveDetails(@RequestBody Student student)
	

/** This getStudentList method will display the student details based on the filter */
public Page<Student> getStudentList(@RequestBody Map<String, Object> queryFilters, @RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam String sortBy)


/** This updateStudent method will update the existing student details*/
public ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody Student student) {
		
/** This deleteStudent method will delete the student data*/
public ResponseEntity <Map <String,Boolean>> deleteStudent(@PathVariable Integer id)

### How to run the application? 

step 1: Open the StudentInfoApplication class which is present in com.jsp.springboot
step 2:Right Click -> Click on Run -> In that click on Spring Boot App
step 3:To test this open Postman Tool 


### How to test the APIs? 


saveDetails:

HTTP METHOS: POST
URL: http://localhost:8080/student
(In body choose Raw and select the JSON)
Body :
{
	"name":"ramya",
	"age":26,
	"totalmarks":88
}


getStudentList: 

HTTP METHOD: POST 
URL: http://localhost:8080/getStudentList?pageNumber=0&pageSize=2&sortBy=id 
Body: 
{
	"name":"maya",
	"age":17
}


updateStudent:

HTTP METHODS: PUT
URL: http://localhost:8080/student/7
(In body choose Raw and select the JSON)
Body :
{
	"name":"ramya",
	"age":26,
	"totalmarks":66

}

deleteStudent:
HTTP METHODS: DELETE
URL: http://localhost:8080/student/8







