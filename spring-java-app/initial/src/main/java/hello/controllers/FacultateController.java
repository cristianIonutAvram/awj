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
public class FacultateController {
  private List<Facultate> facultati = new ArrayList<Facultate>();

  FacultateController() {
    Facultate f1 = new Facultate(1, "Automatica si Calculatoare", "ACS", 600);
    Facultate f2 = new Facultate(2, "Electronica si Telecomunicatii", "ETTI", 600);
    Facultate f3 = new Facultate(3, "Academia de Studii Economice", "ASE", 700);

    facultati.add(f1);
    facultati.add(f2);
    facultati.add(f3);
  }

  @RequestMapping(value="/facultate", method = RequestMethod.GET)
  public List<Facultate> index() {
    return this.facultati;
  }

  @RequestMapping(value="/facultate/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Facultate f : this.facultati) {
      if(f.getId() == id) {
        return new ResponseEntity<Facultate>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/facultate/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Facultate f : this.facultati) {
      if(f.getId() == id) {
        this.facultati.remove(f);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/facultate", method = RequestMethod.PUT)
	  public List<Facultate> update(@RequestBody Facultate f){
		for(Facultate fac : this.facultati){
		  if(fac.getId() == f.getId())    {
		facultati.set(facultati.indexOf(fac), f);
		  }
		}
		return this.facultati;
	  }
   
   @RequestMapping(value="/facultate", method = RequestMethod.POST)
   public ResponseEntity create(@RequestBody Facultate f) {    
  this.facultati.add(f); 
    return new ResponseEntity<Facultate>(f, new HttpHeaders(), HttpStatus.OK);
  }
}
