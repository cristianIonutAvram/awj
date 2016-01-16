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
public class ProfesorController {
  private List<Profesor> profesori = new ArrayList<Profesor>();

  ProfesorController() {
    Profesor p1 = new Profesor(1, "Oara", "Cristian", "doctor");
    Profesor p2 = new Profesor(2, "Paul", "Costea", "doctor");
    Profesor p3 = new Profesor(3, "Paul", "Hrubaru", "doctor");

    profesori.add(p1);
    profesori.add(p2);
    profesori.add(p3);
  }

  @RequestMapping(value="/profesor", method = RequestMethod.GET)
  public List<Profesor> index() {
    return this.profesori;
  }

  @RequestMapping(value="/profesor/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Profesor p : this.profesori) {
      if(p.getId() == id) {
        return new ResponseEntity<Profesor>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/profesor/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Profesor p : this.profesori) {
      if(p.getId() == id) {
        this.profesori.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/profesor", method = RequestMethod.PUT)
	  public List<Profesor> update(@RequestBody Profesor p){
		for(Profesor prof : this.profesori){
		  if(prof.getId() == p.getId())    {
		profesori.set(profesori.indexOf(prof), p);
		  }
		}
		return this.profesori;
	  }
   
   
    @RequestMapping(value="/profesor", method = RequestMethod.POST)
   public ResponseEntity create(@RequestBody Profesor p) {    
  this.profesori.add(p); 
    return new ResponseEntity<Profesor>(p, new HttpHeaders(), HttpStatus.OK);
  }


 }