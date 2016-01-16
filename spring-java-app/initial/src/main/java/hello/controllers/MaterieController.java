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
public class MaterieController {
  private List<Materie> materii = new ArrayList<Materie>();

  MaterieController() {
    Materie m1 = new Materie(1, "Matematica", "Mate");
    Materie m2 = new Materie(2, "Electronica analogica", "EA");
    Materie m3 = new Materie(3, "Electronica digitala", "ED");

    materii.add(m1);
    materii.add(m2);
    materii.add(m3);
  }

  @RequestMapping(value="/materie", method = RequestMethod.GET)
  public List<Materie> index() {
    return this.materii;
  }

  @RequestMapping(value="/materie/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Materie m : this.materii) {
      if(m.getId() == id) {
        return new ResponseEntity<Materie>(m, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/materie/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Materie m : this.materii) {
      if(m.getId() == id) {
        this.materii.remove(m);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/materie", method = RequestMethod.PUT)
	  public List<Materie> update(@RequestBody Materie m){
		for(Materie mat : this.materii){
		  if(mat.getId() == m.getId())    {
		materii.set(materii.indexOf(mat), m);
		  }
		}
		return this.materii;
	  }
   
   
    @RequestMapping(value="/materie", method = RequestMethod.POST)
   public ResponseEntity create(@RequestBody Materie m) {    
  this.materii.add(m); 
    return new ResponseEntity<Materie>(m, new HttpHeaders(), HttpStatus.OK);
  }


 }