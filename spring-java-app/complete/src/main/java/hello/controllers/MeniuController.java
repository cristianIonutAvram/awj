package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class MeniuController {
  private List<Meniu> meniuri = new ArrayList<Meniu>();

  MeniuController() {
    Meniu m1 = new Meniu(1, "Golden");
    Meniu m2 = new Meniu(2, "Silver");
    Meniu m3 = new Meniu(3, "Bronze");

    meniuri.add(m1);
	meniuri.add(m2);  
meniuri.add(m3);
  }
    
    
    
    
    //create
    @RequestMapping(value="/meniu/{id>},{nume}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("id") int id,@PathVariable("nume") String nume) {
   this.meniuri.create (new Meniu (id, "Nume"));
      Meniu m = new Meniu(id,nume);
      this.meniu.add(m);
      return new ResponseEntity<Meniu>(m, new HttpHeaders(), HttpStatus.OK);
  }
    
    
    //Update
    @RequestMapping(value="/meniu/{id>},{nume}", method = RequestMethod. PUT)
    public ResponseEntity update(@PathVariable("id") int id,@PathVariable("nume") String nume) {
        for(Meniu m: this.meniuri) {
            if(m.getId() == id) {
                m.setName(nume);
            }
        }
    }
    
    
    
    
    
    //Show all
  @RequestMapping(value="/meniu", method = RequestMethod.GET)
  public List<Meniu> index() {
    return this.meniuri;  //returneaza lista meniurilor
  }

    
    
    //show id
  @RequestMapping(value="/meniu/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Meniu m : this.meniuri) {
      if(m.getId() == id) {
        return new ResponseEntity<Meniu>(m, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
    
    
    
    
    //delete

  @RequestMapping(value="/meniu/{id}", method = RequestMethod.DEL)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Meniu m : this.meniuri) {
      if(m.getId() == id) {
        this.meniuri.remove(m);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}