package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
public class StudentController {
  private List<Student> studenti = new ArrayList<Student>();

  StudentController() {
    Student s1 = new Student(1, "John", "Miller", 19);
    Student s2 = new Student(2, "Paul", "Jack", 20);
    Student s3 = new Student(3, "Paul", "Harris", 20);

    studenti.add(s1);
    studenti.add(s2);
    studenti.add(s3);
  }

  @RequestMapping(value="/student", method = RequestMethod.GET)
  public List<Student> index() {
    return this.studenti;
  }

  @RequestMapping(value="/student/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/student/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        this.studenti.remove(s);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
	@RequestMapping(value="/student", method = RequestMethod.PUT)
	  public List<Student> update(@RequestBody Student s){
		for(Student stud : this.studenti){
		  if(stud.getId() == s.getId())    {
		studenti.set(studenti.indexOf(stud), s);
		  }
		}
		return this.studenti;
	  }
   
    @RequestMapping(value="/student", method = RequestMethod.POST)
	public ResponseEntity create(@RequestBody Student s) {    
	this.studenti.add(s); 
    return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
  }
 }
